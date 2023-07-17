package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository;

import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
