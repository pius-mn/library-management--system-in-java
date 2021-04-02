
import java.awt.*;
public class App {
    public static void main(String[] args) throws Exception {
      EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
          extracted();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

      private void extracted() {
        login.main(new String[]{});
      }
        });
      

    }
 public static Dimension device(){
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
       // int screenHeight= screenSize.height; 
       // int screenwidth= screenSize.width; 
        //System.out.println(screenHeight);
        //System.out.println(screenwidth); 
        return screenSize;
    } 
}
