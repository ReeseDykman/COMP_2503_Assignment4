package model;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseEncoder{
     
	private HashMap<Character, String> letters;
	
	/**
	 * creates new hash map of character to string
	 * @throws FileNotFoundException
	 */
	public MorseEncoder() throws FileNotFoundException {
		
		letters = new HashMap<Character, String>();
		loadLetters();
	}
	
	/**
	 * loads from file
	 * puts String morse code into hash with key as its corresponding Character
	 * @throws FileNotFoundException
	 */
	private void loadLetters() throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("res/codes.txt"));
		Character letter;
		String morse;
		
		while(input.hasNextLine()) {
			letter = input.next().charAt(0);
			morse = input.next();
			letters.put(letter, morse);
		}
		
		input.close();
		
	}
	
	/**
	 * encodes letters by returning morse Strings based on character key
	 * @param letter
	 * @return
	 */
	public String encode(Character letter) {
		
		return letters.get(letter);
		
	}
	
	/**
	 * prints contents of hash map
	 */
	public void printMap() {
		System.out.println(letters.toString());
	}
	
}
