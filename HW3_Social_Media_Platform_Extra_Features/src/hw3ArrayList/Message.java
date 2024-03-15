package hw3ArrayList;
/**
 * Class for Messages
 * @author BeyzaAcar
 */public class Message
{
    private final int messageId;
    private String senderUserName;
    private String receiverUserName;
    private String content;


    /**
     * Constructor for Message class
     * @param messageId
     * @param senderUserName
     * @param receiverUserName
     * @param content
     */
    public Message(int messageId, String senderUserName, String receiverUserName, String content)
    {
        this.messageId = messageId;
        this.receiverUserName = receiverUserName;
        this.senderUserName = senderUserName;
        this.content = content;
    }

    /**
     * Getter for the sender of the message
     * @return
     */
    public String getSenderUserName()
    {
        return senderUserName;
    }

    /**
     * Getter for the reciever of the message
     * @return
     */
    public String getReceiverUserName(){ return receiverUserName; }
    /**
     * Allows viewing a message
     * @return content + sender username + receiver username
     */
    @Override
    public String toString() {
        return "Message :" +
                " content= '" + content + "\n'" +
                "senderUserName='" + senderUserName + "'\n'" +
                "receiverUserName='" + receiverUserName + "'\n\n";
    }
}
