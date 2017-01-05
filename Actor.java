//Sharyar Khan 				id: 110677446			HW 7

/**
 * This is the actor class. It stores all parameters for an Actor including name and film count.
 * This class is used to create a list of actors that have acted in a particular movie
 * @author Sharyar
 *
 */
public class Actor {


	private String name;
	private int count;
	
	
	/**
	 * @param name Takes the actual name of the Actor (First And Last) as a string and sets it as
	 * the classes name
	 */
	public Actor(String name){
	this.name=name;
	}
	
	
	//getters
	/**
	 * @return returns the name of the actor
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @return returns the amount of movies that the actor has been in
	 */
	public int getCount() {
		return count;
	}
	
	

	//setters
	
	/**
	 * @param name Allows the name of the actor to be changed (never used)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @param count takes an int that holds the amount of movies the actor has acted int
	 * this method is called when a movie is deleted and the actor's film must be decremented or
	 * called when the actor is found again and needs his count incremented
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
		
}
