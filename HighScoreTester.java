import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class HighScoreTester {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new scoreFrame();
				frame.setTitle("test");
				frame.setLocation(0, 0);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
}
}

class scoreFrame extends JFrame{
	private JPanel menuScreen;
	private FileStorer testStuffs;
	private JPanel titleScreen;
	private JPanel placementScreen;
	private JPanel selectionScreen;
	private int[] currentHighPoints;
	private String[] currentHighNames;
	private JLabel place[] = new JLabel[10];
	private JButton selection[][] = new JButton[7][];
	public scoreFrame(){
		setSize(1920, 1080);
		menuScreen = new JPanel();
		menuScreen.setLayout(new GridLayout(0, 1));
		menuScreen.setBackground(Color.BLACK);
		titleScreen = new JPanel();
		titleScreen.setBackground(Color.BLACK);
		placementScreen = new JPanel();
		placementScreen.setBackground(Color.BLACK);
		selectionScreen = new JPanel();
		selectionScreen.setBackground(Color.BLACK);
		selectionScreen.setLayout(new GridLayout(0, 1));
		
		testStuffs = new FileStorer();
		currentHighPoints = testStuffs.getAllHighScorePoints(testStuffs.getBoardSize(), testStuffs.getTimeLimit());
		currentHighNames = testStuffs.getAllHighScoreNames(testStuffs.getBoardSize(), testStuffs.getTimeLimit());
		
		JLabel title = new JLabel("", new ImageIcon("highscore.png"), JLabel.CENTER);
		titleScreen.add(title);
		
		JLabel placements = new JLabel ("", new ImageIcon("placements.png"), JLabel.CENTER);
		placementScreen.add(placements);
		
		for(int k = 0; k < 10; k++)
		{
			place[k] = new JLabel(currentHighNames[k] + ":" + currentHighPoints[k]);
			
			place[k].setFont(new Font("Arial", Font.ROMAN_BASELINE, 72));
			if(k % 2 == 0)
			{
				place[k].setForeground(new Color(255, 97, 48));
			} else
			{
				place[k].setForeground(new Color(66, 124, 184));
			}
			menuScreen.add(place[k]);
		}
		for(int k = 4; k <= 6; k++)
		{
			selection[k] = new JButton[6];
			selection[k][0] = new JButton("Board = " + k + "x" + k + ", Time = Unlimited");
			selection[k][0].addActionListener(new highListner(k, 0));
			selection[k][1] = new JButton("Board = " + k + "x" + k + ", Time = 1 minute");
			selection[k][1].addActionListener(new highListner(k, 1));
			selection[k][3] = new JButton("Board = " + k + "x" + k + ", Time = 3 minutes");
			selection[k][3].addActionListener(new highListner(k, 3));
			selection[k][5] = new JButton("Board = " + k + "x" + k + ", Time = 5 minutes");
			selection[k][5].addActionListener(new highListner(k, 5));
			
			selectionScreen.add(selection[k][0]);
			selectionScreen.add(selection[k][1]);
			selectionScreen.add(selection[k][3]);
			selectionScreen.add(selection[k][5]);
		}
		selection[testStuffs.getBoardSize()][testStuffs.getTimeLimit()].setEnabled(false);
		
		
		add(placementScreen, BorderLayout.WEST);
		add(menuScreen, BorderLayout.CENTER);
		add(titleScreen, BorderLayout.NORTH);
		add(selectionScreen, BorderLayout.EAST);
		
	}
	public class highListner extends AbstractAction{
		private int board;
		private int minutes;
		public highListner(int size, int time)
		{
			board = size;
			minutes = time;
		}
		public void actionPerformed(ActionEvent e) {
			currentHighPoints = testStuffs.getAllHighScorePoints(board, minutes);
			currentHighNames = testStuffs.getAllHighScoreNames(board, minutes);
			
			for(int k = 0; k < 10; k++)
			{
				place[k].setText(currentHighNames[k] + ":" + currentHighPoints[k]);
				if(k % 2 == 0)
				{
					place[k].setForeground(new Color(255, 97, 48));
				} else
				{
					place[k].setForeground(new Color(66, 124, 184));
				}
			}
			menuScreen.revalidate();
			menuScreen.repaint();
			for(int k = 4; k <= 6; k++)
			{
				selection[k][0].setEnabled(true);
				selection[k][1].setEnabled(true);
				selection[k][3].setEnabled(true);
				selection[k][5].setEnabled(true);
			}
			selection[board][minutes].setEnabled(false);
		}
	}	
}