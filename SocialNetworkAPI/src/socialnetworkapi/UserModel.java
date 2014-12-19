package socialnetworkapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserModel {

    public static IUser myUser;

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
  
  public static ArrayList <IUser> getUserFriends(IUser user){
      return new ArrayList();
  }
 
  public static boolean makeFriendRequest(IUser s,IUser d){
      return true;
  }
  public static boolean addNewFriendship(IUser user){
      return true;
  }
  public static IUser getUser(Map<String,String>data){
      return myUser;
  }
}