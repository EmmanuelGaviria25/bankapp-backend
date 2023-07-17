package com.emma.gaviria.bankapp.domain.service;

import com.emma.gaviria.bankapp.application.ports.input.movement.CreateMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.DeleteMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.GetMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.input.movement.UpdateMovementUseCase;
import com.emma.gaviria.bankapp.application.ports.output.AccountOutputPort;
import com.emma.gaviria.bankapp.application.ports.output.MovementEventPublisher;
import com.emma.gaviria.bankapp.application.ports.output.MovementOutputPort;
import com.emma.gaviria.bankapp.domain.event.movement.MovementCreatedEvent;
import com.emma.gaviria.bankapp.domain.event.movement.MovementUpdatedEvent;
import com.emma.gaviria.bankapp.domain.exception.MovementNotFound;
import com.emma.gaviria.bankapp.domain.exception.PersonNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Movement;
import lombok.AllArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
public class MovementService implements CreateMovementUseCase, GetMovementUseCase, UpdateMovementUseCase, DeleteMovementUseCase {

    private final MovementOutputPort movementOutputPort;

    private final MovementEventPublisher movementEventPublisher;

    private final AccountOutputPort accountOutputPort;

    @Override
    public Movement createMovement(Movement movement) {
        Movement finalMovement = movement;
        Account account = accountOutputPort.getAccountById(movement.getAccountId())
                .orElseThrow(() -> new PersonNotFound("Account not found with id " + finalMovement.getAccountId()));

        movement.setAccount(account);
        movement.setDate(new Date(new java.util.Date().getTime()));
        movement = movementOutputPort.saveMovement(movement);
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
}
