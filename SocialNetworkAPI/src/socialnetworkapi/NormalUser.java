package socialnetworkapi;

import java.util.HashMap;

public class NormalUser extends IUser {

    public NormalUser(int id,String name,String email,String gender){
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.type = "normal";
    }
    
    public boolean checkCurrentFriendsCount() {
        return true;
    }

    public void initializeFriends(){  
    }
  
    public static IUser makeInstance(HashMap<String,String> data){
        NormalUser ret = new NormalUser(
            Integer.valueOf(data.get("id")),data.get("name"),data.get("email"),
            data.get("gender")
        );
        
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