package utilities;

import java.io.*;
import java.util.Scanner;

public class IdDispenser {
	public static int getID() throws FileNotFoundException,IOException
	{
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/utilities/id.txt"));
		int id = input.nextInt()+1;
		PrintStream output = new PrintStream(new File(System.getProperty("user.dir") + "/src/utilities/id.txt"));
		output.print(id);
		output.close();
		return id;
	}
}
