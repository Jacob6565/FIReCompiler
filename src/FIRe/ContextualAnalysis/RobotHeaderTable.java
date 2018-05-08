package FIRe.ContextualAnalysis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class RobotHeaderTable {
    List<String> RobotParts;
    List<String> ValidColors;
    List<String> RobotTypes;

    public RobotHeaderTable(){
        RobotParts = new ArrayList<String>();
        ValidColors = new ArrayList<String>();
        RobotTypes = new ArrayList<String>();
        //Fills the robot parts list with all valid robot parts
        RobotParts.add("GunColor");
        RobotParts.add("BodyColor");
        RobotParts.add("RadarColor");


        //Fills the color list with all valid colors
        ValidColors.add("black");
        ValidColors.add("BLACK");
        ValidColors.add("blue");
        ValidColors.add("BLUE");
        ValidColors.add("cyan");
        ValidColors.add("CYAN");
        ValidColors.add("darkGray");
        ValidColors.add("DARK_GRAY");
        ValidColors.add("gray");
        ValidColors.add("GRAY");
        ValidColors.add("green");
        ValidColors.add("GREEN");
        ValidColors.add("lightGray");
        ValidColors.add("LIGHT_GRAY");
        ValidColors.add("magenta");
        ValidColors.add("MAGENTA");
        ValidColors.add("orange");
        ValidColors.add("ORANGE");
        ValidColors.add("pink");
        ValidColors.add("PINK");
        ValidColors.add("red");
        ValidColors.add("RED");
        ValidColors.add("white");
        ValidColors.add("WHITE");
        ValidColors.add("yellow");
        ValidColors.add("YELLOW");

        //Fills the robot type list with all valid robot types
        RobotTypes.add("AdvancedRobot");
        RobotTypes.add("Robot");
        RobotTypes.add("JuniorRobot");
    }
}