package com.emma.gaviria.bankapp.application.ports.input.movement;

import com.emma.gaviria.bankapp.domain.model.Movement;

public interface CreateMovementUseCase {

    Movement createMovement(Movement movement);

}
