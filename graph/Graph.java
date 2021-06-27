package graph;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
public class Graph<V> {
	private Set<V> verticies;
	private Map<V,Set<V>>edges;
	public Graph() {
		verticies=new HashSet<>();
		edges=new HashMap<V,Set<V>>();
	}
public void addVertex(V v) throws GraphException
{
	if(!verticies.add(v)) throw new GraphException("Vertex already exsist");
	edges.put(v, new HashSet<>());
}
public void addEdge(V v1, V v2) throws GraphException
{
		if(verticies.contains(v1)){
			if(verticies.contains(v2))
			{
				if(!edges.get(v1).add(v2))  throw new GraphException("Edge already exists");
				if(!edges.get(v2).add(v1))  throw new GraphException("Edge already exists");
			}
			else
				throw new GraphException("Vertex v2 doesn't exsist"); 
		}
		else
			throw new GraphException("Vertex v1 doesn't exsist"); 
}
public boolean hasEdge(V v1,V v2)
{
	return edges.get(v1).contains(v2);
}
public boolean connected (V v1,V v2) throws GraphException
{
	if(!verticies.contains(v2)) throw new GraphException("Vertex v2 doesn't exsist"); 
	if(!verticies.contains(v1)) throw new GraphException("Vertex v1 doesn't exsist"); 
	Map<V,Double> d=new HashMap<>();
	Queue<V> q=new PriorityQueue<>();
	Set<V> met =new HashSet<>();
	for(V v:verticies)
	{
		d.put(v,Double.POSITIVE_INFINITY);
	}
	d.replace(v1, 0.0);
	q.add(v1);
	while(q.peek()!=null)
	{
		V u=q.remove();
		met.add(u);
		for(V v:edges.get(u))
		{
			if(met.add(v)){//checks if we have visited the node or not
				d.replace(v,d.get(u)+1);
				q.add(v);
			}
		}
	}
	if(d.get(v2)!= Double.POSITIVE_INFINITY) return true;
	return false;
		
}


}
