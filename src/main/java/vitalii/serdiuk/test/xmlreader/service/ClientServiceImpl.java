package vitalii.serdiuk.test.xmlreader.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitalii.serdiuk.test.xmlreader.dto.ClientDTO;
import vitalii.serdiuk.test.xmlreader.entity.Client;
import vitalii.serdiuk.test.xmlreader.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        clientRepository.save(client);
    }

}
