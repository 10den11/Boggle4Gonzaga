import java.util.ArrayList;

public class ScoreCard {
	private ArrayList scoredWords = new ArrayList<String>();
	private ArrayList scoredPoints = new ArrayList<Integer>();
	private int Size;
	private int Total;
	
	public ScoreCard(int boardSize)
	{
		Size = boardSize;
		Total = 0;
	}
	
	public Boolean scoreWord(String newWord)
	{
		Boolean alreadyScored = false;
		for(int k = 0; k < scoredWords.size(); k++)
		{
			if(newWord.equals(scoredWords.get(k)))
			{
				alreadyScored = true;
			}
		}
		if(!alreadyScored)
		{
			if(Size == 4)
			{
				if(newWord.length() == 3 || newWord.length() == 4)
				{
					scoredPoints.add(1);
					Total += 1;
				} else if(newWord.length() == 5)
				{
					scoredPoints.add(2);
					Total += 2;
				} else if (newWord.length() == 6)
				{
					scoredPoints.add(3);
					Total += 3;
				} else if (newWord.length() == 7)
				{
					scoredPoints.add(5);
					Total += 5;
				} else if (newWord.length() > 7)
				{
					scoredPoints.add(11);
					Total += 11;
				} else
				{
					return false;
				}
			} else if (Size == 5)
			{
				if(newWord.length() == 4)
				{
					scoredPoints.add(1);
					Total += 1;
				} else if(newWord.length() == 5)
				{
					scoredPoints.add(2);
					Total += 2;
				} else if(newWord.length() == 6)
				{
					scoredPoints.add(3);
					Total += 3;
				} else if (newWord.length() == 7)
				{
					scoredPoints.add(5);
					Total += 5;
				} else if (newWord.length() > 7)
				{
					scoredPoints.add(newWord.length() * 2);
					Total += (newWord.length() * 2);
				} else
				{
					return false;
				}
			} else
			{
				if(newWord.length() == 4)
				{
					scoredPoints.add(1);
					Total += 1;
				} else if (newWord.length() == 5)
				{
					scoredPoints.add(2);
					Total += 2;
				} else if (newWord.length() == 6)
				{
					scoredPoints.add(3);
					Total += 3;
				} else if(newWord.length() == 7)
				{
					scoredPoints.add(5);
					Total += 5;
				} else if(newWord.length() == 8)
				{
					scoredPoints.add(11);
					Total += 11;
				} else if(newWord.length() > 8)
				{
					scoredPoints.add(newWord.length() * 2);
					Total += (newWord.length() * 2);
				} else
				{
					return false;
				}
			}
			scoredWords.add(newWord);
			return true;
		} else
		{
			return false;
		}
	}
	public ArrayList getScoredWords()
	{
		return scoredWords;
	}
	public ArrayList geScoredPoints()
	{
		return scoredPoints;
	}
	public int getTotal()
	{
		return Total;
	}
}
