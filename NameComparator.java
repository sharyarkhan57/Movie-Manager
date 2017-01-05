//Sharyar Khan 				id: 110677446			HW 7

import java.util.Comparator;

public class NameComparator implements Comparator<Actor>{


	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * This method overrides the compare method and returns a specific int depending on whether  actor 1 is
	 * equal to the actor 2, larger than actor 2 (alphabetically) or smaller than actor 2
	 */
	@Override
	public int compare(Actor o1, Actor o2) {
		// TODO Auto-generated method stub
		Actor e1 = (Actor) o1;
		Actor e2 = (Actor) o2;
        return (e1.getName().compareTo(e2.getName()));
    }
	

}
