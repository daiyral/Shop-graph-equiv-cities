package shop;

public class Guitar extends Instrument {
	private Type type;
	public Guitar(String company,int price,Type type) {
		super(company,price);
		this.type=type;
	}

	
	public Type getType()
	{
		return type;
	}
	private String getName() {return "Guitar";}
	public String toString() {
		String str=super.toString();
		str=str.replaceFirst("XXX", type.toString());
		return str;
	}

}
