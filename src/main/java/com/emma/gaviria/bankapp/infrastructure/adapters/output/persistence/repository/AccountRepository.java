package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository;

import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
