package emailmessagingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a mailbox which contains e-mail messages.
 * @author egsef
 */
public class Mailbox {

    private List<Message> receivedEmails;
    private List<Message> sentEmails;

    /**
     * Construct a mailbox.
     */
    public Mailbox() {
        this.receivedEmails = new ArrayList<Message>();
        this.sentEmails = new ArrayList<Message>();
    }

    /**
     * Get the received e-mails.
     * @return the received e-mails.
     */
    public List<Message> getReceivedEmails() {
        return this.receivedEmails;
    }

    /**
     * Get the sent e-mails.
     *
     * @return the sent e-mails.
     */
    public List<Message> getSentEmails() {
        return this.sentEmails;
    }

    /**
     * Receives a new email and adds it to the received array list.
     * @param m the e mail to be received.
     */
    public void receiveEmail(Message email) {
        this.receivedEmails.add(email);
    }

    /**
     * Send a new email and adds it to the sent array list.
     * @param m the e mail to be sent.
     */
    public void sendEmail(Message email) {
        this.sentEmails.add(email);
    }
}
