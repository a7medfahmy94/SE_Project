package socialnetworkapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APICont {
    public boolean login(Map<String,String>data){
        IUser.login(data);
        return true;
    }
    public boolean promoteMember(IUser user,String newRole){
        IGroup.promoteUser(user, newRole);
        return true;
    }
    
    
    public List<IUser> searchForUser(String email){
        List<IUser> ret;
        IUser user = IUser.getCurrentActiveUser();
        ret = UserModel.getUsers(email);
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
    public boolean likeAPage(IPage page){
        IUser userObject=IUser.getCurrentActiveUser();
        IPage.likeAPage(page,userObject);
        
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
        IGroup groupObject=IGroup.makeGroup(data, userObject);
        GroupModel.createGroup(groupObject);
        
        return true;
    }
    public boolean changeGroupCover(String photo){
        IUser userObject=IUser.getCurrentActiveUser();
        return true;
    }
    public boolean addMember(IGroup group,IUser user){
        IGroup.addMember(user);
        return true;
    }
    public ArrayList<IUser> getPendingRequests(){
        IUser userObject=IUser.getCurrentActiveUser();
        ArrayList<IUser> users=new ArrayList<>();
        users=IUser.getPendingRequests();
        return users ;
        
    }
    public boolean addFriend(IUser user){
        IUser.addFriend(user);
        return true;
    }
}


/*
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/Bankdatabase";//database name

// Database credentials
static final String USER = "root";
static final String PASS = "";

Connection conn=null;
Statement stmt =null;
PreparedStatement pst = null;

try {

// STEP 2: Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    stmt = conn.createStatement();

    ////////////////////////////////////////////////////
      String sql2 = "select  username from client";//client is table name
    ResultSet rs = stmt.executeQuery(sql2);
    // STEP 5: Extract data from result set
    while (rs.next()) {
            // Retrieve by column name
            String name = rs.getString("Username");//column name
        System.out.println(name);

    }

    rs.close();



    conn.close();
    stmt.close();
    pst.close();

}
catch(ClassNotFoundException e){
    //System.out.println("error");

}catch(SQLException e)
{
    //    System.out.println("sql error");

}
*/