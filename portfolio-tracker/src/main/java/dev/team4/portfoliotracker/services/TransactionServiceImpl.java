package dev.team4.portfoliotracker.services;

import dev.team4.portfoliotracker.models.Transaction;
import dev.team4.portfoliotracker.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository txnRepo;

    @Override
    public List<Transaction> getAllTransactions(int userId) {
        return txnRepo.findAllTransactionsByUserId(userId);
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return txnRepo.findByTransactionId(transactionId);
    }

    @Override
    public List<Transaction> getTransactionsByDate(long date) {
        return txnRepo.findAllTransactionsByDate(date);
    }


    @Override
    public Transaction addTransaction(int userId, double shareAmount, double sharePrice, String note, long date) {
        Transaction txn = new Transaction(userId, shareAmount, sharePrice, note, date);
        return txnRepo.save(txn);
    }

    @Override
    public void updateTransaction(int transactionId, int userId, double shareAmount, double sharePrice, String note, long date) {
        Transaction txn = txnRepo.findByTransactionId(transactionId);
        txn.setShareAmount(shareAmount);
        txn.setSharePrice(sharePrice);
        txn.setNote(note);
        txn.setDate(date);
    }

    @Override
    public void deleteTransaction(int transactionId, int userId) {
        txnRepo.deleteById(transactionId);
    }
}
