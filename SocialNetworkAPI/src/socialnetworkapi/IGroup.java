package socialnetworkapi;

import java.util.Vector;

public abstract class IGroup {

  public GroupPrivacy privacy;

    
    public GroupPrivacy myGroupPrivacy;
    public Vector  hasA;

  public void addMember(IUser user) {
  }

  public void removeMember() {
  }

  public void setRole(String role) {
  }

  public void setPrivacy() {
  }

}