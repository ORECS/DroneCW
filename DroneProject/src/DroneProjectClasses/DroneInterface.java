package DroneProjectClasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class DroneInterface  {
	
	
	
	private Scanner s;								// scanner used for input from user
	   private DroneArena myArena;	              // arena in which drones are shown
	   private int width;
	   private int height;
	    /**
	    	 * constructor for DroneInterface
	    	 * sets up scanner used for input and the arena
	    	 * then has main loop allowing user to enter commands
	     */
	    public DroneInterface() {
	    	 s = new Scanner(System.in);    // set up scanner for user input
	    	 char cha = ' ';
	     while(cha != 'n' || cha!= 'N') {
	    	 
	    		 System.out.println("Load(L)");
	    		 System.out.println("New(n)");
	    		 cha = s.next().charAt(0);
	    		 s.nextLine();
	    		 switch(cha) {
	    		 
	    		 case 'l':
	    		 case 'L':
	    			 load();
	    			 
	    			 break;
	    		
	    			 // might have to get rid of this while loop and think of sometehing else
	    		 }
	     }
	    	 
	    		 System.out.print("Enter the width of the arena!");
	    		 width = s.nextInt();
	    		 System.out.println("Enter the height of the arena!");
	    		 height = s.nextInt();
	    		 myArena = new DroneArena(width, height);	// create arena of size 20*6
	    		 
	    	
	        char ch = ' ';
	        do {
	        	System.out.print("Enter (A)dd drone, get (I)nformation, (D)isplay Drone, (M)ove Drone, Move (t)en times or e(X)it > ");
	        	ch = s.next().charAt(0);
	        	s.nextLine();
	        	switch (ch) {
	    				case 'A' :
	    				case 'a' :
	        			myArena.AddDrone();	// add a new drone to arena
	        			break;
	        		case 'I' :
	        		case 'i' :
	        		System.out.print(myArena.toString());
	            	    break;
	        		case 'x' : 	ch = 'X';				// when X detected program ends
	        		break;
	        		case 'd':
	        		case 'D':
	        			doDisplay();
	        			break;
	        		case 'm':
	        		case 'M':
	        			myArena.moveAllDrones();
	        			doDisplay();
	        			break;
	        		case 't':
	        			for(int i = 0; i<10; i++) {
	        				doDisplay();
	        				myArena.moveAllDrones();
	        				try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	        			}
	        			break;
	        		case 's':
	        		case 'S':
	        			 save();
	        			 break;
	        		//case 'l':
	        		//case 'L':
	        			//load();
	        			//break;
	        		
	        	}
	    		} while (ch != 'X');						// test if end
	        
	       s.close();									// close scanner
	    }
	    
	    
	    void doDisplay() {
 		//int ax = myArena.getXsize();
 		//int ay =myArena.getYsize();                                               // determine the arena size 
 		ConsoleCanvas c = new ConsoleCanvas (width, height);                                   // hence create a suitable sized ConsoleCanvas object
 		myArena.showDrones(c);                                               // call showDrones suitably
        System.out.println(c.toString());                                           // then use the ConsoleCanvas.toString method 
    }
                                                                             //
	    
	    
	    public void  save() {
	    	
	    	
	    	
	    	 try {
	             // Find file
	             File file = new File("C:\\tmp\\save.txt");

	             // Check if file exists, if not, create one
	             if (!file.exists()) {
	                 file.createNewFile();
	             }

	             // FOS to write to the file
	             FileOutputStream fos = new FileOutputStream(file);
	             // OOS to write the object
	             ObjectOutputStream ous = new ObjectOutputStream(fos);

	             
	             
	            
                 
	             // Write object to file
	             ous.writeObject(myArena);

	             // Close the streams
	             ous.close();
	             fos.close();
	         } catch (FileNotFoundException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	    	
	    	
	    	
	    }
	    public void  load() {
	    	myArena = null;
	        try {
	            // GEt file
	            File file = new File("C:\\tmp\\save.txt");

	            // If it does not exist, then break
	            if (!file.exists()) {
	                return;
	            }

	            // FIS to read file
	            FileInputStream fis = new FileInputStream(file);
	            // OOS to read object in file
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            // cast readObject() to class and store it in the pointer declared as null
	            myArena = (DroneArena) ois.readObject();

	            // close stream
	            ois.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        System.out.print(myArena.toString());
	    }
	    
	
	    	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		public static void main(String[] args) {
			DroneInterface r = new DroneInterface();	// just call the interface
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	