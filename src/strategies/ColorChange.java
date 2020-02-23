package strategies;

import mainpack.Enumerations;
import mainpack.Global;

public class ColorChange implements ColorStrategy {
	public void action() {
		System.out.print(Global.YELLOW + "(1)Yellow  " + Global.RESET);
		System.out.print(Global.GREEN + "(2)Green  " + Global.RESET);
		System.out.println(Global.BLUE + "(3)Blue" + Global.RESET);
		System.out.print("Choose color: ");
		int optionColor = input.nextInt();
		switch (optionColor) {
		case 1:
			Global.currentFormat.setColor(Enumerations.Color.YELLOW);
			System.out.println("Changed to yellow!");
			break;
		case 2:
			Global.currentFormat.setColor(Enumerations.Color.GREEN);
			System.out.println("Changed to green!");
			break;
		case 3:
			Global.currentFormat.setColor(Enumerations.Color.BLUE);
			System.out.println("Changed to blue!");
			break;
		}
	}
}
