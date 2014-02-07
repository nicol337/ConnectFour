package edu.nyu.pqs.connectfour.impl;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChipTest {

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
	public void testSetPlayer() {
		Chip chip1 = new Chip(player1);
		Chip chip2 = new Chip(player2);
		assertEquals(true,chip1.getPlayer().equals(board.getPlayer1()));
		assertEquals(true,chip2.getPlayer().equals(board.getPlayer2()));
	}

	@Test
	public void testChipGetPlayer() {
		board.addChip(player2, 3);
		assertEquals(true, board.getChip(0,3).getPlayer().equals(player2));
		board.addChip(player1, 3);
		assertEquals(true, board.getChip(1,3).getPlayer().equals(player1));
	}
}
