package strategies;

import java.util.Scanner;

public interface ColorStrategy {
	Scanner input = new Scanner(System.in);

	public abstract void action();
}
