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
					
				}; 
			}
		);
		while(true){
			switch(currentStrategy){
				case "_Default"
					while(true){
						_turnRadarRight(360.0);
						for(int _i = (int)0.0;_i < (int)2.0; _i++){
							_ahead(20.0);
					}
						for(; (int)_x > (int)-9128.9182; _x--){
					}
					}
					break;
				case "_Offensive"
					while(true){
						_fire(1.0);
					}
					break;
			}
		}
	}
	public boolean _turnLeftAndRotate (String _currentRival){ 
	boolean _asd = false;
	boolean _was = true;
	boolean _wefas[(int)5.0];
	double _uno = 1.0;
	double _x = 3.6;
	double _RobinHood, _LilleJohn;
	_nameOfRival = _currentRival;
	boolean _shotAtRival = false;
	boolean _a[(int)5.0];
	_a = true;
	if(_x == 3.6){
		_x = 2.0;
		if(_x == 5.2){
			_x = 3.0;
		}
		if(_x == 0.0){
		}
	}
	if(_a[(int)3.0] ){
		_fire(_firepower);
		_shotAtRival = true;
	}
	for(int _b = (int)0.0;_b < (int)2.0; _b++){
		_turnLeft(_b);
	}
	
	}
	public void _doSomething (){ 
	
	}
	public double _Function (){ 
	double _x = 0.0;
	
	}
	public void onCustomEvent (CustomEvent e){ 
		String condition = e.getCondition().getName();
		switch (condition) { 
			case _ScannedRobotEvent:
				switch (currentStrategy) { 
					case _Default:
							String _currentRival = _e.getName();
							_turnLeftAndRotate(_currentRival);
							_Offensive();
						break;
				}
				break;
			case _LowHealth:
				switch (currentStrategy) { 
					case _Offensive:
							_Default(100.0, 50.0 + 50.0);
						break;
				}
				break;
		}
	
	}

}