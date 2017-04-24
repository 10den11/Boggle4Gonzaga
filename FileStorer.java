
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
	private String  dictionary = "dictionary.txt";
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
    
    public void mySort(String filename, ArrayList<String> arrayList)
    {
    	Scanner inFile = new Scanner(filename);
    	StringBuilder highscoreInt = new StringBuilder();
    	
    	StringBuilder newHighScore = new StringBuilder();
    	line = (arrayList.get(arrayList.size()-1));
    	
    	for(int i=0;i<line.length();i++)
		{
		   if(Character.isDigit(line.charAt(i)))
		   newHighScore.append(line.charAt(i));
		}
    	
    	int counter = 0;
    	Boolean flag = true;
    	while (((line = inFile.nextLine()) != null) && flag)
    	{
    		for(int i=0;i<line.length();i++)
    		{
    		   if(Character.isDigit(line.charAt(i)))
    		   highscoreInt.append(line.charAt(i));
    		}
    		if (Integer.parseInt(highscoreInt.toString()) < Integer.parseInt(newHighScore.toString()))
    		{
    			flag = false;
    			String temp ="";
    			temp = arrayList.get(counter);
    			arrayList.set(counter, arrayList.get(arrayList.size()-1)); 
    			for (int j = arrayList.size()-2; j >= counter; j++)
    				arrayList.set(j+1, arrayList.get(j));	
    			arrayList.set(counter+1,temp);
    		}
    		counter ++;
    	}
    }
    
    public int getLowestHighScore()
    {
    	return HighScorePoints[boardSize][timeLimit][9];
    }
    
    public int[] getAllHighScorePoints()
    {
    	return HighScorePoints[boardSize][timeLimit];
    }
    
    public String[] getAllHighScoreNames()
    {
    	return HighScoreNames[boardSize][timeLimit];
    }
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
    	try {
    		currentWriter1 = new PrintWriter("highscores/" + boardSize + timeLimit + "_points.txt");
    		currentWriter2 = new PrintWriter("highscores/" + boardSize + timeLimit + "_names.txt");
    		for(int k = 0; k < 10; k++)
    		{
    			currentWriter1.println(score + "");
    			currentWriter2.println(name);
    		}
    		currentWriter1.close();
    		currentWriter2.close();
    	} catch(Exception e)
		{
			System.out.println("You done fucked up");
		} 
    }

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
    	settingsArray.set(1, newLimit);
    }
    
    public void setBoardSize(int newBoardSize)
    {
    	boardSize = newBoardSize;
    	settingsArray.set(0, newBoardSize);
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
    
    public static void main(String[] args) throws IOException{
        FileStorer file = new FileStorer();
        file.setSettings(3,4);
    }

}