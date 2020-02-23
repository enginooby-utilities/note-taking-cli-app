package strategies;

import java.util.ArrayList;
import java.util.List;

import mainpack.Checklist;
import mainpack.Format;
import mainpack.Global;
import mainpack.Note;

public class SearchContent extends SearchHeader {

	@Override
	public void action() {
		System.out.print("Enter content to search: ");
		//String skipThis = input.nextLine();
		String word = input.nextLine();
		List<Format> resultList = new ArrayList<Format>();
		List<Format> currentList = new ArrayList<Format>();
		if (!Global.isVerified) {
			currentList = Global.formatList; // search in unprivate list
		} else
			currentList = Global.privateFormatList; // search in private list

		for (Format format : currentList) {
			if (format instanceof Note) {
				if (((Note) format).getContent().toLowerCase().contains(word.toLowerCase())) {
					resultList.add(format);
				}
			} else {
				if (((Checklist) format).getItemNameList().toLowerCase().contains(word.toLowerCase())) {
					resultList.add(format);
				}
			}
		}
		displayFormatSearch(resultList);
		if (!resultList.isEmpty()) {
			return; //selectMenu();
		}
	}
}
