package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class Customer
{
    private int customerID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mobileNumber;
    private String emailAddress;
    private String streetAddLine1;
    private String streetAddLine2;
    private String city;
    private String province;
    private String country;
    private String bankName;
    private String branchName;
    private String branchCode;
    private String bankAccountNo;

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getStreetAddLine1()
    {
        return streetAddLine1;
    }

    public void setStreetAddLine1(String streetAddLine1)
    {
        this.streetAddLine1 = streetAddLine1;
    }

    public String getStreetAddLine2()
    {
        return streetAddLine2;
    }

    public void setStreetAddLine2(String streetAddLine2)
    {
        this.streetAddLine2 = streetAddLine2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(String branchCode)
    {
        this.branchCode = branchCode;
    }

    public String getBankAccountNo()
    {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo)
    {
        this.bankAccountNo = bankAccountNo;
    }
}
