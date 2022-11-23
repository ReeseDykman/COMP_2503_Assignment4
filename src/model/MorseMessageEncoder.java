package model;
import java.io.FileNotFoundException;

/**
 * encodes messages into morse code by using the MorseDecoder class on each character
 * @author Reese
 *
 */
public class MorseMessageEncoder{
	
	/**
	 * encodes message by looping through letter by letter
	 * 
	 * @param msg message to be encoded
	 * @return string message in morse code
	 * @throws FileNotFoundException
	 */
	public String encodeMessage(String msg) throws FileNotFoundException {
		
		MorseEncoder encoder = new MorseEncoder();
		//split words into array
		String [] words = msg.toUpperCase().split(" ");
		//initialize the message to return
		String toReturn = "";
		
		//loop through words
		for(int i = 0; i < words.length; i++) {
			
			//word to be added to final string
			String newWord = "";
			
			//loop through letters
			for(int j = 0; j < words[i].length(); j ++) {
				//add letters to the new words, seperate letters by 3 spaces
				newWord = newWord.concat(encoder.encode(words[i].charAt(j)) + "   ");
			}
			
			//add words to total message to return, separate by 7-3=5 spaces
			toReturn = toReturn.concat(newWord + "    ");
			
		}
		
		return toReturn;
		
	}
	
	
    
}