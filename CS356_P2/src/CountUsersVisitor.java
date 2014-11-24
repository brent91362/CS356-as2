
public class CountUsersVisitor implements Visitor{
	private int counter =0;
	@Override
	public void visitUser(User users) {
		setCounter(getCounter()+1);
	}

	@Override
	public void visitGroup(Group group) {
		
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
