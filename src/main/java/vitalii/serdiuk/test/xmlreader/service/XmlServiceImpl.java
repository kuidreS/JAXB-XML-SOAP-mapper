package vitalii.serdiuk.test.xmlreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitalii.serdiuk.test.xmlreader.dto.ResponseDTO;
import vitalii.serdiuk.test.xmlreader.dto.TransactionDTO;
import vitalii.serdiuk.test.xmlreader.xml.XmlMapper;
import java.io.File;
import java.util.List;

@Service
public class XmlServiceImpl implements XmlService {

    @Autowired
    private TransactionService transactionService;

    public void saveXmlDataInDb(File xmlFile) {
        XmlMapper xmlReader = new XmlMapper();
        ResponseDTO responseDTO = xmlReader.mapToResponseDTO(xmlFile);

        List<TransactionDTO> transactionDTOs = responseDTO.getTransactions();
        for (TransactionDTO transactionDTO : transactionDTOs) {
            transactionService.save(transactionDTO);
        }
    }
}
