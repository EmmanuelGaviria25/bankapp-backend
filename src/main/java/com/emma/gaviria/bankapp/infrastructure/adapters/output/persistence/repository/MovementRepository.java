package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository;

import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.data.response.account.AccountStatementResponse;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.MovementEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

    List<MovementEntity> findAllByAccount(AccountEntity account, Sort date);

    @Query(value = "SELECT * FROM public.movement_entity m " +
            "WHERE m.account_id = ?1 " +
            "AND m.date BETWEEN ?2 AND ?3 " +
            "ORDER BY id DESC", nativeQuery = true)
    List<MovementEntity> reportStatementByAccountId(Long accountId, Date startDate, Date endDate);
}
