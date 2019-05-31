package vitalii.serdiuk.test.xmlreader.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@XmlRootElement(name = "transaction")
@XmlAccessorType (XmlAccessType.FIELD)
public class TransactionDTO {

    private String place;
    private BigDecimal amount;
    private String currency;
    private String card;

    @XmlElement(name = "client")
    private ClientDTO client;

    public TransactionDTO() {

    }

    public TransactionDTO(TransactionDTOBuilder transactionDTOBuilder) {
        this.place = transactionDTOBuilder.place;
        this.amount = transactionDTOBuilder.amount;
        this.currency = transactionDTOBuilder.currency;
        this.card = transactionDTOBuilder.card;
        this.client = transactionDTOBuilder.client;
    }

    public static class TransactionDTOBuilder {
        private String place;
        private BigDecimal amount;
        private String currency;
        private String card;
        private ClientDTO client;

        public TransactionDTOBuilder setPlace(String place) {
            this.place = place;
            return this;
        }

        public TransactionDTOBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public TransactionDTOBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public TransactionDTOBuilder setCard(String card) {
            this.card = card;
            return this;
        }

        public TransactionDTOBuilder setClient(ClientDTO client) {
            this.client = client;
            return this;
        }

        public TransactionDTO build() {
            return new TransactionDTO(this);
        }
    }
}
