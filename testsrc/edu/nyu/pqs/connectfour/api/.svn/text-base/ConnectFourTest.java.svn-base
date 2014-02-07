package edu.nyu.pqs.connectfour.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.nyu.pqs.connectfour.impl.Board;
import edu.nyu.pqs.connectfour.impl.Chip;
import edu.nyu.pqs.connectfour.impl.IPlayer;
import edu.nyu.pqs.connectfour.impl.PlayerFactory;

public class ConnectFourTest {

	static ConnectFour game;
	static Board board;
	static PlayerFactory playerFactory;
	static IPlayer player1;
	static IPlayer player2;
	static IPlayer computerPlayer;

	@BeforeClass 
	public static void beforeClass() {
		game = ConnectFour.getInstance();
		board = Board.getInstance();
	  playerFactory = PlayerFactory.getInstance();
		player1 = playerFactory.getNewHumanPlayer("Player1");
		player2 = playerFactory.getNewHumanPlayer("Player2");
		computerPlayer = playerFactory.getNewComputerPlayer("");
	}
	
	@Test
	public void setUpGameWithComputerTest() {
		game.setUpGame(true, player1.getName(), "Computer");
		assertEquals(game.getComputerMode(), true);
	}
	
	@Test
	public void setUpGameTwoPlayersTest() {
		game.setUpGame(false, player1.getName(), player2.getName());
		assertEquals(game.getComputerMode(), false);
		assertEquals(true, 
						(game.getCurrentPlayer().getName() == player1.getName()) 
					  || (game.getCurrentPlayer().getName() == player2.getName()));
	}
	
	@Test
	public void togglePlayerTest() {
		game.setUpGame(false, player1.getName(), player2.getName());
		IPlayer firstPlayer = game.getCurrentPlayer();
		game.togglePlayer();
		IPlayer secondPlayer = game.getCurrentPlayer();
		game.togglePlayer();
		IPlayer thirdPlayer = game.getCurrentPlayer();
		game.togglePlayer();
		IPlayer fourthPlayer = game.getCurrentPlayer();
		assertEquals(firstPlayer, thirdPlayer);
		assertEquals(secondPlayer, fourthPlayer);
		assertNotEquals(firstPlayer,secondPlayer);
	}
	
	@Test
	public void nextMoveTest() {
		game.setUpGame(false, player1.getName(), player2.getName());
		assertEquals(true, game.nextMove(0));
		assertEquals(false, game.nextMove(7));
		game.togglePlayer();
		assertEquals(false, game.nextMove(-1));
		assertEquals(true, game.nextMove(2));
	}
	
	@Test
	public void automatedMoveIsLegalTest() {
		game.setUpGame(true, player1.getName(), "");
		assertEquals(true, game.nextMove(0));
		game.togglePlayer();
		assertEquals(true, game.nextMove(game.automatedMove()));
		assertEquals(true, game.nextMove(game.automatedMove()));
		assertEquals(true, game.nextMove(game.automatedMove()));
		assertEquals(true, game.nextMove(game.automatedMove()));
		assertEquals(true, game.nextMove(game.automatedMove()));
	}
	
	@Test
	public void isFinishedTest() {
		game.setUpGame(true, player1.getName(), "");
		game.togglePlayer();
		for (int i=0; i < 7*6; i++) {
			assertEquals(true, game.nextMove(game.automatedMove()));
		}
		assertEquals(true, game.isFinished());
		assertEquals(true, !game.isTied());
		assertEquals(game.getWinner(), game.getCurrentPlayer());
		assertEquals(false, game.nextMove(game.automatedMove()));
	}
	
	@Test
	public void getBoardTest() {
		game.setUpGame(true, player1.getName(), "");
		game.nextMove(0);
		Chip[][] copy = game.getBoard();
		copy[0][0] = new Chip(player2);
		assertNotEquals(copy,game.board);
		assertNotEquals(copy[0][0],game.board.getChip(0, 0));
	}
	
	@After 
	public void afterEveryTest() {
		game.reset();
	}
}