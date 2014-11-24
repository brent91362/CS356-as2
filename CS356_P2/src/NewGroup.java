import java.util.ArrayList;
import java.util.List;


public class NewGroup implements Group, visitorElement{
	private String name;
	List<Group> groups = new ArrayList<Group>();
	List<User> users = new ArrayList<User>();
	public NewGroup(String name) {
		this.name=name;
	}

	@Override
	public String getGroupName() {
		return name;
	}

	@Override
	public void add(Group name) {
		groups.add(name);		
	}

	@Override
	public void remove(Group name) {
		int index =0;
		for(Group i:groups){
			if(i.equals(name)){
				groups.remove(index);
				return;
			}
			index++;
		}
		
	}

	@Override
	public void addUser(User name) {
		users.add(name);
	}

	@Override
	public void removeUser(User name) {
		users.remove(name);
		
	}
	public boolean hasUser(String name){
		for(int i=0; i<users.size();i++){
			if(users.get(i).getName().equals(name)){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public List<Group> allgroups() {
		return groups;
	}

	@Override
	public void accept(Visitor v) {
		v.visitGroup(this);
		
	}

}
