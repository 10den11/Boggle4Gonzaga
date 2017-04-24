/**
 * @author Joe Loftus, Jeb Kilfoyle, Dominic Gianatassio
 * @version 1.0
 * Handles the 
 * 4/23/2017
 * CPSC 224, Project Boggle
 * This file handles the writing and reading of files neccessary for the game.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileStorer {
	
	//boardsizes: 4,5,6 time: unlimited,1,3,5
	
	private String[][][] HighScoreNames = new String[7][][];
	private int[][][] HighScorePoints = new int[7][][];
	
	private Scanner currentReader1;
	private Scanner currentReader2;
	
	private PrintWriter currentWriter1;
	private PrintWriter currentWriter2;
	
	private int boardSize;
	private int timeLimit;
	private ArrayList<Integer> settingsArray = new ArrayList<Integer>(); 
	
	private String  settings = "settings.txt";
	private String  highscore = "highscore.txt";
	private String  dictionary = "WordList.txt";
	private String line;
	

    File settingsFile = new File(settings);
    File dictionaryFile = new File(dictionary);
    File highscoreFile = new File(highscore);
    
    public FileStorer(){
    	for(int k = 4; k <= 6; k++)
    	{
    		HighScoreNames[k] = new String[6][];
    		HighScorePoints[k] = new int[6][];
    		
    		HighScoreNames[k][0] = new String[10];
    		HighScoreNames[k][1] = new String[10];
    		HighScoreNames[k][3] = new String[10];
    		HighScoreNames[k][5] = new String[10];
    		
    		HighScorePoints[k][0] = new int[10];
    		HighScorePoints[k][1] = new int[10];
    		HighScorePoints[k][3] = new int[10];
    		HighScorePoints[k][5] = new int[10];
    		
    		try {
    			currentReader1 = new Scanner(new File("highscores/" + k + "0_points.txt"));
    			currentReader2 = new Scanner(new File("highscores/" + k + "0_names.txt"));
    		}
    		catch(Exception e)
    		{
    			System.out.println("You done fucked up");
    		}
    		for(int n = 0; n < 10; n++)
    		{
    			HighScorePoints[k][0][n] = currentReader1.nextInt();
    			HighScoreNames[k][0][n] = currentReader2.nextLine();
    		}
    		
    		try {
    			currentReader1 = new Scanner(new File("highscores/" + k + "1_points.txt"));
    			currentReader2 = new Scanner(new File("highscores/" + k + "1_names.txt"));
    		}
    		catch(Exception e)
    		{
    			System.out.println("You done fucked up");
    		}
    		for(int n = 0; n < 10; n++)
    		{
    			HighScorePoints[k][1][n] = currentReader1.nextInt();
    			HighScoreNames[k][1][n] = currentReader2.nextLine();
    		}
    		
    		try {
    			currentReader1 = new Scanner(new File("highscores/" + k + "3_points.txt"));
    			currentReader2 = new Scanner(new File("highscores/" + k + "3_names.txt"));
    		}
    		catch(Exception e)
    		{
    			System.out.println("You done fucked up");
    		}
    		for(int n = 0; n < 10; n++)
    		{
    			HighScorePoints[k][3][n] = currentReader1.nextInt();
    			HighScoreNames[k][3][n] = currentReader2.nextLine();
    		}
    		
    		try {
    			currentReader1 = new Scanner(new File("highscores/" + k + "5_points.txt"));
    			currentReader2 = new Scanner(new File("highscores/" + k + "5_names.txt"));
    		}
    		catch(Exception e)
    		{
    			System.out.println("You done fucked up");
    		}
    		for(int n = 0; n < 10; n++)
    		{
    			HighScorePoints[k][5][n] = currentReader1.nextInt();
    			HighScoreNames[k][5][n] = currentReader2.nextLine();
    		}
    	}
    	try{
    		currentReader1 = new Scanner(new File ("settings.txt"));
    	}
    	catch(Exception e)
		{
			System.out.println("You done fucked up");
		}
    	boardSize = currentReader1.nextInt();
    	timeLimit = currentReader1.nextInt();
    	settingsArray.add(5);
    	settingsArray.add(5);
    	
    }
    /**
     * 
     * @param testValue The current highscore
     * @return Returns true if there is a new highscore
     */
    public Boolean checkIfNewHighScore(int testValue)
    {
    	return (HighScorePoints[boardSize][timeLimit][9] < testValue);
    }
    /**
     * 
     * @return returns all highscore points
     */
    public int[] getAllHighScorePoints()
    {
    	return HighScorePoints[boardSize][timeLimit];
    }
   /**
    * 
    * @return returns all names of highscorers
    */
    public String[] getAllHighScoreNames()
    {
    	return HighScoreNames[boardSize][timeLimit];
    }
    /**
     * 
     * @param name name of the new high-scorer
     * @param score the new highscore
     */
    //assumes that the score is a high score
    public void newHighScore(String name, int score)
    {
    	int scorePlacement = 9;
    	for(int k = 9; k >= 0; k--)
    	{
    		if(score > HighScorePoints[boardSize][timeLimit][k])
    		{
    			scorePlacement = k;
    		}
    	}
    	for(int k = 8; k >= scorePlacement; k--)
    	{
    		HighScorePoints[boardSize][timeLimit][k + 1] = HighScorePoints[boardSize][timeLimit][k];
    		HighScoreNames[boardSize][timeLimit][k + 1] = HighScoreNames[boardSize][timeLimit][k];
    	}
    	HighScorePoints[boardSize][timeLimit][scorePlacement] = score;
    	HighScoreNames[boardSize][timeLimit][scorePlacement] = name;
    	try {
    		currentWriter1 = new PrintWriter("highscores/" + boardSize + timeLimit + "_points.txt");
    		currentWriter2 = new PrintWriter("highscores/" + boardSize + timeLimit + "_names.txt");
    		for(int k = 0; k < 10; k++)
    		{
    			currentWriter1.println(HighScorePoints[boardSize][timeLimit][k] + "");
    			currentWriter2.println(HighScoreNames[boardSize][timeLimit][k]);
    		}
    		currentWriter1.close();
    		currentWriter2.close();
    	} catch(Exception e)
		{
			System.out.println("You done fucked up");
		} 
    }
    /**
     * 
     * @param newTimeLimit the new time limit
     * @param newBoardSize the new board size
     * @throws IOException throws an exception there is an error opening settings file
     */
    public void setSettings(int newTimeLimit, int newBoardSize) throws IOException{
    	boardSize = newBoardSize;
    	timeLimit = newTimeLimit;
    
    	settingsArray.set(0, timeLimit);
    	settingsArray.set(1, boardSize);
    	
    	FileWriter outFile = new FileWriter("settings.txt");
    	outFile.append(Integer.toString(newBoardSize));
    	outFile.append(System.lineSeparator());
    	outFile.append(Integer.toString(newTimeLimit));
    	outFile.close();
    	
    }
    /**
     * 
     * @return returns timelimit
     */
    public int getTimeLimit()
    {
    	return timeLimit;
    }
    /**
     * 
     * @return returns Boardsize
     */
    public int getBoardSize()
    {
    	return boardSize;
    }
    
    /**
     * 
     * @return returns settingsArray
     */
    public ArrayList<Integer> getSettings()
    {
    	return settingsArray;
    }
    /**
     * 
     * @param newLimit the new time limit
     */
    public void setTimeLimit(int newLimit)
    {
    	timeLimit = newLimit;
    	settingsArray.set(1, newLimit);
    }
    /**
     * 
     * @param newBoardSize the new board size
     */
    public void setBoardSize(int newBoardSize)
    {
    	boardSize = newBoardSize;
    	settingsArray.set(0, newBoardSize);
    }
    
    /**
     * 
     * @param word the word we are checking for
     * @return Returns true if the word is in the file, false otherwise
     * @throws FileNotFoundException throws an exception if the file cannot be found
     */
    public Boolean checkForWord(String word) throws FileNotFoundException
    {
    	Scanner inFile = new Scanner(dictionaryFile);
    	while (inFile.hasNextLine()) {
    		line = inFile.nextLine();
    		if (line.equalsIgnoreCase(word))
    		{
    			return true;
    		}
    	}
    	return false;
    }

}