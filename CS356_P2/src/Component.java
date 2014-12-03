import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class Component extends JFrame{
//	private List<User> following;
	private JPanel contentPane;
	private JTextField TextId;
	private JTextField txtTextareaTweet;
	public static String Name;
	private JTextField textUsers;
	private JTextField textNewsfeed;
	public Component(User user) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int h = 100, width =500, height =350;
		setBounds(h, h, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnFollow = new JButton("Button - Follow User");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!TextId.getText().isEmpty())&&
						!Admin.getInstance().getRootUsers().contains(TextId.getText())){					
        	    	user.addFollower(((User)Admin.getInstance().getFromRoot(TextId.getText())));
        	    	String text="";
					for(User u: user.getFollowing()){
						text+=(u.getName())+"\n";
					}
					textUsers.setText(text);
					TextId.setText("");
				}
			}
		});
		
		TextId = new JTextField();
		TextId.setText("TextArea - User Id");
		TextId.setColumns(10);
		this.setTitle(user.getName());
		
		JButton btnPost = new JButton("Button - Post Tweet");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tweet = txtTextareaTweet.getText();
				if(!tweet.equals("")){
					user.addMessage(tweet);
					Admin.getInstance().addToFeed(user.getMessage());
					getLastMessage(user);
				}
				updateField(user);
			}
		});
		
		txtTextareaTweet = new JTextField();
		txtTextareaTweet.setText("TextArea - Tweet Message");
		txtTextareaTweet.setColumns(10);
		
		textUsers = new JTextField();
		textUsers.setColumns(10);
		
		textNewsfeed = new JTextField();
		textNewsfeed.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textUsers, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(TextId, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnFollow, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtTextareaTweet, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnPost, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
						.addComponent(textNewsfeed, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TextId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textUsers, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPost, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTextareaTweet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(textNewsfeed, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void updateField(User user){
		String feed="";
		for(User u: user.getFollowing()){
			for(Message news:u.getFeed()){
				feed +=(news.getMessage());
			}
		}
		for(Message news:user.getFeed()){
			feed +=(news.getMessage());
		}
		
		textNewsfeed.setText(feed);
	}

	private void getLastMessage(User user) {
			System.out.println(user.getLast());
	}
	
}
