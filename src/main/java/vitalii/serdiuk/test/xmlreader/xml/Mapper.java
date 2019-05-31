package vitalii.serdiuk.test.xmlreader.xml;

import vitalii.serdiuk.test.xmlreader.dto.ResponseDTO;

import java.io.File;

public interface Mapper {

    ResponseDTO mapToResponseDTO(File file);

}
