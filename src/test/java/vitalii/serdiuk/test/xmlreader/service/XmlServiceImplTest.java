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
import vitalii.serdiuk.test.xmlreader.entity.Client;
import vitalii.serdiuk.test.xmlreader.entity.Transaction;
import vitalii.serdiuk.test.xmlreader.repository.ClientRepository;
import vitalii.serdiuk.test.xmlreader.repository.TransactionRepository;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class XmlServiceImplTest {

    @TestConfiguration
    static class XmlServiceImplTestontextConfiguration {
        @Bean
        public XmlService xmlService() {
            return new XmlServiceImpl();
        }

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
    private XmlService xmlService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void saveXmlDataInDb() {
        ClassLoader classLoader = getClass().getClassLoader();
        File xmlFile = new File(classLoader.getResource("test.xml").getFile());

        xmlService.saveXmlDataInDb(xmlFile);

        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
        List<Client> clients = (List<Client>) clientRepository.findAll();

        assertTrue(transactions.size() == 1);
        assertTrue(clients.size() == 1);
    }
}