package src;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridLayoutFrame extends JFrame implements ActionListener {
	private JButton[] buttons;
	private static final String[] names = 
		{"1", "2", "3", "4", "5", "6", "7", "8", "9", "CLEAR", "0", "ENTER"};
	private JTextField guiConsole;
	private JTextField result;
	private JButton menuButton;
	private JButton cashButton;
	private BankDatabase db;

	private int currentState;
	private String userInput;
	private boolean withdraw = false;
	private boolean deposit = false;
	private boolean cashAction = false;
	private int incorrect;
	
	private int acct;
	private int pin;
	
	
	private boolean acctEntered = false;
	private boolean pinEntered = false;
//	private boolean accBool = false;
//	private boolean accBool = false;
			
	
	//constructor
	public GridLayoutFrame()
	{	
		super( "Welcome to Bank of America!");
		
		currentState = 0;
		
		db = new BankDatabase();
		guiConsole = new JTextField(30);
		result = new JTextField(30);
		menuButton = new JButton("MAIN MENU");
		cashButton = new JButton("CASH DISPENSER"); 
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(result);
		p1.add(guiConsole);
		p1.add(menuButton);
		p1.add(cashButton);
		
	    guiConsole.setEditable(false);
	    result.setEditable(false);
	    
	    //listener for menu button and collect button
	    menuButton.addActionListener( this );
	    cashButton.addActionListener( this );
	    
		//numpad panel
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 3));
		buttons = new JButton[ names.length ];
		for ( int count = 0; count < names.length; count++ )
		{
			buttons[ count ] = new JButton( names[ count ] );
			buttons[ count ].addActionListener( this );
			p2.add( buttons[ count ] );
		}
		
		
		//panel to unite numpad and display
		JPanel p = new JPanel();
		p.setLayout(new GridLayout());
		p.add(p1, BorderLayout.NORTH);
		p.add(p2, BorderLayout.SOUTH);
		
		add(p);

//		guiConsole.setText("Please enter your pin");
//		int pin = keypad.getInput();
//		
//		db.authenticateUser(keypad.getInput(), pin);
//		
//		
//		guiConsole.setText("Please choose an option:");
//		guiConsole.append("\n");	//why must this newline have it's own line?
//		guiConsole.append("\n");
//		guiConsole.append("1. Main Menu");
//		guiConsole.append("\n");
//		guiConsole.append("2. Withdraw");
//		guiConsole.append("\n");
//		guiConsole.append("3. Deposit");
//		guiConsole.append("\n");
//		guiConsole.append("4. Exit");
	
	}
	
	
	//run the program
	public void run()
	{
		guiConsole.setText("Please enter your Account Number\n");
	}
	
	//is this considered recursion?
	public String getText()
	{
		return guiConsole.getText();
	}
	
	
