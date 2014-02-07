package edu.nyu.pqs.connectfour.play;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nyu.pqs.connectfour.impl.Chip;
import edu.nyu.pqs.connectfour.impl.IPlayer;

/**
 * The view of the MVC of ConnectFour. It carries out visual communication
 * of the underlying game being played by ConnectFourModel. It also sends messages
 * for events to be executed and acted on by ConnectFourModel
 * @author nicolelee
 *
 */
public class ConnectFourView implements IConnectFourListener {
	public JButton[] column_buttons;
	private JPanel statusPanel; 
	private JTextField status;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JTextField player;
	private GridDrawing boardDisplay;
	
	 JFrame frame;
	 JPanel panel;
	
	private ConnectFourModel model;

	public ConnectFourView(ConnectFourModel model) {
		this.model = model;
		model.register(this);
		
		JFrame frame = new JFrame("Connect Four");
		
		this.panel = new JPanel(); {
			this.panel.setLayout(new BorderLayout());
		}
		
	  this.statusPanel = new JPanel(); {
	  	this.statusPanel.setLayout(new BorderLayout());
	  	this.status = new JTextField("(Statuses will appear here)                ");
	  	this.statusPanel.add(status, BorderLayout.CENTER);
		}
		
	  this.topPanel = new JPanel(); {

			JButton[] column_buttons = { new JButton("column 1"),
							new JButton("column 2"), new JButton("column 3"),
							new JButton("column 4"), new JButton("column 5"),
							new JButton("column 6"), new JButton("column 7")};
			for (int i=0; i < column_buttons.length; i++) {
				this.topPanel.add(column_buttons[i]);
	    }
	
			column_buttons[0].addActionListener(new ActionListener() {
    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column1_pressed();
				}
			});
	    column_buttons[1].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column2_pressed();
				}
			});
	    column_buttons[2].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column3_pressed();
				}
			});
	    column_buttons[3].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column4_pressed();
				}
			});
	    column_buttons[4].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column5_pressed();
				}
			});
	    column_buttons[5].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column6_pressed();
				}
			});
	    column_buttons[6].addActionListener(new ActionListener() {
	    	@Override
				public void actionPerformed(ActionEvent event) {
					button_column7_pressed();
				}
			});	
		}
	  
//	  GridDrawing gridDrawing = GridDrawing.getInstance();
//	  
//	  this.boardDisplay = gridDrawing.update(new Chip[6][7]);
	  
	  this.boardDisplay = GridDrawing.getInstance();
	  
	  this.boardDisplay.update(new Chip[6][7]);
			
		this.bottomPanel = new JPanel(); {
			this.player = new JTextField("Player's Name");
			bottomPanel.add(this.player, BorderLayout.CENTER);
			this.bottomPanel.add(status, BorderLayout.CENTER);
		}
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(statusPanel);
		panel.add(topPanel);
		panel.add(bottomPanel);
		panel.add(boardDisplay, BorderLayout.NORTH);
	
		frame.getContentPane().add(panel);
		frame.setSize(800, 600);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void button_column1_pressed() {
		model.turn(0);
	}
	
	private void button_column2_pressed() {
		model.turn(1);
	}
	
	private void button_column3_pressed() {
		model.turn(2);
	}
	
	private void button_column4_pressed() {
		model.turn(3);
	}
	
	private void button_column5_pressed() {
		model.turn(4);
	}	
	
	private void button_column6_pressed() {
		model.turn(5);
	}
	
	private void button_column7_pressed() {
		model.turn(6);
	}
	
	@Override
	public void gameStart() {
		gameSetUp();
		model.setUpTurn();
	}
	
	@Override
	public void gameEnd(String endStatus) {
		JOptionPane.showConfirmDialog(null, "Game Over. " + endStatus, "Request", 
				    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	@Override
	public void gameSetUp() {
		if (JOptionPane.showConfirmDialog(null, "Would you like to verse the Computer Opponent?", "Request", 
				    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				    == JOptionPane.YES_OPTION)
		{
		 String player1name = JOptionPane.showInputDialog("Please enter player 1's name ");
		 model.initializeGame(true, player1name, "Computer");
		 this.boardDisplay.setPlayer1(player1name);
		}
		else
		{
			String player1name = JOptionPane.showInputDialog("Please enter player 1's name ");
			String player2name = JOptionPane.showInputDialog("Please enter player 2's name ");
			model.initializeGame(false, player1name, player2name);
			this.boardDisplay.setPlayer1(player1name);
		}
	}

	@Override
	public void updateActivePlayer(IPlayer activePlayer) {
		this.player.setText(activePlayer.getName());
	}

	@Override
	public void updateStatus(String statusMsg) {
		this.status.setText(statusMsg);
	}
	
	public void updateBoard(Chip[][] copy) {
		this.boardDisplay.update(copy);
	}
	
	public void updateBoardGraphic() {
		
	}
}

