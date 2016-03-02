import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 


public class MYaREA extends Area implements KeyListener, ActionListener
{
	//Initialize the variables and the clock like a smart little boy
	int m = 2;
	int n = 2;
	int row = 8;
	int sandOrGrass;
	private Timer fireClock = new Timer(4000,this);
	//Constructor, this code was given
	public MYaREA() {
		super();
		tiles = new int[numTilesX][numTilesY];
		for (int i = 0; i < numTilesX; i++) {
			for (int j = 0; j < numTilesY; j++) {
			}
		}
		//I like water at the bottom of my screen
		for (int i = 0; i < numTilesX; i++){
			for (int j = 8; j < numTilesY; j++){
				tiles[i][j] = wata;
			}

		}
	}
	//draw the tiles
	protected void drawTiles() {
		tiles[m][n] = charizard; 
		Tile t = null;
		for (int i = 0; i < numTilesX; i++) {
			for (int j = 0; j < numTilesY; j++) {
				switch (tiles[i][j]){
					case grass:
						t = new Grass();
						break;
					case stone:
						t = new Stones();
						break;
					case fire:
						t = new Fireeeee();
						break;
					case wata:
						t = new Water();
						break;
					case lava:
						t = new Lava();
						break;
					case charizard:
						
						//the weird stuff is 
						//so that charizard's background
						//matches the background
						
						if (j > 7){
							drawTile(new Water(), i, j);
						}
						else if (sandOrGrass == 1){
							drawTile(new FireGrass(), i, j);
						}
						else if (sandOrGrass > 1) {
							drawTile(new Glass(), i, j);
						}
						else {
							drawTile(new Grass(), i, j);
						}
						
						t = new Charizard();
						break;
					case fireGrass:
						t = new FireGrass();
						break;
					case glass:
						t = new Glass();
						break;
				}
				drawTile(t, i, j);

			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e)
	{
		//MOVE CHARIZARD
		// TODO Auto-generated method stub
		int arrow = e.getKeyCode();
		drawTile(new Charizard(), m, n);
		if (arrow == 39){
			//match the backgrounds
			if (n > 7){
				tiles[m][n] = wata;
			}
			else if (sandOrGrass == 0){
				tiles[m][n] = grass;
			}
			else if (sandOrGrass == 1){
				tiles[m][n] = fireGrass;
			}
			else {
				tiles[m][n] = glass;
			}
			//drawTile(new Grass(), m, n);
			m = m+1;
			tiles[m][n] = charizard;
			//drawTile(new Charizard(), m, n);
		}
		else if (arrow == 37) {
			if (n > 7){
				tiles[m][n] = wata;
			}
			else if (sandOrGrass == 0){
				tiles[m][n] = grass;
			}
			else if (sandOrGrass == 1){
				tiles[m][n] = fireGrass;
			}
			else {
				tiles[m][n] = glass;
			}
			m--;
			tiles[m][n] = charizard;
		}
		else if (arrow == 38){
			if (n > 7){
				tiles[m][n] = wata;
			}
			else if (sandOrGrass == 0){
				tiles[m][n] = grass;
			}
			else if (sandOrGrass == 1){
				tiles[m][n] = fireGrass;
			}
			else {
				tiles[m][n] = glass;
			}
			n--;
			tiles[m][n] = charizard;
		}
		else if (arrow == 40){
			if (n > 7){
				tiles[m][n] = wata;
			}
			else if (sandOrGrass == 0){
				tiles[m][n] = grass;
			}
			else if (sandOrGrass == 1){
				tiles[m][n] = fireGrass;
			}
			else {
				tiles[m][n] = glass;
			}
			n++;
			tiles[m][n] = charizard;
		}
		else if (arrow == 32){
			//CHARIZARD USE FLAMETHROWER!!!
			//only on everything around you though
			sandOrGrass++;
			for (int y = 0; y <= 7; y++){
				for (int c = 0; c <= 9; c++){
					tiles[c][y] = lava;
				}
			}
			repaint();
			fireClock.start();

		}

		repaint();

	}


	@Override
	public void keyReleased(KeyEvent e)
	{

		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ee)
	{
		// TODO Auto-generated method stub
		//CHARIZARD BURN THE GRASS TO BURNT GRASS
		//BURNT GRASS IS SAND
		//BURNT SAND IS GLASS
		if (ee.getSource() == fireClock){
			if (sandOrGrass == 1){
				for (int y = 0; y <= 7; y++){
					for (int c = 0; c <= 9; c++){
						tiles[c][y] = fireGrass;
					}
				}
				repaint();
			}
			else {
				for (int y = 0; y <= 7; y++){
					for (int c = 0; c <= 9; c++){
						tiles[c][y] = glass;
					}

				}
				repaint();

			}
		}
	}
}
