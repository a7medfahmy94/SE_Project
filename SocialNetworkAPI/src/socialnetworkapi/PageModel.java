package socialnetworkapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PageModel {

    public Page myPage;
    
  public void deletePage() {
  }

    public static Page getPage(int id) {
        String q = "select * from pages where id=" + id;
        ArrayList<Page> p = getPagesFromResult(new DB().executeQuery(q));
        if(p == null || p.size() == 0){
            System.out.println("No pages found with id=" + id);
            return null;
        }else{
            return p.get(0);
        }
    }

    public static ArrayList<Page> getPagesFromResult(ResultSet r){
        ArrayList<Page> ret = new ArrayList<>();
        try {
            while(r.next()){
                IUser owner = UserModel.getUser(r.getInt("owner"));
                ret.add(new Page(r.getInt("id") , r.getString("name"),owner));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PageModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
  public void updatePage() {
  }
  public static boolean createLike(Page page,IUser user){
      
        DB db = new DB();
        String q = "insert into pagesLikes VALUES(" +    
                page.getId() + "," + user.getId() 
                + ")";
        System.out.println(q);
        return db.execute(q);
        
  }
   public static boolean createPage(IPage page,IUser user){
      return true;
  }
}