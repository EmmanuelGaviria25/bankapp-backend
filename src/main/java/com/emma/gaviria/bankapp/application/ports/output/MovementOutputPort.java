package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Movement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MovementOutputPort {

    Movement saveMovement(Movement movement);

    Movement updateMovement(Movement movement);

    Optional<Movement> getMovementById(Long id);

    List<Movement> getLastMovementsByAccount(Account account);

    void deleteMovementById(Long id);

    List<Movement> reportStatementByAccountId(Long accountId, Date startDate, Date endDate);
}
