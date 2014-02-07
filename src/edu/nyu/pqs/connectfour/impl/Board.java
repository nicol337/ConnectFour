package edu.nyu.pqs.connectfour.impl;

/**
 * Board class is a wrapper class for 2D array which stores Chips.
 * Error checks moves, state of board, and holds pertinent meta data.
 * Also can return winning mvoes and legal moves if there is a computer
 * opponent.
 * @author nicolelee
 *
 */
public class Board implements ICheckWinning {
	private static Board board = null;
	private Chip[][] grid;
	private int[] topChipPosition;
	private IPlayer player1;
	private IPlayer player2;
	private IPlayer winner;
	private int totalMoves = 0;

	
	private Board() {
		this.grid = new Chip[6][7];
		this.topChipPosition = new int[7];
		for (int i=0; i < topChipPosition.length; i++) {
			this.topChipPosition[i] = 0;
		}
		this.winner = null;
	}
	
	public static Board getInstance() {
		if (board == null) {
			board = new Board();
		}
		return board;
	}
	
	public boolean addChip(IPlayer player, int column) {
		if (isMoveLegal(column)) {
			addChipToColumn(player, column);
			return true;
		}
		return false;
	}
	
	private boolean isFull(int column) {
		return topChipPosition[column] == 6;
	}
	
	private void addChipToColumn(IPlayer player, int column) {
		Chip chip = new Chip(player);
		totalMoves++;
		this.grid[topChipPosition[column]][column] = chip;
		this.topChipPosition[column]++;
		
	}
	
	@Override
	public boolean checkHorizontal() {
		int consecutiveCounter = 0;
		IPlayer samePlayer =  this.player1;
		for (int i=0; i < grid.length; i++) {
			for (int j=0; j < grid[0].length; j++) {
				if (getWinner() == null) {
					if (grid[i][j] != null) {
						if (grid[i][j].getPlayer() == samePlayer) {
							consecutiveCounter++;
							if (consecutiveCounter == 4) {
								setWinner(samePlayer);
								return true;
							}
						}
						else {
							samePlayer = grid[i][j].getPlayer();
							consecutiveCounter = 1;
						}
					}
					else {
						consecutiveCounter = 0;
					}
				}	
			}
			consecutiveCounter = 0;
		}
		return false;
	}

	@Override
	public boolean checkVertical() {
		int consecutiveCounter = 0;
		IPlayer samePlayer =  this.player1;
		for (int j=0; j < grid[0].length; j++) {
			for (int i=0; i < grid.length; i++) {
				if (getWinner() == null) {
					if (grid[i][j] != null) {
						if (grid[i][j].getPlayer() == samePlayer) {
							consecutiveCounter++;
							if (consecutiveCounter == 4) {
								setWinner(samePlayer);
								return true;
							}
						}
						else {
							samePlayer = grid[i][j].getPlayer();
							consecutiveCounter = 1;
						}
					}
					else {
						consecutiveCounter = 0;
					}
				}	
			}
			consecutiveCounter = 0;
		}
		return false;
	}

	@Override
	public boolean checkPositiveDiagonal() {
		int consecutiveCounter = 0;
		IPlayer samePlayer =  this.player1;
		int firstRow = 0;
		int lastRow = 0;
		int firstColumn = 0;
		int lastColumn = 0;
		int numberOfChecks=0;
		
		for (int diagonalDiff=2; diagonalDiff > -4; diagonalDiff--) {
			firstRow = diagonalDiff;
			lastRow = diagonalDiff + 6;
			if (firstRow < 0) {
				firstRow = 0;
			}
			if (lastRow > 5) {
				lastRow = 5;
			}
			firstColumn = 0 - diagonalDiff;
			lastColumn = -1*(diagonalDiff - 5);
			if (firstColumn < 0) {
				firstColumn = 0;
			}
			if (lastColumn > 6) {
				lastColumn = 6;
			}
			numberOfChecks = lastColumn-firstColumn;
			
			int testColumn = firstColumn;
			int testRow = firstRow;
			for (int itr = 0; itr <= numberOfChecks; itr++) {
				if (getWinner() == null) {
					if (grid[testRow][testColumn] != null) {
						if (grid[testRow][testColumn].getPlayer() == samePlayer) {
							consecutiveCounter++;
							if (consecutiveCounter == 4) {
								setWinner(samePlayer);
								return true;
							}
						}
						else {
							samePlayer = grid[testRow][testColumn].getPlayer();
							consecutiveCounter = 1;
						}
					}
					else {
						consecutiveCounter = 0;
					}
				}
				testRow++;
				testColumn++;
			}
			consecutiveCounter = 0;
		}
		return false;
	}

