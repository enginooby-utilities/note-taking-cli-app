package mainpack;
public class Note extends Format {
	private String content;

	// CONSTRUCTOR 
	public Note(int idFormat, String header, String timeCreated, String content) {
		super(idFormat, header, timeCreated);
		this.content = content;
	}

	//ADD CONTENT METHOD
	public void addContent(String add) {
		content += add;
	}
	
	//GETTER-SETTER
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
