import java.util.List;


public interface Group {
	public String getGroupName();
	public void add(Group name);
	public void remove(Group name);
	public void addUser(User name);
	public void removeUser(User name);
	public List<User> getUsers();
	public boolean hasUser(String name);
}
