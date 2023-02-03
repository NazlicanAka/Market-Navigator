
package question;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



import java.util.*;

public class MarketNavigator

{
	
	private static House migros;
	private static ArrayList<House> houseList;
	private static int[] houseArr;
	private static double minDistance = 10000;
	private static ArrayList<House> list = new ArrayList<>();
	
	
	/* Method that gives the distance between two points */
	public static double distanceFinder(int x1, int y1, int x2, int y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	
	public static int pathFinder(String filename) {
		
		
		/* Find the smallestTotalDistance */
		double smallestTotalDistance = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		try {
			
			// Open file
			File myFile = new File(filename);
			
			// Scan file
			Scanner sc = new Scanner(myFile);
			
			// It will continue until all lines are read
			while(sc.hasNextLine()) {
				
				String line = sc.nextLine();
				String[] houseArray = line.split(" ");
				
				// House name
				String houseName = houseArray[0];
				
				// x coordinate
				int x = Integer.parseInt(houseArray[1]);
				
				// y coordinate
				int y = Integer.parseInt(houseArray[2]);
				 
				// House object for one house
				House oneHouse = new House(houseName, x, y);
				
				// Add all oneHouses to my list
				list.add(oneHouse);
				
				migros = list.get(0);
				
			 }//while
			sc.close(); // Close scanner
		}catch(IOException e) // try 
		{  
			e.printStackTrace(); 
		} // catch
		
		// ArrayList that contains just houses
		houseList = new ArrayList<>();
		houseList = (ArrayList<House>) list.clone();
		houseList.remove(0);
		
		// Array that contains just houses
		houseArr = new int[houseList.size()];
		for(int i=0; i<houseList.size(); i++) {
			houseArr[i] = i;
		}
		
		smallestTotalDistance = permute(houseArr, 0);
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		////////////////////
		int roundedValue = (int) Math.round(smallestTotalDistance);
		return roundedValue;
		/////////////////////
		
	} // distanceFinder
	
	public static double permute(int[] arr, int k){
		
        for(int i = k; i < arr.length; i++){
            swap(arr, i, k);
            permute(arr, k+1);
            swap(arr, k, i);
            
        }
        if (k == arr.length -1){
        	
        	if(findDistance(arr) < minDistance) {
        		minDistance = findDistance(arr);

        	}	
            
        }

        return minDistance;
       
    }
    
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		
	}
	
	public static double findDistance(int[] array) {
		
		ArrayList<House> methodList = new ArrayList<>();
		methodList.add(migros);
		for(int i=0; i<array.length; i++) {
			methodList.add(houseList.get(array[i]));
		}
		
		methodList.add(migros);
		
		double total = 0;
		
		for(int i=0; i<methodList.size()-1; i++) {

			// Create x1 and y1
			int x1 = methodList.get(i).getX();
			int y1 = methodList.get(i).getY();
			

			// Create x2 and y2
			int x2 = methodList.get(i+1).getX();
			int y2 = methodList.get(i+1).getY();

			// Find one distance
			double oneDistance = distanceFinder(x1, y1, x2, y2);
			total = total + oneDistance;
		}
		return total;
		
	}
		
	public static void main(String[] args) {
		
		
//		/* This part is for you to test your method, no points will be given from here */
//		String path = MarketNavigator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + ".." + File.separator+"coordinates.txt";
//		int distance = pathFinder(path);
//		System.out.println("Smallest distance:" + distance);
		
		System.out.println(pathFinder("coordinates4.txt"));
		
		
		
		
		

	}
	
}  

