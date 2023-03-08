import java.util.ArrayList;
import java.util.Stack;

public class MazeSolverStack extends MazeSolver 
{
	
	private Maze m;
	
	public MazeSolverStack(Maze maze) 
	{
		super(maze);
		makeEmpty();
	}


	@Override
	public void makeEmpty() 
	{
		
		squareStack = new Stack<Square>();
		m = new Maze();
		squareStack.add(m.getStart());
		
	}

	@Override
	public boolean isEmpty() 
	{
		if(squareStack.size()==0)
		{
			return true;
		}
		return false;
	}

	@Override
	public void add(Square s)
	{
		squareStack.push(s);
		
	}

	@Override
	public Square next() 
	{
		
		ArrayList<Square> solverList = new ArrayList<Square>();
		solverList = m.getNeighbors(squareStack.peek());
		//System.out.println(solverList);

		for(int i = 0; i < solverList.size(); i++)
		{
			if(solverList.get(i).getType()==0 && solverList.get(i).getStatus()!='o')
			{
				return solverList.get(i);
			}
			if(solverList.get(i).getType()==3)
			{
				solved=true;
			}
		}
		return null;
	}

	

	

}
