package socialnetworkapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class IUser {

    private static IUser currentUser;
    
    protected ArrayList<Group> subscribedGroups = new ArrayList<>();
    protected ArrayList<IPage> likedPages = new ArrayList<>();
    protected ArrayList<IUser> friendsList = new ArrayList<>();
    protected String name;
    protected String email;
    protected String gender;
    protected String type;
    protected int id;

    
    public String getEmail(){return email;}
    public String getName(){return name;}
    public int getId(){return id;}
    public String getGender(){return gender;}
    public String getType(){return type;}
    
    
    public abstract boolean sendFriendRequest(IUser u);

    public void initFriendsList(){
        friendsList = UserModel.getFriendsList(this);
    }
    
    public boolean addFriend(IUser user){
        UserModel.addNewFriendship(this,user);
        return true;
    }

    public static boolean signUp(HashMap<String,String> data) {
        IUser newUser;
        if(data.get("userType").equals("premium")){
//            newUser = PremiumUser.makeInstance();
        }else{
//            newUser = NormalUser.makeInstance();
        }
//        if(newUser != null){
//            return UserModel.saveUserData(newUser);
//        }
        return false;
    }

    public static IUser getCurrentActiveUser() {
        return currentUser;
    }
    public static void setCurrentUser(IUser u){
        currentUser = u;
    }
    public ArrayList<IUser> getFriendsList(){
        return friendsList;
    }
    
    
    public static IUser login(String email,String password) {
        if(UserModel.verify(email,password)){
            return UserModel.getUser(email);
        }
        return null;
    }

    public void logout() {
    }

    private void User() {
    }


}