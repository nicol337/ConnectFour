package edu.nyu.pqs.connectfour.play;

import edu.nyu.pqs.connectfour.impl.Chip;
import edu.nyu.pqs.connectfour.impl.IPlayer;

public interface IConnectFourListener {

void gameStart();

void gameSetUp();

void updateActivePlayer(IPlayer player);

void updateStatus(String status);

void updateBoard(Chip[][] copy);

void gameEnd(String endStatus);

}