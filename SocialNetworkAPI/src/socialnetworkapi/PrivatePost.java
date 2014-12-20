package socialnetworkapi;

import java.util.List;

public class PrivatePost extends PrivacyPost {
    private UserPost post;
    
    public PrivatePost(UserPost p){post=p;}
    
    public boolean savePost(){
//        List l = UserModel.getUserFriends(post.getUser());
        return PostModel.createPost(post);
        
    }
  
    public void setAllowedMembers() {
  
    }

}