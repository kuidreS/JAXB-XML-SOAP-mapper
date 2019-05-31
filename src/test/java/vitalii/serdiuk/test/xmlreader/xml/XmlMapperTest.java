package vitalii.serdiuk.test.xmlreader.xml;

import org.junit.Before;
import org.junit.Test;
import vitalii.serdiuk.test.xmlreader.dto.ClientDTO;
import vitalii.serdiuk.test.xmlreader.dto.ResponseDTO;
import vitalii.serdiuk.test.xmlreader.dto.TransactionDTO;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlMapperTest {

    private Mapper mapper;

    @Before
    public void before() {
        mapper = new XmlMapper();
    }

    @Test
    public void mapToResponseDTO() {
        ClientDTO clientDTO = new ClientDTO.ClientDTOBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setMiddleName("R")
                .setInn(BigInteger.valueOf(123456789l))
                .build();

        TransactionDTO transactionDTO = new TransactionDTO.TransactionDTOBuilder()
                .setPlace("A PLACE 1")
                .setAmount(BigDecimal.valueOf(10.01))
                .setCurrency("USD")
                .setCard("123456****1234")
                .setClient(clientDTO)
                .build();

        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        transactionDTOs.add(transactionDTO);

        ResponseDTO expectedResponseDTO = new ResponseDTO();
        expectedResponseDTO.setTransactions(transactionDTOs);

        ClassLoader classLoader = getClass().getClassLoader();
        File xmlFile = new File(classLoader.getResource("test.xml").getFile());

        ResponseDTO actualResponseDTO = mapper.mapToResponseDTO(xmlFile);

        assertEquals(expectedResponseDTO, actualResponseDTO);
    }
}