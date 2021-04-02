
import java.sql.*;

public class controller {
    
    static PreparedStatement ps;
    static ResultSet rs;
    static login login=new login();
    static register register =new register();
    public  static String[] login_auth(String user, String password) {
        String sql = "select* from user WHERE username=? AND password=? ";
        String[] status=new String[4];
        try{
            Connection conn = db.getConnection();
           
            ps=conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
           rs= ps.executeQuery();
           if(rs.next()){
            status[0]=rs.getString("username");
            status[1]=rs.getString("id");
            status[2]=rs.getString("date");
            status[3]=rs.getString("level");
            String sql2 = "UPDATE `user` SET date=current_timestamp WHERE username=?";
            PreparedStatement ps1=conn.prepareStatement(sql2);
            ps1.setString(1, user);
            ps1.execute();

           }else{
            status[0]="notAuthorised";
            status[1]="notAuthorised";
            status[2]="notAuthorised";
            status[3]="notAuthorised";
           }

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public static boolean register_auth(String username, String fname, String lname,String email,String password) {
        String sql = "insert into user(username,fname,lname,email, password) values(?,?,?,?,?)";
        boolean status=false;
		try{
            Connection conn = db.getConnection();
		
		
		ps=conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, email);
        ps.setString(5, password);
        status=!ps.execute();
        login_auth(username, password);
        
        
		//below  commented code may lead to sql injection
		/*Statement st;
		st = con.createStatement();
		st.execute(sql);*/
		conn.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
        }
        return status;

        
    }
    public static boolean booksave(String isbn, String title, String author,String publisher) {
        String sql = "insert into books(isbn,title,author,publisher) values(?,?,?,?)";
        boolean status=false;
		try{
            Connection conn = db.getConnection();
		
		
		ps=conn.prepareStatement(sql);
        ps.setString(1, isbn);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setString(4, publisher);
        status=!(ps.execute());
        System.out.println(status);
        
		//below  commented code may lead to sql injection
		/*Statement st;
		st = con.createStatement();
		st.execute(sql);*/
		conn.close();
		}catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return status;

        
    }
    public  static boolean delete_book(String id) {
        String sql = "delete from books WHERE id=?";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
           status= !ps.execute();
           conn.close();
           
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public  static boolean update_book(String id,String isbn, String title, String author,String publisher) {
        String sql = "UPDATE `books` SET isbn=?, title=?,author=?,publisher=? WHERE id=?";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setString(5, id);
           status= !ps.execute();

           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public  static boolean update_user(String id,String user, String fname, String lname,String mail,String passcode,String userType) {
        String usertype=userType.equals("Admin")?"Admin":"user";
        String sql ="UPDATE `user` SET username=?, fname=?,lname=?,email=?,password=?,level=? WHERE id=?";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, mail);
            ps.setString(5, passcode);
            ps.setString(6, usertype);
            ps.setString(7, id);
           status= !ps.execute();

           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public  static boolean delete_user(String id) {
        String sql = "delete from user WHERE id=?";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
           status= !ps.execute();
           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public static boolean issue_book(String username, String isbn) {
        String sql = "insert into issued_book(username,isbn) values(?,?)";
        
        boolean status=false;
		try{
            Connection conn = db.getConnection();
		ps=conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, isbn);
        status=!ps.execute();
        String action="issue";
        updateBookStatus(isbn, action);

		//below  commented code may lead to sql injection
		/*Statement st;
		st = con.createStatement();
		st.execute(sql);*/
		conn.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
        }
        return status;

        
    }
        public static boolean return_book( String isbn) {
        String sql = "delete from issued_book where isbn=?";
        boolean status=false;
		try{
            Connection conn = db.getConnection();
		
		
		ps=conn.prepareStatement(sql);
        ps.setString(1, isbn);
        status=!ps.execute();
        String action="return";
        updateBookStatus(isbn, action);
        
        
        
		//below  commented code may lead to sql injection
		/*Statement st;
		st = con.createStatement();
		st.execute(sql);*/
		conn.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
        }
        return status;

        
    }
    public static boolean isbnValidate(String isbn){
        String sql = "select*from books WHERE isbn=? ";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, isbn);
            
           rs= ps.executeQuery();
           status=rs.next();
           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public static boolean usernameValidate(String isbn){
        String sql = "select*from user WHERE username=? ";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, isbn);
            
           rs= ps.executeQuery();
           status=rs.next();
           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }
    public static boolean checkBookInIssued(String isbn){
        String sql = "select*from issued_book WHERE isbn=? ";
        boolean status=false;
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, isbn);
            
           rs= ps.executeQuery();
           status=rs.next();
           conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
        return status;

    }

    public static  void updateBookStatus(String isbn,String action) {
        String sql = action.equalsIgnoreCase("issue")?"UPDATE `books` SET status='UNAVAILABLE' WHERE isbn=?":"UPDATE `books` SET status='AVAILABLE' WHERE isbn=?";
        try{
            Connection conn = db.getConnection();
    
            ps=conn.prepareStatement(sql);
            ps.setString(1, isbn);
            ps.execute();
            conn.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
    
        }
    }
}

