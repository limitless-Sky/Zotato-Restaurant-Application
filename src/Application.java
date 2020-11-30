import java.util.Scanner;

public class Application {

	static class zotato {
		Restaurant[] rec_res = new Restaurant[6];
		Customer[] rec_cus = new Customer[6];

		double[] zt=new double[2];


		void build(Scanner s) {
			
			rec_res[1] = new authenticRest("Shah (Authentic)", "Delhi", s);
			rec_res[2] = new simpleRest("Ravi's", "Pune", s);
			rec_res[3] = new authenticRest("The Chinese (Authentic)", "Pune", s);
			rec_res[4] = new fastFoodRest("Wang’s (Fast Food)", "Pune", s);
			rec_res[5] = new simpleRest("Paradise", "Delhi", s);

			rec_cus[1] = new eliteCustomer("Ram (Elite)", "Delhi", s);
			rec_cus[2] = new eliteCustomer("Sam (Elite)", "Pune", s);
			rec_cus[3] = new specialCustomer("Tim (Special)", "Delhi", s);
			rec_cus[4] = new simpleCustomer("Kim", "Delhi", s);
			rec_cus[5] = new simpleCustomer("Jim", "Pune", s);

		}

		void query1(Scanner s) {
			int res_choice;
			int res_task_choice;
			System.out.println("Choose Restaurant");
			System.out.println("1) Shah (Authentic)");
			System.out.println("2) Ravi’s");
			System.out.println("3) The Chinese (Authentic)");
			System.out.println("4) Wang’s (Fast Food)");
			System.out.println("5) Paradise");
			res_choice = s.nextInt();

			while (true) {

				rec_res[res_choice].res_task.show();
				res_task_choice = s.nextInt();

				if (res_task_choice == 1)
					rec_res[res_choice].res_task.addItem();

				else if (res_task_choice == 2)
					rec_res[res_choice].res_task.editItem();

				else if (res_task_choice == 3)
					rec_res[res_choice].res_task.showRewards();

				else if (res_task_choice == 4)
					rec_res[res_choice].res_task.overall_dis();

				else
					break;
			}
		}

		void query2(Scanner s) {
			int cus_choice;
			int cus_task_choice;
			System.out.println("Choose Customer");
			System.out.println("1. Ram (Elite)");
			System.out.println("2. Sam (Elite)");
			System.out.println("3. Tim (Special)");
			System.out.println("4. Kim");
			System.out.println("5. Jim");
			cus_choice = s.nextInt();

			while (true) {

				rec_cus[cus_choice].cus_task.show();
				cus_task_choice = s.nextInt();

				if (cus_task_choice == 1)
					rec_cus[cus_choice].cus_task.selectRes(rec_res);

				else if (cus_task_choice == 2)
					rec_cus[cus_choice].cus_task.checkOut(rec_res, zt);

				else if (cus_task_choice == 3)
					rec_cus[cus_choice].cus_task.printReward();

				else if (cus_task_choice == 4)
					rec_cus[cus_choice].cus_task.recentOrder();

				else
					break;
			}
		}

		void query3(Scanner s) {
			System.out.println("1) Customer List");
			System.out.println("2) Restaurant List");
			int val = s.nextInt();
			if (val == 1) {
				System.out.println("1. Ram");
				System.out.println("2. Sam");
				System.out.println("3. Tim");
				System.out.println("4. Kim");
				System.out.println("5. Jim");
				rec_cus[s.nextInt()].cusMain();
			} else {
				System.out.println("1) Shah");
				System.out.println("2) Ravi’s");
				System.out.println("3) The Chinese");
				System.out.println("4) Wang’s");
				System.out.println("5) Paradise");
				rec_res[s.nextInt()].resMain();
			}
		}

		public void query4(Scanner s) {
			String ans=String.format("%.2f", zt[0]);
			System.out.println("Total Company balance - INR " + ans + "/-");
			System.out.println("Total Delivery Charges Collected - INR " + (int)this.zt[1] + "/-");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		zotato user = new zotato();
		user.build(s);
		int inp;
		while (true) {
			System.out.println("Welcome to Zotato:");
			System.out.println("1) Enter as Restaurant Owner");
			System.out.println("2) Enter as Customer");
			System.out.println("3) Check User Details");
			System.out.println("4) Company Account details");
			System.out.println("5) Exit");
			inp = s.nextInt();

			if (inp == 1)
				user.query1(s);
			else if (inp == 2)
				user.query2(s);
			else if (inp == 3)
				user.query3(s);
			else if (inp == 4)
				user.query4(s);
			if (inp == 5)
				break;

		}
		s.close();
	}
}
