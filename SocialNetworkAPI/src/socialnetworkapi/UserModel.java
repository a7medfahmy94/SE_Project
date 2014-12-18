package socialnetworkapi;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public IUser myUser;

  public void CreateUser() {
  }

  public void DeleteUser() {
  }

  public void getUser() {
  }

  public void updateUser() {
  }
  
  public static boolean saveUserData(IUser object){
      return true;
  }
  
  public static List getUserFriends(IUser user){
      return new ArrayList();
  }
 
  public static boolean makeFriendRequest(IUser s,IUser d){
      return true;
  }
  
}