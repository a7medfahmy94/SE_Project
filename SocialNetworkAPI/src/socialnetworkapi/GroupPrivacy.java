package socialnetworkapi;

import java.util.List;

public abstract class GroupPrivacy {

    public List<IUser> allowedUsers;

    public void getAllowedMembers(Group group) {
        
    }
    public static boolean setAllowedMembers(){
        return true;
    }
  

}