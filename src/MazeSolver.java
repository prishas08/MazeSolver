import java.util.ArrayList;
import java.util.Stack;

public abstract class MazeSolver {
	
	public Maze m;
	public Stack<Square> squareStack;
	public boolean solved;
	int traversedRow = -1;
	int traversedCol = -1;
	
	public MazeSolver(Maze maze)
	{
		m = maze;
	}
	
	public abstract void makeEmpty();
	
	public abstract boolean isEmpty();
	
	public abstract void add(Square s);
	
	public abstract Square next();
	
	public boolean isSolved()
	{
		//System.out.println(solved);
		if(solved || next().getType()==3)
		{
			//System.out.println("Returning true");
			return true;
		}
		return false;
	}
	
	public void step()
	{
		if(isEmpty()==false)
		{
			//System.out.println("INSIDE STEP");
			Square s = next();
			if(next().getType()==0)
			{
				if(traversedRow!=-1)
				{
					m.MazeArray[traversedRow][traversedCol].setStatus('.');
				}
				squareStack.push(s);
				squareStack.peek().setStatus('o');
				m.MazeArray[s.getRow()][s.getCol()].setStatus('o');
				traversedRow = s.getRow();
				traversedCol = s.getCol();
				next();
			}
			else if(next().getType()==1)
			{
				squareStack.peek().setStatus('.');
				m.MazeArray[s.getRow()][s.getCol()].setStatus('.');
				squareStack.pop();
			}
			else if(next().getType()==3)
			{
				solved=true;
			}

		}
		
	}
	
	public String getPath()
	{
		String s = "";
		if(isSolved() == false) 
		{
			s = "Not Yet Solved";
		}
		else if(isSolved()==true)
		{
			s = "Solved";
		}
		else if(isEmpty()==true)
		{
			s = "Unsolvable";
		}
		return s;
	}
	
	public void solve()
	{
		while(solved==false)
		{
			step();
		}
		
	}
	

	

}
