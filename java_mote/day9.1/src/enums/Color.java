package enums;

public enum Color {
	WHITE, BLACK, GREY, SILVER;
	//Can you override toString 
	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
