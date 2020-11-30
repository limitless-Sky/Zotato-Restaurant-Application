public class order {
	final String restaurant_name;
	final int itemID;
	String name;
	int price;
	int quantity;
	int item_discount;
	String category;

	public order(String rr, int id, String nn, int price, int q, int itemdis, String cat) {
		this.restaurant_name = rr;
		this.itemID = id;
		this.name = nn;
		this.price = price;
		this.quantity = q;
		this.item_discount = itemdis;
		this.category = cat;
	}

	public void displayInfo() {
		System.out.println(this.itemID + " " + this.restaurant_name + " " + " - " + this.name + " " + this.price + " "
				+ this.quantity + " " + this.item_discount + "% off " + this.category);
	}
}
