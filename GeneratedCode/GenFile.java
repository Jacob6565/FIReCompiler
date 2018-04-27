import java.awt.*;
import java.lang.*;
import robocode.*;
public class TheDestroyer extends AdvancedRobot{
	private String currentStrategy = "Default";
	public void run (){ 
		SetColors(yellow, red, white);
		addCustomEvent(
			new condition("LowHealth") {
				public boolean test() {
					
				}; 
			}
		);
		while(true){
			switch(currentStrategy){
				case "bitch"
					bitch();
					break;
				case "bitch"
					bitch();
					break;
			}
		}
	}
	public bool turnLeftAndRotate (String currentRival){ 
	
	}
	public void doSomething (){ 
	
	}
	public number Function (){ 
	
	}
	public void onScannedRobot (ScannedRobotEvent e){ 
		switch(currentStrategy){
			case "Default"
				INSERT CODE HERE
				break;
		}
	
	}

}