package shop;

public abstract class Instrument {
	private String company;
	private int price,mySerial;
	private static int serial=0;
	public Instrument(String company,int price) {
		this.company=company;
		this.price= price;
		mySerial=serial++;
	}
	public int getPrice()
	{
		return price;
	}
	public String getCompany()
	{
		return company;
	}
	public int getSerial()
	{
		return mySerial;
	}
	
	public String toString() {
		StringBuilder b=new StringBuilder();
		b.append(this.getClass().getSimpleName());
		b.append("(");
		b.append("XXX");//save position for each unique instrument details
		b.append(") ");
		b.append(company);
		b.append("(");
		b.append(mySerial);
		b.append("), price = ");
		b.append(price);
		return b.toString();
	}
}
