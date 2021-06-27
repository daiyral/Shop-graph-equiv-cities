package equiv;
import java.util.ArrayList;
import java.util.List;
public class Equiv<E> {
	private List<E> [] groups;
	private int num=0;
	@SuppressWarnings("unchecked")
	private Equiv(int size) {
		groups=(List<E>[])new List[size];//starting size for groups we will increase this size if needed
	}
	public Equiv()
	{
		this(10);
	}
	public void add(E e1,E e2){
		int indexE1=exists(e1);
		int indexE2=exists(e2);
		if(num==groups.length)
			{
			 doubleSize();
			}
		if(indexE1==-1&&indexE2==-1)
		{
			groups[num]=new ArrayList<>();
			groups[num].add(e1);
			groups[num].add(e2);
			num++;
		}
		else if(indexE1==-1)
		{
			groups[indexE2].add(e1);
		}
		else if(indexE2==-1)
		{
			groups[indexE1].add(e2);
		}
		else if(indexE1==indexE2) return;
		else//if both elements are their own equivalent group we add all elements in the group to the other
		{
			groups[indexE1].addAll(groups[indexE2]);
			groups[indexE2].clear();
			groups[indexE2]=null;
			num--;
			for(int i=indexE2;i<num;i++)
				groups[i]=groups[i+1];
		}	
	}
	private int exists(E e)
	{
		if(num==0) return -1;
		for(int i=0;i<num;i++)
		 if(groups[i].contains(e)) return i;	
		return -1;
	}
	public boolean are(E e1,E e2)
	{
		return exists(e1)==exists(e2);
	}
	private void doubleSize(){
		Equiv<E> temp=new Equiv<E>(groups.length *2);
		for(int i=0;i<groups.length;i++)
			temp.groups[i]=groups[i];
		groups=temp.groups;		
		
	}
	
	
}
