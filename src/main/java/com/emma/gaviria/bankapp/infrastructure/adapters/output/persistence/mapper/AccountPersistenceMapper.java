package com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper;

import com.emma.gaviria.bankapp.domain.model.Account;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AccountPersistenceMapper {

    AccountEntity toAccountEntity(Account account);

    Account toAccount(AccountEntity accountEntity);

}
