package p1;

public class MathOperations {
	public int doAdd(int...numbers)// var arg
	{
		int sum = 0;
		
		for(int x : numbers)
		{
			sum = sum+x;
		}
		
		return sum;
	}
	
	
}
