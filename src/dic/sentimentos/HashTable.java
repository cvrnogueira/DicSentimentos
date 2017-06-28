package dic.sentimentos;

import java.util.*;

public class HashTable
{

		private List<HashTable1> hashTable;
		private HashTable1[] array= new HashTable1[20000];
		private final static int SIZE = 547;
		private static int colisoes = 0;
		private static int index = 0;

		public HashTable(){
				 hashTable = new ArrayList<>();
			}
		/* computeHash
		*  return an integer based on the input string
		*  used for index into the array in hash table
		*  TODO: esse valor do size, não sei qual a gente usaria, temos de pensar
		*/
		private int computeHash(String keyASerInserida){
			int key = 0; //index para o nome na hashMap
			for (int i = 0; i < (int)keyASerInserida.length(); ++i) //soma os cacateres da chave(nome)
			{
				key += keyASerInserida.charAt(i);
				
			}
			return key % SIZE;// Calculate the rest of key's division by prime number 151, returning it as hash index.

		}

		/* put
		*  input: string word and int score to be inserted
		*  First, look to see if word already exists in hash table
		*   if so, solveCollision with the score to the WordEntry
		*   if not, create a new Entry and push it on the list at the
		*   appropriate array index
		*/
		public void put(String keyASerInserida, int score){
			  int keyASerInseridaComoInt = computeHash(keyASerInserida.trim());
		         if(hashTable.contains(keyASerInseridaComoInt)){ //se nosso arrayList de chaves ja contem o valor a ser inserido--> colisao!
		        		 solveCollision(keyASerInseridaComoInt, score);
		        		 colisoes++;
		        	 }
		         else{
		        
		        	 //hashTable.add(keyASerInseridaComoInt, new HashTable1(keyASerInseridaComoInt, score));//adiciona no hash
		        	 array[keyASerInseridaComoInt] =  new HashTable1(keyASerInseridaComoInt, score);
		         }
		         List<HashTable1> hashTable= Arrays.asList(array);
		}
		
		public boolean getValueFromKey(String keyASerBuscada){
			int keyASerBuscadaComoInt = computeHash(keyASerBuscada);
			boolean result;
			if(array[keyASerBuscadaComoInt].getOcupado() == false){
				//contiua a busca até achar uma que nunca foi ocupada 
				result = buscaIfProbablyCollision(keyASerBuscadaComoInt);
				
			}
			else{
				if(array[keyASerBuscadaComoInt].getWord(keyASerBuscadaComoInt).equals(keyASerBuscada)){
					return true;
				}
				else{
					result = buscaIfProbablyCollision(keyASerBuscadaComoInt);
					
				}
			}
			return result;
	         
		}
		 /* addNewAppearance
		// input integer that is a new score for a word that is
		//already in the hash table
		* function should increase total score by s
		* also should increase numAppearances
		*
		*TODO: temos de faze ro rehash, ou seja, se chegam em 50% de ocupação ele faz o rehash
		*/
		public void solveCollision(int keyASerInseridaComoInt, int score){
	
			for(int i = hashTable.indexOf(keyASerInseridaComoInt); i< hashTable.size(); i++){ //retorna a posição da onde deu colisão
				if(hashTable.get(i).getUsado() == false){ //se nao tem ninguém usando ele, é adicionado
					hashTable.add(new HashTable1(keyASerInseridaComoInt, score));
				}
			 }
		}
		//TODO: o caso que ta tudo oupado, e dai é uma lista encadeada circular:
		//pontos de parada é ou estar ocupado == false OU chegar no prórpio elemento dnv
		//VER SE JAVA TEM ESTRUTURA DE LISTA ENCADEADA CIRCULAR
		public boolean buscaIfProbablyCollision(int keyASerBuscadaComoInt){
			System.out.println(array[keyASerBuscadaComoInt].getWord(keyASerBuscadaComoInt));
			for(int i = keyASerBuscadaComoInt; i< hashTable.size(); i++){ //retorna a posição da onde deu possível colisão
				if(array[i].getOcupado() == false){ //se ninguém nunca ocupou ele, é porque não existe
					return false;
				}
			 }
			return true;
		}
		   
}


