package socialnetworkapi;

public class ChatMessage extends Message {

    public IUser receiver;

    public void addReceiver(IUser user) {
        receiver = user;
    }

    public void sendMessage() {
        IUser currentUser = IUser.getCurrentActiveUser();
        MessageModel.createMessage(this.receiver, currentUser);
    }
}