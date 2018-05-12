package emailmessagingsystem;

import java.util.List;

/**
 *
 * Class that represents the e-mail System.
 * @author egsef
 * @version 1.1.1
 */

public class EmailSystem {

    private User currentUser;
    private Mailbox currentMailbox;
    UsersDatabase usersDB;

    private int state;
    protected static final int START_STATE = 1;
    protected static final int ACCOUNT_STATE = 2;
    protected static final int WRITE_EMAIL_STATE = 3;

    /**
     * Constructs an EmailSystem from a users database;
     *
     * @param userDB th user's database.
     */
    public EmailSystem(UsersDatabase usersDB) {
        this.usersDB = usersDB;
        this.reset();
    }

    /**
     * Resets the email system to initial state.
     */
    public void reset() {
        this.state = START_STATE;
        this.currentUser = null;
        this.currentMailbox = null;
    }

    /**
     * Send an email.
     * @param recipientName the name of the recipient.
     * @param email the email to be sent.
     */
    public void sendEmail(String recipientName, Message email) {
        User recipientUser = this.usersDB.findUser(recipientName);
        if (recipientUser != null) {
            currentMailbox = new Mailbox();
            currentMailbox.sendEmail(email);
            Mailbox recipientMailbox = recipientUser.getMailbox();
            recipientMailbox.receiveEmail(email);
        }
    }

    /**
     * Checks if a user can log in into the users database.
     * @param username the user name.
     * @param password the user password.
     * @return true if the login is successful.
     */
    public boolean canLoginUser(String username, String password) {
        User u = this.usersDB.findUser(username, password);
        if (u != null) {
            this.currentUser = u;
            return true;
        }
        return false;
    }

    /**
     * Get the sent e-mails.
     * @return the sent e-mails
     */
    public List<Message> getSentEmails() {
        return currentMailbox.getSentEmails();
    }

    /**
     * Gets the received e-mails.
     * @return the received e- mails.
     */
    public List<Message> getReceivedEmails() {
        return currentMailbox.getReceivedEmails();
    }

    /**
     * Returns the state.
     * @return the current state.
     */
    public int getState() {
        return this.state;
    }

    /**
     * Sets a state.
     * @param state the state to be set.
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Searches for a matching email in a given mailbox.
     *
     * @param subject the subject of the e-mail.
     * @param emails the mailbox to search in.
     * @return
     */
    public Message searchForEmail(String subject, List<Message> emails) {
        for (Message email : emails) {
            if (email.matchSubject(subject)) {
                return email;
            }
        }
        return null;
    }
}
