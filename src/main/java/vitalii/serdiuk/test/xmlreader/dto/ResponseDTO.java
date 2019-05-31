package vitalii.serdiuk.test.xmlreader.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "transactions")
@XmlAccessorType (XmlAccessType.FIELD)
public class ResponseDTO {

    @XmlElement(name = "transaction")
    private List<TransactionDTO> transactions;

    public ResponseDTO() {

    }

}
