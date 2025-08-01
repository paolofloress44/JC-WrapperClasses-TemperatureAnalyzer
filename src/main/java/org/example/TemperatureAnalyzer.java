package org.example;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        String day1TempStr = "", day2TempStr = "", day3TempStr = "";
        double doubleDay1TempPrimitive = 0.0, doubleDay2TempPrimitive = 0.0, doubleDay3TempPrimitive = 0.0;
        Double day1TempWrapper=null, day2TempWrapper=null, day3TempWrapper=null;
        float day1TempFloat = 0.0f;
        int day2TempInt=0;
        int day1Day2CompareResult;

        Scanner sc = new Scanner(in);
        out.println("Enter three daily high temperatures");
        boolean validInput = false;
        //Day 1
        do{
            out.print("Enter Day 1 High Temperature: ");
            day1TempStr = sc.nextLine();
            try{
                doubleDay1TempPrimitive = Double.parseDouble(day1TempStr);
                day1TempWrapper = Double.valueOf(doubleDay1TempPrimitive);
                day1TempFloat = day1TempWrapper.floatValue();
                validInput = true;
            }catch(NumberFormatException e){
                out.println("Invalid input");
            }
        } while (!validInput);

        //Day 2
        validInput = false;
        do{
            out.print("Enter Day 2 High Temperature: ");
            day2TempStr = sc.nextLine();
            try{
                doubleDay2TempPrimitive = Double.parseDouble(day2TempStr);
                day2TempWrapper = Double.valueOf(doubleDay2TempPrimitive);
                day2TempInt = day2TempWrapper.intValue();
                validInput = true;
            }catch(NumberFormatException e){
                out.println("Invalid input");
            }
        } while (!validInput);

        //Day 3
        validInput = false;
        do{
            out.print("Enter Day 3 High Temperature: ");
            day3TempStr = sc.nextLine();
            try{
                doubleDay3TempPrimitive = Double.parseDouble(day3TempStr);
                day3TempWrapper = Double.valueOf(doubleDay3TempPrimitive);
                validInput = true;
            }catch(NumberFormatException e){
                out.println("Invalid input");
            }
        } while (!validInput);

        //Print Temperature Analysis
        out.println("\n--- Temperature Analysis ---\n");
        out.println("Parsed Day 1 Temp (primitive double): " + doubleDay1TempPrimitive);
        out.println("Parsed Day 2 Temp (primitive double): " + doubleDay2TempPrimitive + "\n");
        day1Day2CompareResult = day1TempWrapper.compareTo(day2TempWrapper);
        if(day1Day2CompareResult < 0){
            out.println("Day 1 (" + day1TempWrapper + "°C) was cooler than Day 2 (" + day2TempWrapper + "°C).\n");
        }else if(day1Day2CompareResult > 0){
            out.println("Day 2 (" + day2TempWrapper + "°C) was cooler than Day 1 (" + day1TempWrapper + "°C).\n");
        }else{
            out.println("Day 1 (" + day1TempWrapper + "°C) was the same temperature as Day 2 (" + day2TempWrapper + "°C).\n");;
        }
        out.println("Extracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt + "\n");

        double maxTempPrimitive = Math.max(day1TempWrapper, Math.max(day2TempWrapper, day3TempWrapper));
        out.println("The highest temperature recorded was: " + maxTempPrimitive + "°C");


        sc.close();
    }
}