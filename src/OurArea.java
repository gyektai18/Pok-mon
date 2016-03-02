public class OurArea extends Area {
  
  /*
  // The trees that are scattered around the area.
  Tree trees[];
  
  // The area tile map, with each tile represented as an integer.
  int tiles[][];
  
  // The tile values for grass (0) and stone (1) tiles.
  int grass;
  int stone;
  
  // The number of tiles on the x-axis, and y-axis.
  int numTilesX;
  int numTilesY;
  
  // The maximum position of a tree on the x-axis and y-axis.
  // Note: The minimum is simply (0, 0).
  double maxTreeX;
  double maxTreeY;
  */
	
  
  // The constructor for OurArea. It takes in a parameter for the
  // number of trees to place in the area.
  public OurArea(int numberOfTrees) {
    super(); // A magic function. I wonder what it does? 
    
    //* Exercise #1. Setup the tree objects at random locations.
    trees = new Tree[numberOfTrees];
    for (int i = 0; i < numberOfTrees; i++) {
      trees[i] = new Tree((int)(Math.random() * maxTreeX),
                          (int)(Math.random() * maxTreeY));
    }
    //*/
    
    //* Exercise #3. Initialize the tiles.
    tiles = new int[numTilesX][numTilesY];
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {
        // Example: Default to grass everywhere.
        tiles[i][j] = grass;
        
      }
    }
    
    // Example: Draw two stones at specific locations.
    tiles[0][0] = stone;
    tiles[2][3] = stone;
    //*/
  }
  
  // This function must draw each tree to the screen.
  protected void drawTrees() {
    //* Exercise #2. Draw the trees.
    for (int i = 0; i < trees.length; i++) {
      drawTree(i);
    }
    //*/
  }
  
  protected void drawTiles() {
    //* Exercise #4. Draw the tiles.
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {
    	//when a tile is set to grass draw grass 
        //otherwise draw a stone
        if (tiles[i][j] == grass) {
        	Grass g = new Grass();
        	drawTile(g, i, j);
        } else if (tiles[i][j] == stone){
        	Stones s = new Stones();
        	drawTile(s, i, j);
        } else if (tiles[i][j] == fire) {
        	Fireeeee f = new Fireeeee();
        	drawTile(f, i, j);
        }
      }
    }
    //*/
  }
  
}
