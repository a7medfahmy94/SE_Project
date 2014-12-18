package socialnetworkapi;

public class UserPost extends Post {
    private IUser user;
    
    public void setUser(IUser u){user = u;}
    public IUser getUser(){return user;}
    
    public void writePost() {
        
    }

}