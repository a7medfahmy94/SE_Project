package socialnetworkapi;

public class NormalUser extends User {

    private NormalUser(){}
    
    public boolean checkCurrentFriendsCount() {
        return true;
    }

    public void initializeFriends(){  
    }
  
    public static User makeInstance(){
        NormalUser ret = new NormalUser();
        ret.initializeFriends();
        return ret;
    }

    @Override
    public boolean sendFriendRequest(User u) {
        if(this.checkCurrentFriendsCount()){
            return UserModel.makeFriendRequest(this,u);
        }
        return false;
    }

    @Override
    public void addFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}