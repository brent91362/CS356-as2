import java.util.List;


public interface Visitor {
	public void visitUser(User users);
	public void visitGroup(Group group);
	public void visistUserNews(Message message);
}
