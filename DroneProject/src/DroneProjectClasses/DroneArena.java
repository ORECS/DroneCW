package DroneProjectClasses;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class DroneArena implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7154162404359525559L;
	private int Xmax, Ymax;
	private ArrayList<Drone> d;
	public Random randomGenerator;

	public DroneArena(int ax, int ay) {
		Xmax = ax;
		Ymax = ay;
		d = new ArrayList<Drone>();
		randomGenerator = new Random();
		AddDrone();
	}

	public void AddDrone() {
		// int a = Xmax / 2;
		// int b = Ymax / 2;
		// d = new Drone(a, b);
		//int val1 = randomGenerator.nextInt(Xmax);
		//int val2 = randomGenerator.nextInt(Ymax);
		//d.add(new Drone(val1, val2));
		Drone newDrone = new Drone(1+randomGenerator.nextInt(Xmax-2), 1+randomGenerator.nextInt(Ymax-2), Direction.ranDir());
		while (getDroneAt(newDrone.getX(), newDrone.getY()) != null) {
			newDrone.setXY(randomGenerator.nextInt(Xmax), randomGenerator.nextInt(Ymax));

		}

		d.add(newDrone);

	}

	public String toString() {
		String ret = "";
		for (int ct = 0; ct < d.size(); ct++) {
			ret += d.get(ct).toString() + "\n";
		}
		return "Arena size " + Xmax + " by " + Ymax + " with " + ret;
	}

	public Drone getDroneAt(int x, int y) {
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isHere(x, y)) {
				return d.get(i);
			}
		}

		return null;

	}
	
	/**
	 * show all the drones in the interface
	 * @param c	the canvas in which drones are shown
	 */
	public void showDrones(ConsoleCanvas c) {
		//<< loop through all the Drones calling the displayDrone method >>
		for(int i =0; i< d.size();i++) {
			d.get(i).displayDrone(c);
		}
	}
	public int getXsize(){   // x size of arena
		return Xmax;
		
	}
	public int getYsize() {  // y size of arena
		return Ymax;
	}
	
	
	public void moveAllDrones() {
		for(int i = 0; i<d.size(); i++) {
			d.get(i).tryToMove(this);
		}
		
	}
	
	
	public boolean canMoveHere(int xa, int ya) {
		if(getDroneAt(xa,ya)!= null){
			return false;
		}
		if(xa < 1 || xa >= Xmax-1) {return false;}  // checks if drone has hit the walls
		if(ya < 1 || ya>= Ymax-1) {return false;} 
		return true;
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {

		DroneArena da = new DroneArena(20, 12);
		da.AddDrone();
		da.AddDrone();
		System.out.println(da.toString());

	}

}
