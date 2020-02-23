package strategies;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface UserStrategy {
	Scanner input = new Scanner(System.in);
	DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
public abstract void action();
}
