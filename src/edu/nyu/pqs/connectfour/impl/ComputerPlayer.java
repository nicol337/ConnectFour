package edu.nyu.pqs.connectfour.impl;

/**
 * ComputerPlayer class. Can optionally be named. Automatically gets moves
 * that the board determines and passes back. If there is a winning move 
 * it is executed, if not any legal move is executed.
 * @author nicolelee
 *
 */
public class ComputerPlayer implements IPlayer{
	String name;
	
	public static class Builder {
		private String name;
		
		public Builder() {
		}
		
 		public Builder name(String name) {
 			this.name = name;
			return this;
		}

		public ComputerPlayer build() {
			return new ComputerPlayer(this);
		}
	}
	
	private ComputerPlayer(Builder builder) {
		this.name = builder.name;
		if (this.name == null){
			this.name = "Computer";
		}
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getMove(Board board) {
		int move = board.findWinningMove(this);
		return (move != -1) ? move : board.findAnyMove();
	}
}
