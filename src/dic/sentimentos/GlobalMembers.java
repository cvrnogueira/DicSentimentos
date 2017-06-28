package dic.sentimentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GlobalMembers
{
	public static void main(String args[]){
		//create hash table
		HashTable table = new HashTable();
	 
		Path path1 = Paths.get("C:/Users/User/workspace/DicionarioSentimentos/pt.csv");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			  String line = null;
			  int score = 0;
				
			  while ((line = reader.readLine()) != null) {
				Scanner sc = new Scanner(line).useDelimiter(","); // separador é ,
				String finalLine = sc.next(); //linha sem o peso
			   // System.out.println(finalLine); 
			    score = sc.nextInt(); // peso
			   // System.out.println(score); 
	
				//identify all individual strings
					String[] sub;
					sub = finalLine.split(" ");
					for(int i =0; i< sub.length; i++){
					table.put(sub[i], score); //insert in the table!
					}

			  } 
			}
			catch (IOException x) {
			  System.err.format("Erro de E/S: %s%n", x);
			}
		
		String keyASerInserida = "bananana98ijskslskj";
		int key= 0;
		boolean result = table.getValueFromKey("bananana98ijskslskj");
		
		System.out.println(result); // ta dando true sempre
	}
}
