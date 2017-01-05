//Sharyar Khan 				id: 110677446			HW 7

import java.util.*;

/**
 * @author Sharyar
 *
 */
public class MovieManager {

	private List<Movie> movies= new ArrayList<Movie>();
	
	private List<Actor> actors= new ArrayList<Actor>();
	
	public MovieManager(){
	
	}
	
	//setters
	/**
	 * @param e takes a movie object and adds it to the list of movies
	 */
	public void addMovie(Movie e){
		movies.add(e);
	}
	
	
	/**
	 * @param e takes a movie e and looks for it in the list. Will delete that movie from 
	 * the list and decrements the count of all of the actors who acted in that movie
	 */
	public void deleteMovie(Movie e){
	try{
		Movie[] movieArray =getMovies();
		
		//declare a actor comparator
		TitleComparator titleComparator = new TitleComparator();
		Actor[] temp=null;
		
		//will increment through the list checking to see whether the movie exists
		for(int i=0;i<movieArray.length;i++){
			//if the movie does already exist in the list, we will get the actors  
			//movie count and decrease it by one
			if(titleComparator.compare(movieArray[i], e)==0){
				//once movie is found, all actors from that movie must be decremented
				temp=movieArray[i].getActors();
				//the movie is removed from the list
				movies.remove(i);
				break;
			}
			else{
				if(movies.size()==i-1){
					System.out.println("Movie Not Found");;
					return;
				}
			}
		}
			
	
		//double for loop used to decrement all the actors from the movie being deleted
		//when a match is found, actors movie count is decremented in the actors list
		
		Actor[] actorArray=this.getActors();
		NameComparator nameComparator = new NameComparator();
	
		for(int k=0;k<temp.length;k++){
			for(int j=0;j<actorArray.length;j++){
				if(nameComparator.compare(temp[k],actorArray[j])==0){
					System.out.println(actorArray[j].getName());
					actors.get(j).setCount((actors.get(j).getCount())-1);
					if(actors.get(j).getCount()==0){
						actors.remove(j);
					}
				}
			}
		}
	}catch(Exception f){
		System.out.println("Movie not found");

	}
	
	}
	
	
	/**
	 * @param e is an intialized actor 
	 * this will add the actor to the actor array if not found in the array. If already in the array, the actor's count will be increased
	 */
	public void addActor(Actor e){
		
		//declare a actor comparator
		NameComparator nameComparator = new NameComparator();
		Actor[] actorArray=this.getActors();
		
		for(int i=0;i<actorArray.length;i++){
			if(nameComparator.compare(actorArray[i], e)==0){
				actors.get(i).setCount(actorArray[i].getCount()+1);
				return;
			}
		}

		
		//if the list was incremented through and the actor was not found then we will add
		//the actor to the list
		e.setCount(1);
		actors.add(e);
	}
	
	
	
	//getters
	/**
	 * @return array of movie
	 */
	public Movie[] getMovies(){
	Movie[] movieArray = new Movie[movies.size()];
		
		movies.toArray(movieArray);
		return movieArray;	
	}
	
	/**
	 * @return array of actors
	 */
	public Actor[] getActors(){
		
		Actor[] actorArray = new Actor[actors.size()];
		
		actors.toArray(actorArray);
		return actorArray;	
	}
	
	
	/**
	 * @return List of actors
	 */
	public List<Actor> getActorsList(){
		return actors;
	}
	
	/**
	 * @return List of Movies
	 */
	public List<Movie> getMoviesList(){
		return movies;
	}
	
	/**
	 * @param comp a comparator object that is declared with with the desired sorting class that extends Comparator
	 * @return movies sorted
	 */
	public List<Movie> getSortedMovies(Comparator comp){
		return movies;
	}
	
	/**
	 * @param comp a comparator object that is declared with with the desired sorting class that extends Comparator
	 * @return actors sorted
	 */
	public List<Actor> getSortedActors(Comparator comp){
		return actors;
	}
	
}
