import java.util.Scanner;

public class CustomerTask {
	Customer cus;
	Scanner s;

	public CustomerTask(Customer cus, Scanner s) {
		this.cus = cus;
		this.s = s;
	}

	public void show() {
		System.out.println("Welcome " + this.cus.name);
		System.out.println("Customer Menu");
		System.out.println("   1) Select Restaurant");
		System.out.println("   2) checkout cart");
		System.out.println("   3) Reward won");
		System.out.println("   4) print the recent orders");
		System.out.println("   5) Exit");
	}

	public void selectRes(Restaurant[] rec_res) {
		System.out.println("Choose Restaurant");
		System.out.println("1) Shah (Authentic)");
		System.out.println("2) Ravi’s");
		System.out.println("3) The Chinese (Authentic)");
		System.out.println("4) Wang’s (Fast Food)");
		System.out.println("5) Paradise");
		int selected_res = s.nextInt();
		cus.setresID(selected_res);
		System.out.println("Choose item by code");
		for (FoodItem fi : rec_res[selected_res].allItem)
			fi.displayInfo();
		int sel_food_id = s.nextInt();
		System.out.println("Enter item quantity -");
		int food_quantity = s.nextInt();
		FoodItem sel = rec_res[selected_res].allItem.get(sel_food_id - 1);
		sel.setQuantity(sel.getQuantity() - food_quantity);
		cus.CartOrder.add(new order(rec_res[selected_res].name, sel_food_id, sel.getName(), sel.getPrice(),
				food_quantity, sel.getItemDiscount(), sel.getCategory()));
		System.out.println("Items added to cart");
	}

	public void checkOut(Restaurant[] rec_res, double[] zt) {
		float cost = 0;
		int count = 0;
		System.out.println("Items in Cart -");
		for (order fi : cus.CartOrder) {
			fi.displayInfo();
			count += fi.quantity;
			float tcost = fi.price * fi.quantity;
			float pdis = (tcost * fi.item_discount) / 100;
			cost += tcost - pdis;
		}

		float bill = this.calc(rec_res, cost);

		if (cus.cus_type.equals("Special")) {
			cus.setDeliveryCharge(20);
			zt[1] += 20;
			bill+=20;
		} else if (cus.cus_type.equals("Elite")) {
			cus.setDeliveryCharge(0);
			zt[1] += 0;
		} else {
			cus.setDeliveryCharge(40);
			zt[1] += 40;
			bill+=40;
		}

		System.out.println("Delivery charge - " + cus.delivery_charge + "/-");
		System.out.println("Total order value - " + bill + "/-");
		float dif = cus.cus_reward_point - bill;
		int actual=0;
		if (dif >= 0)
			cus.cus_reward_point -= bill;
		else {
			actual=cus.cus_reward_point;
			cus.cus_reward_point = 0;
			cus.wallet += dif;
		}
		System.out.println("   1) Proceed to checkout");
		s.nextInt();
		if (cus.wallet > 0)
			System.out.println(count + " items successfully bought for INR " + bill + "/-");
		else {
			while (cus.wallet < 0) {
				cost=0;
				cus.cus_reward_point += actual;
				cus.wallet -= dif;
				System.out.println("Insufficient Balance");
				System.out.println("Delete items from cart");
				for (order fi : cus.CartOrder)
					fi.displayInfo();
				System.out.println("Enter Item Code to be Deleted");
				int del_item_Id = s.nextInt();
				count-=0;
				cus.CartOrder.remove(del_item_Id - 1);
				System.out.println("Items in Cart -");
				for (order fi : cus.CartOrder) {
					fi.displayInfo();
					count += fi.quantity;
					float tcost = fi.price * fi.quantity;
					float pdis = (tcost * fi.item_discount) / 100;
					cost += tcost - pdis;
				}
				bill = this.calc(rec_res, cost);
				dif = cus.cus_reward_point - bill;
				actual=cus.cus_reward_point;
				cus.cus_reward_point = 0;
				cus.wallet += dif;
			}
			System.out.println(count + " items successfully bought for INR " + bill + "/-");
		}

		zt[0] += (bill * 1) / 100;
		rec_res[cus.getresID()].no_order_taken+=1;

		dif = 0 - dif;
		int gain_reward;
		if (rec_res[cus.getresID()].res_type.equals("FastFood"))
			gain_reward = (10 * (int) (dif / 150));
		else if (rec_res[cus.getresID()].res_type.equals("Authentic"))
			gain_reward = (25 * (int) (dif / 200));
		else
			gain_reward = (5 * (int) (dif / 100));

		cus.cus_reward_point += gain_reward;
		rec_res[cus.getresID()].setResRewardPoint(gain_reward);
	}

	public void printReward() {
		System.out.println("Total Rewards - " + cus.cus_reward_point);
	}

	public void recentOrder() {
		int counter = 0;
		if (cus.CartOrder.size() >=10)
			counter = cus.CartOrder.size()-10;
		for (int i = cus.CartOrder.size()-1; i >= counter; i--)
			cus.CartOrder.get(i).displayInfo();
	}

	private float calc(Restaurant[] rec_res, float cost) {
		if (rec_res[cus.getresID()].res_type.equals("FastFood")) {
			float tdis = (cost * rec_res[cus.getresID()].res_discount) / 100;
			cost -= tdis;
		}
		if (rec_res[cus.getresID()].res_type.equals("Authentic")) {
			float tdis = (cost * rec_res[cus.getresID()].res_discount) / 100;
			cost -= tdis;
			if (cost > 100)
				cost -= 50;
		}

		if (cus.cus_type.equals("Elite")) {
			if (cost > 200)
				cost -= 50;
		}
		if (cus.cus_type.equals("Special")) {
			if (cost > 200)
				cost -= 25;
		}
		return cost;
	}
}
