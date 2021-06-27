package graph;

public class Place {
	private int x,y,bound;
	public Place(int x,int y,int bound) {
		if(x<0 || x>bound-1)
			throw new IllegalArgumentException();
		if(y<0 || y>bound-1)
			throw new IllegalArgumentException();
		this.x=x;
		this.y=y;
		this.bound=bound;
	}
public int getX() {return x;}
public int getY() {return y;}
@Override
public int hashCode()
{
	return x%(y+1);
}


@Override
public boolean equals(Object other){
	Place z =(Place)other;
	return (z.getX()==x && z.getY()==y);

}
}
