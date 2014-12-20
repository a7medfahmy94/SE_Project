package socialnetworkapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APICont {
    
    public boolean login(String email,String password){
        IUser user = IUser.login(email,password);
        if(user != null){
            IUser.setCurrentUser(user);
            return true;
        }
        return false;
    }
    
    public boolean promoteMember(IUser user,String newRole){
//        IGroup.promoteUser(user, newRole);
        return true;
    }
    
    public IUser searchForUser(String email){
        IUser ret;
        IUser user = IUser.getCurrentActiveUser();
        ret = UserModel.getUser(email);
        return ret;
    }
    
    public boolean createUser(HashMap<String,String> data){
        return IUser.signUp(data);        
    }
    
    public boolean makeAPost(String text){
        IUser user = IUser.getCurrentActiveUser();
        UserPost post = new UserPost();
        post.setUser(user);
        PrivatePost ppost = new PrivatePost(post);
        return ppost.savePost();
    }

    public boolean sendFriendRequest(IUser user){
        IUser activeUser = IUser.getCurrentActiveUser();
        activeUser.sendFriendRequest(user);
        return true;
    }
    
    public boolean sendAMessage(IUser user){
        Message m = new ChatMessage();
        m.addReceiver(user);
        m.sendMessage();
        return true;
    }
    
    public boolean likeAPage(Page page){
        IUser userObject=IUser.getCurrentActiveUser();
        Page.likeAPage(page,userObject);
        
        return true;
    }
    public ArrayList<String> getMessage(IUser user){
        ArrayList <String> messages=new ArrayList<>();
        IUser userObject=IUser.getCurrentActiveUser();
        messages=MessageModel.getMessage(user,userObject);
        return messages;
    }

   
    public boolean createPage(Map<String,String>data){
        IUser userObject=IUser.getCurrentActiveUser();
        IPage obj=IPage.createPage(data, userObject);
        PageModel.createPage(obj, userObject);
        
       return true; 
    }
    public boolean createGroup(Map<String,String>data){
        IUser userObject=IUser.getCurrentActiveUser();
//        Group groupObject=Group.makeGroup(data, userObject);
//        GroupModel.createGroup(groupObject);
        
        return true;
    }
    public boolean changeGroupCover(Group group,String photo){
        IUser user=IUser.getCurrentActiveUser();
        group.changeGroupPicture(user,photo);
        return true;
    }
    public boolean addMember(Group group,IUser user){
        return group.addMember(user);
    }
   
    public boolean addFriend(IUser user){
        IUser current = IUser.getCurrentActiveUser();
        ArrayList<IUser> friends = current.getFriendsList();
        for(int i = 0 ; i < friends.size(); i++){
            if(friends.get(i).getId() == user.getId()){
                return false;
            }
        }
        current.addFriend(user);
        return true;
    }
    
    public static void main(String args[]){
        //login
        APICont api = new APICont();
        if(api.login("a7med.fahmy94@gmail.com", "123456")){
            System.out.println(IUser.getCurrentActiveUser().getEmail());
        }else{
            System.out.println("Wrong email or password");
        }
        
// add member        
        //Group group = new GroupModel().getGroup(1);
        //IUser user = UserModel.getUser(1);
        //if(user != null && group != null){
        //    new APICont().addMember(group, user);
      //  }
        
   // add friend
//        IUser.currentUser = new NormalUser(1,"ahmed fahmy",
//                "a7med.fahmy94@gmail.com","male");
//        APICont api = new APICont();
//        api.addFriend(new NormalUser(2,"hala mohamed","hala.mohamed199@gmail.com"
//                ,"female"));
    
 // likeApage 
//        IUser.currentUser = UserModel.getUser(1);
//        APICont api = new APICont();
//        api.likeAPage(PageModel.getPage(1));
        
        //update cover photo
//        Group g = GroupModel.getGroup(1);
//        IUser owner = UserModel.getUser(2);
//        IUser.currentUser = owner;
//        new APICont().changeGroupCover(g, "HOPA");
    }
}


