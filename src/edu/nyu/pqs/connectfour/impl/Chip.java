package edu.nyu.pqs.connectfour.impl;

/**
 * Chip class. To be put into a Board. Identifies with the 
 * owning player of the chip.
 * @author nicolelee
 *
 */
public class Chip {
	IPlayer player;
	//temporary for stdout testing
	
	public Chip(IPlayer player) {
		this.player = player;
	}
	
	public IPlayer getPlayer() {
		return player;
	}

}
