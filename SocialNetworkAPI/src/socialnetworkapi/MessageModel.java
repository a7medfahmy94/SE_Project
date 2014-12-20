package socialnetworkapi;

import java.util.ArrayList;

public class MessageModel {

  public static boolean createMessage(IUser receiver,IUser sender) {
      return true;
  }

  public static void deleteMessage() {
  }

  public static ArrayList<String> getMessage(IUser user,IUser object) {
      ArrayList <String> messages=new ArrayList<>();
      return messages;
  }

  public static void updateMessage() {
  }

}