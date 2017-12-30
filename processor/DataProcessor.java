package processor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class reads through file of commands and outputs results
 */
public class DataProcessor {
	
	private ArrayList<CreditCard> list; //List used to hold group of credit card accounts
	File file;
	
	/**
	 * Constructor that reads file
	 * @param fileName
	 */
	public DataProcessor(String fileName) throws FileNotFoundException
	{
		file = new File(fileName);
		list = new ArrayList<CreditCard>();
	}
	
	/**
	 * Parses through selected text file, reads the command and processes them, resulting in an ArrayList of CreditCard accounts 
	 * and balances based on commands in the text file
	 */
	public void process() throws FileNotFoundException
	{
		Scanner scan = new Scanner(file);
		 while(scan.hasNextLine())
		 {
			 String input = scan.nextLine();
			 Scanner reader = new Scanner(input);
			 
			 String command = reader.next();
			 
			 if(command.equals("Add"))
				{
					String name = reader.next();
					String id = reader.next();
					String limit = reader.next();
					CreditCard newUser = new CreditCard(name, id, limit);
					list.add(newUser);
					reader.close();
				}
			else if(command.equals("Charge"))
				{
					String name = reader.next();
					String price = reader.next();
					
					for(int i=0; i<list.size(); i++)
					{
						if(name.equals(list.get(i).getName()))
						{
							list.get(i).charge(price);;
						}
					}
					reader.close();
				}
			else if(command.equals("Credit"))
				{
					String name = reader.next();
					String price = reader.next();
					for(int i=0; i<list.size(); i++)
					{
						if(name.equals(list.get(i).getName()))
						{
							list.get(i).credit(price);;
						}
					}
					reader.close();
				}
			 
			 
		 }
		 scan.close();
	}
	
	/**
	 * Returns the names and balances of each credit card and its balance
	 */
	public void getData()
	{
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getData());
		}
	}
	
	/**
	 * Sorts list of credit card accounts in alphabetical order using selection sort
	 */
	public void sort()
	{
		for(int i = 0; i<list.size(); i++)
		{
			int min = 0;
			for(int j = i+1; j<list.size(); j++)
			{
				if(list.get(j).getName().compareTo(list.get(j).getName())<0)
				{
					min = j;
				}
			}
			
			CreditCard temp =  list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
	}

}
