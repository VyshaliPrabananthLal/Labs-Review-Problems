package caesarcipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class CaesarCipher 
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the file name with .txt");
		String filename = br.readLine();
		BufferedReader br1 = new BufferedReader(new FileReader(filename));
		String linesFromFile = "";
		String eachline;
		while((eachline = br1.readLine()) != null)
		{
			linesFromFile = linesFromFile + eachline;
		}
		
		StringBuilder sb = new StringBuilder();
		int key = 5;
		int count = 1;
		for(int i = 0; i < linesFromFile.length(); i++)
		{
			if(count > 3)
			{
				key = (key + 2)%26;
				count = 1;
			}
			
			char ch = linesFromFile.charAt(i);
			if(ch == ' ')
			{
				sb.append(' ');
			}
			if(Character.isUpperCase(ch))
			{
				char result = (char)((((int)ch) - key + 65 ) % 26 + 65);
				sb.append(result);
			}
			else if(Character.isLowerCase(ch))
			{
				char result = (char)((((int)ch) - key + 97 ) % 26 + 97 - 12);
				sb.append(result);
			}
			else
			{
				sb.append(ch);
			}
			
			count++;
		}
		
		String answer = new String(sb);
		System.out.println(answer);
		BufferedWriter bw = new BufferedWriter(new FileWriter("Solution.txt"));
		bw.write(answer);
		bw.close();
		br1.close();
	}
}
