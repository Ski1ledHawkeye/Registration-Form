import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;

public class Form implements ActionListener
{   

  //variables
    private static JLabel userlabeltt;
    private static JLabel userlabelfn;
    private static JLabel userlabelln;
    private static JLabel userlabeldob;
    private static JTextField userTextfn;
    private static JTextField userTextln;
    private static JTextField userTextdob;
    private static JLabel passwordlabel;
    private static JPasswordField passwordText;
    private static JLabel rpasswordlabel;
    private static JPasswordField rpasswordText;
    private static JButton button;
    private static JLabel success;
    
    public static void main(String args[])                 //main
    {
      JPanel panel = new JPanel();
      JFrame frame = new JFrame();
      frame.setSize(400, 350);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.add(panel);
      
      panel.setLayout(null);
      
      
      //heading
      userlabeltt = new JLabel("----Registration form----"); 
      userlabeltt.setBounds(70, 10, 150, 25);
      panel.add(userlabeltt);
      
      
      //names
      userlabelfn = new JLabel("First Name:"); 
      userlabelfn.setBounds(10, 40, 80, 25);
      panel.add(userlabelfn);
      
      userTextfn = new JTextField();
      userTextfn.setBounds(100, 40, 190, 25);
      panel.add(userTextfn);
      
      userlabelln = new JLabel("Last Name:");
      userlabelln.setBounds(10, 80, 80, 25);
      panel.add(userlabelln);
      
      userTextln = new JTextField();
      userTextln.setBounds(100, 80, 190, 25);
      panel.add(userTextln);
      
      
      //date of birth
      userlabeldob = new JLabel("Date of Birth:");
      userlabeldob.setBounds(10, 120, 80, 25);
      panel.add(userlabeldob);
      
      userTextdob = new JTextField();
      userTextdob.setBounds(100, 120, 190, 25);
      panel.add(userTextdob);
      
      
      //password
      passwordlabel = new JLabel("Password:");
      passwordlabel.setBounds(10, 160, 80, 25);
      panel.add(passwordlabel);
      
      passwordText = new JPasswordField();
      passwordText.setBounds(120, 160, 165, 25);
      panel.add(passwordText);
      
      
      //retype_password
      rpasswordlabel = new JLabel("Retype Password:");
      rpasswordlabel.setBounds(10, 200, 130, 25);
      panel.add(rpasswordlabel);
      
      rpasswordText = new JPasswordField();
      rpasswordText.setBounds(120, 200, 165, 25);
      panel.add(rpasswordText);
      
      //Submit button
      button = new JButton("Submit");
      button.setBounds(10, 230, 80, 25);
      button.addActionListener(new Form());
      panel.add(button);
      
      //sucessfully registerd message
      success = new JLabel("");
      success.setBounds(10, 270, 300, 25);
      panel.add(success);
      
      frame.setVisible(true);
    }
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
        String fn = userTextfn.getText();
        String ln = userTextln.getText();  
        String dob = userTextdob.getText();
        String password = passwordText.getText();
        String rpassword = rpasswordText.getText();
        if(password.equals(rpassword)) {
	        success.setText("Registered Sucessfully! \n Wish you best of luck :) ");
	        System.out.println("First Name - "+fn+" Last Name - "+ln+" DOB - "+dob+" Password - "+password);
	        
	        File myObj = new File("G:\\Registration Form.txt");            //stores the data in a file
	        if(myObj.exists()){
	            System.out.println("File has been written");
	            try{
	            FileWriter myw = new FileWriter("G:\\Registration Form.txt");
	            myw.write("First Name - "+fn+" Last Name - "+ln+" Password - "+password);
	            myw.close();
	         
	            }
	            catch(java.io.IOException ioe)
	            {
	              System.out.println("Error");
	            }
	       }
	        else{
	            System.out.println("Does not Exists");
	        }
        }
        else {
        	success.setText("Password did not match!");
        }
    } 
}
