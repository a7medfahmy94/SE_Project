package socialnetworkapi;

public class GroupModel {

    public Group myGroup;

  public static boolean createGroup(IGroup groupObject){
      return true;
  }
  public static boolean updateGroupPhoto(IGroup groupObject,String photo) {
      return true;
  }
  public static boolean addMemberToGroup(IGroup group,IUser user,String role){
      return true;
  }
  public static boolean updateUserGroup(IUser user,String newRole){
      return true;
  }
  public void getGroup() {
  }

  public void deleteGroup() {
  }

}