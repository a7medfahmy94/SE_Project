package socialnetworkapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {

    private String title;
    private String coverPic;
    public String privacy;
    public int id;
    private HashMap<Integer,String> users;

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getCoverPic(){return coverPic;}
    public HashMap<Integer,String> getUsers(){return users;}

    public Group(int id,String title,String coverPic,String privacy){
        this.id =  id;
        this.title = title;
        this.coverPic = coverPic;
        this.privacy = privacy;
    }
    
    public boolean changeGroupPicture(IUser user,String newPic){
        if(canChangeCover(user)){
            return GroupModel.updateGroupPhoto(this, newPic);
        }
        return false;
    }
    
    private boolean canChangeCover(IUser user){
        if(users.containsKey(user.getId())){
            return users.get(user.getId()) != "member";
        }
        return false;
    }
    
    public void initUsers(){
        users = GroupModel.getMembers(this);
    }
    
    public boolean addMember(IUser user) {
        if(!isMember(user)){
            GroupModel.addMemberToGroup(this, user, "member");
            return true;
        }else{
            return false;
        }
    }

    public boolean isMember(IUser user){
        return users.containsKey(user.getId());
    }
    
    
    
    public void removeMember() {
    }

    public void setRole() {
    }

    public static boolean promoteUser(IUser user, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}