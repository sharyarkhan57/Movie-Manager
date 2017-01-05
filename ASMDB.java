//Sharyar Khan 				id: 110677446			HW 7

import big.data.DataSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * This is the main driver class that asks the user for movies to be inputted, deleted, and ask which of the sorting options they
 * would like to print. All printing is taken care of in the methods folllowing the main
 * @author Sharyar
 *
 */

class ASMDB {
	public static void main (String[] args){
		
		Scanner scan = new Scanner(System.in);
		MovieManager manager= new MovieManager();
		
		while(true){
			
			printMainMenu();
			//gets choice
			String allUpper =scan.next();
			allUpper = allUpper.toUpperCase();
			char choice = allUpper.charAt(0);

			String title ="";
			
			switch (choice) {
			
	         case 'I': 	//	Delete Movie

                System.out.print("Enter a movie title: ");
                //generate the web address for the movie
                title=scan.nextLine();
                title=scan.nextLine();
                Movie newMovie= new Movie(title);
                manager.addMovie(newMovie);
                
                //store actors array in temp array to be able to add to the manager
                Actor[] newActors=newMovie.getActors();

                for(int i=0; i<newActors.length;i++){
                	manager.addActor(newActors[i]);
                }
                
	        	    break;
	        	 
	         case 'D': 	//	Delete movie

	        	 	//create another movie object
                System.out.print("Enter a movie title: ");
                //generate the web address for the movie
                title=scan.nextLine();
                title=scan.nextLine();
                Movie deleteMovie= new Movie(title);
                try{
                	manager.deleteMovie(deleteMovie);
                }catch(Exception e){
                    System.out.print("Movie Could Not Be Found");
                }
		        	break;
	        	
		        	 
		        	 
	         case 'M':	//	Edit Building: by name
	        	 	System.out.println("Sort Movies By:");
	        	 	System.out.println("TA-Title Ascending");
	        	 	System.out.println("TD-Title Descending");
	 			System.out.println("YA-Release Date Ascending");
	 			System.out.println("YD-Release Date Descending");
	 			System.out.println("_________________________________");
	 			System.out.println("Enter a menu option:");
	 			
	 			String sortMovieChoice =scan.next();
	 			sortMovieChoice = sortMovieChoice.toUpperCase();
				
				switch (sortMovieChoice) {
				
		         case "TA": 
					Collections.sort(manager.getMoviesList(), new TitleComparator());
					printMovieList(manager);
					break;

		         case "TD": 
					Collections.sort(manager.getMoviesList(),  new TitleComparator());
					printMovieListReversed(manager);
					break;
					
	        	 		
		         case "YA": 

					Collections.sort(manager.getMoviesList(), new YearComparator());
					printMovieList(manager);
	        	 		break;
	        	 		
		         case "YD": 
		        	 	Comparator yearReversed = new YearComparator();
		        	 	//reverse the comparison count
		        	 	yearReversed.reversed();
					Collections.sort(manager.getMoviesList(), new YearComparator());
					printMovieListReversed(manager);
	        	 		break;
				}
	        	 	
				break;
				
	         case 'A':	// 	- Sort Actors
	        	 
	    			System.out.println("AA-Alphabetically Ascending");
	    			System.out.println("AD-Alphabetically Descending");
	    			System.out.println("NA-By Number of Movies They Are In Ascending");
	    			System.out.println("ND-By Number of Movies They Are In");
	    			System.out.println("_________________________________");
	    			System.out.println("Enter a menu option:");
	    			
	    			String sortActorChoice =scan.next();
	    			sortActorChoice = sortActorChoice.toUpperCase();
					
					switch (sortActorChoice) {
					
			         case "AA": 
			        	 
						Collections.sort(manager.getActorsList(), new NameComparator());
						printActorList(manager);
		        	 		break;
		        	 	
			         case "AD": 
			        	 
						Collections.sort(manager.getActorsList(), new NameComparator());
						printActorListReversed(manager);
		        	 		break;
		        	 		
			         case "NA": 
			        	 
						Collections.sort(manager.getActorsList(), new CountComparator());
						printActorList(manager);
						
		        	 		break;
		        	 		
			         case "ND":
			        	 
			        		Collections.sort(manager.getActorsList(), new CountComparator());
						printActorListReversed(manager);
						break;
	        	 	
					}
					
					System.out.print("\n");

					break;
	        	 	
	         case 'Q':	//	print movie list
	        	 	System.out.println("Program Terminated");
	        	 	System.exit(0);
	        	 	
			}
		}
	}
	
