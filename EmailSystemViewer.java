package emailmessagingsystem;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
/**
 * My approach to the simple e-mail messaging system for practice. 
 * 
 * A message has a recipient, a sender, and a message text. 
 * A mailbox can store messages. 
 * A number of mailboxes is used for different users. 
 * A user interface for users to log in, send messages to other users, read their 
 * own messages, and log out. 
 * 
 * 
 * The users database reads and adds the users from a file.
 * 
 * @author egsef
 * @version 1.1.1
 */
public class EmailSystemViewer 
{

    public static void main(String[] args) throws FileNotFoundException 
    {
        UsersDatabase usersDB = new UsersDatabase("Users.txt");
        JFrame frame = new EmailSystemFrame(usersDB);
    }

}
