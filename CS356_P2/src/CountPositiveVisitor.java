
public class CountPositiveVisitor implements Visitor {
	private int positiveCounter=0;
	@Override
	public void visitUser(User users) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visistUserNews(News news) {
		for(String message:news.getNews()){
			if(message.contains("good")){
				setPositiveCounter(getPositiveCounter() + 1);
			}
		}

	}

	public int getPositiveCounter() {
		return positiveCounter;
	}

	public void setPositiveCounter(int positiveCounter) {
		this.positiveCounter = positiveCounter;
	}

}
