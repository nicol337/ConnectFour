package edu.nyu.pqs.connectfour.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComputerPlayerTest {
	
	static Board board;
	static PlayerFactory playerFactory;
	static IPlayer player1;
	static IPlayer player2;

	@BeforeClass 
	public static void beforeClass() {
		board = Board.getInstance();
	  playerFactory = PlayerFactory.getInstance();
		player1 = playerFactory.getNewHumanPlayer("Player1");
		player2 = playerFactory.getNewComputerPlayer("Computer");
		board.setPlayer1(player1);
		board.setPlayer2(player2);
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testGetMoveFindsAnyMove() {
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
		assertEquals(true, board.addChip(player1, 1));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
	}
	
	@Test
	public void testGetMoveFindsVerticalWinningMove() {
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player1, 0));
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, 5));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
		board.printBoard();
		assertEquals(player2, board.getChip(3,5).getPlayer());
	}
	
	@Test
	public void testGetMoveFindsDiagonalWinningMove() {
		assertEquals(true, board.addChip(player2, 0));
		assertEquals(true, board.addChip(player1, 1));
		assertEquals(true, board.addChip(player2, 1));
		assertEquals(true, board.addChip(player1, 2));
		assertEquals(true, board.addChip(player1, 2));
		assertEquals(true, board.addChip(player2, 2));
		assertEquals(true, board.addChip(player1, 3));
		assertEquals(true, board.addChip(player2, 3));
		assertEquals(true, board.addChip(player1, 3));
		assertEquals(true, board.addChip(player2, player2.getMove(board)));
		board.printBoard();
		assertEquals(player2, board.getChip(3,3).getPlayer());
	}
	
	@After 
	public void afterEveryTest() {
		board.clearBoard();
	}

}
