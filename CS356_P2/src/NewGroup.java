import java.util.ArrayList;
import java.util.List;


public class NewGroup implements Group{
	private String name;
	List<Group> groups = new ArrayList<Group>();
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

}
