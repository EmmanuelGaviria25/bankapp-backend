package com.emma.gaviria.bankapp.application.ports.output;

import com.emma.gaviria.bankapp.domain.model.Movement;

import java.util.Optional;

public interface MovementOutputPort {

    Movement saveMovement(Movement movement);

    Movement updateMovement(Movement movement);

    Optional<Movement> getMovementById(Long id);

    void deleteMovementById(Long id);
}
