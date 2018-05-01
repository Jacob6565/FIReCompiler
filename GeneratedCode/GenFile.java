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
						turnLeftAndRotate("30")
		;
			
				}; 
			}
		);
		while(true){
			switch(currentStrategy){
				case "Default"
					while(true){
						turnRadarRight(360.0)
					;
						for(int _i = (int)0.0; _i < (int)2.0; i++){
						ahead(20.0)
					;
					}
						for(; (int)_x > (int)-9128.9182; _x--){
					}
					}
					break;
				case "Offensive"
					while(true){
						fire(1.0)
					;
					}
					break;
			}
		}
	}
	public boolean turnLeftAndRotate (String currentRival){ 
		double _uno = 1.0;
		double _RobinHood, _LilleJohn;
		_nameOfRival = _currentRival;
		boolean false;
	_shotAtRival = 	boolean _a[(int)5.0];
		_a = true;
		if(_a[(int)3.0] ){
		fire(_firepower)
	;
		_shotAtRival = true;
	}
		for(int _b = (int)0.0; _b < (int)2.0; b++){
		turnLeft(_b)
	;
	}
		
	}
	public void doSomething (){ 
		if(_x == 3.6){
		_x = 2.0;
	}
	else{
		_x = _x + 4.2;
	}
	
	}
	public double Function (){ 
			double _x = 0.0;
	
	}
	public void onScannedRobot (ScannedRobotEvent e){ 
		switch(currentStrategy){
			case "Default"
					String _currentRival = e.getName()
				;
					turnLeftAndRotate(_currentRival)
				;
					Offensive()
				;
				break;
		}
	
	}
	public void onCustomEvent (CustomEvent e){ 
		String condition = e.getCondition().getName();
		switch (condition) { 
			case LowHealth:
				switch (currentStrategy) { 
					case Offensive:
							Default(100.0, 50.0 + 50.0)
						;
						break;
				}
				break;
		}
	
	}

}