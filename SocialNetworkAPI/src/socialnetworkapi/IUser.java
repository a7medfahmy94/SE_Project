package socialnetworkapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class IUser {

  public List<IGroup> subscribedGroups;

  public List<IPage> likedPages;

  public String name;

  public String email;

  private static IUser currentUser;

  public Message message;

    public IUser myUser;
    public IUser Instance;
    /**
   * 
   * @element-type IGroup
   */
  public Vector  memberIn;
    public Vector  myClosedPrivacy;
    public Vector  myPage;
    public Vector  myIPage;
    public Vector  myUserG;
    public Vector  myMessage;
    public UserModel myUserModel;

    
  public abstract boolean sendFriendRequest(IUser u);

  public  static boolean addFriend(IUser user){
      UserModel.addNewFriendship(user);
      return true;
  }

  public static boolean signUp(HashMap<String,String> data) {
      IUser newUser;
      if(data.get("userType").equals("premium")){
          newUser = PremiumUser.makeInstance();
      }else{
          newUser = NormalUser.makeInstance();
      }
      if(newUser != null){
          return UserModel.saveUserData(newUser);
      }
      return false;
  }

  public static IUser getCurrentActiveUser() {
      return currentUser;
  }
  public static ArrayList<IUser> getPendingRequests(){
      
      ArrayList<IUser>users;
      users=UserModel.getUserFriends(currentUser);
      return users;
  }
  public static IUser login(Map<String,String>data) {
      IUser user=UserModel.getUser(data);
      return user;
  }

  public void logout() {
  }

  private void User() {
  }

}