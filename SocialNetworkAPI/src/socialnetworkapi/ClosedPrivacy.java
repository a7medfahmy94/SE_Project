package socialnetworkapi;

public class ClosedPrivacy extends GroupPrivacy {

  public void addAlowedMembers(IUser user){
      this.allowedUsers.add(user);
  }
  public void isAllowed(IUser user) {
  }

}