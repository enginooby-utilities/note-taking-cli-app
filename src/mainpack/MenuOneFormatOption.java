package mainpack;

//options to one format at one time
import strategies.*;
import java.util.*;

public abstract class MenuOneFormatOption extends MenuOneFormatEdit{
	Scanner input = new Scanner(System.in);
	private OneFormatStrategy oneFormatStrategy;
	
	public void oneFormatAction(OneFormatStrategy oneFormatStrategy) {
		this.oneFormatStrategy = oneFormatStrategy;
		oneFormatStrategy.action();
	}
	
	/**************** OPTION MENU ****************/
	public void optionMenu() {	
		while (true) {
			Global.displayAFormat(Global.currentFormat);
			System.out.println("(0) Return");
			System.out.println("(1) Edit");
			System.out.println("(2) Pin on top");
			System.out.println("(3) Set reminder");
			System.out.println("(4) Import");
			if (Global.isVerified) {
				System.out.println("(5) Set to unprivate");
			} else
				System.out.println("(5) Set to private");
			System.out.println("(6) Share");
			System.out.println("(7) Delete");
			System.out.print("Enter a number: ");
			
			int optionOption = input.nextInt();
			if (optionOption == 0)
				break;
			while (optionOption == 1) {
				editMenu();	//including edit menu
				break;
			}
			while (optionOption == 2) {
				oneFormatAction(new OneFormatPin());
				break;
			}
			while (optionOption == 3) {
				oneFormatAction(new OneFormatSetReminder());
				break;
			}
			while (optionOption == 4) {
				oneFormatAction(new OneFormatImport());
				break;
			}
			while (optionOption == 5) {
				oneFormatAction(new OneFormatSwitchPrivacy());
				return;

			}
			while (optionOption == 6) {
				oneFormatAction(new OneFormatShare());
				break;
			}
			while (optionOption == 7) {
				oneFormatAction(new OneFormatDelete());
				return;
			}
		}
	}	
}
