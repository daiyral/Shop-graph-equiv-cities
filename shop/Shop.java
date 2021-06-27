package shop;
import java.util.ArrayList;
import java.util.List;
public class Shop {
	private List<Instrument> l;
	public Shop() {
		l=new ArrayList<>();
	}
	public void add(Instrument I)
	{
		l.add(I);
	}
	public Instrument get(int serial)
	{
		for(Instrument i : l)
		{
			if(i.getSerial()==serial) return i;
		}
		return null;
	}
	public List<Integer> allSerials()
	{
		List<Integer> res=new ArrayList<>();
		for(Instrument i:l)
			res.add(i.getSerial());
		return res;
	}
	public List<Integer> guitarsOfType(Type t)
	{
		List<Integer> res=new ArrayList<>();
		for(Instrument i:l)
			if(i instanceof Guitar && ((Guitar) i).getType()==t)
				res.add(i.getSerial());
		return res;
	}
	public void sell(int serial) throws MusicShopException
	{
		for(Instrument i:l)
		{
			if( i.getSerial()==serial)
			{
				if(i instanceof Guitar)
					if(numOfGuitar()==1) throw new MusicShopException("Only 1 guitar");
			
				l.remove(i);
				return;
			}
		}
			throw new MusicShopException("No such instrument");
	}
	private int numOfGuitar()
	{
		int cnt=0;
		for(Instrument i:l)
			if(i instanceof Guitar) cnt++;
		return cnt;
	}
	
	public int sellAll(int [] serials)
	{
		int cnt=0;
		for(int i : serials)
		{
			try {
				sell(i);
			}
			catch(MusicShopException e) {
				cnt++;
			}
		}
		return cnt;
	}
	

}
