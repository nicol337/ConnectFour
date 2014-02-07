package edu.nyu.pqs.connectfour.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerFactoryTest {

	static Board board;
	static PlayerFactory playerFactory;
	static IPlayer player1;
	static IPlayer player2;

	@BeforeClass 
	public static void beforeClass() {
	  playerFactory = PlayerFactory.getInstance();
	}
	
	@Test
	public void testSingleton() {
		PlayerFactory otherPlayerFactory = PlayerFactory.getInstance();
		assertEquals(playerFactory, otherPlayerFactory);
	}
	
	@Test
	public void testGetNewPlayer() {
		IPlayer humanPlayer1 = playerFactory.getNewHumanPlayer("player1");
		assertEquals(humanPlayer1.getClass(), HumanPlayer.class);
	}
	
	@Test
	public void testGetNewPlayers() {
		IPlayer humanPlayer1 = playerFactory.getNewHumanPlayer("player1");
		IPlayer humanPlayer2 = playerFactory.getNewHumanPlayer("player2");
		assertEquals(humanPlayer1.getClass(), HumanPlayer.class);
		assertEquals(humanPlayer2.getClass(), HumanPlayer.class);
		assertNotEquals(humanPlayer1, humanPlayer2);
	}
	
	@Test
	public void testGetNewComputerPlayer() {
		IPlayer computerOpponent = playerFactory.getNewComputerPlayer("Computer");
		assertEquals(computerOpponent.getClass(), ComputerPlayer.class);
	}
}
