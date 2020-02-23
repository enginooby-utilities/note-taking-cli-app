package strategies;

import mainpack.Global;
//import mainpack.AllFormatOption;

public class ViewPrivateFormat extends ViewUnprivateFormat{
	
	@Override
	public void action() {
		System.out.println("\r\n------VERIFY------");
		System.out.print("Enter PIN: ");
		int aPin = input.nextInt();
		while (aPin != Global.pin) {
			System.out.println("(0) Return");
			System.out.println("Wrong PIN! Try again: "); 
			aPin = input.nextInt();
			if (aPin == 0)
				return;
		}
		Global.isVerified = true;
		super.action();
	}
}
