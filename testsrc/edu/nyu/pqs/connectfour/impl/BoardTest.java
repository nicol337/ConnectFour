package edu.nyu.pqs.connectfour.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {
	
	static Board board;
	static PlayerFactory playerFactory;
	static IPlayer player1;
	static IPlayer player2;

	@BeforeClass 
	public static void beforeClass() {
		board = Board.getInstance();
	  playerFactory = PlayerFactory.getInstance();
		player1 = playerFactory.getNewHumanPlayer("Player1");
		player2 = playerFactory.getNewHumanPlayer("Player2");
		board.setPlayer1(player1);
		board.setPlayer2(player2);
	}
	
	@Test
	public void testPrint() {
		board.addChip(player1, 0);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,3).getPlayer().equals(player2));
		board.addChip(player1, 4);
		board.addChip(player1, 3);
		board.addChip(player1, 3);
		board.addChip(player2, 3);
		board.addChip(player1, 3);
		board.addChip(player2, 3);
	}
	
	@Test
	public void testAddChip() {
		board.addChip(player1, 0);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		board.addChip(player2, 0);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		board.addChip(player1, 0);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		board.addChip(player2,1);
		board.addChip(player2,1);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		board.addChip(player2,2);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,2).getPlayer().equals(player2));
		board.addChip(player2,3);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,2).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		board.addChip(player2,4);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,2).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,4).getPlayer().equals(player2));
		board.addChip(player2,5);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,2).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,4).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,5).getPlayer().equals(player2));
		board.addChip(player2,6);
		assertEquals(true, board.getChip(0,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(1,0).getPlayer().equals(player2));
		assertEquals(true, board.getChip(2,0).getPlayer().equals(player1));
		assertEquals(true, board.getChip(0,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(1,1).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,2).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,4).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,5).getPlayer().equals(player2));
		assertEquals(true, board.getChip(0,6).getPlayer().equals(player2));
	}
	
	@Test
	public void testIsMoveLegal() {
		assertEquals(false,board.addChip(player1, -1));
		assertEquals(false,board.addChip(player2, 7));
	}

	@Test
	public void testCheckHorizontalisTrue() {
		board.addChip(player2, 0);
		board.addChip(player2, 1);
		board.addChip(player2, 2);
		board.addChip(player1, 3);
		board.addChip(player1, 0);
		board.addChip(player1, 1);
		board.addChip(player1, 2);
		board.addChip(player1, 3);
		assertEquals(true, board.checkHorizontal());
	}
	
	@Test
	public void testCheckHorizontalIsFalse() {
		board.addChip(player2, 0);
		board.addChip(player2, 1);
		board.addChip(player2, 2);
		board.addChip(player1, 3);
		board.addChip(player1, 0);
		board.addChip(player1, 0);
		board.addChip(player1, 2);
		board.addChip(player1, 3);
		board.addChip(player2, 4);
		board.addChip(player2, 5);
		board.addChip(player2, 6);
		board.addChip(player1, 3);
		assertEquals(false, board.checkHorizontal());
	}
	
	@Test
	public void testCheckVerticalIsTrue() {
		board.addChip(player2, 0);
		board.addChip(player1, 0);
		board.addChip(player1, 0);
		board.addChip(player1, 0);
		board.addChip(player2, 0);
		board.addChip(player2, 0);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		assertEquals(true, board.checkVertical());
	}
	
	@Test
	public void testCheckVerticalIsFalse() {
		board.addChip(player2, 0);
		board.addChip(player1, 0);
		board.addChip(player2, 0);
		board.addChip(player1, 0);
		board.addChip(player2, 0);
		board.addChip(player2, 1);
		board.addChip(player1, 1);
		board.addChip(player2, 1);
		board.addChip(player1, 1);
		assertEquals(false, board.checkVertical());
	}
	
	@Test
	public void testCheckPositiveDiagonalIsTrue() {
		board.addChip(player1, 0);
		board.addChip(player1, 0);
		board.addChip(player2, 0);
		board.addChip(player1, 1);
		board.addChip(player1, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player1, 2);
		board.addChip(player1, 2);
		board.addChip(player1, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		assertEquals(true, board.checkPositiveDiagonal());
	}
	
	@Test
	public void testCheckPositiveDiagonalIsFalse() {
		board.addChip(player1, 0);
		board.addChip(player1, 0);
		board.addChip(player2, 0);
		board.addChip(player1, 1);
		board.addChip(player1, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player1, 2);
		board.addChip(player1, 2);
		board.addChip(player1, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		assertEquals(false, board.checkPositiveDiagonal());
	}
	
	@Test
	public void testCheckNegativeDiagonalIsTrue() {
		board.addChip(player2, 4);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		assertEquals(true, board.checkNegativeDiagonal());
	}
	
	@Test
	public void testCheckNegativeDiagonalIsFalse() {
		board.addChip(player1, 4);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 1);
		board.addChip(player2, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 2);
		board.addChip(player2, 3);
		board.addChip(player2, 3);
		assertEquals(false, board.checkNegativeDiagonal());
	}
	
	@Test
	public void testAddChipIsTrue() {
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 5));
	}
	
	@Test
	public void testAddChipIsFalse() {
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(false, board.addChip(player2, 2));
	}
	
	@Test 
	public void testIsTied() {
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 1));
		assertEquals(true, board.addChip(player2, 1));
		assertEquals(true, board.addChip(player1, 1));
		assertEquals(true, board.addChip(player1, 1));
		assertEquals(true, board.addChip(player2, 1));
		assertEquals(true, board.addChip(player1, 1));
		
		assertEquals(true, board.addChip(player1, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player1, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player1, 2));
		assertEquals(true, board.addChip(player2, 2));


		assertEquals(true, board.addChip(player2, 3));
		assertEquals(true, board.addChip(player1, 3));
		assertEquals(true, board.addChip(player1, 3));
		assertEquals(true, board.addChip(player2, 3));
		assertEquals(true, board.addChip(player2, 3));
		assertEquals(true, board.addChip(player1, 3));
		
		assertEquals(false, board.isTied());
		
		assertEquals(true, board.addChip(player2, 4));
		assertEquals(true, board.addChip(player1, 4));
		assertEquals(true, board.addChip(player2, 4));
		assertEquals(true, board.addChip(player1, 4));
		assertEquals(true, board.addChip(player2, 4));
		assertEquals(true, board.addChip(player2, 4));
		
		assertEquals(false, board.isTied());
		
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player1, 5));
		assertEquals(true, board.addChip(player1, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player1, 5));
		assertEquals(true, board.addChip(player2, 5));

		assertEquals(false, board.isTied());
		
		assertEquals(true, board.addChip(player1, 6));
		assertEquals(true, board.addChip(player2, 6));
		assertEquals(true, board.addChip(player2, 6));
		assertEquals(true, board.addChip(player1, 6));
		assertEquals(true, board.addChip(player1, 6));
		assertEquals(true, board.addChip(player2, 6));
		
		assertEquals(true, board.isTied());
	}
	
	
	@After 
	public void afterEveryTest() {
		board.clearBoard();
	}
	
	
}
