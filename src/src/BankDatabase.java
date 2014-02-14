/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

public class BankDatabase
{
    private Account[] accounts;
    
    public BankDatabase()
    {
        accounts = new Account[2];
        accounts[0] = new Account(123, 1122, 100.00, 1000.00);
        accounts[1] = new Account(456, 9876, 1000.00, 1000000.00);
    }
    
    public boolean authenticateUser(int acct, int pin)
    {
        for (int c = 0; c < accounts.length; c++)
        {
            if (acct == accounts[c].getAccountNumber() && accounts[c].validatePin(pin))
                return true;
        }
        
        return false;
    }
    
    public double getAvailableBalance(int acct)
    {
        for (int c = 0; c < accounts.length; c++)
        {
            if (acct == accounts[c].getAccountNumber())
                return accounts[c].getAvailableBalance();
        }

        return 0.0;
}

    public double getTotalBalance(int userAccountNumber)
    {
    	return getAccount( userAccountNumber ).getTotalBalance();
    }
    
    public void credit(int acct, double amount)
    {
        for (int c = 0; c < accounts.length; c++)
        {
            if (acct == accounts[c].getAccountNumber())
                accounts[c].credit(amount);
        }
    }

    public void debit(int acct, double amount)
    {
        for (int c = 0; c < accounts.length; c++)
        {
            if (acct == accounts[c].getAccountNumber())
                accounts[c].debit(amount);
        }
    }

    // Use this function if it is safe to assume always receiving a valid acct number
    private Account getAccount(int acct)
    {
        for (int c = 0; c < accounts.length; c++)
        {
            if (acct == accounts[c].getAccountNumber())
                return accounts[c];
        }
        
        return null;
    }
}

