package edu.nyu.pqs.connectfour.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.nyu.pqs.connectfour.api.ConnectFour;

public class HumanPlayerTest {
	static Board board;
	static ConnectFour game;
	static PlayerFactory playerFactory;
	static IPlayer player1;
	static IPlayer player2;

	@BeforeClass 
	public static void beforeClass() {
		board = Board.getInstance();
	  playerFactory = PlayerFactory.getInstance();
	}
	
	@Test
	public void testName() {
		player1 = playerFactory.getNewHumanPlayer("Player1");
		player2 = playerFactory.getNewHumanPlayer("Player2");
		board.setPlayer1(player1);
		board.setPlayer2(player2);
		assertEquals(board.getPlayer1().getName(), player1.getName());
		assertEquals(board.getPlayer2().getName(), player2.getName());
	}
	
	@Test
	public void testGetMove() {
		player1 = playerFactory.getNewHumanPlayer("Player1");
		player2 = playerFactory.getNewHumanPlayer("Player2");
		board.setPlayer1(player1);
		board.setPlayer2(player2);
		assertEquals(true, board.addChip(board.getPlayer1(), player1.getMove(board)));
		assertEquals(true, board.addChip(board.getPlayer2(), player2.getMove(board)));						
	}
	
	@After 
	public void afterEveryTest() {
		board.clearBoard();
	}


}
