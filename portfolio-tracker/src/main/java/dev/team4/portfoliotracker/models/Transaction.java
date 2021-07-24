package dev.team4.portfoliotracker.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "stock_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    // maybe we don't need this
    @Column(name = "user_Id")
    private int userId;

    @Column(name = "share_amount")
    private double shareAmount;

    @Column(name = "share_price")
    private double sharePrice;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private long date;

    public Transaction() {
    }

    public Transaction(int userId, double shareAmount, double sharePrice, String note, long date) {
        this.userId = userId;
        this.shareAmount = shareAmount;
        this.sharePrice = sharePrice;
        this.note = note;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(double shareAmount) {
        this.shareAmount = shareAmount;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && userId == that.userId && Double.compare(that.shareAmount, shareAmount) == 0 && Double.compare(that.sharePrice, sharePrice) == 0 && date == that.date && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, userId, shareAmount, sharePrice, note, date);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", shareAmount=" + shareAmount +
                ", sharePrice=" + sharePrice +
                ", note=" + note +
                '}';
    }
}
