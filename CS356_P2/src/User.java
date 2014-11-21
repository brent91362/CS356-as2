import java.util.ArrayList;
import java.util.List;


public class User {
	private String name;
	private News news;
	private List<User> following=new ArrayList<User>();
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public User(String name){
		this.name=name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void addFollower(User user){
		following.add(user);
	}
	public void accept(Visitor v){
		v.visitUser(this);
	}
	public List<User> getFollowing() {
		return following;
	}
	public void setFollowing(List<User> following) {
		this.following = following;
	}
	
}
