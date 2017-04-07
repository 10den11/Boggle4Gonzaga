import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * @author Jeb Kilfoyle
 * @version 1.0
 * Board class which holds a representation of letters which have specified coordinates (x,y).
 * In addition Board stores the current word being constructed.
 * 4/2/2017
 * CPSC 224, Project Boggle
 */
public class Board {
	private int size;
	private ArrayList<ArrayList<Letter>> board_letters;
	private ArrayList<Letter> cur_word;
	
	/**
	 * Default constructor creates a board of size 4.
	 */
	public Board(){
		this(4);
	}
	/**
	 * Specialized Constructor creates a n x n board.
	 * Each Letter has an associated grid position as well as a character.
	 * @param n
	 */
	public Board(int n){
		size = n; 
		board_letters = new ArrayList<ArrayList<Letter>>();
		
		for(int i = 0; i < n; i++){
			ArrayList<Letter> row = new ArrayList<Letter>();
			
			board_letters.add(row);
			for(int j = 0; j < n; j++){
				Letter c = new Letter(j,i);
				row.add(c);
			}
		}
		//checkVowels(); Currently unnecessary.
	}
	/**
	 * Returns the letter at the x,y coordinate.
	 * @param x The x-coordinate.
	 * @param y The y-coordinate.
	 * @return The letter at coordinates (x,y).
	 */
	private Letter getLetter(int x, int y){
		return board_letters.get(y).get(x);
	}
	/**
	 * Returns a string representation of the board.
	 */
	public String toString(){
		String s_board = "";
		for(int i = 0; i < size; i++){
			s_board += "\n";
			for(int j = 0; j < size; j++){
				s_board += getLetter(j,i).getCharacter() + " ";
			}
		}
		return s_board;
	}
	/**
	 * A method to check the current letters on the board, and if there are not enough vowels,
	 * create a new set of letters until there are enough letters. Used at the end of the constructor after all
	 * letters have been initialized.
	 */
	/* Removed method for now. May bring back later.
	 * private void checkVowels(){
	 
	 	boolean enough_vowels = false;
		while(!enough_vowels){
			
			/*Check selection of letters to see if their are at least 4 vowels.
			 *If their are not enough vowels, roll a new set of letters until
			 * their exists size number of vowels.
			 */
			/*int total_vowels = 0;
			int total_consonants = 0;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j ++){
					String x = getLetter(j,i).getCharacter();
					if (x.equalsIgnoreCase("a")|x.equalsIgnoreCase("e")|x.equalsIgnoreCase("i")
						|x.equalsIgnoreCase("o")|x.equalsIgnoreCase("u")|x.equalsIgnoreCase("y")){
						total_vowels++;
					} else {
						total_consonants++;
					}
				}
			}
						
			
			if(total_vowels >= size){
				enough_vowels = true;
			} else {
				for(int i = 0; i < size; i++){
					for(int j = 0; j < size; j++){
						board_letters.get(j).get(i).reRoll();
					}
				}
			}
			
		}
		
	}
	*/
	/**
	 * Returns whether the current word can be found in the dictionary.
	 * @return true if the current word can be found in the dictionary.
	 */
	public boolean checkWord(){
		File dictionary = FileStorer.getDictionary();
		Scanner sc = new Scanner(dictionary);
		String word = getCurWordString();
		
		boolean valid_word = false;
		
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			if(x.equalsIgnoreCase(word))
				valid_word = true;
		}
		
		return valid_word;
	}
	/**
	 * Returns the string representation of the currently selected letters.
	 * @return The string representation of the currently selected letters.
	 */
	private String getCurWordString() {
		String string_current_word = "";
		for(int i = 0; i < cur_word.size(); i++){
			string_current_word+=cur_word.get(i).getCharacter();
		}
		return string_current_word;
	}
}