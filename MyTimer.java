package timer;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class  MyTimer {

    Timer timer;
    int timeLimit = 10;
    int currentTime;

    public MyTimer() {

    }
    
    public int getCurrentTime(){
    	return currentTime;
    }
    
    public void updateCurrentTime(){
    	
        final JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel(Integer.toString(timeLimit));
        JPanel panel = new JPanel();
        panel.add(label, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        
    	timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(timeLimit));
                timeLimit--;
                if (timeLimit == 0) {
                      timer.stop();
                }
            }
        });timer.start();
    	
    }
}
