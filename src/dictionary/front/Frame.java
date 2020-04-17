package dictionary.front;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dictionary.back.Add;
import dictionary.back.Book;
import dictionary.back.Save;

public class Frame extends JFrame{
	
	JLabel author_l = new JLabel("Author");
	JLabel name_l = new JLabel("Name");
	JLabel num_l = new JLabel("Num");

	JTextField author = new JTextField();
	JTextField name = new JTextField();
	JTextField num = new JTextField();

	JButton add = new JButton("Add");
	JButton save = new JButton("Save");

	
	public Frame() {
		
		author_l.setBounds(20, 20, 100, 50);
		name_l.setBounds(20, 90, 100, 50);
		num_l.setBounds(20, 160, 100, 50);
		
		author.setBounds(140, 30, 200, 30);
		name.setBounds(140, 100, 200, 30);
		num.setBounds(140, 170, 200, 30);

		add.setBounds(165, 300, 70, 40);
		save.setBounds(165, 400, 70, 40);
		
		save.addActionListener((event) -> {
			Save.save();
		});
		
		add.addActionListener((event) -> {
			Add.push(new Book(author.getText(), name.getText(), 
					Integer.parseInt(num.getText())));
		});
		
		setBounds(0, 0, 400, 500);
		setTitle("Dict");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		add(author_l);
		add(name_l);
		add(num_l);
		
		add(author);
		add(name);
		add(num);
		
		add(add);
		add(save);
		
		setVisible(true);
		
	}
}
