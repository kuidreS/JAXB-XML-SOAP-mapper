package vitalii.serdiuk.test.xmlreader.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitalii.serdiuk.test.xmlreader.dto.TransactionDTO;
import vitalii.serdiuk.test.xmlreader.entity.Transaction;
import vitalii.serdiuk.test.xmlreader.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(TransactionDTO transactionDTO) {
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        transactionRepository.save(transaction);
    }

}
