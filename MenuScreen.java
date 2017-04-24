import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
public class MenuScreen {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame;
				try {
					frame = new MenuFrame();
					frame.setTitle("Boggle");
					frame.setLocation(0, 0);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e) {
					System.out.println("IOException Error");
				}
			}
		});

	}

}
class MenuFrame extends JFrame {
	private JPanel menuScreen;
	private FileStorer files;
	private Box box;
	private Board game;
	private ArrayList<ArrayList<JToggleButton>> BoardButtons;
	private ScoreCard scorecard;
	private WordPanel word_panel;
	
	
	public MenuFrame() throws IOException {
		
		setSize(1920, 1080);
		menuScreen = new JPanel();
		menuScreen.setBackground(Color.BLACK);
		box = Box.createVerticalBox();
		files = new FileStorer();
		files.setSettings(3, 4);
		paintMenu();
	}
	public void paintMenu(){
		menuScreen.removeAll();
		box.removeAll();
		menuScreen.setLayout(new FlowLayout());
		
		JButton PlayButton = new JButton(new StartListener());
		JButton OptionButton = new JButton(new OptionListener());
		JButton HighScoreButton = new JButton();
		ImageIcon TitleIcon = new ImageIcon("title.png");
		JLabel titleLabel = new JLabel ("", TitleIcon, JLabel.CENTER);
		box.setOpaque(true);
		box.setBackground(Color.BLACK);
		menuScreen.setBackground(Color.BLACK);
		PlayButton.setIcon(new ImageIcon("start.png"));
		OptionButton.setIcon(new ImageIcon("option.png"));
		HighScoreButton.setIcon(new ImageIcon("highscore.png"));
		
		PlayButton.setOpaque(false);
		OptionButton.setOpaque(false);
		HighScoreButton.setOpaque(false);
		PlayButton.setContentAreaFilled(false);
		OptionButton.setContentAreaFilled(false);
		HighScoreButton.setContentAreaFilled(false);
		PlayButton.setBorderPainted(false);
		OptionButton.setBorderPainted(false);
		HighScoreButton.setBorderPainted(false);
		
		PlayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		OptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		HighScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		PlayButton.setPreferredSize(new Dimension(735, 135));
		OptionButton.setPreferredSize(new Dimension(1033, 133));
		HighScoreButton.setPreferredSize(new Dimension(1338, 134));
		
		box.add(PlayButton);
		box.add(Box.createVerticalStrut(100));
		box.add(OptionButton);
		box.add(Box.createVerticalStrut(100));
		box.add(HighScoreButton);
		menuScreen.add(titleLabel);
		menuScreen.revalidate();
		menuScreen.repaint();
		box.revalidate();
		box.repaint();
		add(box, BorderLayout.CENTER);
		add(menuScreen,BorderLayout.NORTH);
		revalidate();
		repaint();
	}
	public class OptionListener extends AbstractAction {
		/**
		 * The option listener is a listener compononent that brings up an options menu when
		 * the options button is pressed in the main menu.
		 */
		public void actionPerformed(ActionEvent e) {
			menuScreen.removeAll();
			box.removeAll();
			remove(box);
			remove(menuScreen);
			GridLayout GL = new GridLayout(5,10);
			GL.setHgap(0);
			GL.setVgap(0);
			FileStorer Files = new FileStorer();
			
			menuScreen.setLayout(GL);
			JPanel size_panel = new JPanel();
			JPanel time_panel = new JPanel();
			size_panel.setBackground(Color.BLACK);
			time_panel.setBackground(Color.BLACK);
			
			//add Options Title
			ImageIcon i_option = new ImageIcon("option.png");
			JLabel label = new JLabel(i_option);
			menuScreen.add(label);
			
			int size = files.getBoardSize();
			int time = files.getTimeLimit();
			JLabel i_size = new JLabel(new ImageIcon("letters/"+ size + "x" + size + ".png"));
			JLabel i_time = new JLabel(new ImageIcon("letters/" + time + "min.png"));
			
			
			//add Board Size Buttons
			JButton size_back_arrow = new JButton(new SizeListener(0, i_size));
			JButton size_forward_arrow = new JButton(new SizeListener(1, i_size));
			size_back_arrow.setIcon(new ImageIcon("letters/left.png"));
			size_forward_arrow.setIcon(new ImageIcon("letters/right.png"));
			size_back_arrow.setOpaque(false);
			size_back_arrow.setContentAreaFilled(false);
			size_back_arrow.setBorderPainted(false);
			size_forward_arrow.setOpaque(false);
			size_forward_arrow.setContentAreaFilled(false);
			size_forward_arrow.setBorderPainted(false);
			
			size_panel.add(size_back_arrow);
			size_panel.add(i_size);
			size_panel.add(size_forward_arrow);
			
			
			//add Timer Buttons
			JButton time_back_arrow = new JButton(new TimeListener(0, i_time));
			JButton time_forward_arrow = new JButton(new TimeListener(1, i_time));
			time_back_arrow.setIcon(new ImageIcon("letters/left_T.png"));
			time_forward_arrow.setIcon(new ImageIcon("letters/right_T.png"));
			time_back_arrow.setOpaque(false);
			time_back_arrow.setContentAreaFilled(false);
			time_back_arrow.setBorderPainted(false);
			time_forward_arrow.setOpaque(false);
			time_forward_arrow.setContentAreaFilled(false);
			time_forward_arrow.setBorderPainted(false);
			
			time_panel.add(time_back_arrow);
			time_panel.add(i_time);
			time_panel.add(time_forward_arrow);
			
			//add Back Button
			JButton back_button = new JButton(new BackListener());
			back_button.setIcon(new ImageIcon("back.png"));
			back_button.setPreferredSize(new Dimension(333, 171));
			back_button.setOpaque(false);
			back_button.setContentAreaFilled(false);
			back_button.setBorderPainted(false);
			
			JPanel filler = new JPanel();
			JPanel back_panel = new JPanel();
			back_panel.add(back_button);
			back_panel.setBackground(Color.BLACK);
			back_panel.setLayout(new BorderLayout());
			filler.setBackground(Color.BLACK);
			menuScreen.add(filler);
			menuScreen.add(size_panel);
			menuScreen.add(time_panel);
			back_panel.add(back_button, BorderLayout.WEST);
			menuScreen.add(back_panel);
			menuScreen.revalidate();
			menuScreen.repaint();
			add(menuScreen);
			revalidate();
			repaint();
		}
	}
	public class SizeListener extends AbstractAction{
		private int direction;
		private JLabel size_image;
		public SizeListener(int x, JLabel y){
			direction = x;
			size_image = y;
			
		}
		public void actionPerformed(ActionEvent e){
			int cside = files.getBoardSize();
			if(direction == 0){
				if(cside == 5){
					files.setBoardSize(4);
					size_image.setIcon(new ImageIcon("4x4.png"));
				}
				if(cside == 6){
					files.setBoardSize(5);
					size_image.setIcon(new ImageIcon("5x5.png"));
					
				}
			} else if (direction == 1){
				if(cside == 4){
					files.setBoardSize(5);
					size_image.setIcon(new ImageIcon("5x5.png"));
				}
				if(cside == 5){
					files.setBoardSize(6);
					size_image.setIcon(new ImageIcon("6x6.png"));
				}
			}
			OptionListener x = new OptionListener();
			x.actionPerformed(e);
		}
	}
	public class TimeListener extends AbstractAction{
		private int direction;
		private JLabel time_image;
		public TimeListener(int x, JLabel y){
			direction = x;
			time_image = y;
		}
		public void actionPerformed(ActionEvent e){
			int t = files.getTimeLimit(); //current time limit
			System.out.println("BEFORE time = " + t);
			if(direction == 0){
				if(t == 3){
					files.setTimeLimit(1);
					time_image.setIcon(new ImageIcon("1Min.png"));
				}
				if(t == 5){
					files.setTimeLimit(3);
					time_image.setIcon(new ImageIcon("3Min.png"));
				}
				if(t == 0){
					files.setTimeLimit(5);
					time_image.setIcon(new ImageIcon("5Min.png"));
				}
			} else if (direction == 1){
				if(t == 1){
					files.setTimeLimit(3);
					time_image.setIcon(new ImageIcon("3Min.png"));
				}
				if(t == 3){
					files.setTimeLimit(5);
					time_image.setIcon(new ImageIcon("5Min.png"));
				}
				if(t == 5){
					files.setTimeLimit(0);
					time_image.setIcon(new ImageIcon("0Min.png"));
				}
			}
			System.out.println("time after = " + files.getTimeLimit());
			OptionListener x = new OptionListener();
			x.actionPerformed(e);
		}
	}
	public class BackListener extends AbstractAction{
		public void actionPerformed(ActionEvent e){
			paintMenu();
		}
	}
	public class StartListener extends AbstractAction{
		public void actionPerformed(ActionEvent e){
			startGame();
		}
	}
	public void startGame(){
		menuScreen.removeAll();
		remove(box);
		remove(menuScreen);
		int size = files.getBoardSize();
		JButton selectButton = new JButton(new SelectListener(size));
		selectButton.setIcon(new ImageIcon("select.png"));
		selectButton.setPreferredSize(new Dimension(241,172));
		selectButton.setOpaque(false);
		selectButton.setContentAreaFilled(false);
		selectButton.setBorderPainted(false);
		WordPanel curWord = new WordPanel();
		curWord.setBackground(new Color(255,97,48));
		curWord.setPreferredSize(new Dimension(570,160));
		word_panel = curWord;
		game = new Board(size);
		System.out.print(game);
		scorecard = new ScoreCard(size);
		GridLayout GL = new GridLayout(size,size);
		GL.setHgap(0);
		GL.setVgap(0);
		
		menuScreen.setLayout(GL);
		
		BoardButtons = new ArrayList<ArrayList<JToggleButton>>();
		
		for(int i = 0; i < size; i++){
			ArrayList<JToggleButton> row = new ArrayList<JToggleButton>();
			for(int j = 0; j < size; j++){
				JToggleButton LB = new JToggleButton(new LetterAction(j,i,size));
				LB.setIcon(new ImageIcon("letters/"+game.getLetter(j, i).getCharacter().toUpperCase()+"_SL.png"));
				LB.setPreferredSize(new Dimension(128,128));
				LB.setOpaque(false);
				LB.setContentAreaFilled(false);
				LB.setBorderPainted(false);
				row.add(LB);
				menuScreen.add(LB);
				
			}
			BoardButtons.add(row);
		}
		JPanel bottomMiddle = new JPanel();
		
		bottomMiddle.add(curWord);
		bottomMiddle.add(selectButton);
		bottomMiddle.setBackground(Color.BLACK);
		add(bottomMiddle, BorderLayout.SOUTH);
		
		JPanel scorecardPanel = new JPanel();
		scorecardPanel.setBackground(Color.BLACK);
		add(scorecardPanel, BorderLayout.EAST);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		ImageIcon i_scoring_info = new ImageIcon("letters/Score_"+size+"x"+size+".png");
		JLabel label = new JLabel(i_scoring_info);
		leftPanel.add(label);
		add(leftPanel, BorderLayout.WEST);
		
		
		menuScreen.revalidate();
		menuScreen.repaint();
		add(menuScreen, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	private class LetterAction extends AbstractAction{
		private int x;
		private int y;
		private int size;
		public LetterAction(int x, int y, int size){
			this.x = x;
			this.y = y;
			this.size = size;
			this.setEnabled(true);
		}

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					BoardButtons.get(i).get(j).setEnabled(false);
				}
			}
			if(!BoardButtons.get(y).get(x).isSelected()){
				BoardButtons.get(y).get(x).setIcon(
						new ImageIcon("letters/"+game.getLetter(x, y).getCharacter().toUpperCase()+"_Un.png"));
				game.removeLetter();
				if(!game.getCurWordString().isEmpty()){
					int x_temp = game.getLastLetter().getX();
					int y_temp = game.getLastLetter().getY();
					enableAroundCenter(x_temp,y_temp);
					BoardButtons.get(y_temp).get(x_temp).setEnabled(true);
				} else {
					resetBoard(size);
				}
			} else {
				BoardButtons.get(y).get(x).setIcon(
						new ImageIcon("letters/"+game.getLetter(x, y).getCharacter().toUpperCase()+"_Last.png"));
				game.pickLetter(x,y);
				enableAroundCenter(x,y);
			}
			BoardButtons.get(y).get(x).setEnabled(true);
			word_panel.updateword();
			word_panel.repaint();
			System.out.println(game.getCurWordString());
		}
		
