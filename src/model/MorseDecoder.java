package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Decodes morse letters by scaling a binary tree according to the "-" or "." at char positions
 * 
 * @author Reese
 *
 */
public class MorseDecoder{
	
	private BinaryTree<Character> morseTree;
	
	/**
	 * constructor for decoder
	 * creates root of morse tree
	 * calls method to fill tree
	 * 
	 * @throws FileNotFoundException
	 */
	public MorseDecoder()throws FileNotFoundException {
		
		morseTree = new BinaryTree<Character>(null);
		loadTree();
	}
	
	/**
	 * loads data from text file and calls method to build the morse tree
	 * 
	 * @throws FileNotFoundException
	 */
	private void loadTree()throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("res/codes.txt"));
		String letter;
		String morse;
		
		while(input.hasNextLine()) {
			letter = input.next();
			morse = input.next();
			buildTree(morseTree, letter.charAt(0), morse);
		}
		
		input.close();
	}
	
	/**
	 * Constructs binary tree of characters according to morse code
	 * 
	 * @param tree root of current subtree
	 * @param letter to be placed left or right of current subtree
	 * @param morse code to follow in tree
	 */
	private void buildTree(BinaryTree<Character> tree, char letter, String morse) {
		
		BinaryTree<Character> j = new BinaryTree<Character>(letter); //create new subtree with current letter as root
    	
    	if(morse.charAt(0) == '.') {
    		//recurse with the left subtree if not at the end of the code
    		if(morse.length()>1)
    			buildTree(tree.getLeft(), letter,morse.substring(1));
    		//add to the left of the current subtree if last char in code is .
    		else
    			tree.setLeft(j);
    	}
    	
    	if(morse.charAt(0) == '-') {
    		//recurse with the right subtree if not at the end of the code
    		if(morse.length()>1)
    			buildTree(tree.getRight(), letter,morse.substring(1));
    		//add to the right of the subtree if last char in code is -
    		else
    			tree.setRight(j);
    		
    	}
	}
	
	/**
	 * returns the result of the decoder
	 * @param morse code to be decoded
	 * @return the decoded letter after the decoder recursive method is done
	 */
	public char decode(String morse){
		return decoder(morseTree, morse);
	}
	
	/**
	 * decodes char by scaling the binary tree recursively
	 * @param tree current subtree root
	 * @param morse code to be decoded
	 * @return the root element of the final subtree that matches the morse code
	 */
	private char decoder(BinaryTree<Character> tree, String morse) {
			
		if(morse.charAt(0) == '.') {
			//recurse if not at end of code
			if(morse.length() > 1)
				return decoder(tree.getLeft(), morse.substring(1));
			//if at end, return the left subtree root element if the final char is .
			else
				return tree.getLeft().getRootElement();
			
		}else if(morse.charAt(0) == '-') {
			//recurse if not at end of code
			if(morse.length() > 1)
				return decoder(tree.getRight(), morse.substring(1));
			//if at end, return the left subtree root element if the final char is -
			else
				return tree.getRight().getRootElement();
		}
		
		return tree.getRootElement();
		
		
		
	}
	
	/**
	 * prints contents of morseTree
	 * calls iterator method on root
	 */
	public void printMorseTree() {
		Iterator<Character> it = morseTree.iterator();
		 
        while (it.hasNext())
            System.out.print(it.next()+" ");
	}
	
   
}