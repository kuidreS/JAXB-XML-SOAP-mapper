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
import vitalii.serdiuk.test.xmlreader.entity.Client;
import vitalii.serdiuk.test.xmlreader.repository.ClientRepository;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceImplTest {

    @TestConfiguration
    static class ClientServiceImplTestContextConfiguration {
        @Bean
        public ClientService clientService() {
            return new ClientServiceImpl();
        }

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void save() {
        ClientDTO clientDTO = new ClientDTO.ClientDTOBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setMiddleName("R")
                .setInn(BigInteger.valueOf(1234567890l))
                .build();
        clientService.save(clientDTO);

        Iterable<Client> clients = clientRepository.findAll();
        assertThat(clients).hasSize(1);
    }
}