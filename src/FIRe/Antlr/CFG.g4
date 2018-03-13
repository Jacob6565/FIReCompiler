grammar CFG;
//Lexer rules
//Robocode robot terminals
RobotProperty       : 'GunColor' | 'BodyColor' | 'RadarColor' ;
RobotTypeVal	    : 'advancedRobot' | 'juniorRobot' | 'robot' ;
ColorVal	        : 'red' | 'blue' | 'yellow' | 'green' | 'black' | 'white' ;
Type		        : 'number' | 'text' | 'bool' | 'number[]'
                    |'text[]' | 'bool[]'
                    ;
RobotProperties     : 'RobotProperties'
                    ;
RobotName           : 'RobotName'
                    ;
RobotType           : 'RobotType';
//Events types and whens
When                : 'when';
EType 		        : 'BattleEndedEvent' | 'BulletHitBulletEvent'
                    | 'BulletHitEvent' | 'BulletMissedEvent' | 'CustomEvent'
                    | 'DeathEvent' | 'HitByBulletEvent' | 'HitRobotEvent'
                    | 'HitWallEvent' | 'KeyEvent' | 'MessageEvent' | 'MouseEvent'
                    | 'PaintEvent' | 'RobotDeathEvent' | 'RoundEndedEvent'
                    | 'ScannedRobotEvent' | 'SkippedTurnEvent' | 'StatusEvent'
                    | 'WinEvent'
                    ;
SingleLineComment   : '//' [\u0000-\u007Eæøå]* -> skip;
MultiLineComment    : '/*' ([\u0000-\u007Eæøå]* '*')* '/' -> skip;
WhiteSpace          : [ \r\n\t]+ -> skip;
Val	                : [-]? [0-9]+ ('.' [0-9]+)?
                    | '"' [\u0020-\u0021\u0023-\u007E]* '"'
                    ;
// mathematical terminals
AdditiveOp	        : Plus | Minus ;
MultiOp             : Times | Divide | Modulo ;
Plus                : '+';
Minus               : '-';
Times               : '*';
Divide              : '/';
Modulo              : '%';
BoolVal             : TRUE | FALSE ;
RelativeOp		    : '<' | '>' | '<=' | '>=' | '!=' | '==' ;
BoolOp	            : 'and' | 'or' ;
TRUE                : 'true' ;
FALSE               : 'false' ;
Hat                 : '^';

// Parenthesis, scopes brackets and other notation
Scopel              : '{';
Scoper              : '}';
Comma               : ',';
Colon               : ':';
SemiColon           : ';';
Dot                 : '.';
Squarel             : '[';
Squarer             : ']';
Parenl              : '(';
Parenr              : ')';

//ControlStructures and necessities
For                 : 'for';
Upto                : 'upto';
Downto              : 'downto';
While               : 'while';
If                  : 'if';
Elseif              : 'else if';
Else                : 'else';
Strategy            : 'strategy';
Routine             : 'routine';

//Others
Void                : 'void';
Assign              : '=';
Return              : 'return';
Not                 : '!';
Condition           : 'condition';

Name                : [A-z][A-z0-9]*;

//Parser rules
prog                : robotDcl (dcl | funcDcl | strategydcl | conditionDcl)*
                    ;
strategydcl     	: Strategy id Parenl fParamList? Parenr Scopel (dcl | stmt | routine | when)* Scoper
                    ;
funcDcl	            : funcType id Parenl fParamList? Parenr funcBody
                    ;
funcType	        : Void
                    | Type
                    ;
funcBody 	        :Scopel (dcl | stmt)* Scoper
                    ;
fParamList          : Type id
                    | Type id Comma fParamList
                    ;
robotDcl 	        : RobotProperties Scopel robotDclBody Scoper
                    ;
robotDclBody        : RobotName Colon id SemiColon RobotType Colon RobotTypeVal SemiColon (RobotProperty Colon ColorVal SemiColon)*
                    ;
dcl                 : Type id Assign expr SemiColon
                    | Type id (Comma id)* SemiColon
                    ;
stmt		        : assignStmt SemiColon
                    | funcCall SemiColon
                    | ctrlStruct
                    | Return expr SemiColon
                    ;
routine	            : Routine Parenl (Val | id)? Parenr funcBody
                    ;
when		        : When Parenl (eParam | id id) Parenr funcBody
                    ;
expr                : Parenl expr Parenr
                    | Not expr
                    | <assoc=right> expr Hat expr
                    | expr MultiOp expr
                    | expr AdditiveOp expr
                    | expr RelativeOp expr
                    | expr BoolOp expr
                    | Val
                    | BoolVal
                    | id
                    | funcCall
                    ;
assignStmt	        : id Assign expr
                    ;
funcCall	        : id Parenl aParamList? Parenr
                    ;
conditionDcl        : Condition id Parenl fParamList? Parenr funcBody
                    ;
aParamList          : expr (Comma aParamList)?
                    ;
ctrlStruct          : aif (aelseif)* (aelse)?
                    | For Parenl (dcl | Val | id) (Upto | Downto) (Val | id) Parenr funcBody
                    | While Parenl expr Parenr funcBody
                    | routine
                    ;
aif                  : If Parenl expr Parenr funcBody
                    ;
aelseif              : Elseif Parenl expr Parenl  funcBody
                    ;
aelse                : Else  funcBody
                    ;
eParam  	        : EType id
                    ;
id                  : Name ( Dot id)?
                    | Name Squarel Val Squarer
                    ;