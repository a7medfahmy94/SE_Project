package socialnetworkapi;

import java.util.Map;

public class Group extends IGroup {

  public String title;

  public String coverPicture;

  public Map<IUser,String> users;

    public GroupModel myGroupModel;

  public void addMember(IUser user) {
  }

  public void removeMember() {
  }

  public void setRole() {
  }

    @Override
    public boolean promoteUser(IUser user, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}