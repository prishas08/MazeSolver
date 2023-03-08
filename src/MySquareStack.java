
public class MySquareStack {
	
	private Square[] stack;
	private int size;
	
	public MySquareStack()
	{
		this(7);
	}
	public MySquareStack(int initCap)
	{
		stack = new Square[initCap];
		size = initCap;
		
	}
	
	public boolean isEmpty()
	{
		if(stack.length==0)
		{
			return true;
		}
		return false;
	}
	
	public int getSize()
	{
		return stack.length;
	}
	public Square peek()
	{
		return stack[stack.length-1];
	}
	
	public Square pop()
	{
		Square x = stack[0];
		Square[] temp = new Square[stack.length-1];
		x = stack[stack.length-1];
		for(int i = 0; i<temp.length; i++)
		{
			temp[i]=stack[i];
		}
		stack = new Square[getSize()-1];
		for(int i = 0; i<stack.length; i++)
		{
			stack[i]=temp[i];
		}
		return x;
	}
	
	public void push(Square item)
	{
		Square[] temp = new Square[stack.length+1];
		for(int i = 0; i<stack.length+1; i++)
		{
			if(stack.length>0)
			{
				if(i==stack.length)
				{
					temp[i]= item;
				}
				else
				{
					temp[i]=stack[i];
				}
			}
			else
			{
				temp[0]=item;
			}
			
		}
		stack = new Square[getSize()+1];
		for(int i = 0; i<stack.length; i++)
		{
			stack[i]=temp[i];
		}
	}
	
	private void doubleCapacity()
	{
		Square[] temp = new Square[stack.length*2];
		for(int i = 0; i<stack.length; i++)
		{
			temp[i]=stack[i];
		}
		stack = new Square[getSize()*2];
		for(int i = 0; i<stack.length; i++)
		{
			stack[i]=temp[i];
		}
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(int i = stack.length-1; i>0; i--)
		{
				s+=stack[i] + "\n";
		}
		return s;
	}
	

}
