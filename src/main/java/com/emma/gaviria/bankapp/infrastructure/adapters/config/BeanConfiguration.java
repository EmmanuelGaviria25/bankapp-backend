package com.emma.gaviria.bankapp.infrastructure.adapters.config;

import com.emma.gaviria.bankapp.domain.service.*;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.eventpublisher.*;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.*;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.mapper.*;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    /**
     * Product Config
     */
    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }

    /**
     * Person Config
     */
    @Bean
    public PersonPersistenceAdapter personPersistenceAdapter(PersonRepository repository, PersonPersistenceMapper mapper) {
        return new PersonPersistenceAdapter(repository, mapper);
    }

    @Bean
    public PersonEventPublisherAdapter personEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new PersonEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public PersonService personService(PersonPersistenceAdapter personPersistenceAdapter, PersonEventPublisherAdapter personEventPublisherAdapter) {
        return new PersonService(personPersistenceAdapter, personEventPublisherAdapter);
    }

    /**
     * Client Config
     */
    @Bean
    public ClientPersistenceAdapter clientPersistenceAdapter(ClientRepository repository, ClientPersistenceMapper mapper) {
        return new ClientPersistenceAdapter(repository, mapper);
    }

    @Bean
    public ClientEventPublisherAdapter clientEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ClientEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ClientService clientService(ClientPersistenceAdapter clientPersistenceAdapter, ClientEventPublisherAdapter clientEventPublisherAdapter,
                                       PersonPersistenceAdapter personPersistenceAdapter) {
        return new ClientService(clientPersistenceAdapter, clientEventPublisherAdapter, personPersistenceAdapter);
    }

    /**
     * Account Config
     */
    @Bean
    public AccountPersistenceAdapter accountPersistenceAdapter(AccountRepository repository, AccountPersistenceMapper mapper) {
        return new AccountPersistenceAdapter(repository, mapper);
    }

    @Bean
    public AccountEventPublisherAdapter accountEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new AccountEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public AccountService accountService(AccountPersistenceAdapter accountPersistenceAdapter, AccountEventPublisherAdapter accountEventPublisherAdapter,
                                         ClientPersistenceAdapter clientPersistenceAdapter) {
        return new AccountService(accountPersistenceAdapter, accountEventPublisherAdapter, clientPersistenceAdapter);
    }


    /**
     * Movement Config
     */
    @Bean
    public MovementPersistenceAdapter movementPersistenceAdapter(MovementRepository repository, MovementPersistenceMapper mapper) {
        return new MovementPersistenceAdapter(repository, mapper);
    }

    @Bean
    public MovementEventPublisherAdapter movementEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new MovementEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public MovementService movementService(MovementPersistenceAdapter movementPersistenceAdapter, MovementEventPublisherAdapter movementEventPublisherAdapter,
                                          AccountPersistenceAdapter accountPersistenceAdapter) {
        return new MovementService(movementPersistenceAdapter, movementEventPublisherAdapter, accountPersistenceAdapter);
    }
}
