package socialnetworkapi;

import java.util.Map;

public class Group extends IGroup {

  public String title;

  public String coverPicture;

  public Map<IUser,String> users;

    public GroupModel myGroupModel;

  public static boolean addMember(IUser user) {
      return true;
  }

  public void removeMember() {
  }

  public void setRole() {
  }

}