	@Override
	public boolean checkNegativeDiagonal() {
		int consecutiveCounter = 0;
		IPlayer samePlayer =  this.player1;
		int firstRow = 0;
		int lastRow = 0;
		int firstColumn = 0;
		int lastColumn = 0;
		int numberOfChecks=0;
		
		for (int diagonalDiff=3; diagonalDiff <= 8; diagonalDiff++) {
			firstRow = diagonalDiff - 6;
			if (firstRow < 0) {
				firstRow = 0;
			}
			lastRow = diagonalDiff;
			if (lastRow > 5) {
				lastRow = 5;
			}
			firstColumn = diagonalDiff;
			if (firstColumn > 6) {
				firstColumn = 6;
			}
			lastColumn = diagonalDiff - 5;
			if (lastColumn < 0) {
				lastColumn = 0;
			} 
			numberOfChecks = firstColumn - lastColumn;
		
			int testColumn = firstColumn;
			int testRow = firstRow;
			for (int itr = 0; itr <= numberOfChecks; itr++) {
				if (getWinner() == null) {
					if (grid[testRow][testColumn] != null) {
						if (grid[testRow][testColumn].getPlayer() == samePlayer) {
							consecutiveCounter++;
							if (consecutiveCounter == 4) {
								setWinner(samePlayer);
								return true;
							}
						}
						else {
							samePlayer = grid[testRow][testColumn].getPlayer();
							consecutiveCounter = 1;
						}
					}
					else {
						consecutiveCounter = 0;
					}
				}
				testRow++;
				testColumn--;
			}
			consecutiveCounter = 0;
		}
		return false;
	}
	
	public void printBoard() {
		for (int i=grid.length-1; i >= 0; i--) {
			for (int j=0; j < grid[0].length; j++) {
				if (grid[i][j] == null) {
					System.out.print("|"+" "+"|");
				}
				else if (grid[i][j].getPlayer().equals(player2)) {
					System.out.print("|"+'2'+"|");
				}
				else {
					System.out.print("|"+'1'+"|");
				}
			}
			System.out.println();
		}
	}
	
	private void setWinner(IPlayer winner) {
		this.winner = winner;
	}
	
	public void setPlayer1(IPlayer player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(IPlayer player2) {
		this.player2 = player2;
	}
	
	public IPlayer getWinner() {
		return this.winner;
	}
	
	public IPlayer getPlayer1() {
		return this.player1;
	}
	
	public IPlayer getPlayer2() {
		return this.player2;
	}
	
	public boolean isTied() {
		if (isFilled() && (getWinner() == null)) {
			return true;
		}
		return false;
	}
	
	private boolean isFilled() {
		return this.totalMoves == 42;
	}
	
	public void clearBoard() {
		for (int i=0; i < grid.length; i++) {
			for (int j=0; j < grid[0].length; j++) {
				this.grid[i][j] = null;
			}
		}
		for (int i=0; i < topChipPosition.length; i++) {
			this.topChipPosition[i] = 0;
		}
		this.winner = null;
		this.totalMoves = 0;
		
	}
	
	public boolean isMoveLegal(int column) {
		if ((column > grid.length) || (column < 0)) {
			return false;
		}
		else if (isFull(column)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Chip getChip(int row, int column) {
		Chip chip = null;
		if (grid[row][column] != null) {
			chip = grid[row][column];
		}
		return chip;
	}
	
 	public int findWinningMove(IPlayer player) {
		for (int i=0; i < grid[0].length; i++) {
			if (addChip(player, i)) {
				if (checkHorizontal() || 
								checkVertical() || 
								checkPositiveDiagonal() ||
								checkNegativeDiagonal()) {
					removeChip(i);
					return i;
				}
			removeChip(i);
			}
		}
		return -1; 
	}
	
	public int findAnyMove() {
		if (!isFilled()) {
			for (int col=0; col < grid[0].length; col++) {
				if (this.isMoveLegal(col)) {
					return col;
				}
			}
		}
		return -1;
	}
	
	private void removeChip(int column) {
		if (this.topChipPosition[column] > 0) {
			this.grid[topChipPosition[column]-1][column] = null;
			this.topChipPosition[column]--;
			this.totalMoves--;
			this.winner = null;
		}
	}
	
	public Chip[][] getGridCopy() {
		final Chip[][] copy = new Chip[6][7];
		for (int i=0; i < grid.length; i++) {
			for (int j=0; j < grid[0].length; j++) {
				copy[i][j]=grid[i][j];
			}
		}
		return copy;
	}
}
