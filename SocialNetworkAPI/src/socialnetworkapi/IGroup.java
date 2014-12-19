package socialnetworkapi;

import java.util.Map;
import java.util.Vector;

public abstract class IGroup {
    public static boolean promoteUser(IUser user,String newRole){
        IUser users=IUser.getCurrentActiveUser();
        GroupModel.updateUserGroup(users, newRole);
        return true;
        
    }

    private static IGroup groupObject;
    public GroupPrivacy privacy;

    
    public GroupPrivacy myGroupPrivacy;
    public Vector  hasA;

  public static boolean addMember(IUser user) {
      ClosedPrivacy.addAlowedMembers(user);
      String role="";
      IGroup group = null;
      GroupModel.addMemberToGroup(group, user, role);
      return true;
  }

  public void removeMember() {
  }

  public void setRole(String role) {
  }

  public void setPrivacy() {
  }
  public static IGroup makeGroup(Map<String,String>data,IUser userObject){
      GroupPrivacy.setAllowedMembers();
      return groupObject;
  }
  public static boolean changeGroupPicture(IUser user,String photo){
      GroupModel.updateGroupPhoto( groupObject, photo);
      return true;
  }
}