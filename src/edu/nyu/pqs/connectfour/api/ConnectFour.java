package edu.nyu.pqs.connectfour.api;

import edu.nyu.pqs.connectfour.impl.Board;
import edu.nyu.pqs.connectfour.impl.Chip;
import edu.nyu.pqs.connectfour.impl.IPlayer;
import edu.nyu.pqs.connectfour.impl.PlayerFactory;

/**
 * ConnectFour class is instantiated as a "game". It is the underlying 
 * methods that support the game played in the ConnectFour Model.  
 * @author nicolelee
 *
 */
public class ConnectFour {
	
	static ConnectFour game = null;
	public Board board;
	PlayerFactory playerFactory;
	private IPlayer player1;
	private IPlayer player2;
	private boolean computerMode;
	private boolean player1Turn;
	
	private ConnectFour() {
		this.board = Board.getInstance();
		this.player1Turn = false;
	  this.computerMode = false;
	}
	
	public static ConnectFour getInstance() {
		if (game == null) {
			game = new ConnectFour();
		}
		return game;
	}

	public void setUpGame(boolean computerOpponent, 
					String player1name, String player2name) {
		if (computerOpponent) {
			computerMode = true;
		}
		playerFactory = PlayerFactory.getInstance();
		if (computerMode) {
			player1 = playerFactory.getNewHumanPlayer(player1name);
			player2 = playerFactory.getNewComputerPlayer(player2name);
		}
		else {
			player1 = playerFactory.getNewHumanPlayer(player1name);
			player2 = playerFactory.getNewHumanPlayer(player2name);
		}
		board.setPlayer1(player1);
		board.setPlayer2(player2);
	}
	
	public void togglePlayer() {
		this.player1Turn=!this.player1Turn;
	}
	
	public boolean nextMove(int column) {
		if (!board.isMoveLegal(column)) {
			return false;
		}
		else {
			if (this.player1Turn) {
				if (!board.addChip(player1, column)) {
					System.out.println("error on player1 move");
				}
			}
			else {
				if (!board.addChip(player2, column)) {
					System.out.println("error on player2 move");
				}
			}
		}
		return true;
	}
	
	public int automatedMove() {
		return player2.getMove(this.board);
	}
	
	public boolean isFinished() {
		return (board.checkHorizontal() ||
						board.checkVertical() ||
						board.checkPositiveDiagonal() ||
						board.checkNegativeDiagonal() ||
						board.isTied());
	}
	
	public void reset() {
		board.clearBoard();
		this.player1Turn = false;
	  this.computerMode = false;
	  this.player1 = null;
	  this.player2 = null;
	}
	
	public boolean isTied() {
		return board.isTied();
	}
	
	public IPlayer getWinner() {
		return board.getWinner();
	}

	public boolean getComputerMode() {
		return this.computerMode;
	}
	
	public IPlayer getCurrentPlayer() {
		if (player1Turn) {
			return player1;
		}
		return player2;
	}
	
	public Chip[][] getBoard() {
		return board.getGridCopy();
	}
}