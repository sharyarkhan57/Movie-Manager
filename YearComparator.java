//Sharyar Khan 				id: 110677446			HW 7

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * This method overrides the compare method and returns a specific int depending on whether  movie 1 is
	 * equal to the movie 2, larger than movie 2 (alphabetically) or smaller than movie 2
	 */
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getYear() == o2.getYear()){
			return 0;
		}
		else if(o1.getYear() > o2.getYear()){
			return 1;
		}
		else if(o1.getYear() < o2.getYear()) {
			return -1;
		}
		
		
		
		return 0;
	}
}

