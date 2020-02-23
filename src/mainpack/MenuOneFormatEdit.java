package mainpack;

import java.util.*;

import strategies.*;

public class MenuOneFormatEdit {
	Scanner input = new Scanner(System.in);
	private HeaderEditStrategy headerEditStrategy;
	private ContentEditStrategy contentEditStrategy;
	private ColorStrategy colorStrategy;

	public void headerAction(HeaderEditStrategy headerEditStrategy) {
		this.headerEditStrategy = headerEditStrategy;
		headerEditStrategy.action();
	}
	
	public void contentAction(ContentEditStrategy contentEditStrategy) {
		this.contentEditStrategy = contentEditStrategy;
		contentEditStrategy.action();
	}
	
	public void colorAction(ColorStrategy colorStrategy) {
		this.colorStrategy = colorStrategy;
		colorStrategy.action();
	}

	/**************** EDIT MENU ****************/
	public void editMenu() {
		while (true) {
			Global.displayAFormat(Global.currentFormat);
			System.out.println("(0) Return");
			System.out.println("(1) Change header");
			System.out.println("(2) Add header");
			if (Global.currentFormat instanceof Note) {
				System.out.println("(3) Change content");
				System.out.println("(4) Add content");
			} else {
				System.out.println("(3) Delete item");
				System.out.println("(4) Add item");
			}
			System.out.println("(5) Change color");
			System.out.print("Enter a number: ");
			int optionEdit = input.nextInt();
			if (optionEdit == 0)
				break;
			while (optionEdit == 1) {
				headerAction(new HeaderChange());
				break;
			}
			while (optionEdit == 2) {
				headerAction(new HeaderAdd());
				break;
			}
			while (optionEdit == 3) {
				if (Global.currentFormat instanceof Note) {
					contentAction(new ContentNoteChange());
					break;
				} else {
					contentAction(new ContentItemDelete());
					break;
				}
			}
			while (optionEdit == 4) {
				if (Global.currentFormat instanceof Note) {
					contentAction(new ContentNoteAdd());
					break;
				} else {
					contentAction(new ContentItemAdd());
					break;
				}
			}
			while (optionEdit == 5) {
				colorAction(new ColorChange());
				break;
			}
		}
	}
}
