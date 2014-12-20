package socialnetworkapi;

import java.util.List;
import java.util.Vector;

public class Page extends IPage {

   // public List<IUser> users;
    private int id;
    private String name;
    private IUser owner;
    public Page(int id,String name,IUser owner){
        this.id=id;
    }
    public int getId(){return id;}
   
    
    public static boolean likeAPage(Page page,IUser userObject) {
     
      PageModel.createLike(page, userObject);
      return true;
  }

    

}