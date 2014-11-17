import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class User extends Admin {
	private List<User> following;
	private List<User> users;
	private JPanel contentPane;
	private JTextField TextId;
	private JTextField txtTextareaTweet;
	private News news;
	private static String Name;
	
	private static User instance;
	public static User getInstance(){
//		if(instance == null){
//			instance = new User(user);
//		}
		return instance;
	}
	public static void init(String Id, List<User> users){
		instance = new User(Id, users);
	}
	public User(String name){
		Name=name;
	}
	private User(String user, List<User> users) {
		Name=user;
		this.users=users;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int h = 100, width =500, height =350;
		setBounds(h, h, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JList listFollowing = new JList();
		listFollowing=new JList((ListModel) following);
		JButton btnFollow = new JButton("Button - Follow User");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(following==null){
					following = new ArrayList<User>();
				}
				System.out.println(users.toString());
				if(!(TextId.getText().isEmpty())&&users.contains(TextId.getText())){
					following.add(findUser(TextId.getText()));
//					listFollowing.add(TextId, 0);
					TextId.setText("");
				}
//				news.update();
			}

			private User findUser(String text) {
				for(int index = 0; index<users.size(); index++){
					if(users.get(index).Name.equals(text)){
						return users.get(index);
					}
				}
				return null;
			}
		});
		
		TextId = new JTextField();
		TextId.setText("TextArea - User Id");
		TextId.setColumns(10);
		TextId.setText(user);
		
		JButton btnPost = new JButton("Button - Post Tweet");
		
		txtTextareaTweet = new JTextField();
		txtTextareaTweet.setText("TextArea - Tweet Message");
		txtTextareaTweet.setColumns(10);
		
		JList listNews = new JList();
		listNews =new JList( getNews() );
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(listFollowing, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(TextId, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnFollow, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtTextareaTweet, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnPost, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
						.addComponent(listNews, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TextId)
						.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listFollowing, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPost, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTextareaTweet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listNews, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private ListModel getNews() {
		// TODO Auto-generated method stub
		return null;
	}
}
