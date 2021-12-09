

import java.awt.Color;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
private int canvasSize = 512; 						
private DroneArena DArena;
private Canvas canvas;
private GraphicsContext gc;
//private Drone drone;
private AnimationTimer timer;
//private boolean AnimationON = false;
private VBox rtPane;


public void  save() {
	
	
	
  	 try {
           // Find file
           File file = new File("C:\\Users\\sonic\\eclipse-workspace\\DroneProjectGUI\\bin\\save1.txt");

           // Check if file exists, if not, create one
           if (!file.exists()) {
               file.createNewFile();
           }

           // FOS to write to the file
           FileOutputStream fos = new FileOutputStream(file);
           // OOS to write the object
           ObjectOutputStream ous = new ObjectOutputStream(fos);

           
           
           // Write object to file
           ous.writeObject(DArena.toString());

           // Close the streams
           ous.close();
           fos.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
}


private void showMessage(String TStr, String CStr) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(TStr);
    alert.setHeaderText(null);
    alert.setContentText(CStr);

    alert.showAndWait();
}


 private void showAbout() {
	 showMessage("About", "Ore's Drone Simulation" + "\n" + "Press AddDrone to add drones within the arena" + "\n"+ "Start will make the drones move"
	+ "\n" + "Stop will make the drones stop moving" + "\n" + "Have fun!!!!!!");
 }

MenuBar SetMenu() {
	MenuBar menubar = new MenuBar(); // create a menubar
	
	Menu file = new Menu("File"); // one of the menus is called file
	
	MenuItem exit = new MenuItem("Exit");
	exit.setOnAction(new EventHandler<ActionEvent>() { // when user clicks exit, calls handle to close 

		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
			
		}
		
		
	});
	MenuItem save = new MenuItem("Save");
	save.setOnAction(new EventHandler<ActionEvent>() { // when user clicks exit, calls handle to close 

		@Override
		public void handle(ActionEvent arg0) {
			save();
			System.out.print("saved!");
			
		}
		
		
	});
	
	MenuItem load = new MenuItem("load");
	load.setOnAction(new EventHandler<ActionEvent>() { // when user clicks exit, calls handle to close 

		@Override
		public void handle(ActionEvent arg0) {
			
			System.out.print("loaded!");
			
		}
		
		
	});
	
	Menu help = new Menu("Help"); // menu to display "about"
	MenuItem about = new MenuItem("About");
	about.setOnAction(new EventHandler<ActionEvent>(){
		
		@Override
		public void handle(ActionEvent arg0) {
			showAbout();
			
		}
	});
	file.getItems().add(load);
	file.getItems().add(save);
	file.getItems().add(exit);
	help.getItems().add(about);
	menubar.getMenus().addAll(file, help);
	
	return menubar;
	
	}
private HBox setButtons() {
	// create button
	//drone = new Drone();
Button addDrone = new Button("Add Drone");
addDrone.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		// button should add a drone onto the stage
		DArena.AddDrone();
		DArena.showDrones(gc);
		System.out.print("button clicked");
		
	}
});
Button addSpike = new Button("Add Spike");
addSpike.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		// button should add a spike
		DArena.AddSpike();
		DArena.showSpike(gc);
		System.out.print("button clicked for spike");
		
	}
});
Button addShyDrone = new Button("Add Shy Drone");
addShyDrone.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		// button should add a spike
		DArena.AddShyDrone();
		DArena.showShyDrone(gc);
		System.out.print("button clicked for shyDrone");
		
	}
});
  Button start = new Button("Start");
  start.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
								
					
			
			timer.start();
			
		}
	});
 
   Button stop  = new Button("Stop");
   stop.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
				timer.stop();
		}
		
	}); 
   
   
return new HBox(addDrone,addSpike,addShyDrone,start, stop);
}

public void infoPanel() {
	// clear rtPane
	rtPane.getChildren().clear();
	
	Label l = new Label(DArena.toString());
	// add label to rtPane
	l.setTextFill(javafx.scene.paint.Color.RED);
	rtPane.getChildren().add(l);
}





@Override
public void start(Stage stagePrimary) throws Exception {
	DArena = new DroneArena(canvasSize,canvasSize);
	//drone = new Drone();
	Image imag = new Image("C:\\Users\\sonic\\eclipse-workspace\\DroneProjectGUI\\bin\\warzone2clear.png");
    BackgroundImage bImg = new BackgroundImage(imag, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                                               BackgroundSize.DEFAULT);
	stagePrimary.setTitle("Ore's DroneSimulation");
	
	BorderPane bp = new BorderPane();
    Group root = new Group();					// for group of what is shown
    
    bp.setTop(SetMenu());
 
     canvas = new Canvas(canvasSize, canvasSize );
     gc = canvas.getGraphicsContext2D();
    							// create canvas onto which animation shown
    root.getChildren().add( canvas );			// add to root and hence stage
 
    bp.setCenter(root);							// put group in centre pane
   //mc = new MyCanvas(canvas.getGraphicsContext2D(), canvasSize, canvasSize);
    								// create MyCanvas passing context on canvas onto which images put
   timer =  new AnimationTimer()			// create timer
			{
				public void handle(long currentNanoTime) {
					//if(AnimationON = true)
					gc.clearRect(0, 0, canvasSize, canvasSize);
						
						DArena.moveAllDrones();
						DArena.showDrones(gc);
						DArena.showSpike(gc);
						DArena.showShyDrone(gc);
						infoPanel();
								
					
				}
			};
   bp.setBottom(setButtons());
   rtPane = new VBox();						// set vBox for listing data
   bp.setRight(rtPane);
   
    Scene scene = new Scene(bp, canvasSize*1.5, canvasSize*1.2 );		// put it in a scene
    Background bGround = new Background(bImg);
     
    bp.setBackground(bGround);
 
    stagePrimary.setScene( scene );	
    
  
	
    stagePrimary.show();
}	
	
public static void main(String[] args) {
	Application.launch(args);			// launch the GUI
}

}
