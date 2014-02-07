package edu.nyu.pqs.connectfour.play;

public class ConnectFourApp {
	
	private void startGame() {
		ConnectFourModel model = new ConnectFourModel();
		new ConnectFourView(model);
		model.fireGameStartEvent();
	}
	
	public static void main(String[] args) {
		new ConnectFourApp().startGame();
	}
}