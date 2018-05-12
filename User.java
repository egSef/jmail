package emailmessagingsystem;

/**
 * Class responsible for creating an e-mail user with a personal mailbox.
 * @author egsef
 */
public class User {

    private String name;
    private String password;
    private Mailbox mailbox;

    /**
     * Constructs a user with a given name and a password.
     *
     * @param name the name of the user.
     * @param password the password of the user.
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.mailbox = new Mailbox();
    }

    /**
     * Gets the name of the user.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the mailbox of the user.
     * @return the mailbox.
     */
    public Mailbox getMailbox() {
        return mailbox;
    }

    /**
     * Check if the user name and password exist for a valid user.
     * @param aName the name of a user.
     * @param aPassword the password of a user.
     * @return true if the user is valid.
     */
    public boolean match(String aName, String aPassword) {
        return this.name.equals(aName) && this.password.equals(aPassword);
    }

}
