package pk.anas.accounting.entities;

import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class BankTransaction
{
    private int transactionID;
    private int bankAccountID;
    private boolean isCredit;
    private double transactionAmount;
    private String transactionDescription;
    private Timestamp transactionTimestamp;

    public int getTransactionID()
    {
        return transactionID;
    }

    public void setTransactionID(int transactionID)
    {
        this.transactionID = transactionID;
    }

    public int getBankAccountID()
    {
        return bankAccountID;
    }

    public void setBankAccountID(int bankAccountID)
    {
        this.bankAccountID = bankAccountID;
    }

    public boolean isIsCredit()
    {
        return isCredit;
    }

    public void setIsCredit(boolean isCredit)
    {
        this.isCredit = isCredit;
    }

    public double getTransactionAmount()
    {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount)
    {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDescription()
    {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription)
    {
        this.transactionDescription = transactionDescription;
    }

    public Timestamp getTransactionTimestamp()
    {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Timestamp transactionTimestamp)
    {
        this.transactionTimestamp = transactionTimestamp;
    }
}
