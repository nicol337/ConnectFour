package edu.nyu.pqs.connectfour.play;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import edu.nyu.pqs.connectfour.impl.Chip;

class GridPicture extends JComponent {
	
  private static final long serialVersionUID = 1L;
  private Chip[][] grid = new Chip[6][7];
  private static int xPix = 50;
  private static int yPix = 50;
  private Color player1Color = Color.red;
  private Color player2Color = Color.white;
  private Color backgroundColor = Color.gray;
  private String player1;
  
  public GridPicture update(Chip[][] grid){
  	for (int i=0; i < grid.length; i++) {
			for (int j=0; j < grid[0].length; j++) {
				this.grid[i][j] = grid[i][j];
			}
		}
  	repaint();
  	return this;
  }
  
  public GridPicture getGridPicture() {
  	return this;
  }
  
  public void setPlayer1(String player1) {
  	this.player1 = player1;
  }
  
  @Override
  public Dimension getMinimumSize() {
      return new Dimension(600, 400);
  }

  @Override
  public Dimension getPreferredSize() {
      return new Dimension(430,400);
  }

  @Override
  public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D)g;
      super.paintComponent(g);
      g.setColor(Color.blue);
      
      for (int i=0; i < this.grid.length; i++) {
  			for (int j=0; j < this.grid[0].length; j++) {
  				g.setColor(backgroundColor);
					g.fillRect(50 + j*xPix, 250 -i*yPix, xPix, yPix);
          g.setColor(Color.white);
          g.drawRect(50 + j*xPix, 250 - i*yPix, xPix, yPix);
          
          
  				if (!(grid[i][j] == null)) {
    				if (grid[i][j].getPlayer().getName().equals(this.player1)) {
    					g.setColor(player1Color);
              Ellipse2D.Double circle = new 
              				Ellipse2D.Double(52 + j*xPix, 252 - i*yPix, xPix-4, yPix-4);
              g2d.fill(circle);
    				}
    				else {
    					g.setColor(player2Color);
              Ellipse2D.Double circle = new 
              				Ellipse2D.Double(52 + j*xPix, 252- i*yPix, xPix-4, yPix-4);
              g2d.fill(circle);
    				}
  				}
  			}
  		}
  }
}