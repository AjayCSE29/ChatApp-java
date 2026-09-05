import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;

public class Main{
	
  public static void AddUserCard(String name, JPanel panel){
		JPanel usrcrd = new JPanel(new GridBagLayout());
		JLabel usrname = new JLabel(name);
		usrname.setForeground(Color.WHITE);
		usrcrd.setBackground(Color.BLACK);
		usrcrd.setMaximumSize(new Dimension(180, 40));
		usrname.setFont(new Font("Arial", Font.BOLD, 15));
		usrcrd.add(usrname);
		panel.add(usrcrd);
		
		panel.revalidate();
		panel.repaint();
		
  }
  
  public static void sendMessage(String usrmessage, JPanel panel){
	  JPanel usrmsg = new JPanel(new GridBagLayout());
	  JLabel message = new JLabel(usrmessage);
	  usrmsg.setBackground(Color.BLACK);
	  message.setForeground(Color.WHITE);
	  usrmsg.setMaximumSize(new Dimension(120, 40));
	  message.setFont(new Font("Arial", Font.BOLD, 12));
	  usrmsg.add(message);
	  panel.add(usrmsg);
	  
	  panel.revalidate();
	  panel.repaint();
	  
  }

  public static void ChatInterface(String name){
  
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
	
	JPanel title = new JPanel(new GridBagLayout());
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
	
	JPanel leftContainer = new JPanel();
	leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.Y_AXIS));

	JPanel rightContainer = new JPanel();
	rightContainer.setLayout(new BoxLayout(rightContainer, BoxLayout.Y_AXIS));

	Leftpanel.add(leftContainer, BorderLayout.CENTER);
	Rightpanel.add(rightContainer, BorderLayout.CENTER);
	
	Leftpanel.add(title, BorderLayout.NORTH);
	title.add(t1);
	
	AddUserCard(name, leftContainer);
	
    frame.setVisible(true);
	
	send.addActionListener(e -> {
		String message = chat.getText();
		sendMessage(message, rightContainer);
	});
	
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
      frame.dispose();
      ChatInterface(name);
    });
    
    frame.add(panel);
    frame.setVisible(true);
  }
}