	/**
	 * Prints the main menu
	 */
	static void printMainMenu(){
		System.out.println("_________________________________");
		System.out.println("\t\tMAIN MENU");
		System.out.println("_________________________________");
		System.out.println("I - Import Movie");

		System.out.println("D - Delete Movie");
		System.out.println("M - Sort Movies");
		System.out.println("A - Sort Actors");
		System.out.println("Q - Quit");
		System.out.println("_________________________________");
		System.out.println("Enter a menu option:");

	}

	/**
	 * @param manager  the current manager being used to hold the movie and actor arrays
	 * prints the list of actors aggregate 
	 */
	static void printActorList(MovieManager manager){
		System.out.printf("%-25s %5s %n", "Actors", "Number of Films");
		System.out.print("________________________________________________\n");
		for(int i = 0; i < manager.getActorsList().size(); i++){					
			System.out.printf("%-25s %5s %n", manager.getActorsList().get(i).getName(), manager.getActorsList().get(i).getCount() );	
		}
		
	}
	
	/**
	 * @param manager  the current manager being used to hold the movie and actor arrays
	 * prints the list of the actors aggregate (reversed)
	 */
	static void printActorListReversed(MovieManager manager){
		System.out.printf("%-25s %5s %n", "Actors", "Number of Films");
		System.out.print("________________________________________________\n");
		for(int i = manager.getActorsList().size() - 1; i >= 0; i--){					
			System.out.printf("%-25s %5s %n", manager.getActorsList().get(i).getName(), manager.getActorsList().get(i).getCount() );	
		}
		
		
	}

	/**
	/**
	 * @param manager  the current manager being used to hold the movie and actor arrays
	 * prints the list of movie aggregate 
	 */
	static void printMovieList(MovieManager manager){
		System.out.printf("%-30s %-10s %-7s %n", "Title", "Year", "Actors");
		System.out.print("________________________________________________________________________________________________\n");
		String actorPrintA = "";
		for(int i = 0; i < manager.getMoviesList().size(); i++){
			Actor[] actorStringList = manager.getMoviesList().get(i).getActors();
			for(int j = 0; j < actorStringList.length; j++){
				if(j == 0){
					actorPrintA = actorPrintA+ actorStringList[j].getName();
				}
				else{
					actorPrintA = actorPrintA+ ", " + actorStringList[j].getName();
				}
			}
			System.out.printf("%-30s %-10s %-7s %n", manager.getMoviesList().get(i).getTitle(), manager.getMoviesList().get(i).getYear(), actorPrintA);
			actorPrintA = "";
		}
		System.out.print("\n");
	}
	
	/**
	 * @param manager  the current manager being used to hold the movie and actor arrays
	 * prints the list of movie aggregate (reversed)

	 */
	static void printMovieListReversed(MovieManager manager){

		System.out.printf("%-30s %-10s %-7s %n", "Title", "Year", "Actors");
		System.out.print("________________________________________________________________________________________________\n");
		String actorPrintD = "";

		for(int i = manager.getMoviesList().size()-1; i>=0; i--){
			Actor[] actorStringList = manager.getMoviesList().get(i).getActors();
			for(int j = 0; j < actorStringList.length; j++){
				if(j == 0){
					actorPrintD += actorStringList[j].getName();
				}
				else{
					actorPrintD += ", " + actorStringList[j].getName();
				}
			}
			System.out.printf("%-30s %-10s %-7s %n", manager.getMoviesList().get(i).getTitle(), manager.getMoviesList().get(i).getYear(), actorPrintD);
			actorPrintD = "";
		}
		System.out.print("\n");
	}
	
}	
