//Rory Welch & Jacob Scott
//June 14 2019
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class jframe extends JFrame implements ActionListener{

	JTextField tf1, tf2;
	JLabel l1, l1b, l1c, l3;
	JButton b1, b2, bCheckbox, bMultiChoice, bLinearScale;
	JSlider s1;
	Student[] student;
	int currentColumn;
	int questionType;
	final int WIDTH = 600;
	final int HEIGHT = 400;
	
	jframe(){
		l1 = new JLabel("Welcome to Jacob's and Rory's Medway Polling System!");
		l1.setBounds(WIDTH/2-175, HEIGHT/8, 350, 25);
		l1b = new JLabel("Make sure to make the sheet public, and not apart of the TVDSB school board so anyone can access it");
		l1b.setBounds(WIDTH/2-300, HEIGHT*3/4, 600, 25);
		tf1 = new JTextField("Enter your URL for the Google Sheet");
		tf1.setBounds(WIDTH/2-250, HEIGHT/4, 500, 25);
		l1c = new JLabel("Make sure to copy update.txt into the folder, GoogleSurvey");
		l1c.setBounds(WIDTH/2-250, HEIGHT/3, 500, 25);
		b1 = new JButton("Confirm");
		b1.setBounds((WIDTH/2-50), (HEIGHT/2)-25, 100, 50);
		b1.addActionListener(this);
		add(l1b);
		add(l1);
		add(b1);
		add(tf1);
		add(l1c);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)  throws FileNotFoundException{
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(()->new jframe());
		//new jframe();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			//Search for textfield link, and
			if(true /*textfield link is valid*/){
				collectData();
				tf1.setText("Success!");
				try {
					validateEmails();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				columnScreen();
			} else {
				tf1.setText("That link was not valid, check that everything should work.");
			}
		} else if (e.getSource() == b2){
			for(int i = 0; i < 1; /*column name array.length*/ i++){
				if(tf2.getText().toLowerCase().equals("columnNameArray[i]".toLowerCase())){
					currentColumn = i;
					questionTypeScreen();
				} else if(tf2.getText().equals("continue")){
					currentColumn = i;
					questionTypeScreen();
				} else {
					tf2.setText("There was no Question with that name");
				}
			}
			
		} else if (e.getSource() == bCheckbox){
			questionType = 0;
			checkBoxScreen();
		} else if (e.getSource() == bMultiChoice){
			questionType =1;
			multiChoiceScreen();
		} else if (e.getSource() == bLinearScale){
			questionType = 2;
			linearScaleScreen();
		} 
	
	}
	public static void collectData(){
		//from google
	}
	
	public static void validateEmails() throws FileNotFoundException{
		Student[] students = getEmails("update.txt");
	}
	
	public static Student[] getEmails(String fileName) throws FileNotFoundException{
		
        File file = new File(fileName);
        Scanner parser = new Scanner(new FileReader(file));
       
        int length = 0;
        String[] item = new String[length];
        String[] item2 = new String[length];
 
        // checks if there is another entry, and puts it in the array
        while (parser.hasNextLine()) {
            length++;
            for (int i = 0; i < item.length; i++) {
                item2[i] = item[i];
            }
            item = new String[length];
            for (int i = 0; i < item2.length; i++) {
                item[i] = item2[i];
            }
            item2 = new String[length];
            item[length - 1] = parser.nextLine();
        }
        Student[] stu = new Student[length];
        for(int i = 0; i < length; i ++){
        	stu[i] = new Student();
        	String[] items = item[i].split(",");
        	stu[i].lName = items[0];
        	stu[i].fName = items[1];
        	stu[i].sNum = items[3];
        }
        return stu;
	}
	
	public void columnScreen(){ // displays the second screen, where the user picks the column
		b1.setVisible(false);
		tf1.setVisible(false);
		l1b.setVisible(false);
		remove(b1);
		remove(tf1);
		remove(l1b);
		
		tf2 = new JTextField("Enter the title of the Question you would like data for.");
		tf2.setBounds(WIDTH/2-250, HEIGHT/4, 500, 25);
		b2 = new JButton("Confirm");
		b2.setBounds((WIDTH/2-50), (HEIGHT/2)-25, 100, 50);
		b2.addActionListener(this);
		add(tf2);
		add(b2);
	}
	
	public void questionTypeScreen(){
		b2.setVisible(false);
		tf2.setVisible(false);
		remove(b2);
		remove(tf2);
		
		l3 = new JLabel("What type of Question is this?");
		l3.setBounds(WIDTH/2-250, HEIGHT/4, 500, 25);
		//bCheckbox, bMultiChoice, bLinearScale;
		bCheckbox = new JButton("Checkbox");
		bCheckbox.setBounds((WIDTH/2-250), (HEIGHT/2)-25, 150, 50);
		bCheckbox.addActionListener(this);
		
		bMultiChoice = new JButton("MutliChoice");
		bMultiChoice.setBounds((WIDTH/2-75), (HEIGHT/2)-25, 150, 50);
		bMultiChoice.addActionListener(this);
		
		bLinearScale = new JButton("LinearScale");
		bLinearScale.setBounds((WIDTH/2+100), (HEIGHT/2)-25, 150, 50);
		bLinearScale.addActionListener(this);
		add(l3);
		add(bCheckbox);
		add(bMultiChoice);
		add(bLinearScale);
	}
	
	public void multiChoiceScreen(){
		
	}
	
	public void checkBoxScreen(){
		
	}
	
	public void linearScaleScreen(){
		
	}
	
	
}
