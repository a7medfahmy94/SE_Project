package socialnetworkapi;

import java.util.Vector;

public abstract class IPage {

    public Vector  myUser;
    /**
   * 
   * @element-type User
   */
  public Vector  like;

  public static boolean likeAPage(IPage page,IUser userObject) {
      return true;
  }

}