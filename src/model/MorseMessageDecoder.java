package model;
import java.io.FileNotFoundException;


/**
 * decodes message using the morse decoder class
 * 
 * @author Reese
 *
 */
public class MorseMessageDecoder{
	
	/**
	 * calls decoder method in MorseDecoder class for each character in morse string
	 * 
	 * @param msg message to be decoded
	 * @return String message that is now decoded
	 * @throws FileNotFoundException
	 */
	public String decodeMessage(String msg) throws FileNotFoundException {
		
		MorseDecoder decoder = new MorseDecoder();
		//split words separated by 7 spaces
		String[] words = msg.split("       ");
		//initialize message to return
		String toReturn = "";
		
		//loop over words
		for(int i = 0; i < words.length; i ++) {
			//split letters
			String[] letters = words[i].split("   ");
			//new word to be added to total message
			String newWord = "";
			
			//decode by looping through each letter 
			for(int j = 0; j < letters.length; j++) {
				//concatenate letters to word
				newWord = newWord.concat(Character.toString(decoder.decode(letters[j])));
			}
			//concatenate words to the total decoded message
			toReturn = toReturn.concat(newWord + " ");
		}
		
		return toReturn;
		
	}
    
}