import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;


public class CountSquares extends ApplicationTest {
	
	private GameApplication game;
	
	public int getNumberReds() {
		int numberOfReds = 0;

		for (int i = 0; i < GameApplication.GRID_SIZE * GameApplication.GRID_SIZE; i++) {
			Button b = lookup("#button" + i).queryButton();

			if(b.getStyle().equals(GameApplication.BUTTON_STYLE_RED)) {
				numberOfReds++;
			}
		}
	
		return numberOfReds;
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test11() throws InterruptedException {
		Thread.sleep(500);
		int x = 1;
		int y = 1;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test12() throws InterruptedException {
		Thread.sleep(500);
		int x = 1;
		int y = 2;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test13() throws InterruptedException {
		Thread.sleep(500);
		int x = 1;
		int y = 3;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test14() throws InterruptedException {
		Thread.sleep(500);
		int x = 1;
		int y = 4;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test21() throws InterruptedException {
		Thread.sleep(500);
		int x = 2;
		int y = 1;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test22() throws InterruptedException {
		Thread.sleep(500);
		int x = 2;
		int y = 2;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test23() throws InterruptedException {
		Thread.sleep(500);
		int x = 2;
		int y = 3;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test24() throws InterruptedException {
		Thread.sleep(500);
		int x = 2;
		int y = 4;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test31() throws InterruptedException {
		Thread.sleep(500);
		int x = 3;
		int y = 1;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test32() throws InterruptedException {
		Thread.sleep(500);
		int x = 3;
		int y = 2;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test33() throws InterruptedException {
		Thread.sleep(500);
		int x = 3;
		int y = 3;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}

	@Test
	public void test34() throws InterruptedException {
		Thread.sleep(500);
		int x = 3;
		int y = 4;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test41() throws InterruptedException {
		Thread.sleep(500);
		int x = 4;
		int y = 1;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test42() throws InterruptedException {
		Thread.sleep(500);
		int x = 4;
		int y = 2;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test43() throws InterruptedException {
		Thread.sleep(500);
		int x = 4;
		int y = 3;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
	@Test
	public void test44() throws InterruptedException {
		Thread.sleep(500);
		int x = 4;
		int y = 4;
		game.displaySquare(x, y);
		Thread.sleep(500);
		assertEquals(1, getNumberReds());
	}
	
}
