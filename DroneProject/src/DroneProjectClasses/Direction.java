package DroneProjectClasses;
import java.util.Random;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	
	//public static void main(String[] args) {
		//Direction dir = Direction.EAST;
		//dir = dir.ranDir();
		//System.out.println(dir);
		//Direction n = Direction.NORTH;
		//n = n.next();
		//System.out.println(n);
		//for(int i = 0; i < 10; i++) {
			//System.out.println(Direction.ranDir());
		//}

		
		//}
	
	
	
	
	
	public static Direction ranDir() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
 		 
		
	}
	
	public  Direction next() {
		
		return values()[(ordinal() + 1) % values().length];
	}
	
	
}

