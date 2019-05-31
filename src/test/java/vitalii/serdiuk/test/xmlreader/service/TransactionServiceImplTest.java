package vitalii.serdiuk.test.xmlreader.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import vitalii.serdiuk.test.xmlreader.dto.ClientDTO;
import vitalii.serdiuk.test.xmlreader.dto.TransactionDTO;
import vitalii.serdiuk.test.xmlreader.entity.Transaction;
import vitalii.serdiuk.test.xmlreader.repository.TransactionRepository;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionServiceImplTest {

    @TestConfiguration
    static class TransactionServiceImplTestContextConfiguration {
        @Bean
        public TransactionService transactionService() {
            return new TransactionServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void save() {
        ClientDTO clientDTO = new ClientDTO.ClientDTOBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setMiddleName("R")
                .setInn(BigInteger.valueOf(1234567890l))
                .build();

        TransactionDTO transactionDTO = new TransactionDTO.TransactionDTOBuilder()
                .setPlace("A PLACE 1")
                .setAmount(BigDecimal.valueOf(10.01))
                .setCurrency("USD")
                .setCard("123456****1234")
                .setClient(clientDTO)
                .build();
        transactionService.save(transactionDTO);

        Iterable<Transaction> clients = transactionRepository.findAll();
        assertThat(clients).hasSize(1);
    }
}