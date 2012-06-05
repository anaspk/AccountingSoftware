package pk.anas.accounting.entities;

import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class CashTransaction
{
    private int transactionID;
    private double cashInHand;
    private double transactionAmount;
    private Timestamp transactionTimestamp;
    private boolean isCredit;

    public int getTransactionID()
    {
        return transactionID;
    }

    public void setTransactionID(int transactionID)
    {
        this.transactionID = transactionID;
    }

    public double getCashInHand()
    {
        return cashInHand;
    }

    public void setCashInHand(double cashInHand)
    {
        this.cashInHand = cashInHand;
    }

    public double getTransactionAmount()
    {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount)
    {
        this.transactionAmount = transactionAmount;
    }

    public Timestamp getTransactionTimestamp()
    {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Timestamp transactionTimestamp)
    {
        this.transactionTimestamp = transactionTimestamp;
    }

    public boolean isIsCredit()
    {
        return isCredit;
    }

    public void setIsCredit(boolean isCredit)
    {
        this.isCredit = isCredit;
    }
}
