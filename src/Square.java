
public class Square {
	
	public static final int EMPTY_SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;
	public static final char exploring = 'o';
	public static final char alreadyExplored = '.';
	public static final char finalPath = 'x';
	public int row;
	public int col;
	public int type;
	public char status;
	
	public Square(int r, int c, int t)
	{
		row = r;
		col = c;
		if(t == 0)
		{
			this.type = EMPTY_SPACE;
		}
		if(t == 1)
		{
			this.type = WALL;
		}
		if(t == 2)
		{
			this.type = START;
		}
		if(t == 3)
		{
			this.type = EXIT;
		}
	}
	
	public String toString()
	{
		String s = "";
		if(this.type == 0)
		{
			s = "_";
		}
		else if(this.type == 1)
		{
			s = "#";
		}
		else if(this.type == 2)
		{
			s = "S";
		}
		else if(this.type == 3)
		{
			s = "E";
		}
		if (status == exploring)
		{
			s = "o";
		}
		else if (status == alreadyExplored)
		{
			s = ".";
		}
		else if (status == finalPath)
		{
			s = "x";
		}
		return s;
	}
	
	public boolean equals(Object obj)
	{
		if(((Square) obj).getRow()!= this.getRow())
		{
			return false;
		}
		if(((Square) obj).getCol()!= this.getCol())
		{
			return false;
		}
		return true;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public char getStatus()
	{
		return status;
	}
	public void setStatus(char s)
	{
		status = s;
	}
}
