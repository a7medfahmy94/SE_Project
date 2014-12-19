package socialnetworkapi;

import java.util.List;

public class GroupChatMessage extends Message {

  public List<IUser> allUsers;

  public String title;

  public void addReceiver(IUser user) {
  }

    @Override
    public void sendMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}