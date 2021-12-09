



import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Drone extends Objects {
	
	
	
	protected Direction dir = Direction.NORTH;
	private int dx = 1, dy =1;
	private int count = 0;
	private Image DroneImage;
	
	
	public Drone(int bx, int by, Direction dt){
		super(bx,by);
		this.dir = dt;
		DroneImage = new Image(getClass().getResourceAsStream("drone.png"));
		
	 }
	public Drone(){
		super();
		
		
	 }

		
		public void displayDrone(GraphicsContext gc) {
			//gc.setFill(Color.BLACK);
			
			//gc.fillRect(x, y, DroneW, DroneH);
			//gc.fillRect(x, y, DroneW, DroneH);
			
			gc.drawImage(DroneImage, x, y, objectW, objectH);
			
			//draws image into the gc
		}
		 
		
		public void tryToMove(DroneArena da) {
			int newx = x + dx;   // increments position of drone
			int newy = y + dy;
			while(da.canMoveHere(newx, newy, objectid)!= true) { //checks if drone can move to a location
			count++;
			this.dir = Direction.ranDir();
			this.setDirection(); // sets a new direction if it cant move
			newx = x + dx;
			newy = y + dy;
			//System.out.print("changed direction!");
			if(count>1000) { // count to know when to destroy the drone
				//System.out.print("crashed!!!");
				da.removeDrone(objectid);
				count = 0;
				System.out.print("removed");
			}
			}
			//System.out.print("not in while loop");
			x = newx;
			y = newy;
		}
		
		
		public void setDirection() {
			if(this.dir == Direction.NORTH) {
				dx = 0;
				dy = 1;
			}
			else if(this.dir == Direction.NORTHE) {
				dx = 2;
			    dy = 2;
			}
			else if(this.dir == Direction.EAST) {
				dx = 1;
			    dy = 0;
			}
			else if(this.dir == Direction.SOUTHE) {
				dx = 2;
			    dy = -2;
			}
			else if(this.dir == Direction.SOUTH) {
				dx = 0;
				dy = -1;
			}
			else if(this.dir == Direction.SOUTHW) {
				dx = -2;
			    dy = -2;
			}
			else if(this.dir == Direction.WEST) {
				dx = -1;
				dy = 0;
			}
			else if(this.dir == Direction.NORTHW) {
				dx = -2;
			    dy = 2;
			} // different ways the drone can move, movement control
		}
	/*	
		public int getID() {
			return droneid;
		}
*/
	
	
	
	
	public String toString() {
		return "Drone " + objectid + " at " + x + ", " + y + ", "+dir;
	}

	
	
	
	
	
	
	

	public static void main(String[] args) {
		Drone z = new Drone(5,3,Direction.SOUTH);
		System.out.println(z.toString());
		

	}

}

