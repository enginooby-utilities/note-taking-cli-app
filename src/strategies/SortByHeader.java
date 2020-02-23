package strategies;
import java.util.Comparator;

import mainpack.Format;

public class SortByHeader implements Comparator<Format> {
	public int compare(Format a, Format b) {
		return a.getHeader().compareTo(b.getHeader());
	}
}
