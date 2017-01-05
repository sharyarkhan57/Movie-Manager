//Sharyar Khan 				id: 110677446			HW 7

import java.util.Comparator;

public class CountComparator implements Comparator<Actor>{
	
	/*
	* This method overrides the compare method and returns a specific int depending on whether  actor 1's count is
	 * equal to the actor 2's count, larger than actor 2's count (alphabetically) or smaller than actor 2's count
	 */
	@Override
	public int compare(Actor o1, Actor o2) {
			if(o1.getCount() == o2.getCount()){
				return 0;
			}
			else if(o1.getCount() > o2.getCount()){
				return 1;
			}
			else if(o1.getCount() < o2.getCount()){
				return -1;
			}
			
			return 0;
		}
	
}
