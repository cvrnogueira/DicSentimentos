package dic.sentimentos;

public class HashTable1 {
	
    private int key;
    private int value;
    private boolean ocupado = false;
    private boolean usado = false;
    private static int numAppearances= 0;

    
	public HashTable1(int key, int value){
		this.key = key;
		this.value = value;
		this.setUsado(); //se tem alguem ali, no momento
		this.setOcupado(); //se algum dia já foi ou se está com alguem ali
		numAppearances++;
	}
	

	public int getKey() {
        return key;
     }

	public int getValue() {
        return value;
    } 
	public boolean getUsado(){
		return usado;
	}
	public boolean getOcupado(){
		return ocupado;
	}
	public void setOcupado(){
		this.ocupado = true;
	}
	public void setUsado(){
		this.usado = true;
	}
	/*getWord
	* this accessor function is needed
	* particularly in the HashTable code to get the word to be
	* used for the hash value
	*/
	public String getWord(int key){

		return String.valueOf(key);


	}
	@Override
	public String toString() {
		return key + " [" + value+  "]";
	}
 
}
