package edu.nyu.pqs.connectfour.play;

import javax.swing.JPanel;

import edu.nyu.pqs.connectfour.impl.Chip;

public class GridDrawing extends JPanel {

    private static final long serialVersionUID = 1L;  
    public static GridDrawing drawing = null;
    private static GridPicture picture = null;
  
    public static GridDrawing getInstance() {
    	if (drawing == null) {
    		drawing = new GridDrawing();
    	}
    	return drawing;
    }
    
    private GridDrawing() {
        picture = new GridPicture();
        add(picture);
        setVisible(true);
    }
    
    public void setPlayer1(String player1) {
    	picture.setPlayer1(player1);
    }
    
    public GridDrawing update(Chip[][] grid) {
    	picture.update(grid);
    	return this;
    }
}
