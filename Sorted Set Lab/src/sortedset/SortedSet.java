package sortedset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class SortedSet
{
	// Write a sorted set data structure using binary search trees
	class Node
	{
		int key;
		Node left, right;
		
		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}
	
	
	Node root;
	
	public SortedSet()
	{
		root = null;
	}
	
	
	// Inserting elements into a binary search tree
	public void add(int key)
	{
		root = insertRecord(root,key);
	}
	
	
	public Node insertRecord(Node root, int key)
	{
		if(root == null)
		{
			root = new Node(key);
			return root;
		}
		
		if(key < root.key)
		{
			root.left = insertRecord(root.left, key);
		}
		else if(key > root.key)
		{
			root.right = insertRecord(root.right,key);
		}
		
		return root;
	}
	
	
	// If the value is present, output "Yes" and no other text. If the value is missing, output "No" and no other text.
	public void contains(int key)
	{
		Node temp = search(root,key);
		if(temp == null)
		{
			System.out.println("No");
		}
		else
		{
			System.out.println("Yes");
		}
	}
	
	
	public Node search(Node root, int Key)
	{
		if(root == null || root.key == Key)
			return root;
		
		if(Key < root.key)
			return search(root.left, Key);
		
		return search(root.right, Key);
	}
	
	
	public void isEmpty()
	{
		if(root == null)
		{
			System.out.println("Tree is Empty");
		}
	}
	
	
	public static void main(String[] args)throws Exception
	{
		// Then, read in numbers from a file named infile.dat, inserting them into an instance of your sorted set.
		BufferedReader br = new BufferedReader(new FileReader("infile.dat"));
		SortedSet SortedSetObj = new SortedSet();
		String numbers = "";
		String eachLine;
		while((eachLine = br.readLine()) != null)
		{
			numbers = numbers + eachLine;
		}
		
		String[] x = numbers.split(", ");
		for(int i = 0; i < x.length; i++)
		{
			SortedSetObj.add(Integer.parseInt(x[i]));
		}
		
		// You will then prompt the user for a value, and search the tree to determine if the value is found in the tree.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the element to be searched");
		int searchNum = sc.nextInt();
		SortedSetObj.contains(searchNum);	
		br.close();
		sc.close();
	}
}
