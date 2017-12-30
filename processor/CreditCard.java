package processor;

public class CreditCard {
	
	private int balance; //Balance of credit card accout
	private String name; //Account Name
	private String id; //Account ID#
	private int limit; //ChargeLimit
	private boolean valid; //If creditCard account is valid
	
	
	/**
	 * This constructor accepts takes the name, id number and balance limit, which makes up a credit carad account
	 * 
	 * @param  uName  
	 * @param  uID ID 
	 * @param  uLimit  
	 */
		
	public CreditCard(String uName, String uID, String uLimit)
	{
		balance = 0;
		name = uName;
		id = uID;
		limit = Integer.parseInt(uLimit.substring(1));
		
		
		int[] lunh = new int[id.length()];
		for(int i=0; i<lunh.length; i++) //Use 1 to account for dollar sign
		{
			lunh[i] = Integer.parseInt(id.substring(i, i+1));
		}
		
		int sum = 0;
		for(int i =0; i<lunh.length; i++) //lunh10 modifier
		{
			if(i%2 == 0)
			{
				lunh[i] *= 2;
				if(lunh[i]>9)
				{
					lunh[i] -= 9;
				}
			}
			sum += lunh[i];
		}

		if(sum%10 == 0 && id.length()<=19)
		{
			valid = true;
		}
		else
		{
			valid = false;
		}
		
	}
	
	
	/**
	 * Adds the amount charged to the accounts balance as long as it is not over the account's limit
	 * 
	 * @param  amount
	 */
	
	public void charge(String amount)
	{
		int amountInt  = Integer.parseInt(amount.substring(1));
		if(amountInt + balance <limit && valid == true)
		{
			balance+=amountInt;
		}
	}
	
	/**
	 * subtracts balance from the amount of credit added being applied
	 * 
	 * @param  amount
	 */
	
	public void credit(String amount)
	{
		int amountInt  = Integer.parseInt(amount.substring(1));
		if(valid == true)
		{
			balance-=amountInt;
		}
	}
	
	/**
	 * Returns Name and either balance or error based on whether or not the account is valid
	 */
	public String getData()
	{
		String val = name;
		
		if(valid == true)
		{
			val += ": $" + balance + "\n";
		}
		else
		{
			val += ": Error";
		}
			
		return val;
	}
	
	/**
	 * Returns account Name (for testing) 
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns account account ID (for testing) 
	 */
	public String getID()
	{
		return id;
	}
	
	/**
	 * Returns account balance (for testing) 
	 */
	public int getBalance()
	{
		return balance;
	}
	
	/**
	 * Returns if account is valid (for testing) 
	 */
	public boolean getValidity()
	{
		return valid;
	}
	
	

}
