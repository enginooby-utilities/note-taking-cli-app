package strategies;

import mainpack.Checklist;
import mainpack.Global;

public class ContentItemAdd implements ContentEditStrategy {
	public void action() {
		System.out.print("Add item name: ");
		//String something = input.nextLine();
		String itemName = input.nextLine();
		System.out.println("(1) Checked");
		System.out.println("(2) Unchecked");
		int option1 = input.nextInt();
		boolean isChecked = false;
		if (option1 == 1) {
			isChecked = true;
		} else
			isChecked = false;
		((Checklist) Global.currentFormat).addItem(itemName, isChecked);
	}
}
