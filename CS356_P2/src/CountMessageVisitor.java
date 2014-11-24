
public class CountMessageVisitor implements Visitor {
	private int counter =0;
	private int posCounter =0;
	@Override
	public void visitUser(User users) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visistUserNews(Message message) {
		String pos="good, great, fun, coding";
		setCounter(getCounter()+1);
		if(pos.contains(message.getMessage())){
			setPosCounter(getPosCounter()+1);
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getPosCounter() {
		return posCounter;
	}

	public void setPosCounter(int posCounter) {
		this.posCounter = posCounter;
	}

}
