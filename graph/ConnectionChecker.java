package graph;

public class ConnectionChecker<V>  {
	private GraphInterface<V> g;
	public ConnectionChecker(GraphInterface<V> g) {
		this.g=g;
	}
	public boolean check(V v1, V v2) {
		for(V u:g.neighbours(v1))
		{
			if(u.equals(v2)) return true;
			check(u,v2);
		}
		return false;
	}

}
