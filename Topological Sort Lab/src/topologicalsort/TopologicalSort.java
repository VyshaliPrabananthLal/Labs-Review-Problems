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
	
	// Implement the pseudocode presented in the lecture for both creating a graph and for topological sort.
	// Construct a data structure to store a graph, 
	// which can be based on an adjacency matrix, adjacency list, or any other underlying structure you create.
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
		
		// You will need to modify the topological sort algorithm slightly to allow it to come up with a different valid topological ordering the second time, 
		// by tweaking one of the id(0) nodes that it selects.
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
		
		// When the program starts, read in a graph from a file called infile.dat.
		// The graph we input to test is guaranteed to have at least two valid orderings, 
		// and you do not need to error check for that. 
		BufferedReader br = new BufferedReader(new FileReader("infile.dat"));
		String eachLine = "";
		while((eachLine = br.readLine()) != null)
		{
			String[] eachNumber = eachLine.split(",");
			ts.addEdge(Integer.parseInt(eachNumber[0]), Integer.parseInt(eachNumber[1]));
		}
		
		// Then, print out two different topological orderings for the graph to the screen.
		System.out.println("Topological sort of the given graph");
		
		ts.topologicalSort(count);
		
		count ++;
		
		System.out.println("\nTopological sort of the given graph");
		
		ts.topologicalSort(count);
		br.close();
	}
	
}
