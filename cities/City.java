package cities;
public class City implements Comparable<City>{
	private String name;
	private Country country;
	private int population;
	public City(String name,Country country,int population) {
		this.country=country;
		this.name=name;
		this.population=population;
	}
	
	public String getName(){
		return name;
	}
	public Country getCountry(){
		return country;
	}
	public int getPopulation(){
		return population;
	}
	@Override
	public int compareTo(City other)
	{
		if(country.compareTo(other.getCountry())==-1) return -1;
		return name.compareTo(other.name);
		
	
	}
	@Override
	public boolean equals(Object obj) {
		City other=(City) obj;
		return country.equals(other.country)&&(this.name==other.getName());
	}
	
	@Override
	public String toString()
	{
		StringBuilder b=new StringBuilder();
		b.append(name);
		b.append(" (of ");
		b.append(country.toString());
		b.append(")");
		return b.toString();
	}
}
