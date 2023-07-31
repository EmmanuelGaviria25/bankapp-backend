package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence;

import com.emma.gaviria.bankapp.application.ports.output.MovementOutputPort;
import com.emma.gaviria.bankapp.domain.exception.MovementNotFound;
import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.domain.model.Movement;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.MovementEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.AccountPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.MovementPersistenceMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovementPersistenceAdapter implements MovementOutputPort {

    private final MovementRepository repository;

    private final MovementPersistenceMapper mapper;

    private final AccountPersistenceMapper accountPersistenceMapper;

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

    @Override
    public List<Movement> getLastMovementsByAccount(Account account) {
        List<MovementEntity> movementEntityList = repository
                .findAllByAccount(accountPersistenceMapper.toAccountEntity(account), Sort.by(Sort.Direction.DESC, "id"));
        return mapper.toMovements(movementEntityList);
    }

    @Override
    public List<Movement> reportStatementByAccountId(Long accountId, Date startDate, Date endDate) {
        List<MovementEntity> movementEntityList = repository
                .reportStatementByAccountId(accountId, startDate, endDate);
        return mapper.toMovements(movementEntityList);
    }

}
