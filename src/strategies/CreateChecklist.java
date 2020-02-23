package strategies;

import java.time.LocalDateTime;
import java.util.Scanner;

import mainpack.Checklist;
import mainpack.Global;

public class CreateChecklist implements CreateStrategy {
	public void create() {
		Scanner input = new Scanner(System.in);
		System.out.println("\r\n------CREATE A CHECKLIST------");
		String something = input.nextLine();
		System.out.print("Enter header: ");
		String header = input.nextLine();
		LocalDateTime now = LocalDateTime.now();
		Checklist newChecklist = new Checklist(Global.countFormatId++, header, formatTime.format(now));
		Global.formatList.add(newChecklist);
		while (true) {
			System.out.println("\r\n-----CHECKLIST CREATING-----");
			System.out.println("(1) Add item");
			System.out.println("(2) Save");
			int option = input.nextInt();
			if (option == 2)
				break;
			System.out.print("Enter item: ");
			String something1 = input.nextLine();
			String itemName = input.nextLine();
			System.out.println("(1) Checked");
			System.out.println("(2) Unchecked");
			int option1 = input.nextInt();
			boolean isChecked = false;
			if (option1 == 1) {
				isChecked = true;
			} else
				isChecked = false;
			newChecklist.addItem(itemName, isChecked);
		}

	}
}