package edu.nyu.pqs.connectfour.play;

import edu.nyu.pqs.connectfour.api.ConnectFour;
import edu.nyu.pqs.connectfour.impl.ComputerPlayer;
import edu.nyu.pqs.connectfour.impl.IPlayer;

/**
 * The Model of the MVC of ConnectFour. It hosts the underlying game play
 * with the help of the methods from ConnectFour.java. It sends messages to view
 * to update the board and also accepts event messages from ConnectFourView.
 * @author nicolelee
 *
 */
public class ConnectFourModel {

	private ConnectFour game;
	private IConnectFourListener listener;
	
	public ConnectFourModel() {
		this.game = ConnectFour.getInstance();
	}
	
	void fireGameStartEvent() {
		listener.gameSetUp();
		setUpTurn();
	}
	
	void initializeGame(Boolean computerMode, String player1Name, String player2Name) {
		game.setUpGame(computerMode, player1Name, player2Name);
	}
	
	public void setUpTurn() {
		game.togglePlayer();
		listener.updateActivePlayer(game.getCurrentPlayer());
		if (game.getComputerMode() && 
						game.getCurrentPlayer().getClass() == ComputerPlayer.class) {
			turn(game.automatedMove());
		}
	}
	
	public void turn(int column) {
		if(!game.isFinished()) {
			boolean failed = game.nextMove(column);
			if (!failed) {
				listener.updateStatus("Illegal Move. Please try again.");
			}
			else {
				completeTurn();
			}
		}
	}
	
	public void completeTurn() {
		listener.updateBoard(game.getBoard());
		if (game.isFinished()) {
			endGame();
		}
		else {
			setUpTurn();
		}
	}
	
	public void endGame() {
		String endStatus;
		if (!game.isTied()) {
			IPlayer winner = game.getWinner();
			endStatus = "Game Over. Winner is "+winner.getName();
			listener.updateStatus(endStatus);
			listener.gameEnd(endStatus);
		}
		else {
			endStatus = "Tie game.";
			listener.updateStatus(endStatus);
			listener.gameEnd(endStatus);
		}
	}
	
	public void register(IConnectFourListener listener) {
		this.listener = listener;
	}

	public void unregister(IConnectFourListener listener) {
		this.listener = null; 
	}
}