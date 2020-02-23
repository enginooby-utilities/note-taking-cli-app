package strategies;
import mainpack.Global;

public class PinCreate implements PinStrategy {
	public void action() {

		if (Global.pin != 0) {
			System.out.println("PIN has been created!");
			return;
		} else {
			System.out.println("\r\n-----CREATE A PIN-----");
			System.out.println("This number will help you keep your deepest secrets in private formats!");
			System.out.println("(0) Return");
			System.out.print("Enter a number: ");
			int aPin = input.nextInt();
			if (aPin == 0)
				return; // terminate the method
			else {
				Global.pin = aPin;
				System.out.println("PIN created!");
			}
		}
	}
}
