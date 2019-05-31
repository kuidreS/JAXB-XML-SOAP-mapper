package vitalii.serdiuk.test.xmlreader.xml;

import org.apache.log4j.Logger;
import vitalii.serdiuk.test.xmlreader.dto.ResponseDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XmlMapper implements Mapper {

    final static Logger logger = Logger.getLogger(XmlMapper.class);

    public ResponseDTO mapToResponseDTO(File xmlFile) {
        ResponseDTO responseDTO = null;
        try {
            logger.info("The XML mapping has been started");
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(xmlFile);
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xml);
            xmlStreamReader.nextTag();
            while(!xmlStreamReader.getLocalName().equals("transactions")) {
                xmlStreamReader.nextTag();
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(ResponseDTO.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<ResponseDTO> jaxbElement = unmarshaller.unmarshal(xmlStreamReader, ResponseDTO.class);
            xmlStreamReader.close();

            responseDTO = jaxbElement.getValue();
            logger.info("The XML mapping has been finished");
        } catch (JAXBException | XMLStreamException e) {
            logger.error(e.getMessage());
        }
        return responseDTO;
    }

}
