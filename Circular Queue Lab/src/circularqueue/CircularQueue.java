package circularqueue;

import java.util.Scanner;

public class CircularQueue
{
	static class Node
	{
		int data;
		Node link;
	}
	
	static class Queue
	{
		Node front, rear, current;
	}
	
	static void enQueue(Queue q, int dataByUser, int count)
	{
		Node temp = new Node();
		temp.data = dataByUser;
		q.current = q.front;
		if(count > 12)
		{
			int number = count%12+12;
			for(int i = 1; i < number; i++)
			{
				q.current = q.current.link;
			}
			
			q.current.data = temp.data;
		}
		else
		{
			if(q.front == null)
			{
				q.front = temp;
			}
			else
			{
				q.rear.link = temp;
			}
			q.rear = temp;
			q.rear.link = q.front;
		}
	}
	
	static int deQueue(Queue q)
	{
		if(q.front == null)
		{
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		int ElementRemoved;
		if(q.front == q.rear)
		{
			ElementRemoved = q.front.data;
			q.front = null;
			q.rear = null;
		}
		else
		{
			Node temp = q.front;
			ElementRemoved = temp.data;
			q.front = q.front.link;
			q.rear.link = q.front;
		}
		
		return ElementRemoved;
	}
	
	static void displayQueue(Queue  q)  
	{  
	    Node  temp = q .front;  
	    System.out.printf("\nElements in Circular Queue are: ");  
	    while (temp.link != q .front)  
	    {  
	        System.out.printf("%d ", temp.data);  
	        temp = temp.link;  
	    }  
	    System.out.printf("%d", temp .data);  
	}  
	
	public static void main(String[] args)
	{
		int count = 0;
		Scanner sc = new Scanner(System.in);
		Queue q = new Queue();
		q.front = null; 
		q.rear = null;
		System.out.println("Enter the elements to enqueue in Queue. 'done' to stop stop and display the queue elements");
		String element = sc.next();
		while(!element.equals("done"))
		{
			count++;
			enQueue(q,Integer.parseInt(element),count);
			System.out.println("Enter the elements to enqueue in Queue. 'done' to stop stop and display the queue elements");
			element = sc.next();
		}
		/*do
		{
			int element = sc.nextInt();
			count++;
			enQueue(q,element,count);
			System.out.println("Do you want to add another element to the queue. press (y/n)");
			option = sc.next();
		} while(option.equals("y"));*/
		
		displayQueue(q);
		
		if(count > 12)
		{
			count = 12;
		}
		
		System.out.println("\n");
		for(int i = 0; i < count; i++)
		{
			int removedElement = deQueue(q);
			System.out.println("Dequeued Element:" + removedElement);
		}
		sc.close();
	}
}
