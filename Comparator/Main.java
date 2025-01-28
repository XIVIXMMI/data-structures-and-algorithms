import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		/* ArrayList<Car> myCars =  new ArrayList<Car>();
		myCars.add(new Car("BMW","i8",2023));
		myCars.add(new Car("Porche","911",2022));
		myCars.add(new Car("Honda","NSX",2015));
		myCars.add(new Car("Toyota","Cambry",2025));

		Comparator compare = new SortByYear();
		Collections.sort(myCars, (obj1, obj2) -> {
			Car a = (Car) obj1;
			Car b = (Car) obj2;

			if ( a.year < b.year ) return -1;
			if ( a.year > b.year ) return 1;
			return 0;
		});

		myCars.forEach( (c) -> { System.out.println(c.brand + " " + c.model +" " + c.year); } );
*/
		ArrayList<Integer> myNum = new ArrayList<Integer>();
		myNum.add(14);
		myNum.add(13);
		myNum.add(29);
		myNum.add(30);
		myNum.add(12);
		myNum.add(16);

		Comparator myCompare = new SortEvenFirst();
		Collections.sort(myNum, myCompare);

		myNum.forEach( (n) -> { System.out.println(n); } );
	}
}
