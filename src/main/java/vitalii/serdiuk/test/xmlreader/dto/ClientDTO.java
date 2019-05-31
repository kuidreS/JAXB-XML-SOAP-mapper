package vitalii.serdiuk.test.xmlreader.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@Data
@XmlRootElement(name = "client")
@XmlAccessorType (XmlAccessType.FIELD)
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String middleName;
    private BigInteger inn;

    public ClientDTO() {

    }

    public ClientDTO(ClientDTOBuilder clientDTOBuilder) {
        this.firstName = clientDTOBuilder.firstName;
        this.lastName = clientDTOBuilder.lastName;
        this.middleName = clientDTOBuilder.middleName;
        this.inn = clientDTOBuilder.inn;
    }

    public static class ClientDTOBuilder {
        private String firstName;
        private String lastName;
        private String middleName;
        private BigInteger inn;

        public ClientDTOBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ClientDTOBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientDTOBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public ClientDTOBuilder setInn(BigInteger inn) {
            this.inn = inn;
            return this;
        }

        public ClientDTO build() {
            return new ClientDTO(this);
        }
    }
}
