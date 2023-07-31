package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.movement.CreateMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.DeleteMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.GetMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.UpdateMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.output.AccountOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.MovementEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.MovementOutputPort;
import com.emma.gaviria.bankapp.domain.constant.MovementType;
import com.emma.gaviria.bankapp.domain.event.movement.MovementCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.movement.MovementUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.AccountNotFound;
import com.emma.gaviria.bankapp.domain.exception.BalanceNotAvailable;
import com.emma.gaviria.bankapp.domain.exception.MovementNotFound;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Movement;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Log4j2
public class MovementService implements CreateMovementUseCase, GetMovementUseCase, UpdateMovementUseCase, DeleteMovementUseCase {

    private final MovementOutputPort movementOutputPort;

    private final MovementEventPublisher movementEventPublisher;

    private final AccountOutputPort accountOutputPort;

    @Override
    @Transactional
    public Movement createMovement(Movement movement) {
        Movement finalMovement = movement;
        Account account = accountOutputPort.getAccountActiveById(movement.getAccountId())
                .orElseThrow(() -> new AccountNotFound("Account active not found with id " + finalMovement.getAccountId()));

        List<Movement> lastMovementsByAccount = movementOutputPort.getLastMovementsByAccount(account);
        if(lastMovementsByAccount.isEmpty()) {
            movement.setBalance(account.getInitialBalance());
        } else {
            movement.setBalance(lastMovementsByAccount.get(0).getBalance());
        }

        Movement calculatedMovement = calculateMovementBalanceByType(movement);
        account.setInitialBalance(calculatedMovement.getBalance());
        calculatedMovement.setAccount(account);
        calculatedMovement.setDate(new Date(new java.util.Date().getTime()));
        movement = movementOutputPort.saveMovement(calculatedMovement);
        accountOutputPort.saveAccount(account);

        movementEventPublisher.publishMovementCreatedEvent(new MovementCreatedEvent(movement.getId()));
        return movement;
    }

    @Override
    public Movement getMovementById(Long id) {
        Movement movement = movementOutputPort.getMovementById(id)
                .orElseThrow(() -> new MovementNotFound("Movement not found with id " + id));

        return movement;
    }

    @Override
    @Transactional
    public Movement updateMovement(Movement movement) {
        Movement finalMovement = movement;
        Account account = accountOutputPort.getAccountById(movement.getAccountId())
                .orElseThrow(() -> new PersonNotFound("Account not found with id " + finalMovement.getAccountId()));

        movement.setAccount(account);
        movement.setDate(new Date(new java.util.Date().getTime()));
        movement = movementOutputPort.updateMovement(movement);
        movementEventPublisher.publishMovementUpdatedEvent(new MovementUpdatedEvent(movement.getId()));
        return movement;
    }

    @Override
    public void deleteMovementById(Long id) {
        movementOutputPort.deleteMovementById(id);
    }

    private Movement calculateMovementBalanceByType(Movement movement) {
        double result = 0;
        switch (movement.getType()) {
            case MovementType.CREDIT:
                result = Double.parseDouble(movement.getBalance())+Double.parseDouble(movement.getValue());
                movement.setBalance(String.valueOf(result));
                break;
            case MovementType.DEBIT:
                result = Double.parseDouble(movement.getBalance())-Double.parseDouble(movement.getValue());
                if(result < 0) {
                    throw new BalanceNotAvailable("Balance not Available");
                } else {
                    movement.setBalance(String.valueOf(result));
                }
                break;
            default:
                break;
        }

        return movement;
    }
}
