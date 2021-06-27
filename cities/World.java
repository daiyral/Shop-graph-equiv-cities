package cities;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class World {
	private Map<String,Country> countries;
	private int population;
	public World() {
		countries=new TreeMap<>();
		population=0;
	}
	public void addCountry(String name){
		
		countries.put(name,new Country(name));
	}
	public void addCity(String name, String countryName, int population){
		if(!countries.containsKey(countryName)) throw new IllegalArgumentException();
		Country c=countries.get(countryName);
		c.addCity(new City(name,c,population));
		this.population+=population;
	}
	public int population() {
		return population;
	}
	public List<City> smallCities(int under){
		List<City> res=new ArrayList<>();
		
		for(Country country: countries.values())
		{
			res.addAll(country.smallCities(under));
		}
		return res;
	}
	public String report() {
		StringBuilder b=new StringBuilder();
		for(Country c: countries.values())
		{

			b.append(c.report());		
			b.append("\n");
		}
		b.append("Total population is ");
		b.append(population);
		b.append("\n");
		return b.toString();
	}

}
