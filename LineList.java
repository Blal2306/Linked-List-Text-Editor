public class LineList{
	
	//First and last DUMMY NODES
	private LineNode first; //HEAD
	private LineNode last; //TAIL
	
	private LineNode cursor; //CURSOR 
	
	private int howMany;
	
	public LineList()
	{
		first = null;
		last = null;
		cursor = null;
		
		howMany = 0;
	}
	//INSERT A NODE WHERE THE CURSOR IS
	public boolean insertBeforeCursor(String data)
	{
		//special case if the list is empty
		//can't insert to an empty list
		if(isEmpty())
		{
			System.out.println("... CAN'T INSERT INTO AN EMPTY LIST");
			return false;
		}
		
		else
		{
			LineNode x = new LineNode();
			x.setLine(data);
			x.setPrev(cursor.getPrev());
			x.setNext(cursor);
			
			cursor.getPrev().setNext(x);
			cursor.setPrev(x);

			howMany++;
			return true;
			
		}
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public void append(String data)
	{
		LineNode newNode = new LineNode();
		newNode.setLine(data);

		
		if(isEmpty())
		{
			first = newNode;
			cursor = first;
			
			howMany++;
		}
		
		else
		{
			newNode.setNext(last.getNext());
			newNode.setPrev(last);
			
			last.setNext(newNode);
			
			howMany++;
		}
		
		last = newNode;
		cursor = last;
	}
	public boolean removeCursor()
	{
		
		if(cursor == null) //EMPTY LIST
		{
			System.out.println("... LIST IS EMPTY");
			return false;
		}
		if(size() == 1) //ONLY ITEM IN THE LIST
		{
			first = null;
			last = null;
			cursor = null;
			
			howMany--;
			return true;
		}
		if(cursor.getNext() == null) //REMOVING AT THE END OF THE LIST
		{
			cursor.getPrev().setNext(null);
			cursor = cursor.getPrev();
			last = cursor;
			
			howMany--;
			return true;
		}
		if(cursor.getPrev() == null) //REMOVING AT THE BEGINING
		{
			cursor.getNext().setPrev(null);
			cursor = cursor.getNext();
			first = cursor;
			howMany--;
			return true;
		}

		else
		{
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getPrev();
			howMany--;
			return true;
		}
	}
	public static void printListFull(LineList a)
	{
		LineNode n;
		for(n = a.first; n!=null; n = n.getNext())
			System.out.println(n.getLine());
	}
	public String nextLine()
	{
		if(isEmpty())
			throw new IllegalArgumentException("EMPTY LIST ....");
		if(cursor.getNext()!=null)
		{
			cursor = cursor.getNext();
			return cursor.getLine();
		}
		return "AT THE END ...";
	}
	public String previousLine()
	{
		if(isEmpty())
			throw new IllegalArgumentException("EMPTY LIST ....");
		if(cursor.getPrev()!=null)
		{
			cursor = cursor.getPrev();
			return cursor.getLine();
		}
		return "... AT THE BEGINING";
	}
	public int cursorLineNo()
	{
		int count = 0;
		LineNode x;
		for(x = first; x!=cursor; x = x.getNext())
			count++;
		
		return count;
		
	}
	public void printCursor()
	{
		System.out.println(cursor.getLine());
	}
	public LineNode printList(int startingLine, int endingLine)
	{
		if(endingLine > size())
			throw new IllegalArgumentException("ENDING EXCEDES THE LIST ....");
		if(startingLine > endingLine)
			throw new IllegalArgumentException("START > END ....");
		int count = 0;
		LineNode x;
		for(x = first; count <= endingLine; x = x.getNext())
		{
			if(count >= startingLine)
				System.out.println(x.getLine());
			count++;
		}
		
		cursor = x;
		return cursor;
	}
	public int size()
	{
		return howMany;
	}
}
