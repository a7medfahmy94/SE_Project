package socialnetworkapi;

import java.util.Vector;

public abstract class Message {


  public abstract void sendMessage();

  public abstract void addReceiver(IUser user);

}