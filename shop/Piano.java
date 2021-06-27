package shop;

public class Piano extends Instrument{

	private int octaves;
	public Piano(String company,int price, int octaves) {
		super(company,price);
		this.octaves=octaves;
	}

	private String getName() {return "Piano";}
	public int getOctaves(){return octaves;}
	public String toString() {

		String str=super.toString();
		String piano=octaves+ " octaves";
		str= str.replaceFirst("XXX", piano);
		return str;
	}
}
