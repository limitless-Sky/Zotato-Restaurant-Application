public class FoodItem {
	final String restaurant_name;
	final int itemID;
	private String name;
	private int price;
	private int quantity;
	private int item_discount;
	private String category;

	public FoodItem(String nn, int id) {
		this.restaurant_name = nn;
		this.itemID = id;
	}

	public void setName(String nn) {
		this.name = nn;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(int nn) {
		this.price = nn;
	}

	public int getPrice() {
		return this.price;
	}

	public void setQuantity(int nn) {
		this.quantity = nn;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setItemDiscount(int nn) {
		this.item_discount = nn;
	}

	public int getItemDiscount() {
		return this.item_discount;
	}

	public void setCategory(String nn) {
		this.category = nn;
	}

	public String getCategory() {
		return this.category;
	}

	public void displayInfo() {
		System.out.println(this.itemID + " " + this.restaurant_name + " " + " - " + this.name + " " + this.price + " "
				+ this.quantity + " " + this.item_discount + "% off " + this.category);
	}
}
