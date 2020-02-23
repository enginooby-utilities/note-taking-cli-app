package strategies;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import mainpack.Global;
import mainpack.Note;

public class CreateNote implements CreateStrategy {
public void create() {
	Scanner input = new Scanner(System.in);
	
	
	System.out.println("\r\n-----CREATE A NOTE-----");
	//String something = input.nextLine();
	System.out.print("Enter header: ");
	String header = input.nextLine();
	System.out.print("Enter content: ");
	String content = input.nextLine();
	LocalDateTime now = LocalDateTime.now();  
	Global.formatList.add(new Note(Global.countFormatId++, header,  formatTime.format(now),content));
}
}

