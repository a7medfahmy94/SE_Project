package socialnetworkapi;

import java.util.ArrayList;
import java.util.Map;

public class Group {

    private String title;
    private String coverPic;
    public String privacy;
    public int id;
    private ArrayList<IUser> users;

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getCoverPic(){return coverPic;}
    public ArrayList<IUser> getUsers(){return users;}

    public Group(int id,String title,String coverPic,String privacy){
        this.id =  id;
        this.title = title;
        this.coverPic = coverPic;
        this.privacy = privacy;
    }
    
    public void initUsers(){
        users = GroupModel.getMembers(this);
    }
    
    public boolean addMember(IUser user) {
        if(!isMember(user)){
            users.add(user);
            GroupModel.addMemberToGroup(this, user, "member");
            return true;
        }else{
            return false;
        }
    }

    public boolean isMember(IUser user){
        for(int i = 0 ; i < users.size(); i++){
            if(users.get(i).getId() == user.getId()){
                return true;
            }
        }
        return false;
    }
    
    
    
    public void removeMember() {
    }

    public void setRole() {
    }

    public static boolean promoteUser(IUser user, String newRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}