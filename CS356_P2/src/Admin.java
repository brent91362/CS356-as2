import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;


@SuppressWarnings("serial")
public class Admin extends JFrame implements visitorElement {
	private Group root;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textGroup;
	private List<Message> rootFeed;

	/**
	 * Create the frame.
	 */
	public List<User> getRootUsers(){
		return root.getUsers();
	}
	public User getFromRoot(String name){
		for(User u:root.getUsers()){
			if(u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}
	private static Admin instance;
	public static Admin getInstance(){
		if(instance == null){
			instance = new Admin();
		}
		return instance;
	}
	public void addToFeed(Message m){
		if(rootFeed==null){
			rootFeed = new ArrayList<Message>();
		}
		rootFeed.add(m);
	}
	private Admin() {
		root = new NewGroup("Root");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int h = 100, width =500, height =350;
		setBounds(h, h, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
			}
		));
		JButton btnAddUser = new JButton("Button - Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textUser.getText();
				if(root.hasUser(text)||!text.equals("")){
					User user = new User(text);
					root.addUser(user);	
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if (node == null){}
					else{Object nodeInfo = node.getUserObject();
				    for(Group g:root.allgroups()){
				    	if(g.getGroupName().equals(nodeInfo.toString())){
				    		g.addUser(user);
				    		treeSet(tree, user, g);
				    	}
				    }}
					treeSet(tree, user);				
				}
				
				textUser.setText("");
			}
		});
		
		
		JButton btnAddGroup = new JButton("Button - Add Group");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Group group = new NewGroup(textGroup.getText());
				root.add(group);
				treeSet(tree, group);
			}
		});
		
		JButton btnShowGroup = new JButton("Group Total");
		btnShowGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountGroupVisitor count=new CountGroupVisitor();
				instance.accept(count);
				System.out.println(count.getCounter());
			}
		});
		
		JButton btnShowPos = new JButton("Positive Percentage");
		btnShowPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountMessageVisitor count=new CountMessageVisitor();
				instance.accept(count);
				System.out.println(count.getPosCounter());
			}
		});
		
		JButton btnShowUser = new JButton("User Total");
		btnShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountUsersVisitor count=new CountUsersVisitor();
				instance.accept(count);
				System.out.println(count.getCounter());
				
			}
		});
		
		JButton btnShowMess = new JButton("Messages Total");
		btnShowMess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountMessageVisitor count=new CountMessageVisitor();
				instance.accept(count);
				System.out.println(count.getCounter());
			}
		});
		
		textUser = new JTextField();
		textUser.setText("TextArea - User ID");
		textUser.setColumns(10);
		
		textGroup = new JTextField();
		textGroup.setText("TextArea - Group Id");
		textGroup.setColumns(10);
		
		JButton btnView = new JButton("View User");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						if (node != null){
							Object nodeInfo = node.getUserObject();
							for(User u:root.getUsers()){
								if(u.getName().equals(nodeInfo.toString())){
									try {
										new Component(u);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				});
			}
		});
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		User u = null;
		treeSet(tree, u);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnShowUser, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowPos, GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnShowMess, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnShowGroup, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(btnView, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnView, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShowUser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowPos, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShowMess, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowGroup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(71))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void treeSet(JTree tree, User u){
		if(u!=null){
			DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
			DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)model.getRoot();
			rootNode.add(new DefaultMutableTreeNode(u.getName()));
			model.reload();
		}
	}
	public void treeSet(JTree tree, Group g){
		if(g!=null){
			DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
			DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)model.getRoot();
			rootNode.add(new DefaultMutableTreeNode(g.getGroupName()));
			model.reload();
		}
	}
	public void treeSet(JTree tree, User u,Group g){
		if(g!=null){
			DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
			DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)model.getRoot();
			rootNode.add(new DefaultMutableTreeNode(g.getGroupName()));
			model.reload();
		}
	}
	@Override
	public void accept(Visitor v) {
		v.visitGroup(root);
		for(User u:root.getUsers()){
			v.visitUser(u);
		}
		if(rootFeed!=null){
			for(Message m : rootFeed){
				v.visistUserNews(m);
			}
		}
		
	}
	
}
