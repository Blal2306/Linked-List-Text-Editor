//----------
//NODE CLASS
//----------
class LineNode
{
	
	public String data;
	public LineNode prev;
	public LineNode next;

	public LineNode()
	{}
	//----------------------------
	//ACCESSOR AND MUTATOR METHODS
	//----------------------------
	public void setLine(String line)
	{this.data = line;}
	public String getLine()
	{return data;}
	public void setPrev(LineNode x)
	{prev = x;}
	public void setNext(LineNode x)
	{next = x;}
	public LineNode getPrev()
	{return prev;}
	public LineNode getNext()
	{return next;}
	public String toString()
	{
		return data;
	}
}