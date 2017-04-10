import java.awt.*;
import javax.swing.*;
public class MenuScreen {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MenuFrame();
				frame.setTitle("Yahtzee");
				frame.setLocation(0, 0);
				frame.setVisible(true);
				frame.setBackground(Color.BLACK);
			}
		});

	}

}
class MenuFrame extends JFrame {
	private JPanel menuScreen;
	private Box box;
	
	public MenuFrame() {
		setSize(1920, 1080);
		menuScreen = new JPanel();
		JButton PlayButton = new JButton();
		JButton OptionButton = new JButton();
		JButton HighScoreButton = new JButton();
		ImageIcon TitleIcon = new ImageIcon("title.png");
		JLabel titleLabel = new JLabel ("", TitleIcon, JLabel.CENTER);
		box = Box.createVerticalBox();
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
		add(box, BorderLayout.CENTER);
		add(menuScreen, BorderLayout.NORTH);
	}
}