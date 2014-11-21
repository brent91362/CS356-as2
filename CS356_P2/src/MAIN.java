import java.awt.EventQueue;

//Singleton, Observer, Visitor, and
//Composite
public class MAIN {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = null;
					frame.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
