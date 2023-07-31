package com.emma.gaviria.bankapp.input.rest;

import com.emma.gaviria.bankapp.application.ports.input.account.*;
import com.emma.gaviria.bankapp.config.H2JpaConfig;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.AccountRestAdapter;
import com.emma.gaviria.bankapp.infrastructure.adapters.input.rest.mapper.AccountRestMapper;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.entity.AccountEntity;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.AccountRepository;
import com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.repository.ClientRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {AccountRestAdapter.class, H2JpaConfig.class})
@EnableAutoConfiguration
@ActiveProfiles("test")
class AccountRestAdapterIntegrationTest {

    @Autowired
    private AccountRepository accountRepository;

    @MockBean
    private CreateAccountUseCase createAccountUseCase;

    @MockBean
    private UpdateAccountUseCase updateAccountUseCase;

    @MockBean
    private GetAccountUseCase getAccountUseCase;

    @MockBean
    private DeleteAccountUseCase deleteAccountUseCase;

    @MockBean
    private ReportAccountStatementUseCase reportAccountStatementUseCase;

    @MockBean
    private AccountRestMapper accountRestMapper;

    @MockBean
    private ClientRepository clientRepository;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @After
    public void resetDb() {
        accountRepository.deleteAll();
    }

    @Test
    public void testGetAccount() throws Exception {
        createTestEmployee(new AccountEntity(1L, null, "1234123", "AHORROS", "0", Boolean.TRUE));

        MvcResult mvcResult = this.mvc.perform(get("/v1/accounts/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1L))
                .andReturn();


        Assert.assertEquals(MediaType.APPLICATION_JSON,
                mvcResult.getResponse().getContentType());

    }


    private void createTestEmployee(AccountEntity account) {
        accountRepository.saveAndFlush(account);
    }

}
