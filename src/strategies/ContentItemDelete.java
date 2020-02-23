package strategies;

import mainpack.Checklist;
import mainpack.Global;

public class ContentItemDelete implements ContentEditStrategy {
	public void action() {
		System.out.print("Enter item name to delete: ");
		// String something = input.nextLine();
		String itemName = input.nextLine();
		System.out.println();
		Global.displayAFormat(Global.currentFormat);
		System.out.println("delete " + itemName);
		((Checklist) Global.currentFormat).deleteItem(itemName);
	}
}
