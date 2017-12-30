package processor;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EclipseUI {
	
	public static void main(String[]args) throws FileNotFoundException
	{
		
		System.out.println("Input the file you want to process: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();
		scan.close();
		System.out.print("Data: ");
		
		DataProcessor data = new DataProcessor(fileName);
		data.process();
		data.getData();
	}

}
