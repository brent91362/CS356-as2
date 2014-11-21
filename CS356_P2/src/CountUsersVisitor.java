
public class CountUsersVisitor implements Visitor{
	private int userCount=0;
	@Override
	public void visitUser(User users) {
		setUserCount(users.getFollowing().size());
	}

	@Override
	public void visitGroup(Group group) {
	}

	@Override
	public void visistUserNews(News news) {
		
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	

}
