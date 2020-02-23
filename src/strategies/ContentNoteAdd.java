package strategies;

import mainpack.Global;
import mainpack.Note;

public class ContentNoteAdd implements ContentEditStrategy {
	public void action() {
		System.out.print("Add content: ");
		// String something = input.nextLine();
		String add = input.nextLine();
		((Note) Global.currentFormat).addContent(add);
	}
}
