package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository;

import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

}
