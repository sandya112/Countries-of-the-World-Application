package question2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountriesOfTheWorld {
  public static void main(String[]args) {
	 Scanner input=new Scanner(System.in);
	 System.out.println("(Enter ',' to add country names in the list or Press enter to exit)");
	 System.out.println("Please enter the name of countries:"); 
	 String countryname = input.nextLine();        //enter names
	 String countries[] = countryname.split(",") ; //countrynames array
     while(true) {
    	 System.out.println("--MENU OPTIONS--");//options
		 System.out.println("Press 1 to display names of country");  
		 System.out.println("Press 2 to sort the country names in alphabetical order");
		 System.out.println("Press 3 to search for a country name in the list");
		 System.out.println("Press 4 to check if there are duplicates for a country name in the list");
		 System.out.println("Press 5 to exit the country name list");
		 int num=input.nextInt(); //enter option
    	 switch(num) {
    	 
    	 case 1:
    	 displayCountryNames(countries);
    	 break;
    	 
    	 case 2:
         sortAscendingAndDisplay(countries);
    	 break;
    	     
    	 case 3: 
    	 System.out.println("please enter country name to search:");//enter country to search
    	 String x = input.next(); 
    	 int output = searchAndDisplay(sortAscendingAndDisplay(countries), x); 
    	  
    	 if (output == -1) {
    	 System.out.println("The country entered is not present in the list"); //output for search not found
    	 }
    	 else if(output !=-1){
    	 System.out.println("The country entered is present in the list"); //output for search found
    	 }
    	 break;
    	     
    	 case 4:
         containsDuplicates(countries,1);
         break;
    		
    	 case 5:
    		 System.out.println("You have succesfully exited the countries name list system");
    		 System.exit(0);//exit system
    		 break;
    		 
        default:
        break;	 
     }
    	 
    	 
    }
  }
  
 
//method to display country names
  public static void displayCountryNames(String[]countries) { 
	  System.out.println("The country names in the list are: ");	
	  for(int i=0;i<countries.length;i++) {  
	     System.out.println(countries[i]);//print country names
		  }
     }
  
  
  
  //method to display country names in ascending order
  public static int partition(String[] countries, int lowerIndex, int upperIndex) {
	  String p = countries[lowerIndex];
      while (lowerIndex < upperIndex) {
         String first_val;
         String second_val;
         while ((first_val = countries[lowerIndex]).compareTo( p ) < 0) {
             lowerIndex = lowerIndex + 1; //increment lowerIndex
         }
         while ((second_val = countries[upperIndex]).compareTo( p ) > 0) {
             upperIndex = upperIndex - 1;//decrement upper index
         }
         countries[lowerIndex] = second_val;
         countries[upperIndex] = first_val;
      }
      return lowerIndex;
  }
  public static void sort(String[] countries, int lowerIndex, int upperIndex) {
      if (lowerIndex >= upperIndex) {
         
          return;
      }
      int p = partition(countries,lowerIndex, upperIndex);
      sort(countries,lowerIndex, p);
      sort(countries, p+1, upperIndex);
   }
  
  
  //print sorted array
  public static String[] sortAscendingAndDisplay(String[] countries) {
        sort(countries, 0, countries.length - 1); //sort method
    	System.out.println("The country names sorted in aphabetical order is: ");
        for (String output:countries) { 
            System.out.println( output + " " );//output countries in ascending order

        }
		return countries;
  }
  
  
  
  //method to search for a country
  public static int searchAndDisplay(String[] countries, String target) { //searches for country name using binary search method
	  { 
	        int low = 0, high = countries.length - 1; 
	        while (low <= high) { 
	            int middle = low + (high - low) / 2; //calculates middle
	  
	            int r = target.compareTo(countries[middle]); 
	  
	            // target found
	            if (r == 0) 
	                return middle; 
	  
	            // search high end of array
	            if (r > 0) 
	                low = middle + 1; 
	  
	            // search low end of array
	            else
	                high = middle - 1; 
	        } 
	  
	        return -1; // search not found
	  } 
	}
  
  
  
	//method to check for duplicates  
  public static boolean containsDuplicates(String countries[], int value) {
	  Set<String>set=new HashSet<String>();//create Set
	// cross the array 
      for (int i=0; i<countries.length; i++) 
      { 
        
          // verfies for duplicate
          if (set.contains(countries[i]) &&(countries[i]!=null)) {
        	  System.out.println("YES, the list for country names contains duplicates.");//duplicate present
        	  return true; 
          }
          // Add value  
          set.add(countries[i]); 

          // Remove value
          if (i >= value) 
            set.remove(countries[i-value]); 
      } 
      System.out.println("NO, the list for country names does not contain duplicates."); //no duplicate
      return false; 
	  
  }
  
 }

