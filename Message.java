package emailmessagingsystem;

/**
 * My approach to the simple e-mail messaging system for practice.
 * Class that represents a message for the email system. A message has a
 * recipient, a sender, and a message text.
 *
 * @author egsef
 * @version 1.1.1
 */
public class Message {

    private String recipient;
    private String sender;
    private String subject;
    private String text;

    /**
     * Constructs a new message.
     * @param recipient the recipient of the message.
     * @param sender the sender of the message.
     * @param subject the subject of the message.
     * @param text the contents of the message.
     */
    public Message(String recipient, String sender, String subject, String text) {
        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        this.text = text;
    }

    /**
     * Gets the recipients name.
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Gets the sender 's name.
     * @return the sender.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Checks if the subjects match.
     * @param subject the subject of the message.
     * @return true if the subjects match.
     */
    public boolean matchSubject(String subject) {
        return this.subject.equals(subject);
    }

    /**
     * Gets the subject of the message.
     * @return
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the text of the message.
     * @return the text of the message.S
     */
    public String getText() {
        return text;
    }

    public String toString() {
        return subject + " " + text;
    }
}
