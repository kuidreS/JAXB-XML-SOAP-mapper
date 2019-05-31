package vitalii.serdiuk.test.xmlreader.repository;

import org.springframework.data.repository.CrudRepository;
import vitalii.serdiuk.test.xmlreader.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
