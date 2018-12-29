/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.business.transactions;

import accounts.model.Account;
import java.util.Date;

public class Transaction {

    public Transaction(TransactionId id, Date date, long amount, Account maDati, Account dal, String comment) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.maDati = maDati;
        this.dal = dal;
        this.comment = comment;
    }

    private TransactionId id;
    private Date date;
    private long amount;
    private Account maDati;
    private Account dal;
    private String comment;

    /**
     * @return the id
     */
    public TransactionId getId() {
        return id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @return the maDati
     */
    public Account getMaDati() {
        return maDati;
    }

    /**
     * @return the dal
     */
    public Account getDal() {
        return dal;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

}
