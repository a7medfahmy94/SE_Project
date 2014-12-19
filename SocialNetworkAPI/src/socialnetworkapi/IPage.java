package socialnetworkapi;

import java.util.Map;
import java.util.Vector;

public abstract class IPage {
    private static IPage pageObject;
    public Vector  myUser;
    /**
   * 
   * @element-type User
   */
  public Vector  like;

  public static boolean likeAPage(IPage page,IUser userObject) {
     
      PageModel.createLike(page, userObject);
      return true;
  }
  public static IPage createPage(Map<String,String>data,IUser object){
      return pageObject;
  }

}