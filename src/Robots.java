/*
We have a bin of robot parts in a factory. Each part goes to a robot with a specific, unique name. Each part will be described by a string, with the name of the robot and the part name separated by an underscore, like "Rosie_arm".

All robots are made of the same types of parts, and we have a string of all of the parts required to form a complete robot. Given a list of available parts, return the collection of robot names for which we can build at least one complete robot.

Sample Input:

all_parts = [
    "Rosie_claw",
    "Rosie_sensors",
    "Optimus_sensors",
    "Dustie_case",
    "Rust_sensors",
    "Rosie_case",
    "Rust_case",
    "Optimus_speaker",
    "Rosie_wheels",
    "Rosie_speaker",
    "Dustie_case",
    "Dustie_arms",
    "Rust_claw",
    "Dustie_case",
    "Dustie_speaker",
    "Optimus_case",
    "Optimus_wheels",
    "Rust_legs",
    "Optimus_sensors" ]

required_parts_1 = "sensors,case,speaker,wheels"
required_parts_2 = "sensors,case,speaker,wheels,claw"
required_parts_3 = "sensors,motors,claw"

Expected Output (output can be in any order):

get_robots(all_parts, required_parts_1) => ["Optimus", "Rosie"]
get_robots(all_parts, required_parts_2) => ["Rosie"]
get_robots(all_parts, required_parts_3) => []

N: Number of elements in `all_parts`
P: Number of elements in `required_parts`
*/


import java.io.*;
import java.util.*;

public class Robots {
    public static void main(String[] argv) {
        String required_parts_1 = "sensors,case,claw,legs";
        String required_parts_2 = "sensors,case,speaker,wheels,claw";
        String required_parts_3 = "sensors,case,screws";

        String[] all_parts = {
                "Rosie_claw",
                "Rosie_sensors",
                "Optimus_sensors",
                "Dustie_case",
                "Rust_sensors",
                "Rosie_case",
                "Rust_case",
                "Optimus_speaker",
                "Rosie_wheels",
                "Rosie_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Optimus_case",
                "Optimus_wheels",
                "Rust_legs",
                "Optimus_sensors"};

        Robots s = new Robots();
        String[] robots = s.getRobotPartsMap(all_parts, required_parts_1);

        for(String robot: robots){
            System.out.println("Robot: "+robot);
        }

    }
    String[] getRobotPartsMap(String[] all_parts, String required_parts_1){
        Map<String, List<String>> mp = new HashMap<String, List<String>>();

        System.out.println("-----1----");
        List lst;
        for(String parts: all_parts){

            String[] robot_part = parts.split("_");
            System.out.println("robot_part[0]="+robot_part[0]+" robot_part[1]="+robot_part[1]);

            if(mp.containsKey(robot_part[0])){
                List<String> list = (List)mp.get(robot_part[0]);
                System.out.println("----"+list);
                list.add(robot_part[1]);

                mp.put(robot_part[0], mp.get(robot_part[0]));
            }else{
                System.out.println(" new robot "+robot_part[0]);
                System.out.println(" new robot part "+robot_part[1]);
                lst =  new ArrayList<String>();
                lst.add(robot_part[1]);
                mp.put(robot_part[0], lst);
            }
            System.out.println("mp = "+mp);
        }

        System.out.println(mp.size());
        String[] required_parts = required_parts_1.split(",");
        System.out.println("required_parts size="+required_parts.length);
        int i=0;
        String[] result = new String[mp.size()];
        for(Map.Entry<String, List<String>> e: mp.entrySet()){
            System.out.println(" key -"+e.getKey());

            List<String> parts =  (List)e.getValue();
            System.out.println(" value size-"+parts.size());
            if(required_parts.length==parts.size()){
                System.out.println("Equal!!");
                boolean match = true;
                for(String part: required_parts){
                    if(!parts.contains(part)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    System.out.println("Matched!!");
                    result[i++] = e.getKey();
                }

            }


        }
        return result;

    }
}



