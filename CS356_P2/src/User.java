import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class User implements visitorElement{
	private final long creationtime;
	private long lastUpdate=0;
	private String name;
	private Message m;
	private List<Message> feed;
	private List<User> following;
	private List<User> follower;
	
	public User(String name){
		creationtime = System.currentTimeMillis();
		follower =new ArrayList<User>();
		following =new ArrayList<User>();
		feed =new ArrayList<Message>();
		this.name=name;
	}
	public void addMessage(String mess){
		m = new Message(mess, name);
		feed.add(m);
		tellFollowing();
		lastUpdate=System.currentTimeMillis();
	}
	//gets time for last message added
	public long getLast(){
		return lastUpdate;
	}
	//tells followers message and add to their feed
	public void tellFollowing(){
		for(User u: following){
			u.update(this);
		}
	}
	//gets message user posted
	public Message getMessage(){
		return m;
	}
	
	public long getTime(){
		return creationtime;
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
	public void update(User u) {
		feed.add(u.getMessage());
	}
	
	
}
