package socialnetworkapi;

import java.util.HashMap;

public class PremiumUser extends IUser {

    
    private String creditCardNumber;

    public PremiumUser(int id,String name,String email,String gender){
        this.type = "premium";
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public boolean payByCredit() {
        return true;
    }

    public static IUser makeInstance(HashMap<String,String> data){
        PremiumUser ret = new PremiumUser(
            Integer.valueOf(data.get("id")),data.get("name"),data.get("email"),
            data.get("gender")
        );
        
        if(ret.payByCredit()){
            return ret;
        }else{
            return null;
        }
    }


    public boolean sendFriendRequest(IUser u) {
        return UserModel.makeFriendRequest(this, u);
    }

    public void addFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}