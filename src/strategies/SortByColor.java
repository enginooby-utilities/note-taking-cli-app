package strategies;
import java.util.Comparator;
import mainpack.Enumerations;

import mainpack.Format;
public class SortByColor implements Comparator<Format> {
	public int compare(Format a, Format b) {
		return a.getColor().compareTo(b.getColor());
	}
}
