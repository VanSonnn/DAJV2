package Phone;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LoginKH extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tftensignin;
    private ServerSocket serversocket;
    private Socket socket;
    private PrintWriter Output;
    private JPasswordField tfpasssignin;
    private JTextField tftensignup;
    private JPasswordField passsingup1;
    private JPasswordField passsignup2;
    private JButton btnNewButton;
    private JButton btnNewButton_2_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginKH frame = new LoginKH();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginKH() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 761, 477);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_signin = new JPanel();
        panel_signin.setBackground(SystemColor.window);
        panel_signin.setBounds(276, 0, 473, 442);
        contentPane.add(panel_signin);
        panel_signin.setLayout(null);
     

        tftensignin = new CustomTextField("Tên đăng nhập");
        tftensignin.setBounds(102, 147, 267, 30);
        panel_signin.add(tftensignin);
        
        JLabel lblNewLabel_2 = new JLabel("Sign in");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_2.setForeground(new Color(46, 139, 87));
        lblNewLabel_2.setBounds(195, 79, 115, 41);
        panel_signin.add(lblNewLabel_2);
        
         tfpasssignin = new PlaceholderPasswordField("Mật khẩu");
        tfpasssignin.setBounds(102, 188, 267, 30);
        panel_signin.add(tfpasssignin);
        
        JButton btsignin = new JButton("Sign in");
        btsignin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		saveToXML();
        		   Dash dash = new Dash();
        	        dash.setVisible(true);
        	}
        });
        btsignin.setBackground(new Color(46, 139, 87));
        btsignin.setForeground(new Color(255, 255, 255));
        btsignin.setBounds(184, 268, 108, 41);
        panel_signin.add(btsignin);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(46, 139, 87));
        panel.setBounds(0, 0, 277, 442);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblWelcome = new JLabel("Welcome Store!");
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblWelcome.setForeground(new Color(255, 255, 255));
        lblWelcome.setBounds(54, 159, 169, 48);
        panel.add(lblWelcome);
        
        JPanel panel_signup = new JPanel();
        panel_signup.setBackground(new Color(255, 255, 255));
        panel_signup.setBounds(279, 0, 470, 442);
        panel_signup.setVisible(false);  // Ban đầu đặt nó là vô hình
        contentPane.add(panel_signup);
        panel_signup.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Create Account");
        lblNewLabel.setForeground(new Color(46, 139, 87));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(162, 65, 210, 40);
        panel_signup.add(lblNewLabel);
        
        PlaceholderTextField tftensignup = new PlaceholderTextField("Tên đăng nhập");
        tftensignup.setBounds(105, 127, 267, 30);
        panel_signup.add(tftensignup);
        
        
        
        PlaceholderPasswordField passsingup1 = new PlaceholderPasswordField("Nhập mật khẩu");
        passsingup1.setBounds(105, 185, 267, 30);
        panel_signup.add(passsingup1);
        
        PlaceholderPasswordField passsignup2 = new PlaceholderPasswordField("Nhập mật khẩu");
        passsignup2.setBounds(105, 241, 267, 30);
        panel_signup.add(passsignup2);
        
        JButton btsignup = new JButton("Sign up");
        btsignup.setForeground(new Color(255, 255, 255));
        btsignup.setBackground(new Color(46, 139, 87));
        btsignup.setFont(new Font("Tahoma", Font.BOLD, 15));
        btsignup.setBounds(200, 285, 106, 40);
        panel_signup.add(btsignup);
		
        btnNewButton = new JButton("Sign up");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel_signup.setVisible(true);
                panel_signin.setVisible(false);
                btnNewButton.setVisible(false);
                btnNewButton_2_1.setVisible(true);
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(46, 139, 87));
        btnNewButton.setBounds(76, 241, 110, 28);
        // Tạo một viền màu trắng
        btnNewButton.setBorder(new LineBorder(Color.WHITE));
        panel.add(btnNewButton);
        
        btnNewButton_2_1 = new JButton("Sign in");
        btnNewButton_2_1.setBounds(76, 241, 110, 28);
        panel.add(btnNewButton_2_1);
        btnNewButton_2_1.setForeground(new Color(255, 255, 255));
        btnNewButton_2_1.setBackground(new Color(46, 139, 87));
        btnNewButton_2_1.setVisible(false);
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_signup.setVisible(false);
        		panel_signin.setVisible(true);
        		btnNewButton_2_1.setVisible(false);
        		 btnNewButton.setVisible(true);
        	}
        });
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_2_1.setBorder(new LineBorder(Color.WHITE));
        panel.add(btnNewButton);
        

        
    }

    private void saveToXML() {
        String name = tftensignin.getText();
       String pass = tfpasssignin.getText();
       

        try {
            // Tạo một tài liệu XML mới
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Tạo phần tử root
            Element rootElement = doc.createElement("person");
            doc.appendChild(rootElement);

            // Tạo các phần tử con
            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            rootElement.appendChild(nameElement);

            Element ageElement = doc.createElement("SDT");
            ageElement.appendChild(doc.createTextNode(pass));
            rootElement.appendChild(ageElement);

            // Lưu tài liệu XML vào tệp
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("imformation.xml"));
            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public class CustomTextField extends JTextField implements FocusListener {
        private String placeholder;

        public CustomTextField(String placeholder) {
            this.placeholder = placeholder;
            setFont(new Font("Tahoma", Font.PLAIN, 14));
            setForeground(Color.GRAY);
            setText(placeholder);
            addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getText().equals(placeholder)) {
                setText("");
                setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getText().isEmpty()) {
                setText(placeholder);
                setForeground(Color.GRAY);
            }
        }
    }
    public class PlaceholderPasswordField extends JPasswordField implements FocusListener {
        private String placeholder;

        public PlaceholderPasswordField(String placeholder) {
            this.placeholder = placeholder;
            setFont(new Font("Tahoma", Font.PLAIN, 14));
            setForeground(Color.GRAY);
            setText(placeholder);
            setEchoChar((char)0); // Hiện chữ mờ
            addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getText().equals(placeholder)) {
                setText("");
                setForeground(Color.BLACK);
                setEchoChar('*'); // Khi focus, hiện ký tự thực
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getText().isEmpty()) {
                setText(placeholder);
                setForeground(Color.GRAY);
                setEchoChar((char)0); // Khi mất focus, hiện chữ mờ
            }
        }
    }
    public class PlaceholderTextField extends JTextField implements FocusListener {
        private String placeholder;

        public PlaceholderTextField(String placeholder) {
            this.placeholder = placeholder;
            addFocusListener(this);
            setText(placeholder);
            setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getText().equals(placeholder)) {
                setText("");
                setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getText().isEmpty()) {
                setText(placeholder);
                setForeground(Color.GRAY);
            }
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            if (!hasFocus()) {
                setText(placeholder);
                setForeground(Color.GRAY);
            }
        }
    }
    public class PlaceholderPasswordField2 extends JPasswordField implements FocusListener {
        private String placeholder;
        private boolean showingPlaceholder;

        public PlaceholderPasswordField2(String placeholder) {
            this.placeholder = placeholder;
            this.showingPlaceholder = true;
            addFocusListener(this);
            setEchoChar((char) 0); // Show the placeholder text
            setText(placeholder);
            setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (showingPlaceholder) {
                setText("");
                setEchoChar('*'); // Restore the echo character for password
                setForeground(Color.BLACK);
                showingPlaceholder = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getPassword().length == 0) {
                setEchoChar((char) 0); // Show the placeholder text
                setText(placeholder);
                setForeground(Color.GRAY);
                showingPlaceholder = true;
            }
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            if (showingPlaceholder) {
                setText(placeholder);
                setForeground(Color.GRAY);
            }
        }
    }
    
}
