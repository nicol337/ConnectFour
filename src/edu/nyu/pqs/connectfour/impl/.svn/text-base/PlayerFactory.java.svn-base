package edu.nyu.pqs.connectfour.impl;

/**
 * PlayerFactory class. Singleton factory that generates different types of players.
 * 
 * @author nicolelee
 *
 */
public class PlayerFactory {
	private static PlayerFactory INSTANCE = null;
	
	
	private PlayerFactory() {
	}
	
	public static PlayerFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlayerFactory();
		}
		return INSTANCE;
	}
	
	public IPlayer getNewHumanPlayer(String name)  throws IllegalArgumentException {
		if ((name == null) || (name.equals(""))) {
			throw new IllegalArgumentException();
		}
		HumanPlayer newPlayer = new HumanPlayer(name);
		return newPlayer;
	}
	
	public IPlayer getNewComputerPlayer(String name) {
		
		ComputerPlayer computerPlayer = 
						new ComputerPlayer.Builder().name(name).build();
		
		return computerPlayer;
	}
	
}
