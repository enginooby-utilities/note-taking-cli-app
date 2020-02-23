package strategies;

import mainpack.Global;

public class HeaderAdd implements HeaderEditStrategy {
	public void action() {
		System.out.print("Add to header: ");
		// String something = input.nextLine();
		String addHeader = input.nextLine();
		Global.currentFormat.setHeader(Global.currentFormat.getHeader() + addHeader);
	}
}
