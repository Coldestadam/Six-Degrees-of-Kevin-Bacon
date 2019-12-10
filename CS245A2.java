import java.io.File; 
import java.io.IOException;
import java.util.Scanner;


//Main File to run the program.
public class CS245A2
{
	public static void main(String args[])
	{
		File csvfile;
		String filename = args[0];
		Graph graph = new Graph();
		CSVReader reader = new CSVReader();
		Scanner scan = new Scanner(System.in);
		

		try
		{
			csvfile = new File(filename);
			reader.traverse(csvfile, graph);
		}

		catch (IOException e) 
		{
			System.out.println("Your inputted file does not exist.");
		}


		boolean foundActor1 = false;
		boolean foundActor2 = false;
		String actor1 = "";
		String actor2 = "";
		while(!foundActor1)
		{
			System.out.print("Actor 1 name: ");
			actor1 = scan.nextLine().toLowerCase();
			if(graph.containsActor(actor1))
			{
				foundActor1 = true;
			}
			else
			{
				System.out.println("No such actor.");
			}
		}
		while(!foundActor2)
		{
			System.out.print("Actor 2 name: ");
			actor2 = scan.nextLine().toLowerCase();
			if(actor2.equals(actor1))
			{
				System.out.println("You inputted the same actor twice, please enter a different one: ");
			}
			else
			{
				if(graph.containsActor(actor2))
				{
					foundActor2 = true;
				}
				else
				{
					System.out.println("No such actor.");
				}
			}
		}
		reader.DFS(graph, actor1, actor2);
		scan.close();
	}
}