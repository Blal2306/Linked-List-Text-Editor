import java.util.Scanner;


public class Editor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner x = new Scanner(System.in);
		char input; //Holds the user's menu option
		int count; //temp count variable
		String line;
		LineList myList = new LineList();
		
		printMenu();
		input = getInput();
		while(Character.toLowerCase(input)!='Q'){
		switch(Character.toUpperCase(input))
		{
			case 'A': 
				System.out.print("HOW MANY LINES TO APPEND : ");
				count = x.nextInt();
				while(count!=0)
				{
					System.out.print("ENTER LINE "+count+" : ");
					line = x.next();
					myList.append(line);
					
					count--;
				}
				break;
			case 'H': helpMenu(); break;
			case 'I': 
				System.out.print("HOW MANY LINES : ");
				count = x.nextInt();
				while(count!=0)
				{
					System.out.print("ENTER LINE "+count+" : ");
					line = x.next();
					myList.insertBeforeCursor(line);
					
					count--;
				}
				break;
			case 'L':
				System.out.print("ENTER THE START : ");
				int start = x.nextInt();
				System.out.print("ENTER THE END : ");
				int end = x.nextInt();
				System.out.println("*********");
				myList.printList(start, end);
				System.out.println("*********");
				
				break;
			case 'F':
				System.out.println("*********");
				System.out.println("PRINTING");
				System.out.println("*********");
				
				LineList.printListFull(myList);
				System.out.println("*********");
				break;
				
			case 'N':
				System.out.println(myList.nextLine());
				break;
			case 'P':
				System.out.println(myList.previousLine());
				break;
			case 'R':
				myList.removeCursor();
				break;
			case 'Q':
				System.out.println("QUITING ....");
				System.exit(0);
		}
		printMenu();
		input = getInput();
		}
		
		
		
	}
	public static void printMenu()
	{
		System.out.println("-----");
		System.out.println("MENU");
		System.out.println("-----");
		
		System.out.println("A\t"+"<number of lines>");
		System.out.println("H\t"+"<Help>");
		System.out.println("I\t"+"<number of lines>");
		System.out.println("L\t"+"<Starting Line>  "+"<Ending Line>");
		System.out.println("F\t"+"<Print full list>");
		System.out.println("N\t"+"<Move forward to the next Line>");
		System.out.println("P\t"+"<Move backward to the previous line>");
		System.out.println("R\t"+"<Remove the current line>");
		System.out.println("Q\t"+"<Quit>");
		
		System.out.println();
		System.out.println("--------------------------------------------");
	}
	public static void helpMenu()
	{
		System.out.println("----------");
		System.out.println("HELP MENU");
		System.out.println("----------");
		
		
		System.out.println("No help available !");
	}
	public static char getInput()
	{
		System.out.print("ENTER THE OPTION : ");
		Scanner keyboard = new Scanner(System.in);
		String in =  keyboard.next();
		
		
		return in.charAt(0);
	}

}
