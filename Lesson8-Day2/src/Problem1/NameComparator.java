package Problem1;
import java.util.Comparator;
public class NameComparator implements Comparator<Marketing> {
	 @Override
	 public int compare(Marketing o1, Marketing o2) {
		 
		 String s1 = o1.getEmployeename();
		 String s2 = o2.getEmployeename();
		  	  return s1.compareTo(s2);
}
}