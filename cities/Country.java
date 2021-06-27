package cities;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
public class Country implements Comparable<Country> {
	private Set<City> cities;
	private int population;
	private String name;
	public Country(String name) {
		this.name=name;
		population=0;
		cities=new TreeSet<>();
	}
	public void addCity(City city)
	{
		if(!this.equals(city.getCountry())) throw new IllegalArgumentException();
		if(!cities.contains(city))
		{
			cities.add(city);
			population+=city.getPopulation();
		}
	}
	public int population() {return population;}

	public String toString(){
		return name;
	}
	public List<City> smallCities(int under){
		List<City> res=new ArrayList<>();
		for(City c:cities)
		{
			if(c.getPopulation()<under) 
		
				res.add(c);
		}
		return res;
	}
	@Override
	public int compareTo(Country other)
	{
		return name.compareTo(other.name);
	}
	@Override
	public boolean equals(Object obj) {
		Country other=(Country) obj;
		if(name!=other.name)return false;
		return true;
	}
	public String report() 
	{
		StringBuilder b=new StringBuilder();
		b.append(toString());
		b.append("(");
		b.append(population);
		b.append(") : ");
		
		for(City c:cities)
		{
			b.append(c.getName());
			b.append("(");
			b.append(c.getPopulation());
			b.append("), ");
		}
		b.delete(b.length()-2,b.length());
		return b.toString();
		
	}
	

	
}
