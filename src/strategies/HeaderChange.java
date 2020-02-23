package strategies;

import mainpack.Global;

public class HeaderChange implements HeaderEditStrategy {
public void action() {
	System.out.print("Enter new header: ");
	//String something = input.nextLine();
	String newHeader = input.nextLine();
	Global.currentFormat.setHeader(newHeader);
}
}
