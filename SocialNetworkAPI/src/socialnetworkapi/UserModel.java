package socialnetworkapi;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public IUser myUser;

  public void CreateUser() {
  }

  public void DeleteUser() {
  }

  public static ArrayList<IUser> getUsers(String email) {
      return new ArrayList<IUser>();
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