package mainpack;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class Main {
	public static void main(String[] args) {
		
		/******************************** DEMO *********************************/
		DateTimeFormatter getTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		User userDemo = new User("demo", "demo", "demo"); userDemo.setID(123); Global.userList.add(userDemo);
		Note noteDemo = new Note(123, "noteDemo", "2000-10-12 15:00:00", "This is a sentence. Well actually, two!"); Global.formatList.add(noteDemo);
		Note privateDemo = new Note(999, "privateDemo" , getTime.format(now),"My FB password is ***BetYouCouldntSee***"); Global.privateFormatList.add(privateDemo);
		Checklist listDemo = new Checklist(204, "listDemo", "2010-10-12 12:00:00"); listDemo.addItem("item1", false); listDemo.addItem("item2", true); Global.formatList.add(listDemo);
		Note noteDemo2 = new Note(143, "anotherDemo","1990-10-12 16:00:00", "Hello!"); Global.formatList.add(noteDemo2);
		
		System.out.println(Global.RED + "WELCOME TO NOTEPAD" + Global.RESET);
		
		while (true) {
			while (Global.menuState == 1) {
				new Guest().menuGuest();
			}
			while (Global.menuState == 2) {
				new User("", "", "").menuUser();
			}
		} 
	} 
}
