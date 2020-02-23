package strategies;

import java.util.Scanner;

public interface OneFormatStrategy {
	Scanner input = new Scanner(System.in);

	public abstract void action();
}
