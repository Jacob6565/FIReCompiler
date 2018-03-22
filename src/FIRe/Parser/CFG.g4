grammar CFG;
//Lexer rules
//Robocode robot terminals
//RobotProperty       : 'GunColor' | 'BodyColor' | 'RadarColor' ;
//RobotTypeVal	    : 'advancedRobot' | 'juniorRobot' | 'robot' ;
//ColorVal	        : 'red' | 'blue' | 'yellow' | 'green' | 'black' | 'white' ;
Type		        : 'number' | 'text' | 'bool' | 'number[]'
                    |'text[]' | 'bool[]'
                    ;
RobotProperties     : 'RobotProperties'
                    ;
//Events types and whens
When                : 'when';
SingleLineComment   : '//' [\u0000-\u007E]* -> skip;
MultiLineComment    : '/*' ([\u0000-\u007E]* '*')* '/' -> skip;
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
Event               : 'event';
Setup               : 'setup';

Name                : [A-z][A-z0-9]*;
EndOfFile           : '$';

//Parser rules
prog                : robotDcl (progBody)* EndOfFile
                    ;
progBody            : dcl
                    | funcDcl
                    | strategyDcl
                    | eventDcl
                    ;
strategyDcl     	: Strategy id Parenl fParamList? Parenr Scopel (Setup block)? (strategyBlock)* Scoper
                    ;
strategyBlock       : routine
                    | when
                    ;
funcDcl	            : funcType id Parenl fParamList? Parenr block
                    ;
funcType	        : Void
                    | Type
                    ;
block 	            :Scopel (blockBody)* Scoper
                    ;
blockBody           : dcl
                    | stmt
                    ;
fParamList          : Type id
                    | Type id Comma fParamList
                    ;
robotDcl 	        : RobotProperties Scopel robotDclBody Scoper
                    ;

robotDclBody        : (id Colon id SemiColon)*
//robotDclBody        : RobotName Colon id SemiColon RobotType Colon RobotTypeVal SemiColon (RobotProperty Colon ColorVal SemiColon)*
                    ;
dcl                 : Type id Assign expr SemiColon
                    | Type id (Comma id)* SemiColon
                    ;
stmt		        : assignStmt SemiColon
                    | funcCall SemiColon
                    | ctrlStruct
                    | Return expr SemiColon
                    ;
routine	            : Routine Parenl (expr)? Parenr block
                    ;
when		        : When Parenl (id id) Parenr block
                    ;
expr                : Parenl expr Parenr
                    | expr Squarel expr Squarer
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
eventDcl            : Event id Parenl Parenr block
                    ;
aParamList          : expr (Comma aParamList)?
                    ;
ctrlStruct          : aif (aelseif)* (aelse)?
                    | For Parenl (dcl | expr) (Upto | Downto) (expr) Parenr block
                    | While Parenl expr Parenr block
                    | routine
                    ;
aif                 : If Parenl expr Parenr block
                    ;
aelseif             : Elseif Parenl expr Parenl  block
                    ;
aelse               : Else  block
                    ;
id                  : Name ( Dot id)?
                    | Name Squarel Squarer;