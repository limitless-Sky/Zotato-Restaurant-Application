import java.util.LinkedList;
import java.util.Scanner;

public class Customer {
	final String name;
	final String address;
	String cus_type;
	private int resID;
	public float wallet;
	public int cus_reward_point;
	public LinkedList<order> CartOrder;
	public CustomerTask cus_task;
	protected int delivery_charge = -1;

	public Customer(String nn, String add) {
		this.name = nn;
		this.address = add;
		this.cus_reward_point = 0;
		this.wallet = 1000;
		this.CartOrder = new LinkedList<>();
	}

	public int getresID() {
		return this.resID;
	}

	public void setresID(int mon) {
		this.resID = mon;
	}

	public void setDeliveryCharge(int mon) {
	}

	public void cusMain() {
		System.out.println("   " + this.name + ", " + this.address + ", " + this.wallet + "/-");
	}
}

class simpleCustomer extends Customer {

	public simpleCustomer(String nn, String add, Scanner s) {
		super(nn, add);
		this.cus_type = "Simple";
		delivery_charge = 40;
		this.cus_task = new CustomerTask(this, s);
	}

	public int getDeliveryCharge() {
		return this.delivery_charge;
	}

	public void setDeliveryCharge(int mon) {
		this.delivery_charge = mon;
	}
}

class eliteCustomer extends Customer {

	public eliteCustomer(String nn, String add, Scanner s) {
		super(nn, add);
		this.cus_type = "Elite";
		this.cus_task = new CustomerTask(this, s);
	}

	public int setDeliveryCharge() {
		return this.delivery_charge;
	}

	public void setDeliveryCharge(int mon) {
		this.delivery_charge = mon;
	}
}

class specialCustomer extends Customer {

	public specialCustomer(String nn, String add, Scanner s) {
		super(nn, add);
		this.cus_type = "Special";
		this.cus_task = new CustomerTask(this, s);
	}

	public int setDeliveryCharge() {
		return this.delivery_charge;
	}

	public void setDeliveryCharge(int mon) {
		this.delivery_charge = mon;
	}

}
