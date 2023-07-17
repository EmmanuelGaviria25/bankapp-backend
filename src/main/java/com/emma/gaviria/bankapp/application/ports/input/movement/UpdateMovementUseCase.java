package com.emma.gaviria.bankapp.application.ports.input.movement;

import com.emma.gaviria.bankapp.domain.model.Movement;

public interface UpdateMovementUseCase {

    Movement updateMovement(Movement movement);

}
