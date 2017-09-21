package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Marketing {
	private String employeename;
	private String productname;
	private double salesamount;

	public Marketing(String employeename, String productname, double salesamount) {
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(double salesamount) {
		this.salesamount = salesamount;
	}

	@Override
	public String toString() {
		return employeename + " " + productname + " " + salesamount;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = hash + (employeename.hashCode() + employeename.hashCode());
		hash = hash + (productname.hashCode() + productname.hashCode());
		long temp = Double.doubleToLongBits(salesamount);
		hash = hash + (int) (temp ^ (temp >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Marketing other = (Marketing) obj;
		boolean isEqual = employeename.equals(other.employeename) && productname.equals(other.productname)
				&& (salesamount == other.salesamount);
		return isEqual;
	}

	public static List<Marketing> listMoreThan1000(List<Marketing> list) {
		List<Marketing> temp = new ArrayList();
		for (Marketing marketing : list) {
			if (marketing.getSalesamount() >= 1000) {
				temp.add(marketing);
			}
		}
		return temp;
	}
}