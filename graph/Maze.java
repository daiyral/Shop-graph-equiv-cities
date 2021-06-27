package graph;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class Maze implements GraphInterface<Place> {
private Vals[][]maze;
private int size;
private Place start,end;
private enum Vals{EMPTY,START,END,WALL;
	@Override
	public String toString()
	{
		switch(this)
		{
		case EMPTY: return ".";
		case START: return "S";
		case END: return "E";
		case WALL: return "@";
		default: throw new IllegalArgumentException();
		}
	}
}
	public Maze(int size, int startx, int starty, int endx, int endy){
		start= new Place(startx,starty,size);
		end= new Place(endx,endy,size);
		this.size=size;
		maze=new Vals[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				maze[i][j]=Vals.EMPTY;
		maze[startx][starty]=Vals.START;
		maze[endx][endy]=Vals.END;
	}
	public boolean addWall(int x, int y){
		Place wall=new Place(x,y,size);
		if(maze[x][y]!=Vals.EMPTY)
			return false;
		maze[x][y]=Vals.WALL;
		return true;
	}
	public String toString()
	{
		StringBuilder b=new StringBuilder();
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
				b.append(maze[i][j].toString());
			b.append("\n");
		}
		return b.toString();		
	}

	public boolean isSolvable()
	{
		Graph<Place> g=new Graph<>();
		Place temp;
		Set<Place> met =new HashSet<>();
		//builds vertecies
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(maze[i][j]!=Vals.WALL)
				{
				try {
						g.addVertex(new Place(i,j,size));}
				catch(GraphException e) {e.printStackTrace();}	
				}	
		
		
		//build edges
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(maze[i][j]!=Vals.WALL)
				try{
					temp=new Place(i,j,size);
					if(met.add(temp))
						for(Place u:neighbours(temp))
							//if(met.add(u))
								g.addEdge(u, temp);}catch(GraphException e){};
			
		try { return g.connected(start, end);}
		catch(GraphException e) {e.printStackTrace(); return false;} 
	}
	


	public Collection<Place> neighbours(Place p){
		Collection<Place> temp=new ArrayList<>();
		int x=p.getX();
		int y=p.getY();
		if(x+1<size  && maze[x+1][y] != Vals.WALL ) temp.add(new Place(x+1,y,size));
		if(x-1>0 && maze[x-1][y] != Vals.WALL) temp.add(new Place(x-1,y,size));
		if(y+1<size && maze[x][y+1] != Vals.WALL) temp.add(new Place(p.getX(),p.getY()+1,size));
		if(y-1>0 && maze[x][y-1] != Vals.WALL) temp.add(new Place(p.getX()-1,p.getY()-1,size));
		return temp;
	}
}
