import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Maze {
	
	
	public Square MazeArray[][];
	public int[][] tempArray;
	public static final String fileN = "maze-2";
	public Square start;
	public Square end;
	
	public Maze()
	{
		loadMaze(fileN);
	}
	public boolean loadMaze(String fileName)
	{
		try {
			//System.out.println("IM HERE");
			File file = new File (fileName);
			Scanner scan = new Scanner(file);
			int finalRow = scan.nextInt();
			int finalCol = scan.nextInt();
			tempArray = new int[finalRow][finalCol];
			int counter = 0;
			for(int i = 0; i < finalRow; i++)
			{
				for(int x = 0; x < finalCol; x++)
				{
					tempArray[i][x] = scan.nextInt();
					
					//System.out.println(tempArray[i][x]);
				}
			}
			/*while(scan.hasNext())
			{
				while(!scan.hasNextLine())
				{
					//never goes inside of here, so the loop goes on forever because the nextInt() is never called
					for(int i = 0; i < tempArray.length; i++)
					{
							tempArray[i][finalRow] = scan.nextInt();
							finalCol = i;
					}

				}
				finalRow++;
				
			}*/
			MazeArray = new Square[finalRow][finalCol];
			for(int i = 0; i < MazeArray.length; i++)
			{
				for(int x = 0; x < MazeArray[0].length; x++)
				{
					MazeArray[i][x] = new Square(i, x, tempArray[i][x]);
					if(tempArray[i][x]==2 && counter==0)
					{
						start = MazeArray[i][x];
					}
					if(tempArray[i][x]==3)
					{
						end = MazeArray[i][x];
					}
					//System.out.println(MazeArray[i][x]);
				}
			}
			//System.out.println("Row: " + finalRow);
			//System.out.println("Col: " + finalCol);

			return true;
		}
		catch(FileNotFoundException e)
		{
			//System.out.println("The File Could Not Be Read");
			return false;
		}
	}
	
	public ArrayList<Square> getNeighbors (Square s)
	{
		ArrayList<Square> list = new ArrayList<Square>();
		int cordRow = s.getRow();
		int cordCol = s.getCol();
		//North = row - 1, col
		if(cordRow>0)
		{
			list.add(MazeArray[cordRow-1][cordCol]);
		}
		//East = row, col + 1
		if(cordCol<MazeArray[0].length-1)
		{
			list.add(MazeArray[cordRow][cordCol+1]);
		}
		//South = row + 1, col
		if(cordRow<MazeArray.length-1)
		{
			list.add(MazeArray[cordRow+1][cordCol]);
		}
		//West = row, col - 1
		if(cordCol>0)
		{
			list.add(MazeArray[cordRow][cordCol-1]);
		}
		return list;
	}
	
	public Square getStart()
	{
		/*Square start = MazeArray[0][0];
		for(int i = 0; i < MazeArray.length; i++)
		{
			for(int x = 0; x < MazeArray[0].length; x++)
			{
				if(MazeArray[i][x].getType()==2)
				{
					start = MazeArray[i][x];
				}
			}
		}*/
		return start;
	}
	public Square getExit()
	{
		/*Square exit = MazeArray[0][0];
		for(int i = 0; i < MazeArray.length; i++)
		{
			for(int x = 0; x < MazeArray[0].length; x++)
			{
				if(MazeArray[i][x].getType()==3)
				{
					exit = MazeArray[i][x];
				}
			}
		}*/
		return end;
	}
	
	public void reset()
	{
		loadMaze(fileN);
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < MazeArray.length; i++)
		{
			for(int x = 0; x < MazeArray[0].length; x++)
			{
				s+= MazeArray[i][x] + " ";
			}
			s+="\n";
		}
		return s;
	}
	

}
