//import javafx.scene.image.Image;

public abstract class Objects {
	
	protected int x,y, objectid;
	protected static int objectCount = 0;
	protected double objectW = 50,objectH = 50;
	
	
	public Objects(int bx, int by){
		
		x = bx;
		y = by;
		objectid = objectCount++;
		
	 }
	public Objects(){
		
		x = this.getX();
		y = this.getY();
		objectid = objectCount++;
		
	 }
	
	
	
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
	public boolean isHere(Objects other) {
		if (x < other.x + other.objectW + 2 && x + objectH + 2 > other.x && y < other.y + objectH + 2 && objectH + y + 2 > other.y)
	        return true;
	    return false;
		//makes sure a drone does not spawn untop of another drone
	}
	
	public boolean isHere(int x, int y) {
		if (x < this.x + this.objectW + 2 && x + objectH + 2 > this.x && y < this.y + objectH + 2 && objectH + y + 2 > this.y)
	        return true;
	    return false;
		// handles collisions between drone and other objects
	}
	
	public int getID() {
		return objectid;
	}
	

}