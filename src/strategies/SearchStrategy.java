package strategies;

import java.util.Scanner;

public interface SearchStrategy {
	Scanner input = new Scanner(System.in);

	public abstract void action();
}
