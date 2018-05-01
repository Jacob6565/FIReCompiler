import java.awt.*;
import java.lang.*;
import robocode.*;
public class TheDestroyer extends AdvancedRobot{
	private String currentStrategy = "Default";
	public void run (){ 
		SetColors(yellow, red, white);
		addCustomEvent(
			new condition("_LowHealth") {
				public boolean test() {
						_turnLeftAndRotate("30")
		;
			
				}; 
			}
		);
		while(true){
			switch(currentStrategy){
				case "_Default"
					while(true){
						_turnRadarRight(360.0)
					;
						for(int __i = (int)0.0;__i < (int)2.0; __i++){
						_ahead(20.0)
					;
					}
						for(; (int)_x > (int)-9128.9182; _x--){
					}
					}
					break;
				case "_Offensive"
					while(true){
						_fire(1.0)
					;
					}
					break;
			}
		}
	}
	public boolean _turnLeftAndRotate (String _currentRival){ 
		double __uno = 1.0;
		double _RobinHood, _LilleJohn;
		_nameOfRival = _currentRival;
		boolean false;
	__shotAtRival = 	boolean __a[(int)5.0];
		_a = true;
		if(_a[(int)3.0] ){
		_fire(_firepower)
	;
		_shotAtRival = true;
	}
		for(int __b = (int)0.0;__b < (int)2.0; __b++){
		_turnLeft(_b)
	;
	}
		
	}
	public void _doSomething (){ 
		if(_x == 3.6){
		_x = 2.0;
	}
	else{
		_x = _x + 4.2;
	}
	
	}
	public double _Function (){ 
			double __x = 0.0;
	
	}
	public void onCustomEvent (CustomEvent e){ 
		String condition = e.getCondition().getName();
		switch (condition) { 
			case _ScannedRobotEvent:
				switch (currentStrategy) { 
					case _Default:
							String __currentRival = _e.getName()
						;
							_turnLeftAndRotate(_currentRival)
						;
							_Offensive()
						;
						break;
				}
				break;
			case _LowHealth:
				switch (currentStrategy) { 
					case _Offensive:
							_Default(100.0, 50.0 + 50.0)
						;
						break;
				}
				break;
		}
	
	}

}