		/*
		 *      a-1,b+1		a,b+1     a+1,b+1
		 * 		a-1.b	    a,b	      a+1,b
		 * 		a-1,b-1	    a,b+1	  a+1,b-1
		 * 
		 */
		private void enableAroundCenter(int a, int b){
			if(a-1>=0){
				if(b-1>=0){
					if(!BoardButtons.get(b-1).get(a-1).isSelected()){  
						enableHelper(a-1,b-1);
					} else {
						prevEnabled(a-1,b-1);
					}
				}
				if(!BoardButtons.get(b).get(a-1).isSelected()){
					enableHelper(a-1,b);
				} else {
					prevEnabled(a-1,b);
				}
				if(b+1<size){
					if(!BoardButtons.get(b+1).get(a-1).isSelected()){
						enableHelper(a-1,b+1);
					}
				}
			}
			//a
			if(b-1>=0){
				if(!BoardButtons.get(b-1).get(a).isSelected()){
					enableHelper(a,b-1);
				} else {
					prevEnabled(a,b-1);
				}
			}
			if(b+1<size){
				if(!BoardButtons.get(b+1).get(a).isSelected()){
					enableHelper(a,b+1);
				} else {
					prevEnabled(a,b+1);
				}
			}
			
			if(a+1<size){
				if(b-1>=0){
					if(!BoardButtons.get(b-1).get(a+1).isSelected()){
						enableHelper(a+1,b-1);
					}	else {
						prevEnabled(a+1,b-1);
					}
				}
				if(!BoardButtons.get(b).get(a+1).isSelected()){
					enableHelper(a+1,b);
				} else {
					prevEnabled(a+1,b);
				}
				if(b+1<size){
					if(!BoardButtons.get(b+1).get(a+1).isSelected()){
						enableHelper(a+1,b+1);
					} else {
						prevEnabled(a+1,b+1);
					}
				}
			}
			if(BoardButtons.get(b).get(a).isSelected()){
				BoardButtons.get(b).get(a).setIcon(
					new ImageIcon("letters/"+game.getLetter(a, b).getCharacter().toUpperCase()+"_Last.png"));
			}
		}
			
		
	}
	public class SelectListener extends AbstractAction{
		private int size;
		
		public SelectListener(int boardsize){
			size = boardsize;
		}
		
		public void actionPerformed(ActionEvent e) {
			String word = game.getCurWordString();
			try {
				if(files.checkForWord(word)){
					if(scorecard.scoreWord(word)){
						//update scorecard UX
						//refresh board
						
						resetBoard(size);
					} else {
						resetBoard(size);
					}
				}  else {
					resetBoard(size);
					//display invalid word message
				}
			} catch (FileNotFoundException e1) {
			}
			System.out.println(scorecard.getScoredWords());
			System.out.println(scorecard.getTotal());
		}
		
	}
	public void resetBoard(int size){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				BoardButtons.get(i).get(j).setEnabled(true);
				BoardButtons.get(i).get(j).setSelected(false);
				BoardButtons.get(i).get(j).setIcon(
						new ImageIcon("letters/"+game.getLetter(j,i).getCharacter().toUpperCase()+"_SL.png"));
			}
		}
		game.clearCurWord();
		word_panel.updateword();
		word_panel.repaint();
		
	}
	public void enableHelper(int a, int b){
		BoardButtons.get(b).get(a).setEnabled(true);
		BoardButtons.get(b).get(a).setIcon(
			new ImageIcon("letters/"+game.getLetter(a,b).getCharacter().toUpperCase()+"_SL.png"));

	}
	public void prevEnabled(int a, int b){
		BoardButtons.get(b).get(a).setIcon(
			new ImageIcon("letters/"+game.getLetter(a,b).getCharacter().toUpperCase()+"_SL.png"));
	}
	public class WordPanel extends JPanel {
		private String word;
		
		public WordPanel(){
			word = "";
			super.setFont(new Font("Arial", Font.BOLD, 64));
		}
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawString(word, 10, 100);
	    }
	    public void updateword(){
	    	word = game.getCurWordString().toUpperCase();
	    	if(word.length()>11)
	    		super.setFont(new Font("Arial", Font.BOLD, 48));
	    	if(word.length()>16)
	    		super.setFont(new Font("Arial", Font.BOLD, 16));
	    	if(word.length()<11)
	    		super.setFont(new Font("Arial", Font.BOLD, 64));
	    }

	}
}