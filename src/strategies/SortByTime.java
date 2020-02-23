package strategies;
import java.util.Comparator;

import mainpack.Format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SortByTime implements Comparator<Format> {
	DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
	public int compare(Format a, Format b) {
		LocalDateTime aTime = LocalDateTime.parse(a.getTimeCreated(), formatTime);
		LocalDateTime bTime = LocalDateTime.parse(b.getTimeCreated(), formatTime);
		return aTime.compareTo(bTime);
}
}
