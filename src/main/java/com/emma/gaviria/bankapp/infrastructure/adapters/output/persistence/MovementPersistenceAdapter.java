package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.application.ports.output.MovementOutputPort;
import com.emma.gaviria.bankapp.domain.exception.MovementNotFound;
import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.MovementEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.MovementPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@RequiredArgsConstructor
public class MovementPersistenceAdapter implements MovementOutputPort {

    private final MovementRepository repository;

    private final MovementPersistenceMapper mapper;

    @Override
    public Movement saveMovement(Movement movement) {
        MovementEntity movementEntity = mapper.toMovementEntity(movement);
        movementEntity = repository.save(movementEntity);
        return mapper.toMovement(movementEntity);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        MovementEntity movementEntity = mapper.toMovementEntity(movement);
        movementEntity = repository.save(movementEntity);
        return mapper.toMovement(movementEntity);
    }

    @Override
    public Optional<Movement> getMovementById(Long id) {
        Optional<MovementEntity> movementEntity = repository.findById(id);

        if(movementEntity.isEmpty()) {
            return Optional.empty();
        }

        Movement movement = mapper.toMovement(movementEntity.get());
        return Optional.of(movement);
    }

    @Override
    public void deleteMovementById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new MovementNotFound("Movement not found with id " + id);
        }
    }

}
