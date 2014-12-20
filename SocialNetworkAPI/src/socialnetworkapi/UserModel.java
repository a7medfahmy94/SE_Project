package socialnetworkapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel {

    public static IUser myUser;

  public void CreateUser() {
  }

  public void DeleteUser() {
  }


  public void updateUser() {
  }
  
  public static boolean saveUserData(IUser object){
      return true;
  }
  
  public static ArrayList <IUser> getFriendsList(IUser user){
      ArrayList<IUser> ret = new ArrayList<>();
      DB db = new DB();
      int id = user.getId();
      String query = "select * from friends where userOne="+id+" or " +
              "userTwo=" + id;
      ResultSet r = db.executeQuery(query);
        ret = getUserFromResult(r);
        
        return ret;
  }
 
    public static boolean makeFriendRequest(IUser s,IUser d){
        return true;
    }
    public static boolean addNewFriendship(IUser one,IUser two){
        DB db = new DB();
        String q = "insert into friends VALUES("+ one.getId()+
                "," + two.getId() + ", '"+ "pending" +"' )";
        db.execute(q);
        return true;
    }
    
    public static boolean verify(String email,String password){
        String q = "select * from users where email='" + email +"' and " +
                "password='" + password + "'";
        ArrayList<IUser> r = getUserFromResult(new DB().executeQuery(q));
        if(r == null || r.size() == 0){
            return false;
        }
        return true;
    }
    
    public static IUser getUser(String email){
        String q = "select * from users where email='" + email +"'";
        ArrayList<IUser> r = getUserFromResult(new DB().executeQuery(q));
        if(r == null || r.size() == 0){
            System.out.println("no user with email=" + email);
            return null;
        }
        return r.get(0);
    }
    
    public static IUser getUser(int id){
        String q = "select * from users where id=" + id;
        DB db = new DB();
        ResultSet r = db.executeQuery(q);
        ArrayList<IUser> ret = UserModel.getUserFromResult(r);
        if(ret == null || ret.size() == 0){
            System.out.println("can't find user with id=" + id);
            return null;
        }else{
            return ret.get(0);
        }
    }
    
    public static ArrayList<IUser> getUserFromResult(ResultSet r){
        ArrayList<IUser> ret = new ArrayList<>();
        try {
            while(r.next()){
                HashMap<String,String> data = new HashMap<>();
                data.put("name", r.getString("name"));
                data.put("id", r.getString("id"));
                data.put("email", r.getString("email"));
                data.put("type", r.getString("type"));
                data.put("gender", r.getString("gender"));
                if(r.getString("type").equals("normal")){
                    ret.add(NormalUser.makeInstance(data));
                }else{
                    ret.add(PremiumUser.makeInstance(data));
                }
            }
        } catch (SQLException ex) { 
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}