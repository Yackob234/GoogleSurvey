//Rory Welch & Jacob Scott
//June 14 2019
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class jframe extends JFrame implements ActionListener, ChangeListener {

	JTextField tf1, tf2;
	JLabel l1;
	JButton b1, b2, bCheckbox, bMultiChoice, bLinearScale;
	JSlider s1;
	final int WIDTH = 600;
	final int HEIGHT = 400;
	
	jframe() {
		tf1 = new JTextField("Enter your URL");
		tf1.setBounds(WIDTH/2, HEIGHT/2, 100, 50);
		b1 = new JButton("Confirm");
		b1.setBounds((WIDTH/2-50), (HEIGHT/2)-25, 100, 50);
		b1.addActionListener(this);
		add(b1);
		add(tf1);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new jframe();

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			//Search for textfield link, and
			if(true /*textfield link is valid*/){
				collectData();
				validateEmails();
				columnScreen();
			}
		} else if (e.getSource() == b2){
			if(tf2.getText() == "enter column name array"){
				questionTypeScreen();
			} 
		} else if (e.getSource() == bMultiChoice){
			multiChoiceScreen();
		} else if (e.getSource() == bLinearScale){
			linearScaleScreen();
		} else if (e.getSource() == bCheckbox){
			checkBoxScreen();
		} 
	
	}
	public void collectData(){
		
	}
	
	public void validateEmails(){
		
	}
	
	public void columnScreen(){
		
	}
	
	public void questionTypeScreen(){
		
	
	}
	
	public void multiChoiceScreen(){
		
	}
	
	public void checkBoxScreen(){
		
	}
	
	public void linearScaleScreen(){
		
	}
	
	
}
