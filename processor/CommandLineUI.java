package processor;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;


public class CommandLineUI {
	public static void main(String[]args) throws FileNotFoundException
	{
		System.out.print("Data: ");
		System.out.println(args[0]);
		DataProcessor data = new DataProcessor(args[0]);
		data.process();
		data.getData();
	}

}
