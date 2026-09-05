import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;



public class Main{

  public static void ChatInterface(){
  
    JFrame frame = new JFrame("Chat Window");
    frame.setLayout(new BorderLayout());
    frame.setSize(640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    JPanel Leftpanel = new JPanel(new BorderLayout());
    Leftpanel.setBackground(Color.LIGHT_GRAY);
    Leftpanel.setPreferredSize(new Dimension(180, 640));
    JPanel Rightpanel = new JPanel(new BorderLayout());
    Rightpanel.setBackground(Color.WHITE);
	JPanel BottomPanel = new JPanel(new BorderLayout());
	
	JPanel title = new JPanel(new BorderLayout());
	title.setBackground(Color.BLUE);
	title.setPreferredSize(new Dimension(180, 40));
	JLabel t1 = new JLabel("Users");
	t1.setBounds(0, 90, 50, 20);
	t1.setForeground(Color.WHITE);
	t1.setFont(new Font("Arial", Font.BOLD, 20));

    frame.setLocationRelativeTo(null);
    frame.add(Leftpanel, BorderLayout.WEST);
    frame.add(Rightpanel, BorderLayout.CENTER);
	Rightpanel.add(BottomPanel, BorderLayout.SOUTH);
		
	JTextField chat = new JTextField(20);
	BottomPanel.add(chat, BorderLayout.CENTER);
	
	JButton send = new JButton("Send");
	send.setPreferredSize(new Dimension(75, 25));
	send.setBackground(Color.BLUE);
	send.setForeground(Color.WHITE);
	BottomPanel.add(send, BorderLayout.EAST);
	
	Leftpanel.add(title, BorderLayout.NORTH);
	title.add(t1, BorderLayout.CENTER);

	
    frame.setVisible(true);
  }

  public static void main(String[] args){
  
    JFrame frame = new JFrame("ChatApp");
    frame.setSize(640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    JLabel l1 = new JLabel("Welcome to ChatApp !");
    l1.setBounds(50, 50, 200, 40);
    l1.setFont(new Font("Arial", Font.BOLD, 25));
    l1.setForeground(Color.BLUE);
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(l1, gbc);
    
    JLabel l2 = new JLabel("Enter your name to continue: ");
    l2.setBounds(50, 50, 200, 40);
    l2.setFont(new Font("Arial", Font.BOLD, 15));
    l2.setForeground(Color.BLACK);
    gbc.gridx = 0; 
    gbc.gridy = 1;
    panel.add(l2, gbc);
    
    JTextField tf1 = new JTextField(20);
    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(tf1, gbc);
    
    JButton b1 = new JButton("Get in !");
    b1.setPreferredSize(new Dimension(50, 30));
    b1.setForeground(Color.WHITE);
    b1.setBackground(Color.BLUE);
    gbc.gridx = 0;
    gbc.gridy = 5;
    panel.add(b1, gbc);
    
    b1.addActionListener(e -> {
      String name = new String(tf1.getText());
      JOptionPane.showMessageDialog(frame, "Logged in as " + name);
      frame.setVisible(false);
      ChatInterface();
    });
    
    frame.add(panel);
    frame.setVisible(true);
  }
}
