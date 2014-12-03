import java.util.ArrayList;
import java.util.List;


public class User implements visitorElement, Observer{
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
		notifyFollowing();
		lastUpdate=System.currentTimeMillis();
	}
	//gets time for last message added
	public long getLast(){
		return lastUpdate;
	}
	//tells followers message and add to their feed
	public void notifyFollowing(){
		for(User u: follower){
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
		follower.add(user);
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
		if(u.getMessage()==null){
			return;
		}
		feed.add(u.getMessage());
	}
	
	
}
