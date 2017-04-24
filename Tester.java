import static org.junit.Assert.*;

import java.awt.*;
import java.awt.event.InputEvent;

import org.junit.Test;

public class Tester {
	/**
	 * 
	 * @throws AWTException this exception is mandatory for robots
	 * For testing the functionality of the options menu
	 */
	 
	 
	@Test
	public void optionsTest() throws AWTException {
		Robot bot = new Robot();
		MenuScreen.main(null);
		bot.mouseMove(630, 390);
		bot.delay(3000);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseMove(50, 890);
		bot.delay(3000);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(3000);
		//fail("Not yet implemented");
	}
	
	/**
	 * 
	 * @throws AWTException this exception is mandatory for robots
	 * For testing the functionality of the highscore menu
	 */
	@Test
	public void highscoreTest() throws AWTException {
		Robot bot = new Robot();
		MenuScreen.main(null);
		bot.mouseMove(630, 500);
		bot.delay(3000);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseMove(50, 890);
		bot.delay(3000);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(3000);
		//fail("Not yet implemented");
	}


}
