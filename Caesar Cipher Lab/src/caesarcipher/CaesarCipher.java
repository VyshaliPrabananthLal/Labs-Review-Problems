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
		
		// your program will prompt the user for the name of the file
		System.out.println("Enter the file name with .txt");
		String filename = br.readLine();
		BufferedReader br1 = new BufferedReader(new FileReader(filename));
		String linesFromFile = "";
		String eachline;
		while((eachline = br1.readLine()) != null)
		{
			linesFromFile = linesFromFile + eachline;
		}
		
		// It is encrypted with a Caesar Cipher that increases by 2 after every 3 characters (including symbol characters, which are not encoded), starting at key = 5. 
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
		
		// write the decrypted message to a new file called solution.txt.
		String answer = new String(sb);
		System.out.println(answer);
		BufferedWriter bw = new BufferedWriter(new FileWriter("Solution.txt"));
		bw.write(answer);
		bw.close();
		br1.close();
	}
}
