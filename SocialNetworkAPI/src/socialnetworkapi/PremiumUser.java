package socialnetworkapi;

public class PremiumUser extends IUser {

  public String creditCardNumber;

  private PremiumUser(){}
    
  public boolean payByCredit() {
      return true;
  }
  
  public static IUser makeInstance(){
      PremiumUser ret = new PremiumUser();
      if(ret.payByCredit()){
          return ret;
      }else{
          return null;
      }
  }

    @Override
    public boolean sendFriendRequest(IUser u) {
        return UserModel.makeFriendRequest(this, u);
    }

    @Override
    public void addFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}