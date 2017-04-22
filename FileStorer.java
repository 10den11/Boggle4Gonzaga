import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStorer {
	
	private int highscoreInt;
	private int boardSize;
	private int timeLimit;
	private ArrayList<Integer> settingsArray = new ArrayList<Integer>(); 
	
	private String  settings = "settings.txt";
	private String  highscore = "highscore.txt";
	private String  dictionary = "WordList.txt";

    File settingsFile = new File(settings);
    File dictionaryFile = new File(dictionary);
    File highscoreFile = new File(highscore);
    
    public FileStorer(){
    	//check if files exist
    }
    
    public int getHighScore() throws FileNotFoundException{
    	return highscoreInt;

    }
    public void setHighScore(int newScore) throws IOException {
    	
    	highscoreInt = newScore;
    	
    	FileWriter outFile = new FileWriter("highscore.txt");
    	outFile.write(newScore);
    	outFile.close();
    }
    
    public void setSettings(int newBoardSize, int newTimeLimit) throws IOException{
    	boardSize = newBoardSize;
    	timeLimit = newTimeLimit;
    	
    	FileWriter outFile = new FileWriter("settings.txt");
    	outFile.write(newBoardSize);
    	outFile.append("\n");
    	outFile.write(newTimeLimit);
    	outFile.close();
    	
    }
    
    public int getTimeLimit()
    {
    	return timeLimit;
    }
    
    public int getBoardSize()
    {
    	return boardSize;
    }
    
    public ArrayList<Integer> getSettings()
    {
    	return settingsArray;
    }
    
    public void setTimeLimit(int newLimit)
    {
    	timeLimit = newLimit;
    	settingsArray.set(0, newLimit);
    }
    
    public void setBoardSize(int newBoardSize)
    {
    	boardSize = newBoardSize;
    	settingsArray.set(1, newBoardSize);
    }
    
    
    public Boolean checkForWord(String word) throws FileNotFoundException
    {
    	Scanner inFile = new Scanner(dictionaryFile);
    	while (inFile.hasNextLine()) {
    		String line = inFile.nextLine();
    		if (line.equalsIgnoreCase(word))
    		{
    			inFile.close();
    			return true;
    		}
    	}
    	inFile.close();
    	return false;
    }

}  	