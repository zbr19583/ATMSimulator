/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

public class Account
{
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    
    public Account()
    {
        accountNumber = -1;
        pin = -9999;
        availableBalance = 1.0;
        totalBalance = -1.0;
    }
    
    public Account(int a, int p, double ab, double tb)
    {
        accountNumber = a;
        pin = p;
        availableBalance = ab;
        totalBalance = tb;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    public int getPin()
    {
        return pin;
    }
    
    public double getAvailableBalance()
    {
        return availableBalance;
    }
    
    public double getTotalBalance()
    {
        return totalBalance;
    }
    
    public void setAccountNumber(int a)
    {
        accountNumber = a;
    }
    
    public void setPin(int p)
    {
        pin = p;
    }
    
    public void setAvailableBalance(double ab)
    {
        availableBalance = ab;
    }
    
    public void setTotalBalance(double tb)
    {
        totalBalance = tb;
    }
    
    public boolean validatePin(int p)
    {
        return (pin == p);
    }
    
    public void credit(double amount)
    {
        totalBalance += amount;
    }
    
    public void debit(double amount)
    {
        totalBalance -= amount;
    }
}
