package Problem1;
import java.util.Comparator;
public class SalesComparator  implements Comparator<Marketing> {
	 @Override
	 public int compare(Marketing o1, Marketing o2) {
		 Double x1 = o1.getSalesamount();
		 Double x2 = o2.getSalesamount();
		 String s1 = o1.getEmployeename();
		 String s2 = o2.getEmployeename();
		 String p1 = o1.getProductname();
		 String p2 = o2.getProductname();
	      if(x1.compareTo(x2)!=0)
		        return x1.compareTo(x2);
	      else if(s1.compareTo(s2)!=0)
	    	  return s1.compareTo(s2);
	      else 
	    	  return p1.compareTo(p2);
	 }
}
