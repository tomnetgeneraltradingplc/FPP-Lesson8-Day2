package Problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
	
	 public static List<Marketing> listMoreThan1000(List<Marketing> list) {
		 List<Marketing> temp = new ArrayList();
		 for (Marketing marketing : list) {
		 if (marketing.getSalesamount() >= 1000) {
		 temp.add(marketing);
		 }
		 }
		 return temp;
		 }

	 public static void main(String[] args) {
	 ArrayList<Marketing> list = new ArrayList();
	 list.add(new Marketing("Thomas", "HeadPhone", 50000));
	 list.add(new Marketing("Henok", "Smart Phone", 30000));
	 list.add(new Marketing("Betty", "Laptop", 90000));
	 list.add(new Marketing("Habtamu", "Memory", 200));
	 list.add(new Marketing("Solomon", "Screen", 500));
	 list.add(new Marketing("Mekonen", "TV", 80000));
	 System.out.println("Marketing List");
	 System.out.println(list);
	 System.out.println("_________________________________\n");
	 list.remove(list.get(2));
	 System.out.println("After remove");
	 System.out.println(list);
	 System.out.println("_________________________________\n");
	 list.get(1).setProductname("Speacker");
	 System.out.println("Size : " +list.size() );
	 System.out.println("_________________________________\n");
	 System.out.println("Order by Sales Amount");
	 Collections.sort(list, new SalesComparator());
	 System.out.println(list);
	 System.out.println("_________________________________\n");
	 System.out.println("Order by Name and list More Than 1000 sales amount ");
	  List<Marketing> list1 = listMoreThan1000(list);
	 Collections.sort(list1, new NameComparator());
	 System.out.println(list1);
	 System.out.println("_________________________________\n");
	 }
	}
/*Output
 * Marketing List
[Thomas HeadPhone 50000.0, Henok Smart Phone 30000.0, Betty Laptop 90000.0, Habtamu Memory 200.0, Solomon Screen 500.0, Mekonen TV 80000.0]
_________________________________

After remove
[Thomas HeadPhone 50000.0, Henok Smart Phone 30000.0, Habtamu Memory 200.0, Solomon Screen 500.0, Mekonen TV 80000.0]
_________________________________

Size : 5
_________________________________

Order by Sales Amount
[Habtamu Memory 200.0, Solomon Screen 500.0, Henok Speacker 30000.0, Thomas HeadPhone 50000.0, Mekonen TV 80000.0]
_________________________________

Order by Name and list More Than 1000 sales amount 
[Henok Speacker 30000.0, Mekonen TV 80000.0, Thomas HeadPhone 50000.0]
_________________________________

*/
