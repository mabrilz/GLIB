package enums;

public enum Profile {

	Reader("Lector");
	
	private String name;
	
	Profile(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
}
