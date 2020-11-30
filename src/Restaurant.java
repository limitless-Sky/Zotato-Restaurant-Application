import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant implements RewardPoint {
	Scanner s;
	final String name;
	final String address;
	String res_type;
	int item_no = 0;
	int no_order_taken=0;
	ArrayList<FoodItem> allItem;
	private int res_reward_point = 0;
	protected int res_discount = 0;
	public RestaurantTask res_task;

	public Restaurant(String nn, String add, Scanner s) {
		this.allItem = new ArrayList<>();
		this.name = nn;
		this.address = add;
	}

	public void setResDis(int nn) {
		this.res_discount = nn;
	}

	public void setResRewardPoint(int nn) {
		this.res_reward_point += nn;
	}

	@Override
	public void rewards() {
		System.out.println("Reward Points: - " + this.res_reward_point);
	}

	public void resMain() {
		System.out.println("   " + this.name + ", " + this.address + ", " + this.no_order_taken);
	}
}

class simpleRest extends Restaurant {
	public simpleRest(String nn, String add, Scanner s) {
		super(nn, add, s);
		this.res_type = "Simple";
		this.res_task = new RestaurantTask(this, s);
	}

	public void setResDis(int nn) {
		System.out.println("Only Special category restaurent provide discount on overall bill");
	}
}

class fastFoodRest extends Restaurant {

	public fastFoodRest(String nn, String add, Scanner s) {
		super(nn, add, s);
		this.res_task = new RestaurantTask(this, s);
		this.res_type = "FastFood";
	}

	public int getResDis() {
		return this.res_discount;
	}
}

class authenticRest extends Restaurant {

	public authenticRest(String nn, String add, Scanner s) {
		super(nn, add, s);
		this.res_task = new RestaurantTask(this, s);
		this.res_type = "Authentic";
	}

	public int getResDis() {
		return this.res_discount;
	}
}
