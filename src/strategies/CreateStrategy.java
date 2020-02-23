package strategies;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface CreateStrategy {
	DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  

public abstract void create();
}
