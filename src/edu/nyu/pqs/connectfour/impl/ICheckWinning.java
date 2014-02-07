package edu.nyu.pqs.connectfour.impl;

public interface ICheckWinning {

	boolean checkHorizontal();
	
  boolean checkVertical();
	
	boolean checkPositiveDiagonal();
	
	boolean checkNegativeDiagonal();
		
}
