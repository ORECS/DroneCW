package DroneProjectClasses;

import java.io.Serializable;

public class Drone implements Serializable {
	
	private static final long serialVersionUID = 5803802795565053480L;
	private int x,y, droneid;
	private static int droneCount = 0;
	 Direction dir;
	private int dx = 1, dy =1;
	
	
	public Drone(int bx, int by, Direction dt){
		this.dir = dt;
		x = bx;
		y = by;
		droneid = droneCount++;
		
	 }
	 
		//public Drone(String s) {
		//	this(0,0);
		//	StringSplitter ss = new StringSplitter(s, " ");
		//	setXY(ss.getNthInt(0, 5), ss.getNthInt(1, 8));
	//	}
		
	public int getX(){   //returns position of the drones x position
			return x;
			
		}
		public int getY() { //returns position of the drones y position
			return y;
		}
		public void setXY(int nx, int ny) {
			x = nx;
			y = ny;
		}
		
		public boolean isHere(int sx, int sy) {
			if(x == sx && y == sy) {
				return true;
			}
			return false;
			
		}

		/**
		 * display the drone in the canvas
		 * @param c	the canvas used
		 */
		public void displayDrone(ConsoleCanvas c) {
			//<< call the showIt method in c to put a D where the drone is
			c.showIt(x, y, 'D');
			//c.showIt(4, 3, 'D');
			//c.showIt(4, 2, 'D');
			// how to make it so addDrone adds into the console instead of just these hardcoded ones
		}
		
		
		public void tryToMove(DroneArena da) {
			int newx = x + dx;
			int newy = y + dy;
			while(!da.canMoveHere(newx, newy)) {
			this.dir = dir.next();
			this.setDirection();
			newx = x + dx;
			newy = y + dy;
			}
			x = newx;
			y = newy;
		}
		
		public void setDirection() {
			if(this.dir == Direction.NORTH) {
				dx = 0;
				dy = -1;
			}
			else if(this.dir == Direction.EAST) {
				dx = -1;
			    dy = 0;
			}
			else if(this.dir == Direction.SOUTH) {
				dx = 0;
				dy = 1;
			}
			else if(this.dir == Direction.WEST) {
				dx = 1;
				dy = 0;
			}
		}

	
	
	
	
	public String toString() {
		return "Drone " + droneid + " at " + x + ", " + y + ", "+dir;
	}

	
	
	
	
	
	
	

	public static void main(String[] args) {
		Drone z = new Drone(5,3,Direction.SOUTH);
		System.out.println(z.toString());
		

	}

}
