import java.util.Scanner;

public class RestaurantTask {
	Restaurant res;
	Scanner s;

	public RestaurantTask(Restaurant res, Scanner s) {
		this.res = res;
		this.s = s;
	}

	public void show() {
		System.out.println("Welcome " + this.res.name);
		System.out.println("   1) Add item");
		System.out.println("   2) Edit item");
		System.out.println("   3) Print Rewards");
		System.out.println("   4) Discount on bill value");
		System.out.println("   5) Exit");
	}

	public void addItem() {
		FoodItem fi = new FoodItem(res.name, res.item_no + 1);
		System.out.println("Enter food item details");
		System.out.println("Food name:");
		s.nextLine();
		fi.setName(s.nextLine());
		System.out.println("item price:");
		fi.setPrice(s.nextInt());
		System.out.println("item quantity:");
		fi.setQuantity(s.nextInt());
		System.out.println("item category:");
		s.nextLine();
		fi.setCategory(s.nextLine());
		System.out.println("Offer:");
		fi.setItemDiscount(s.nextInt());
		res.allItem.add(res.item_no, fi);
		System.out.println(fi.itemID + " " + fi.getName() + " " + fi.getPrice() + " " + fi.getQuantity() + " "
				+ fi.getItemDiscount() + "% off " + fi.getCategory());
		res.item_no += 1;
	}

	public void editItem() {
		System.out.println("Choose item by code");
		for (FoodItem fi : res.allItem)
			fi.displayInfo();
		int item_edit_id = s.nextInt();
		System.out.println("Choose an attribute to edit:");
		System.out.println("   1) Name");
		System.out.println("   2) Price");
		System.out.println("   3) Quantity");
		System.out.println("   4) Category");
		System.out.println("   5) Offer");
		int query = s.nextInt();
		switch (query) {
		case 1:
			System.out.print("Enter the new name - ");
			s.nextLine();
			res.allItem.get(item_edit_id - 1).setName(s.nextLine());
			break;
		case 2:
			System.out.print("Enter the new price - ");
			res.allItem.get(item_edit_id - 1).setPrice(s.nextInt());
			break;
		case 3:
			System.out.print("Enter the new quantity - ");
			res.allItem.get(item_edit_id - 1).setQuantity(s.nextInt());
			break;
		case 4:
			System.out.print("Enter the new category - ");
			s.nextLine();
			res.allItem.get(item_edit_id - 1).setCategory(s.nextLine());
			break;
		case 5:
			System.out.print("Enter the new offer - ");
			res.allItem.get(item_edit_id - 1).setItemDiscount(s.nextInt());
			break;
		}
		res.allItem.get(item_edit_id - 1).displayInfo();
	}

	public void showRewards() {
		res.rewards();
	}

	public void overall_dis() {
		System.out.print("Enter offer on total bill value - ");
		res.setResDis(s.nextInt());
	}
}
