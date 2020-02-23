package strategies;

import mainpack.Global;
import mainpack.MenuAllFormatOption;

public class ViewUnprivateFormat extends MenuAllFormatOption implements ViewStrategy {
	public void action() {

		while (true) {
			/**************** VIEW FORMATS MENU ****************/
			System.out.println("\r\n------VIEW FORMATS------"); // including Select Menu, Search Menu, Arrange Menu
			Global.displayFormat2();
			System.out.println("(0) Return");
			System.out.println("(1) Select a format");
			System.out.println("(2) Search");
			System.out.println("(3) Arrange");
			System.out.print("Enter a number: ");
			int option = input.nextInt();
			if (option == 0) {
				Global.isVerified = false;
				break;
			}
			while (option == 1) {
				selectMenu();
				break;
			}
			while (option == 2) {
				searchMenu();
				break;
			}
			while (option == 3) {
				arrangeMenu();
				break;
			}
		}
	}
}
