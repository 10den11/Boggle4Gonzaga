package FileStorer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileStorer {
	
	private ArrayList<Integer> highScoreArray = new ArrayList<Integer>();
	private int boardSize;
	private int timeLimit;
	private ArrayList<Integer> settingsArray = new ArrayList<Integer>(); 
	
	private String  settings = "settings.txt";
	private String  highscore = "highscore.txt";
	private String  dictionary = "dictionary.txt";
	private String line;

    File settingsFile = new File(settings);
    File dictionaryFile = new File(dictionary);
    File highscoreFile = new File(highscore);
    
    public FileStorer(){
    	
    }
    
    public ArrayList<Integer> getHighScore() throws FileNotFoundException{
    	return highScoreArray;

    }
    public void setHighScore(int newScore) throws IOException {
    	
    	highScoreArray.add(newScore);
    	Collections.sort(highScoreArray);
    	
    	StringBuilder previousHighScores = new StringBuilder();
    	Scanner inFile = new Scanner(highscore);
    	while ((line = inFile.nextLine()) != null)
    	{
    		previousHighScores.append(line);
    		previousHighScores.append("\n");
    	}
    	
    	
    	FileWriter outFile = new FileWriter("highscore.txt");
    	outFile.append(previousHighScores);
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
    	timeLimit = newBoardSize;
    	settingsArray.set(1, newBoardSize);
    }
    
    
    public Boolean checkForWord(String word)
    {
    	Scanner inFile = new Scanner(dictionary);
    	while ((line = inFile.nextLine()) != null) {
    		if (line.equals(word))
    		{
    			return true;
    		}
    	}
    	return false;
    }

}

  	