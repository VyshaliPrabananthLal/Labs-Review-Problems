package heapsforsorting;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Heap<T extends Comparable<T>>
{
	// Using only an array/list/vector (depending on your language of choice), 
	// construct a max-heap data structure.
	
	ArrayList<T> items;
	
	public Heap()
	{
		items = new ArrayList<T>();
	}
	

	public void siftUp()
	{
		int k = items.size() - 1;
		while(k > 0)
		{
			int p = (k-1)/2;
			T item = items.get(k);
			T parent = items.get(p);
			
			if(item.compareTo(parent) > 0)
			{
				items.set(k, parent);
				items.set(p, item);
				
				k = p;
			}
			else
			{
				break;
			}
		}
	}
	
	
	// You must use a max-heap to solve this problem, 
	// and you must implement the heap yourself using an array/list/vector. 
	// No other data structure will be permitted.
	public void insert(T item)
	{
		items.add(item);
		siftUp();
	}
	
	
	public void siftDown()
	{
		int k = 0;
		int l = 2*k + 1;
		
		while(l < items.size())
		{
			int max = l;
			int r = l+1;
			
			if(r < items.size())
			{
				if(items.get(r).compareTo(items.get(l)) > 0)
				{
					max++;
				}
			}
			
			if(items.get(k).compareTo(items.get(max)) < 0)
			{
				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				l = 2*k + 1;
			}
			else
			{
				break;
			}
		}
	}
	
	
	// Deleting is done at the root and last element in the tree is placed at the root
	// and sift down takes place to satisfy max heap condition
	public T delete() throws NoSuchElementException
	{
		if(items.size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		if(items.size() == 1)
		{
			return items.remove(0);
		}
		
		T hold = items.get(0);
		items.set(0, items.remove(items.size()-1));
		siftDown();
		return hold;
	}
	
	public int size()
	{
		return items.size();
	}
	
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	public String toString()
	{
		return items.toString();
	}

	
	public static void main(String[] args)
	{
		Heap<Integer> hp = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 10 elements that you want to add to the heap");
		
		/*System.out.println("Enter 'done' to stop");
		String inputAsString = sc.next();
		
		while(!inputAsString.equals("done"))
		{
			hp.insert(Integer.parseInt(inputAsString));
			System.out.println("Enter the elements that you want to add to the heap, 'done' to stop entering");
			inputAsString = sc.next();
		}*/
		
		
		// Then, read in 10 numbers from the screen, 1 line at a time. 
		for(int i = 0; i < 10; i++)
		{
			String inputAsString = sc.next();
			// Store each one in your max-heap, one at a time. 
			hp.insert(Integer.parseInt(inputAsString));
		}
		
		
		while(!hp.isEmpty())
		{
			// Then, output the numbers in descending order, one line at at time,
			// by repeatedly retrieving and deleting the largest item from the heap.
			int max = hp.delete();
			System.out.println("Element Removed from max heap:" + max);
		}
		sc.close();
	}
}
