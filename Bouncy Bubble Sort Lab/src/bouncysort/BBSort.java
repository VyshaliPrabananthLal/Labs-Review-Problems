package bouncysort;

import java.util.Scanner;

public class BBSort 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements that you will sort");
		int n = sc.nextInt();
		Integer[] sortArray = new Integer[n];
		System.out.println("Enter the elements that you will sort");
		for(int i = 0; i < n; i++)
		{
			sortArray[i] = sc.nextInt();
		}
		
		int temp = 0;
		for(int i = 0; i < n-1; i++)
		{
			if(i%2 == 0)
			{
				for(int j = 0; j < n-1-i; j++)
				{
					if(sortArray[j] > sortArray[j+1])
					{
						temp = sortArray[j];
						sortArray[j] = sortArray[j+1];
						sortArray[j+1] = temp;
					}
				}
			}
			else if(i%2 != 0)
			{
				for(int j = n-1-i; j > 0 ; j--)
				{
					if(sortArray[j] < sortArray[j-1])
					{
						temp = sortArray[j];
						sortArray[j] = sortArray[j-1];
						sortArray[j-1] = temp;
					}
				}
			}
			
		}
		
		for(int i = 0; i < n; i++)
		{
			System.out.print(sortArray[i]+" ");
		}
	}
	
}
