package FileStorer;import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileStorer {
	
	//boardsizes: 4,5,6 time: unlimited,1,3,5
	private ArrayList<String> highscoreArray40 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray41 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray43 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray45 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray50 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray51 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray53 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray55 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray60 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray61 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray63 = new ArrayList<String>(); 
	private ArrayList<String> highscoreArray65 = new ArrayList<String>(); 
	
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
    	//check if files exist
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
    public ArrayList<String> getHighScore() throws FileNotFoundException{
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(0))
    	{
    		return highscoreArray40;
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(1))
    	{
    		return highscoreArray41;
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(3))
    	{
    		return highscoreArray43;
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(5))
    	{
    		return highscoreArray45;	
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(0))
    	{
    		return highscoreArray50;
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(1))
    	{
    		return highscoreArray51;
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(3))
    	{
    		return highscoreArray53;
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(5))
    	{
    		return highscoreArray55;
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(0))
    	{
    		return highscoreArray60;
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(1))
    	{
    		return highscoreArray61;
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(3))
    	{
    		return highscoreArray63;
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(5))
    	{
    		return highscoreArray65;
    	}
    	return highscoreArray65;

    }

    public void setHighScore(String name, int newScore) throws IOException {
    	
    	StringBuilder previousScores = new StringBuilder();
    	previousScores.setLength(0);
    	Scanner inFile = new Scanner(dictionary);
    	while ((line = inFile.nextLine()) != null)
    	{
    		previousScores.append(line);
    		previousScores.append(System.lineSeparator());
    	}
    	
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(0))
    	{
    		FileWriter outFile = new FileWriter("highscore40.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray40.add(name + " " + Integer.toString(newScore));
        	mySort("highscore40.txt", highscoreArray40);
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(1))
    	{
    		FileWriter outFile = new FileWriter("highscore41.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray41.add(name + " " + Integer.toString(newScore));
        	mySort("highscore41.txt", highscoreArray41);
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(3))
    	{
    		FileWriter outFile = new FileWriter("highscore43.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray43.add(name + " " + Integer.toString(newScore));
        	mySort("highscore43.txt", highscoreArray43);
    	}
    	if (settingsArray.get(0).equals(4) && settingsArray.get(1).equals(5))
    	{
    		FileWriter outFile = new FileWriter("highscore45.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();	
        	highscoreArray45.add(name + " " + Integer.toString(newScore));
        	mySort("highscore45.txt", highscoreArray45);
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(0))
    	{
    		FileWriter outFile = new FileWriter("highscore50.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray50.add(name + " " + Integer.toString(newScore));
        	mySort("highscore50.txt", highscoreArray50);
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(1))
    	{
    		FileWriter outFile = new FileWriter("highscore51.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray51.add(name + " " + Integer.toString(newScore));
        	mySort("highscore51.txt", highscoreArray51);
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(3))
    	{
    		FileWriter outFile = new FileWriter("highscore53.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray53.add(name + " " + Integer.toString(newScore));
        	mySort("highscore53.txt", highscoreArray53);
    	}
    	if (settingsArray.get(0).equals(5) && settingsArray.get(1).equals(5))
    	{
    		FileWriter outFile = new FileWriter("highscore55.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray55.add(name + " " + Integer.toString(newScore));
        	mySort("highscore55.txt", highscoreArray55);
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(0))
    	{
    		FileWriter outFile = new FileWriter("highscore60.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray60.add(name + " " + Integer.toString(newScore));
        	mySort("highscore60.txt", highscoreArray60);
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(1))
    	{
    		FileWriter outFile = new FileWriter("highscore61.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray61.add(name + " " + Integer.toString(newScore));
        	mySort("highscore61.txt", highscoreArray61);
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(3))
    	{
    		FileWriter outFile = new FileWriter("highscore63.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray63.add(name + " " + Integer.toString(newScore));
        	mySort("highscore63.txt", highscoreArray63);
    	}
    	if (settingsArray.get(0).equals(6) && settingsArray.get(1).equals(5))
    	{
    		FileWriter outFile = new FileWriter("highscore65.txt");
        	outFile.append(previousScores);
        	outFile.append(name + " " + Integer.toString(newScore));
        	outFile.close();
        	highscoreArray65.add(name + " " + Integer.toString(newScore));
        	mySort("highscore65.txt", highscoreArray65);
    	}
    	
    	
    }
    
    public void setSettings(int newTimeLimit, int newBoardSize) throws IOException{
    	boardSize = newBoardSize;
    	timeLimit = newTimeLimit;
    
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
        file.setSettings(3,400);
    }

}