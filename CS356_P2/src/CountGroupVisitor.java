
public class CountGroupVisitor implements Visitor {

	private int counter =0;
	@Override
	public void visitUser(User users) {
	}

	@Override
	public void visitGroup(Group group) {
		setCounter(getCounter()+1);		
	}

	@Override
	public void visistUserNews(Message message) {
		// TODO Auto-generated method stub

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
