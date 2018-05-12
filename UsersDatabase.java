
package emailmessagingsystem;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
 

/**
 * Class to represent a database of users of the e-mail system.
 * @author egsef
 */
public class UsersDatabase implements Runnable
{ 
    private List<User> users; 
 
    
    /**
     * Constructs a user database.
     */ 
    public UsersDatabase() 
    { 
        this.users = new ArrayList<User>(); 
    } 
 
    public void run() {
        // body of the method
    }
    
    
    /**
     * Construct a user database to be read from a file.
     * @param filename the name of the file to open.
     */
    public UsersDatabase(String filename) throws FileNotFoundException 
    { 
        this(); 
        this.readUsers(filename); 
    } 
 
    /**
     * Read users from a file.
     * @param filename the file to read from.
     */
    public void readUsers(String filename) throws FileNotFoundException 
    { 
        Scanner fileIn = new Scanner(new File(filename)); 
        while (fileIn.hasNext()) { 
            String username = fileIn.next(); 
            String password = fileIn.next(); 
            System.out.println(username); 
            System.out.println(password); 
            User u = new User(username, password); 
            this.addUser(u); 
        } 
        fileIn.close(); 
    } 
 
    /**
     * Adds a user to the users database
     * @param u the user to be added.
     */
    public void addUser(User user) { 
        this.users.add(user); 
    } 
 
    /**
     * Finds a user with a username and a password.
     * @param username
     * @param password 
     */
    public User findUser(String username, String password) { 
        for (User user : this.users) { 
            if (user.match(username, password)) { 
                return user; 
            } 
        } 
        return null; 
    } 
 
    
    /**
     * Finds a user from the given name.
     * @param name 
     */
    public User findUser(String username) { 
        for (User user : this.users) { 
            if (user.getName().equals(username)) { 
                return user; 
            } 
        } 
        return null; 
    } 
}


