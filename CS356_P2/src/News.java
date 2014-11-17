import java.util.List;


public abstract class News {
	private List<String> news;
	public List<String> update(){
		return news;
	}
	public void addFeed(String news){
		this.news.add(news);
	}
}
