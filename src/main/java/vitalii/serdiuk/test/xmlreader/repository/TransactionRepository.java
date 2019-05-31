package vitalii.serdiuk.test.xmlreader.repository;

import org.springframework.data.repository.CrudRepository;
import vitalii.serdiuk.test.xmlreader.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
