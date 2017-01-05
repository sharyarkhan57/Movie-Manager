//Sharyar Khan 				id: 110677446			HW 7

import java.util.ArrayList;
import java.util.List;
import big.data.DataSource;
import java.util.*;

public class Movie {

	private String title;
	private int year;
	
	private List<Actor> actors =  new ArrayList<Actor>();
	
	
	/**
	 * default constructor for a movie, creates the films parameters and sets the actors count to 1
	 * @param url simple name of the movie that you want to look for, it has a prefix and postfix attached to it with the necessary url components
	 * 
	 */
	public Movie(String url){
		try{
	        String prefix= "http://www.omdbapi.com/?t=";
	        String postfix="&y=&plot=short&r=xml";
		    if(url.length()<=0){
		        System.out.println("Invalid Title");
		        return;
		    }
		    	
	        DataSource ds = DataSource.connectXML(prefix+url.replace(' ','+')+postfix);
	        ds.load();
	        
	        // storing title
	        System.out.println("true title: "+ds.fetchString("movie/title"));
	        title=ds.fetchString("movie/title");
	        
	        //storing actors separately in a list
//	        System.out.println("actors: "+ds.fetchString("movie/actors"));
		    String actorsString = ds.fetchString("movie/actors");
			System.out.println("Actors: "+actorsString);
			
		    String actorDelimString=actorsString.replaceAll(", ","-");

		    String [] actorsArray=actorDelimString.split("-");
		    
		    
			for(int i=0;i<actorsArray.length;i++){
				Actor tempActor= new Actor(actorsArray[i]);
				this.actors.add(tempActor);
			}

			
			//storing year
	        System.out.println("year: " + ds.fetchInt("movie/year"));
	        year=ds.fetchInt("movie/year");
	        
	        
	        
	        
		}catch(Exception e){
			System.out.println("Movie not found");
			return;
		}
		
	}
	
	/**
	 * @param title takes a string name of the movie
	 * @param year	takes an int that represents the year of the movie
	 */
	public Movie(String title, int year){
		this.title=title;
		this.year=year;
	}
	
	
	
	//getters
	/**
	 * @return title of movie
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return year of movie
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @return an array of the Actors in the film
	 */
	public Actor[] getActors(){
		
		Actor[] actorArray = new Actor[actors.size()];
		
		actors.toArray(actorArray);
		return actorArray;	
	}
	
	/**
	 * @return a List of actors of the actors in the film
	 */
	public List<Actor> getActorsList(){
		
		return actors;	
	}

	//setters
	/**
	 * @param year representing the year the movie was made
	 */
	public void setYear(int year) {
		this.year = year;
	}

	
	/**
	 * @param title string representing the name of the movie
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
