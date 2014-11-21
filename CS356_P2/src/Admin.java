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


public class Admin extends JFrame {
	private List<Group> groups = new ArrayList<Group>();
	private Group root;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textGroup;

	/**
	 * Create the frame.
	 */
	private static Admin instance;
	public static Admin getInstance(){
		if(instance == null){
			instance = new Admin();
		}
		return instance;
	}
	private Admin() {
		root = new NewGroup();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int h = 100, width =500, height =350;
		setBounds(h, h, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddUser = new JButton("Button - Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textUser.getText();
				if(root.hasUser(text)||!text.equals("")){
					User user = new User(text);
					root.addUser(user);					
				}
				textUser.setText("");
			}
		});
		
		
		JButton btnAddGroup = new JButton("Button - Add Group");
		
		JButton btnShowGroup = new JButton("Button - Show Group Total");
		
		JButton btnShowPos = new JButton("Button - Show Positive Percentage");
		
		JButton btnShowUser = new JButton("Button - Show User Total");
		
		JButton btnShowMess = new JButton("Button - Show Messages Total");
		
		textUser = new JTextField();
		textUser.setText("TextArea - User ID");
		textUser.setColumns(10);
		
		textGroup = new JTextField();
		textGroup.setText("TextArea - Group Id");
		textGroup.setColumns(10);
		
		JButton btnView = new JButton("View User");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ldjkfa");
				EventQueue.invokeLater(new Runnable() {
					@SuppressWarnings("null")
					public void run() {
						try {
//							User u = new User("p");
							Component newUser = new Component("p");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JList list = new JList();
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					add(new DefaultMutableTreeNode("user1"));
					add(new DefaultMutableTreeNode("user2"));
					node_1 = new DefaultMutableTreeNode("group1");
						node_1.add(new DefaultMutableTreeNode("user4"));
					add(node_1);
				}
			}
		));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, width/2-30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
							.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnShowUser, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowGroup, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnShowMess, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowPos, GroupLayout.PREFERRED_SIZE, width/4, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnView, GroupLayout.PREFERRED_SIZE, width/2, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnView, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShowGroup, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowUser, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShowMess, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowPos, GroupLayout.PREFERRED_SIZE, height/10, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, height-10, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
