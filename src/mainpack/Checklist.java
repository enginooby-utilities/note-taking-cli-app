package mainpack;
import java.util.List;
import java.util.*;

public class Checklist extends Format {
	private List<Item> itemList = new ArrayList<Item>();

	// CONSTRUCTOR
	public Checklist(int idFormat, String header, String timeCreated) {
		super(idFormat, header, timeCreated);
	}
	
	// GET LIST OF ITEM NAME AND ITEM STATE
	public String getContent() {
		String content = "";
		for (Item item : itemList) {
			content += item.getItem();
		}
		return content;
	}
	
	// GET LIST OF ITEM NAME
	public String getItemNameList() {
		String content = "";
		for (Item item : itemList) {
			content += item.getItemName();
		}
		return content;
	}

	// ADD ITEM TO CHECKLIST METHOD
	public void addItem(String itemName, boolean isChecked) {
		itemList.add(new Item(itemName, isChecked));
	}

	// DELETE ITEM BY ITEM NAME
	public void deleteItem(String itemName) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemName().equals(itemName)) {
				itemList.remove(itemList.get(i));
			}
		}
	}

	// GETTER-SETTER
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


}
