import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class SortEvenFirst implements Comparator {
	public int compare(Object obj1, Object obj2){
		// Make sure that obj1 & obj2 are Integer
		Integer a = (Integer) obj1;
		Integer b = (Integer) obj2;
		
		// Check if a and b is even or odd
		boolean aIsEven = (a%2) == 0;
		boolean bIsEven = (b%2) == 0;

		if ( aIsEven == bIsEven ) {
			// If both num are even or odd, then just normal sorting 
			if ( a < b ) return -1;
			if ( a > b ) return 1;
			return 0;
		} else {
			// If a is even then it goes first, otherwise b goes first
			if (aIsEven) {
				return -1;
			} else {
				return 1;
			}
		}

	}

}
