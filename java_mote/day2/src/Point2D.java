import java.lang.*;


class Point2D{
	private int x;
	private int y;
	//constructor
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	//setters and getters
	public int getX()
	{
		return this.x; 
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return this.x; 
	}
	public void setY(int Y)
	{
		this.y = y;
	}

	public boolean isEqual(Point2D point2)
	{
		if(this.x == point2.x && this.y == point2.y)
		{
			return true;
		}
		return false;
	}
	
	public String showPoint()
	{
		return "x: " + this.x + " y: " + this.y;
	}
}