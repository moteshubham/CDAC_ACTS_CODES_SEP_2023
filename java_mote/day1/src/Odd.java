import java.lang.*;

class Odd
{
	public static void main(String[] args)
	{
		int start = Integer.parseInt(args[0]);
		int end = Integer.parseInt(args[1]);
		for(int i=start; i<=end; i++)
		{
			if(i%2 !=0)
			{
			System.out.println(i);
			}
		}
	}
}