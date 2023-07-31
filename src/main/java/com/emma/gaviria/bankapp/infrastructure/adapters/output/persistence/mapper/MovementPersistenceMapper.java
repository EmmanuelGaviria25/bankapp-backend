package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper;

import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.MovementEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MovementPersistenceMapper {

    MovementEntity toMovementEntity(Movement movement);

    Movement toMovement(MovementEntity movementEntity);

    List<Movement> toMovements(List<MovementEntity> movementEntityList);

}
