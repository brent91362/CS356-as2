import java.util.ArrayList;
import java.util.List;


public class User implements visitorElement{
	private String name;
	private Message m;
	private List<Message> feed;
	private List<User> following;
	private List<User> follower;
	public void addMessage(String mess){
		m = new Message(mess, name);
		System.out.print(m.getMessage());
		feed.add(m);
	}
	public Message getMessage(){
		return m;
	}
	public User(String name){
		follower =new ArrayList<User>();
		following =new ArrayList<User>();
		feed =new ArrayList<Message>();
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void addFollower(User user){
		following.add(user);
		user.getFollower().add(this);
		feed.addAll(user.feed);
	}
	public void accept(Visitor v){
		v.visitUser(this);
	}
	public List<User> getFollower() {
		return follower;
	}
	public List<User> getFollowing() {
		return following;
	}
	public void addFollowing(User u) {
		following.add(u);
		
	}
	public List<Message> getFeed(){
		return feed;
	}
	
	
}
