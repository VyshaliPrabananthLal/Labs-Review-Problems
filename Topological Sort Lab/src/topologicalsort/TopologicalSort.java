package topologicalsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort 
{
	int noOfVertices;
	LinkedList<Integer>[] AdjacencyList;
	
	
	public TopologicalSort(int totalVertices)
	{
		noOfVertices = totalVertices;
		AdjacencyList = new LinkedList[totalVertices];
		
		for(int i = 0; i < totalVertices; i++)
		{
			AdjacencyList[i] = new LinkedList();
		}
	}
	
	
	void addEdge(int v, int w)
	{
		AdjacencyList[v].add(w);
	}
	
	
	
	void topologicalSortFunction(int i, boolean[] visitedArr, Stack stack)
	{
		visitedArr[i] = true;
		Integer j;
		
		Iterator<Integer> itr = AdjacencyList[i].iterator();
		while(itr.hasNext())
		{
			j = itr.next();
			
			if(visitedArr[j] == false)
			{
				topologicalSortFunction(j, visitedArr, stack);
			}
		}
		
		stack.push(new Integer(i));
	}
	
	void topologicalSort(int count)
	{
		Stack stack = new Stack();
		
		boolean[] visitedArr = new boolean[noOfVertices];
		
		for(int i = 0; i < noOfVertices; i++)
		{
			visitedArr[i] = false;
		}
		
		
		if(count == 0)
		{
			for(int i = 0; i < noOfVertices; i++)
			{
				if(visitedArr[i] == false)
				{
					topologicalSortFunction(i, visitedArr, stack);
				}
			}
		}
		
		
		if(count == 1)
		{
			for(int i = noOfVertices-1; i >= 0 ; i--)
			{
				if(visitedArr[i] == false)
				{
					topologicalSortFunction(i, visitedArr, stack);
				}
			}
		}
		
		
		while(stack.isEmpty() == false)
		{
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static void main(String args[])throws Exception
	{
		int count = 0;
		TopologicalSort ts = new TopologicalSort(6);
		BufferedReader br = new BufferedReader(new FileReader("infile.dat"));
		String eachLine = "";
		while((eachLine = br.readLine()) != null)
		{
			String[] eachNumber = eachLine.split(",");
			ts.addEdge(Integer.parseInt(eachNumber[0]), Integer.parseInt(eachNumber[1]));
		}
		
		System.out.println("Topological sort of the given graph");
		
		ts.topologicalSort(count);
		
		count ++;
		
		System.out.println("\nTopological sort of the given graph");
		
		ts.topologicalSort(count);
		br.close();
	}
	
}
