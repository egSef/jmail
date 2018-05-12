package emailmessagingsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * Class responsible for creating the e-mail system user interface.
 *
 * @author egsef
 */
public class EmailSystemFrame extends JFrame {

    // Variables declaration     
    private EmailSystem emailSystem;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton composeButton;
    private JButton inboxButton;
    private JButton sendButton;
    private JButton logoutButton;

    private JLabel subjectLabel;
    private JLabel logoLabel;
    private JLabel programInfoLabel;
    private JLabel authorLabel;
    private JLabel versionLabel;
    private JLabel toLabel;
    private JPanel jPanel1;
    private JPanel jPanel2;

    private JScrollPane jScrollPane1;
    private static JTextArea messageTextArea;

    private JTextField recipientField;
    private JTextField subject;

    /**
     * Creates new form NewJFrame
     */
    public EmailSystemFrame(UsersDatabase usersDB) throws FileNotFoundException {
        emailSystem = new EmailSystem(usersDB);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmailSystemFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EmailSystemFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EmailSystemFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EmailSystemFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        initComponents();
        this.setVisible(true);
    }

    /**
     * Initializes all user interface components.
     */
    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();

        //initilize labels and fields
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();

        //initialize buttons
        loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setBackground(java.awt.Color.GREEN);
        loginButton.addActionListener(new loginButtonListener());

        composeButton = new JButton();
        composeButton.setText("COMPOSE");
        composeButton.addActionListener(new composeButtonListener());

        inboxButton = new JButton();
        inboxButton.setText("Inbox");
        inboxButton.addActionListener(new inboxButtonListener());

        sendButton = new JButton();
        sendButton.setText("SEND");
        sendButton.addActionListener(new sendButtonListener());

        logoutButton = new JButton();
        logoutButton.setText("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.addActionListener(new logoutButtonListener());
        messageTextArea = new JTextArea();

        subjectLabel = new JLabel();
        recipientField = new JTextField();

        logoLabel = new JLabel();
        programInfoLabel = new JLabel();

        authorLabel = new JLabel();
        versionLabel = new JLabel();

        toLabel = new JLabel();
        subject = new JTextField();

        usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        usernameLabel.setText("Username");

        passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        passwordLabel.setText("Password");

        //Inform user that database was initialized.
        printUserInfo("Database of users initialized, Login to continue...");

        //Creates Panel 1
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 84,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(passwordField))
                        .addGap(14, 14, 14))
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton)
                        .addGap(62, 62, 62)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginButton)
                        .addContainerGap(12, Short.MAX_VALUE)));
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 107, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(inboxButton, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sendButton, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(composeButton, GroupLayout.PREFERRED_SIZE, 124,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)))));

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(composeButton)
                                .addGap(48, 48, 48)
                                .addComponent(inboxButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendButton)
                                .addContainerGap(179, Short.MAX_VALUE)));

        //Text area 
        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        //Subject Label
        subjectLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        subjectLabel.setText(" Subject:");

        logoLabel.setFont(new Font("Arial", 1, 26)); // NOI18N
        logoLabel.setText("  J  M A I L ");
        logoLabel.setForeground(Color.red);

        programInfoLabel.setText("My simple E-mail System Implementation");
        authorLabel.setText("@author egSef");
        versionLabel.setText("@version 1.1.1");
        //Recipient Label
        toLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        toLabel.setText("To:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 179,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(programInfoLabel, GroupLayout.PREFERRED_SIZE, 284,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(versionLabel, GroupLayout.Alignment.LEADING,
                                                                        GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(authorLabel, GroupLayout.Alignment.LEADING,
                                                                        GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(logoutButton))))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(subjectLabel, GroupLayout.PREFERRED_SIZE, 114,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(subject))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(toLabel, GroupLayout.PREFERRED_SIZE, 114,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(recipientField, GroupLayout.PREFERRED_SIZE, 502,
                                                GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING))
                        .addGap(33, 33, 33)));

        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 30,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(programInfoLabel, GroupLayout.PREFERRED_SIZE, 27,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(authorLabel)
                                                .addComponent(logoutButton))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(versionLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(toLabel)
                                                .addComponent(recipientField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(subjectLabel)
                                                .addComponent(subject, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(
                                GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE)));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    /*
      Prints information and makes generic use of the text area
     */
    public static void printUserInfo(String s) {
        messageTextArea.setText(s);
    }

    //Actions for login button 
    class loginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String username = usernameField.getText();
            String password = "";
            char[] pass = passwordField.getPassword();
            for (char c : pass) {
                password = password + c;
            }

            if (emailSystem.canLoginUser(username, password)) {
                emailSystem.setState(2);  //ACCOUNT_STATE
                printUserInfo(username + " logged in");
                recipientField.setText("Recipient' s address");
                subject.setText("Title of the message");
                messageTextArea.setText("Write message text Here...");
            } else {
                printUserInfo("User not found or database error!");
            }
        }
    }

    //Actions for compose button.
    class composeButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (emailSystem.getState() == 2) {
                subject.setText(null);
                recipientField.setText(null);
                messageTextArea.setText(null);
            } else {
                printUserInfo("Not logged in.");
            }
        }
    }

    //Actions for send button functions.
    class sendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String user = recipientField.getText();

            if (emailSystem.getState() == 2 && emailSystem.usersDB.findUser(user) != null) {
                Message email = new Message(recipientField.getText(), usernameField.getText(),
                        subject.getText(), messageTextArea.getText());
                emailSystem.sendEmail(recipientField.getText(), email);
                printUserInfo("Message sent to " + recipientField.getText());
            } else {
                printUserInfo("Invalid recipient!");
            }
        }
    }

    //Actions for inbox Button function
    class inboxButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String username = usernameField.getText();
            User u = emailSystem.usersDB.findUser(username);
            Mailbox m = u.getMailbox();
            readReceivedEmails(m);
            recipientField.setText(null);
            subject.setText(null);
        }
    }

    //Logout button function
    class logoutButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (emailSystem.getState() == 2) {
                printUserInfo("Log in to continue");
                usernameField.setText(null);
                passwordField.setText(null);
                emailSystem.setState(1);
                recipientField.setText(null);
                subject.setText(null);
            }
        }
    }

    private void readReceivedEmails(Mailbox m) {
        String s = "";
        List<Message> received = m.getReceivedEmails();
        if (received != null) {
            for (Message mess : received) {
                s = s + "From:" + mess.getSender() + "\n" + "Subject:"
                        + mess.getSubject() + "\n" + "Message text:" + mess.getText() + "\n\n";
            }
            printUserInfo(s);
        } else {
            printUserInfo("No inbox messages found");
        }
    }
}
