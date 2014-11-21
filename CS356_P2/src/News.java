import java.util.List;


public abstract class News {
	private List<String> news;
	public List<String> update(Group following){
		for(User u:following.getUsers()){
			News newNews =  u.getNews();
			if(!news.contains(newNews)){
				news.addAll(newNews.getNews());
			}
		}
		return news;
	}
	public void addFeed(String news){
		this.news.add(news);
	}
	public List<String> getNews(){
		return news;
	}
}
