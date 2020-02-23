package strategies;

import mainpack.Global;

public class PinChange implements PinStrategy {
	public void action() {
		if (Global.pin == 0) {
			System.out.println("PIN hasn't been created!");
			return;
		} else {
			System.out.println("\r\n-----CHANGE PIN-----");
			System.out.print("Enter old PIN: ");
			int oldPin = input.nextInt();
			while (oldPin != Global.pin) {
				System.out.println("(0) Return");
				System.out.print("Wrong PIN! Try again: ");
				oldPin = input.nextInt();
				if (oldPin == 0)
					return;
			}
			System.out.print("Enter new PIN: ");
			int newPin = input.nextInt();
			Global.pin = newPin;
		}

	}
}
