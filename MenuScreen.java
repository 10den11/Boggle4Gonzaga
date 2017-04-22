import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;
public class MenuScreen {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MenuFrame();
				frame.setTitle("Boggle");
				frame.setLocation(0, 0);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	public MenuFrame() {
		
		setSize(1920, 1080);
		menuScreen = new JPanel();
		menuScreen.setBackground(Color.BLACK);
		box = Box.createVerticalBox();
		files = new FileStorer();
		paintMenu();
	}
	public void paintMenu(){
		menuScreen.removeAll();
		box.removeAll();
		
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
		
		/*menuScreen.add(PlayButton);
		menuScreen.add(OptionButton);
		menuScreen.add(HighScoreButton);
		add(menuScreen, BorderLayout.CENTER);*/
		
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
			remove(box);
			remove(menuScreen);
			menuScreen.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			//add Options Title
			ImageIcon i_option = new ImageIcon("option.png");
			JLabel label = new JLabel("", i_option, JLabel.CENTER);
			c.gridwidth = 3;
			c.gridx = 2;
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
			menuScreen.add(label, c);
			
			//Add Display bars for settings
			int size = files.getBoardSize();
			int time = files.getTimeLimit();
			JLabel i_size = new JLabel(new ImageIcon(size + "x" + size + ".png"));
			JLabel i_time = new JLabel(new ImageIcon("time" + time + ".png"));
			c.gridy = 3;
			menuScreen.add(i_size, c);
			c.gridy = 4;
			menuScreen.add(i_time, c);
			
			
			
			
			//add Board Size Buttons
			JButton size_back_arrow = new JButton(new SizeListener(0, i_size));
			JButton size_forward_arrow = new JButton(new SizeListener(1, i_size));
			size_back_arrow.setIcon(new ImageIcon("size_arrow_back.png"));
			size_forward_arrow.setIcon(new ImageIcon("size_arrow_forward.png"));
			//size_back_arrow.setPreferredSize(new Dimension(x,y));
			//size_forward_arrow.setPreferredSize(new Dimension(x,y));
			c.gridx = 1;
			c.gridy = 3;
			menuScreen.add(size_back_arrow, c);
			c.gridx = 3;
			menuScreen.add(size_forward_arrow, c);
			
			
			//add Timer Buttons
			JButton time_back_arrow = new JButton(new TimeListener(0, i_time));
			JButton time_forward_arrow = new JButton(new TimeListener(1, i_time));
			time_back_arrow.setIcon(new ImageIcon("time_arrow_back.png"));
			time_forward_arrow.setIcon(new ImageIcon("time_arrow_forward.png"));
			//time_back_arrow.setPreferredSize(new Dimension(x,y));
			//time_forward_arrow.setPreferredSize(new Dimension(x,y));
			c.gridx = 1;
			c.gridy = 4;
			menuScreen.add(time_back_arrow, c);
			c.gridx = 3;
			menuScreen.add(time_forward_arrow, c);
			
			//add Back Button
			JButton back_button = new JButton(new BackListener());
			back_button.setIcon(new ImageIcon("back.png"));
			back_button.setPreferredSize(new Dimension(333, 171));
			c.gridx = 0;
			c.gridy = 5;
			c.weighty = 1;
			c.anchor = GridBagConstraints.PAGE_END;
			menuScreen.add(back_button, c);
			
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
			int t = files.getBoardSize(); //current time limit
			if(direction == 0){
				if(t == 1){
					files.setTimeLimit(0);
					time_image.setIcon(new ImageIcon("time0.png"));
				}
				if(t == 3){
					files.setTimeLimit(1);
					time_image.setIcon(new ImageIcon("time1.png"));
				}
				if(t == 5){
					files.setTimeLimit(3);
					time_image.setIcon(new ImageIcon("time3.png"));
				}
			} else if (direction == 1){
				if(t == 0){
					files.setTimeLimit(1);
					time_image.setIcon(new ImageIcon("time1.png"));
				}
				if(t == 1){
					files.setTimeLimit(3);
					time_image.setIcon(new ImageIcon("time3.png"));
				}
				if(t == 3){
					files.setTimeLimit(5);
					time_image.setIcon(new ImageIcon("time5.png"));
				}
			}
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
		int size = 6;
		//JPanel centerPanel = new JPanel();
		JButton selectButton = new JButton(new SelectListener(size));
		selectButton.setIcon(new ImageIcon("select.png"));
		selectButton.setPreferredSize(new Dimension(241,172));
		JLabel curWord = new JLabel(new ImageIcon (""));
		//int size = files.getBoardSize();
		game = new Board(size);
		System.out.print(game);
		scorecard = new ScoreCard(size);
		menuScreen.setLayout(new GridLayout(size,size));
		
		BoardButtons = new ArrayList<ArrayList<JToggleButton>>();
		
		for(int i = 0; i < size; i++){
			ArrayList<JToggleButton> row = new ArrayList<JToggleButton>();
			for(int j = 0; j < size; j++){
				JToggleButton LB = new JToggleButton(new LetterAction(j,i,size));
				LB.setIcon(new ImageIcon("start.png"));
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
				
				game.removeLetter();
				if(!game.getCurWordString().isEmpty()){
					int x_temp = game.getLastLetter().getX();
					int y_temp = game.getLastLetter().getY();
					enableAroundCenter(x_temp,y_temp);
					BoardButtons.get(y_temp).get(x_temp).setEnabled(true);
				} else {
					for(int i = 0; i < size; i++){
						for(int j = 0; j < size; j++){
							BoardButtons.get(i).get(j).setEnabled(true);
						}
					}
				}
			} else {
				game.pickLetter(x,y);
				enableAroundCenter(x,y);
			}
			BoardButtons.get(y).get(x).setEnabled(true);
			System.out.println(game.getCurWordString());
		}
		private void enableAroundCenter(int a, int b){
			if(a-1 >= 0){
				if(b-1 >= 0){
					if(!BoardButtons.get(b-1).get(a-1).isSelected())
						BoardButtons.get(b-1).get(a-1).setEnabled(true);
					if(!BoardButtons.get(b-1).get(a).isSelected())
						BoardButtons.get(b-1).get(a).setEnabled(true);
				}
				if(b >= 0){
					if(!BoardButtons.get(b).get(a-1).isSelected())
						BoardButtons.get(b).get(a-1).setEnabled(true);
					
				}
				if(b+1 < size){
					if(!BoardButtons.get(b+1).get(a-1).isSelected())
						BoardButtons.get(b+1).get(a-1).setEnabled(true);
					if(!BoardButtons.get(b+1).get(a).isSelected())
						BoardButtons.get(b+1).get(a).setEnabled(true);
				}
			}
			if(b-1 >=0){
				if(!BoardButtons.get(b-1).get(a).isSelected())
					BoardButtons.get(b-1).get(a).setEnabled(true);
			}
			if(b+1 < size){
				if(!BoardButtons.get(b+1).get(a).isSelected())
					BoardButtons.get(b+1).get(a).setEnabled(true);
			}
			if(a+1 < size){
				if(b-1 >= 0){
					if(!BoardButtons.get(b-1).get(a+1).isSelected())
						BoardButtons.get(b-1).get(a+1).setEnabled(true);
				}
				if(!BoardButtons.get(b).get(a+1).isSelected())
					BoardButtons.get(b).get(a+1).setEnabled(true);	
				if(b+1 < size){
					if(!BoardButtons.get(b+1).get(a+1).isSelected())
						BoardButtons.get(b+1).get(a+1).setEnabled(true);
				}
			}
			if(game.getCurWordString().isEmpty()){
				resetBoard(size);
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
				e1.printStackTrace();
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
			}
		}
		game.clearCurWord();
	}
}