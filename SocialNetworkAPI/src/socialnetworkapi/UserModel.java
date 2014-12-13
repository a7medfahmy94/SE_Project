package socialnetworkapi;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public User myUser;

  public void CreateUser() {
  }

  public void DeleteUser() {
  }

  public void getUser() {
  }

  public void updateUser() {
  }
  
  public static boolean saveUserData(User object){
      return true;
  }
  
  public static List getUserFriends(User user){
      return new ArrayList();
  }
 
  public static boolean makeFriendRequest(User s,User d){
      return true;
  }
  
}