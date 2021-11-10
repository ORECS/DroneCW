package DroneProjectClasses;



public class ConsoleCanvas {

	private int xSize, ySize;
	private  char [][] Arena;
	
	ConsoleCanvas(int cx, int cy){
		xSize = cx;	    
		ySize = cy;
	   this.Arena = new char[xSize][ySize]; // the 2d array will have a size xsize and ysize
	   for(int i = 0; i<Arena.length;i++) {
		   for(int j = 0; j<Arena[i].length;j++) {
			   if (i == 0 || i==(Arena.length-1) || j == 0 || j== Arena[i].length-1) {  
		            Arena[i][j] = '#';}
		       // else if (j == 0 || i==(Arena[i].length-1)) { // Sets bottom and top rows to #
		         // Arena[i][j] = '#';}
		        else {
		            Arena[i][j] = ' ';}
			   //System.out.print(Arena[i][j]);
			   }
		   //System.out.print("\n");
		   }
		   
	   }

	   public String toString() {
		   
		   String ret = "";
		   for(int i = 0; i< ySize ;i++) {
			   for(int j =0; j<xSize; j++) {
				   ret += Arena[j][i]; //reverses the array
				    
				   
			   }
			  ret += "\n";
		   }
		   return ret;
		   
	   }
		   
		   
	   public void showIt(int x1, int y2, char z) {
		  		   Arena[x1][y2] = z;
		  		  
		  		   
	   }
	    
	  
	    
	
	
	
	
	

	public static void main(String[] args) {
		ConsoleCanvas c = new ConsoleCanvas (22, 8);	// create a canvas
		c.showIt(4,4,'D');								// add a Drone at 4,3
		c.showIt(9,6,'D');
		System.out.println(c.toString());				// display result
	}
	}

