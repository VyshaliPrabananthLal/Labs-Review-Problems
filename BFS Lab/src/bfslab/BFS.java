package bfslab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
	public static void main(String[] args)throws Exception
	{
		// Read in a graph in the same format as last week from infile.dat. 
		BufferedReader br = new BufferedReader(new FileReader("infile.dat"));
		
		String eachLine = "";
		String totalLines = "";
		while((eachLine = br.readLine()) != null )
		{
			totalLines = totalLines + eachLine + " ";
		}
		
		String[] eachNumber = totalLines.split(" ");
		
		// Create or use any graph data structure that reveals the graph using an adjacency matrix instead of an an adjacency list.
		Integer totalVertex = Integer.parseInt(eachNumber[0]);
		int[][] adjacencyMatrix = new int[totalVertex][totalVertex];
		
		for(int i = 0; i < totalVertex; i++)
		{
			for(int j = 0; j < totalVertex; j++)
			{
				adjacencyMatrix[i][j] = -1;
			}
		}
		
		for(int i = 1; i < eachNumber.length-2; i=i+2)
		{
			int firstCoordinate = Integer.parseInt(eachNumber[i]);
			int secondCoordinate = Integer.parseInt(eachNumber[i+1]);
			
			adjacencyMatrix[firstCoordinate][secondCoordinate] = 1;
			adjacencyMatrix[secondCoordinate][firstCoordinate] = 1;
		}
		
		
		
		boolean[] visited = new boolean[totalVertex];
		for(int i = 0; i < visited.length; i++)
		{
			visited[i] = false;
		}
		
		// Implement the breadth-first search algorithm as described in the lecture notes, using a queue to represent S'. 
		Queue<Integer> queue = new LinkedList<>();
		// Assume node 0 is the start point (s).
		queue.add(0);
		// Just like you can generate dfn for a depth-first search, generate a bfn number for this breadth-first search.
		int order = 0;
		
		visited[0] = true;
		
		while(!queue.isEmpty())
		{
			int xcoordinate = queue.poll();
			order ++;
			for(int i = 0; i < adjacencyMatrix.length; i++)
			{
				int coordinate = adjacencyMatrix[xcoordinate][i];
				if(coordinate == 1 && visited[i] == false)
				{
					queue.add(i);
					visited[i] = true;
				}
			}
			// Output a valid bfn number for each node to the screen in the following format:node# bfn
			System.out.println(xcoordinate + " " + order);
		}
		br.close();
	}
}
