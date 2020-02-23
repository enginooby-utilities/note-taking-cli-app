package strategies;

import mainpack.Global;
import mainpack.Note;

public class ContentNoteChange implements ContentEditStrategy {
public void action() {
	System.out.print("Enter new content: ");
	//String something = input.nextLine();
	String newContent = input.nextLine();
	((Note) Global.currentFormat).setContent(newContent);
}
}
