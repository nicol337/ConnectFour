package edu.nyu.pqs.connectfour.impl;

public interface IPlayer {
	
	public String getName();
	
	public boolean equals(Object obj);
	
	public int getMove(Board board);
}
