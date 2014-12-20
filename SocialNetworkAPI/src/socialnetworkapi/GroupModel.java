package socialnetworkapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroupModel {
    
    public static HashMap<Integer,String> getMembers(Group group){
        HashMap<Integer,String> ret = new HashMap<>();
        String q = "select * from groupsMembers where groupId=" + group.getId();
        ResultSet r = new DB().executeQuery(q);
        ret = GroupModel.getMembersFromResult(r);
        return ret;
    }
    
    public static boolean createGroup(Group groupObject){
        return true;
    }
    public static boolean updateGroupPhoto(Group groupObject,String photo) {
        String q = "update groups set coverPic='" + photo + 
                "' where id=" + groupObject.getId(); 
        return new DB().execute(q);
    }
    public static boolean addMemberToGroup(Group group,IUser user,String role){
        DB db = new DB();
        String q = "insert into groupsMembers VALUES(" +    
                user.getId() + "," + group.getId() + ",'" + role
                + "')";
        System.out.println(q);
        return db.execute(q);
    }
    public static boolean updateUserGroup(IUser user,String newRole){
        return true;
    }
    public static Group getGroup(int id) {
        String q = "select * from groups where id=" + id;
        DB db = new DB();
        ResultSet r = db.executeQuery(q);
        ArrayList<Group> ret = getGroupsFromResult(r);
        if(ret == null || ret.size() == 0){
            System.out.println("No groups with id=" + id);
            return null;
        }
        Group g = ret.get(0);
        g.initUsers();
        return g;
    }

    public void deleteGroup() {
    }
    
    public static ArrayList<Group> getGroupsFromResult(ResultSet r){
        ArrayList<Group> ret = new ArrayList<>();
        try {
            while(r.next()){
                ret.add(new Group(Integer.valueOf(r.getString("id"))
                        ,r.getString("title"),r.getString("coverPic"),
                        r.getString("privacy")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public static HashMap<Integer,String> getMembersFromResult(ResultSet r){
        HashMap<Integer,String> ret = new HashMap<>();
        try {
            while(r.next()){
                ret.put(r.getInt("userId"),r.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}