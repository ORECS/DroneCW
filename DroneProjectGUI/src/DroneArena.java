

import java.util.ArrayList;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//import javafx.scene.image.Image;

import java.io.Serializable;

public class DroneArena   {
	/**
	 * 
	 */
	
	private int Xmax, Ymax;
	private ArrayList<Drone> d;
	private ArrayList<Spikes> s;
	private ArrayList<ShyDrone> sd;
	
	
	
	private Random randomGenerator;
	//private Image D;
    //private int canvasSize = 512;


	public DroneArena(int ax, int ay) {
		
		Xmax = ax;
		Ymax = ay;
		d = new ArrayList<Drone>();
		s = new ArrayList<Spikes>();
		sd = new ArrayList<ShyDrone>();
		
		randomGenerator = new Random();
		AddDrone();
		AddSpike();
		AddShyDrone();
	}

	public void AddDrone() {
		// int a = Xmax / 2;
		// int b = Ymax / 2;
		// d = new Drone(a, b);
		//int val1 = randomGenerator.nextInt(Xmax);
		//int val2 = randomGenerator.nextInt(Ymax);
		//d.add(new Drone(val1, val2));
		Drone newDrone = new Drone(1+randomGenerator.nextInt(Xmax-51), 1+randomGenerator.nextInt(Ymax-51), Direction.ranDir());
		for(int i = 0; i < d.size();i++) {
			if(newDrone.isHere(d.get(i))) {
			newDrone.setXY(randomGenerator.nextInt(Xmax-51), randomGenerator.nextInt(Ymax-51));
			i = 0;
			}
		}
		// generates a random position for the drone and checks to see if any objects are there before adding it to array list
		d.add(newDrone); // add to array list

	}
	
	public void AddSpike() {
		
		Spikes newSpikes = new Spikes(1+randomGenerator.nextInt(Xmax-51), 1+randomGenerator.nextInt(Ymax-51));
		for(int i = 0; i < s.size();i++) {
			if(newSpikes.isHere(s.get(i)) ) {
			newSpikes.setXY(randomGenerator.nextInt(Xmax-51), randomGenerator.nextInt(Ymax-51));
			i = 0;
			}
		}
// generates a random position for the spike and checks to see if any objects are there before adding it to array list
		s.add(newSpikes); // add to array list

	}
public void AddShyDrone() {
		
		ShyDrone newShyDrone = new ShyDrone(1+randomGenerator.nextInt(Xmax-51), 1+randomGenerator.nextInt(Ymax-51),Direction.ranDir());
		for(int i = 0; i < sd.size();i++) {
			if(newShyDrone.isHere(sd.get(i)) ) {
				newShyDrone.setXY(randomGenerator.nextInt(Xmax-51), randomGenerator.nextInt(Ymax-51));
			i = 0;
			}
		}
// generates a random position for the spike and checks to see if any objects are there before adding it to array list
		sd.add(newShyDrone); // add to array list

	}
	


	public String toString() {
		String ret = "";
		String rettwo = "";
		String retthree = "";
		for (int ct = 0; ct < d.size(); ct++) {
			ret += d.get(ct).toString() + "\n";
		}
		for (int cx = 0; cx < s.size(); cx++) {
			ret += s.get(cx).toString() + "\n";
		}
		for (int cn = 0; cn < sd.size(); cn++) {
			ret += sd.get(cn).toString() + "\n";
		}
		return "Arena size " + Xmax + " by " + Ymax + " with "+ "\n" + ret + "\n" + rettwo + "\n" + retthree;
	}
// returns information about the drone arena and the objects within it
	
	/**
	 * show all the drones in the interface
	 * @param c	the canvas in which drones are shown
	 */
	public void showDrones(GraphicsContext gc) {
		//<< loop through all the Drones calling the displayDrone method >>

		for(int i =0; i< d.size();i++) {
			d.get(i).displayDrone(gc);
	}
		}
	public void showSpike(GraphicsContext gc) {
		//<< loop through all the Drones calling the displayDrone method >>

		for(int i =0; i< s.size();i++) {
			s.get(i).displaySpike(gc);
	}
		}
	public void showShyDrone(GraphicsContext gc) {
		//<< loop through all the Drones calling the displayDrone method >>

		for(int i =0; i< sd.size();i++) {
			sd.get(i).displayShyDrone(gc);
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
		// gets that particular drone and calls the tries to move method which tries to move the drone
			// done for all drones in the array
			
		}
		
	}
	

	
	
	
	public boolean canMoveHere(int xa, int ya, int id) {
		
		for(Drone drone : d) {
			if(id!= drone.getID()) {
			if(drone.isHere(xa, ya)) {
				return false;}
			// for all drones, checks if the drone is its on id, if not, checks if there is a drone near by and returns false if so
		}
			}
		
	
		
		
		if(xa < 1 || xa >= Xmax-50) {return false;}  // checks if drone has hit the walls
		if(ya < 1 || ya>= Ymax-50) {return false;}  // in its horizontal and vertical direction
		return true;
	}
	
	public void removeDrone(int id) {
		

			d.remove(id); // removes drone from array list when called
			
			
		
	}
	
}
	
	
	
	

	/*public static void main(String[] args) {

		DroneArena da = new DroneArena(20, 12);
		da.AddDrone();
		da.AddDrone();
		System.out.println(da.toString());

	} 
}
	

	
	/*public void start(String[] arg0) throws Exception {
		Application.launch(arg0);
		
	}
}
*/

	
	
