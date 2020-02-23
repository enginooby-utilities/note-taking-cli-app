package strategies;

import java.util.ArrayList;
import java.util.List;

import mainpack.Checklist;
import mainpack.Format;
import mainpack.Global;
import mainpack.Note;

public class SearchHeader implements SearchStrategy {
	public void action() {
		System.out.print("Enter header to search: ");
		// String skipThis = input.nextLine();
		String word = input.nextLine();
		List<Format> resultList = new ArrayList<Format>();
		List<Format> currentList = new ArrayList<Format>();
		if (!Global.isVerified) {
			currentList = Global.formatList; // search in unprivate list
		} else
			currentList = Global.privateFormatList; // search in private list
		for (Format format : currentList) {
			if (format.getHeader().toLowerCase().contains(word.toLowerCase())) {
				resultList.add(format);
			}
		}
		displayFormatSearch(resultList);
		if (!resultList.isEmpty()) {
			return; // selectMenu();
		}
	}

//DISPLAY ALL FORMATS FOR SEARCH RESULT
	public static void displayFormatSearch(List<Format> list) { // used in searchHeader() and searchContent(), in Search
																// Menu
		if (list.size() != 0) {
			System.out.println("\r\n-----SEARCH RESULTS-----");
			for (Format format : list) {
				switch (format.getColor()) {
				case BLUE:
					System.out.print(Global.BLUE);
					break;
				case GREEN:
					System.out.print(Global.GREEN);
					break;
				case YELLOW:
					System.out.print(Global.YELLOW);
					break;
				}
				System.out.print("+ ID: " + format.getIdFormat() + " - " + format.getClass().getSimpleName()
						+ " - Header: " + format.getHeader() + " - Content: ");
				if (format instanceof Note) {
					System.out.println(((Note) format).getContent());
				} else if (format instanceof Checklist) {
					System.out.println(((Checklist) format).getContent());
				}
				System.out.print(Global.RESET);
			}
		} else {
			System.out.println("No result!");
		}
	}
}
