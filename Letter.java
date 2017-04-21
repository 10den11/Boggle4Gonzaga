import java.util.Random;

/** 
 * @author Jeb Kilfoyle
 * @version 1.0
 * Letter is the individual blocks of the toggle board.
 * Letter has an x position, its horizontal position on the board.
 * Letter has an y position, its vertical position on the board.
 * Letter has a character, an alphabetical character.
 * In addition Letter has a boolean to express whether it has been selected yet.
 * 4/2/2017
 * CPSC 224, Project Boggle
 */
public class Letter {
	private int x;
	private int y;
	private String character;
	private boolean chosen;
	
	/**
	 * Creates a letter with an (x,y) position, a random alphabetical character
	 * chosen according to the probability of selecting a random letter
	 * in a random English word.
	 * @param x The horizontal position of the letter.
	 * @param y The vertical position of the letter.
	 */
	public Letter(int x, int y){
		this.x = x;
		this.y = y;
		this.chosen = false;
		
		
		/* The letter is chosen according to a distribution according to:
		 * https://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
		 * This ensures a suitable distribution of letters.
		 */
		Random rand = new Random();
		int letter_number = rand.nextInt(10000);
		int position = 7;
		while(true){
			if(letter_number < position){
				character = "z";
				break;
			}
			position+=10;
			
			if(letter_number < position){
				character = "j";
				break;
			}
			position+=11;
			
			if(letter_number < position){
				character = "q";
				break;
			}
			position+=17;
			
			if(letter_number < position){
				character = "x";
				break;
			}
			position+=69;
			
			if(letter_number < position){
				character = "k";
				break;
			}
			position+=111;
			
			if(letter_number < position){
				character = "v";
				break;
			}
			position+=149;
			
			if(letter_number < position){
				character = "b";
				break;
			}
			position+=182;
			
			if(letter_number < position){
				character = "p";
				break;
			}
			position+=203;
			
			if(letter_number < position){
				character = "g";
				break;
			}
			position+=209;
			
			if(letter_number < position){
				character = "w";
				break;
			}
			position+=211;
			
			if(letter_number < position){
				character = "y";
				break;
			}
			position+=230;
			
			if(letter_number < position){
				character = "f";
				break;
			}
			position+=261;
			
			if(letter_number < position){
				character = "m";
				break;
			}
			position+=271;
			
			if(letter_number < position){
				character = "c";
				break;
			}
			position+= 288;
			
			if(letter_number < position){
				character = "u";
				break;
			}
			position+=398;
			
			if(letter_number < position){
				character = "l";
				break;
			}
			position+=432;
			
			if(letter_number < position){
				character = "d";
				break;
			}
			position+=592;
			
			if(letter_number < position){
				character = "h";
				break;
			}
			position+=602;
			
			if(letter_number < position){
				character = "r";
				break;
			}
			position+=628;
			
			if(letter_number < position){
				character = "s";
				break;
			}
			position+=695;
			
			if(letter_number < position){
				character = "n";
				break;
			}
			position+=731;
			
			if(letter_number < position){
				character = "i";
				break;
			}
			position+=768;
			
			if(letter_number < position){
				character = "o";
				break;
			}
			position+=812;
			
			if(letter_number < position){
				character = "a";
				break;
			}
			position+=910;
			
			if(letter_number < position){
				character = "t";
				break;
			}
			
			character  = "e";
			break;
		}		
	}
	
	/**
	 * Returns the character of this letter.
	 * @return character The character of this letter.
	 */
	public String getCharacter(){
		return this.character;
	}
	/**
	 * Assigns a new character randomly biased by its popularity in the English language.
	 */
	public void reRoll(){
		this.character = new Letter(x,y).getCharacter();
	}
	public int getX(){
		return x;

	}
	public int getY(){
		return y;
	}
}