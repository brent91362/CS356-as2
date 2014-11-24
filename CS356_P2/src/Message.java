
public class Message implements visitorElement{
	private String message;
	private String user;
	public Message(String mess, String user){
		this.user=user;
		this.message=mess;
	}
	public String getMessage(){
		return message;
	}
	public String getUserName(){
		return user;
	}
	@Override
	public void accept(Visitor v) {
			v.visistUserNews(this);
	}
}
