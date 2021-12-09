import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Spikes extends Objects {
	
	private Image SpikeImage;
	
	public Spikes(int bx, int by) {
		super(bx, by);
		SpikeImage = new Image(getClass().getResourceAsStream("spike1.png"));
		
	}

	public void displaySpike(GraphicsContext gc) {
		gc.drawImage(SpikeImage, x, y, objectW, objectH);
		
		
	}
	public String toString() {
		return "Spike " + objectid + " at " + x + ", " + y + ", ";
	}
}
