package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class CapitalAccount
{
    private int accountID;
    private String accountHolderName;
    private double accountBalance;
    private double initialBalance;

    public int getAccountID()
    {
        return accountID;
    }

    public void setAccountID(int accountID)
    {
        this.accountID = accountID;
    }

    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName)
    {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }

    public double getInitialBalance()
    {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance)
    {
        this.initialBalance = initialBalance;
    }
}
