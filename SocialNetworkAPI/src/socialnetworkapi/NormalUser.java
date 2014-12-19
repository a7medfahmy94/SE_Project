package socialnetworkapi;

public class NormalUser extends IUser {

    private NormalUser(){}
    
    public boolean checkCurrentFriendsCount() {
        return true;
    }

    public void initializeFriends(){  
    }
  
    public static IUser makeInstance(){
        NormalUser ret = new NormalUser();
        ret.initializeFriends();
        return ret;
    }

    public boolean sendFriendRequest(IUser u) {
        if(this.checkCurrentFriendsCount()){
            return UserModel.makeFriendRequest(this,u);
        }
        return false;
    }

    
    public void addFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}