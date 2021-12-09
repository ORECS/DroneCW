import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ShyDrone extends Drone {
	private Image SDroneImage;

	
	ShyDrone(int sx,int sy, Direction dt){
		super(sx,sy,dt);
		
		SDroneImage = new Image(getClass().getResourceAsStream("shydrone1.png"));
	}


public void displayShyDrone(GraphicsContext gc) {

	
	gc.drawImage(SDroneImage, x, y, objectW, objectH);
	
	
}


public String toString() {
	return "Shy Drone " + objectid + " at " + x + ", " + y + ", "+dir;
}

}