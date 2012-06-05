package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class BankAccount
{
    private int accountID;
    private String accountHolderName;
    private String accountNumber;
    private String bankName;
    private String bankBranchName;
    private String bankBranchCode;
    private String branchAddress;
    private String branchCity;
    private String accountType;
    private double accountBalance;

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

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBankBranchName()
    {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName)
    {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchCode()
    {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode)
    {
        this.bankBranchCode = bankBranchCode;
    }

    public String getBranchAddress()
    {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress)
    {
        this.branchAddress = branchAddress;
    }

    public String getBranchCity()
    {
        return branchCity;
    }

    public void setBranchCity(String branchCity)
    {
        this.branchCity = branchCity;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }
}