//have const that define current state 1 2 3 4, initialize as 0 for main menu
	//enable enter and clear button only when its in the right current state
	public void actionPerformed( ActionEvent event )
	{
		if (event.getSource() == menuButton)
		{
			if (db.authenticateUser(acct, pin))
			{
				guiConsole.setText("1. CheckBalance 2. Withdraw 3. Deposit 4. Exit");
				result.setText("");
				currentState = 2;
			}
			else
			{
				String message = "That is not a valid input, try again";
				JOptionPane.showMessageDialog(null, message);	
			}
		}
			
		if (event.getSource() == cashButton)
		{
			if (withdraw)
			{
				String message = "Cash retrieved";
				JOptionPane.showMessageDialog(null, message);
				guiConsole.setText("1. CheckBalance 2. Withdraw 3. Deposit 4. Exit");
				result.setText("");
				currentState = 2;
				withdraw = false;
			}
			else if (deposit)
			{
				String message = "Cash Inserted";
				JOptionPane.showMessageDialog(null, message);
				guiConsole.setText("1. CheckBalance 2. Withdraw 3. Deposit 4. Exit");
				result.setText("");
				currentState = 2;
				deposit = false;
			}
			else
			{
				String message = "That is not a valid input, try again";
				JOptionPane.showMessageDialog(null, message);	
			}
		}
			
		if (event.getSource() == buttons[0])
		{
			result.setText(result.getText() + "1");
		}
		
		if (event.getSource() == buttons[1])
		{
			result.setText(result.getText() + "2");
		}
		
		if (event.getSource() == buttons[2])
		{
			result.setText(result.getText() + "3");
		}

		if (event.getSource() == buttons[3])
		{
			result.setText(result.getText() + "4");
		}
		
		if (event.getSource() == buttons[4])
		{
			result.setText(result.getText() + "5");
		}
		
		if (event.getSource() == buttons[5])
		{
			result.setText(result.getText() + "6");
		}
		
		if (event.getSource() == buttons[6])
		{
			result.setText(result.getText() + "7");
		}
		
		if (event.getSource() == buttons[7])
		{
			result.setText(result.getText() + "8");
		}
		
		if (event.getSource() == buttons[8])
		{
			result.setText(result.getText() + "9");
		}
		
		if (event.getSource() == buttons[10])
		{
			result.setText(result.getText() + "0");
		}
		
		//the CLEAR button
		if (event.getSource() == buttons[9])
		{
			result.setText("");
		}
		
	
//		0 - enter acc number
//		1 - enter pin number
//		2 - Main Menu
		
		//THE ENTER BUTTON
		if (event.getSource() == buttons[11])
		{
			if (!result.getText().equals(""))
			{
				//enter acc number
				if (currentState == 0)
				{
					acct = Integer.parseInt(result.getText());
					System.out.printf("%d", acct);
					result.setText("");
					currentState = 1;
					guiConsole.setText("Please enter your pin number");
				}
				//validate pin
				else if (currentState == 1)
				{
					pin = Integer.parseInt(result.getText());
					result.setText("");
					if (db.authenticateUser(acct, pin))
					{
						guiConsole.setText("1. CheckBalance 2. Withdraw 3. Deposit 4. Exit");
						result.setText("");
						currentState = 2;
					}
					else if (incorrect > 2)
					{
						String message = "Password was incorrect more than 3 times!";
						JOptionPane.showMessageDialog(null, message);
	//					gridlayout.dispose();
					}
					else
					{
						guiConsole.setText("pin number was incorrect, please try again");
						result.setText("");
						incorrect++;
					}
				}
				
				//handle the withdraw transaction
				else if (withdraw == true)
				{
					guiConsole.setText("Please click on CASH DISPENSER to collect your cash");
					cashAction = true;
				}
				
				else if (deposit == true)
				{
					guiConsole.setText("Please click on CASH DISPENSER to insert your cash");
					cashAction = true;
				}
				
				//The Main Menu
				else if (currentState == 2)
				{
					if (Integer.parseInt(result.getText()) == 1)
					{
						String amount = String.valueOf(db.getTotalBalance(acct));
						guiConsole.setText(amount);	
					}
	
					else if (Integer.parseInt(result.getText()) == 2)
					{
						guiConsole.setText("How much do you want to withdraw?");
						db.debit(acct, Integer.parseInt(result.getText()));
						result.setText("");
						withdraw = true;
					}
					
					
					else if (Integer.parseInt(result.getText()) == 3)
					{
						guiConsole.setText("How much do you want to deposit?");
						db.credit(acct, Integer.parseInt(result.getText()));
						result.setText("");
						deposit = true;
					}
					
					else if (Integer.parseInt(result.getText()) == 4)
					{
						guiConsole.setText("Please enter your account number");
						result.setText("");
						currentState = 0;
					}
						
					else
					{
						guiConsole.setText("That is not a valid choice, please try again");
						result.setText("");
					}
				}
			}
			else
			{
				String message = "That is not a valid input, try again";
				JOptionPane.showMessageDialog(null, message);	
			}
		}//end button 11
	}
}
