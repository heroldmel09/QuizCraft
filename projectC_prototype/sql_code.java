package projectC_prototype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sql_code {
    static final String url_sql="jdbc:mysql://localhost:3306/quiztest";
    static final String user="root", password="";
    private  HashMap<String,String> quiz_game= new HashMap<String,String>();
    private  HashMap<String,Integer> library= new HashMap<String,Integer>();
    private  HashMap<String,String> Share= new HashMap<String,String>();
    private  HashMap<String, Integer> check_duplicate= new HashMap<String,Integer>();
    private  HashMap<Integer, String[]> multi= new HashMap<Integer,String[]>();



    private static int use_id;
    private static String name;

    public int getUser_id(){
        return use_id;
    }

    public String getUser_name(){
        return name;
    }

    public static  void setUser_id(int id,String x){
        use_id=id;
        name=x;

    }

    
    public void sql_insert(ArrayList<String> key,ArrayList<String> value,int Quiz_id){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            for (int i = 0; i < key.size(); i++) {
            String insert=String.format("INSERT INTO quiz (Quiz_id, Answer, Question) VALUES ('%s','%s','%s')",Quiz_id,key.get(i),value.get(i));
            statement.executeUpdate(insert);
            System.out.println(insert);
            }
            connect.close();
            System.out.println("insert success");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("insert failed");
        }
    }

    public String sql_Quiz_name(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            ResultSet sql_Setquiz=statement.executeQuery("SELECT Quiz_name FROM quiz_library_db WHERE Quiz_id="+id);
            sql_Setquiz.next();
            String x =sql_Setquiz.getString(1);
            System.out.println("Delete completed");
            connect.close();
            System.out.println("insert success");
            return x;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("insert failed");
            return null;
        }
    }

    public void sql_Quiz_name(int id,String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            String sql=String.format("UPDATE quiz_library_db SET Quiz_name = '%s' WHERE quiz_library_db.Quiz_id = %s; ", name,id);
            statement.executeUpdate(sql);
           
            System.out.println("update completed");
            connect.close();
            System.out.println("insert success");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("insert failed");
        }
    }

    public void sql_delete_library(int Quiz_id){
        try {
          Class.forName("com.mysql.cj.jdbc.Driver"); 
          Connection connect=DriverManager.getConnection(url_sql, user, password);
          Statement statement=connect.createStatement();
          statement.executeUpdate("DELETE FROM quiz_library_db WHERE Quiz_id ="+Quiz_id);
          System.out.println("Delete completed");
          connect.close();
          System.out.println("insert success");

      } catch (Exception e) {
          // TODO: handle exception
          System.out.println(e);
          System.out.println("insert failed");
      }
  }

  public void sql_EditQ(int Quiz_id, String key,String value ){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection connect=DriverManager.getConnection(url_sql, user, password);
      Statement statement=connect.createStatement();
      String insert=String.format("UPDATE quiz SET Question='%s',Answer = '%s' WHERE quiz.quiz_num = %s;",value,key,Quiz_id);
      statement.executeUpdate(insert);
      System.out.println("update completed");
      connect.close();
      System.out.println("insert success");

  } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
      System.out.println("insert failed");
  }
}

  public void sql_delete_library(ArrayList<String> Quiz_Q){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection connect=DriverManager.getConnection(url_sql, user, password);
      Statement statement=connect.createStatement();
      for (String name:Quiz_Q){
            statement.executeUpdate("DELETE FROM quiz WHERE Question='"+name+"'");
      }
      System.out.println("Delete completed");
      connect.close();
      System.out.println("insert success");

  } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
      System.out.println("insert failed");
  }
}

    public void sql_insert(String key,String value,int Quiz_id){
        try {
          Class.forName("com.mysql.cj.jdbc.Driver"); 
          Connection connect=DriverManager.getConnection(url_sql, user, password);
          Statement statement=connect.createStatement();
          String insert=String.format("INSERT INTO quiz (Quiz_id, Answer, Question) VALUES ('%s','%s','%s')",Quiz_id,key,value);
          statement.executeUpdate(insert);
          System.out.println(insert);
          connect.close();
          System.out.println("insert success");

      } catch (Exception e) {
          // TODO: handle exception
          System.out.println(e);
          System.out.println("insert failed");
      }
  }


    public int create_quiz(String Quiz_name,int User_Id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            Statement statement2=connect.createStatement();
            check_duplicate=sql_library();
            if(!check_duplicate.containsKey(Quiz_name)){
            String insert=String.format("INSERT INTO quiz_library_db ( User_Id, Quiz_name) VALUES ('%s','%s');",User_Id,Quiz_name);
            statement.executeUpdate(insert);
            System.out.println(insert);
            String sql_set=String.format("SELECT Quiz_id FROM quiz_library_db WHERE User_Id='%s' and Quiz_name='%s' ",User_Id,Quiz_name);
            ResultSet Quiz_id=statement2.executeQuery(sql_set);
            if(Quiz_id.next()){
                System.out.println("insert success");
                int x=Quiz_id.getInt(1);
                System.out.println("insert success");
                connect.close();
                return x;
            }
        }else{
            int id=check_duplicate.get(Quiz_name);
            return id;
        }
           
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("insert failed");
        }
        return (Integer) null;
    }

    

    public HashMap<String,Integer> sql_library(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            String sql_format=String.format("SELECT Quiz_id, Quiz_name FROM quiz_library_db WHERE User_Id='%s' ",getUser_id());
            ResultSet sql_Setquiz=statement.executeQuery(sql_format);
            while(sql_Setquiz.next()){
                library.put(sql_Setquiz.getString(2), sql_Setquiz.getInt(1));
            }
            connect.close();
            System.out.println("display success");
            return library;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("display failed");
            return null;
        }
    }

    public boolean SQLShare_quiz(String Quiz_title,int user_name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            Statement statement1=connect.createStatement();
            Statement statement2=connect.createStatement();  
            ResultSet Title_name=statement.executeQuery("SELECT Quiz_id FROM quiz_library_db WHERE Quiz_name="+"'"+Quiz_title+"'");
            Title_name.next();
            int x=Title_name.getInt(1);
            System.out.println(x);
            int quiz_id=create_quiz(Quiz_title,user_name);
            ResultSet sql_Setquiz=statement1.executeQuery("SELECT Answer, Question FROM quiz WHERE Quiz_id="+x);
            while(sql_Setquiz.next()){
                Share.put(sql_Setquiz.getString(1), sql_Setquiz.getString(2));
            }

            for(Map.Entry<String,String> data:Share.entrySet()){
            String insert=String.format("INSERT INTO quiz (Quiz_id, Answer, Question) VALUES ('%s','%s','%s')",quiz_id,data.getKey(),data.getValue());
            statement2.executeUpdate(insert);
            }
            connect.close();
            System.out.println("display success");
            System.out.println(Share);
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("display failed");
            return false;
        }
        
    }


    public boolean SQLShare_quiz(String Quiz_title,String user_name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            Statement statement1=connect.createStatement();
            Statement statement2=connect.createStatement();
            Statement statement3=connect.createStatement();  
            ResultSet Title_name=statement.executeQuery("SELECT Quiz_id FROM quiz_library_db WHERE Quiz_name="+"'"+Quiz_title+"'");
            Title_name.next();
            int x=Title_name.getInt(1);
            ResultSet get_id=statement3.executeQuery("SELECT id FROM account_db WHERE User_name="+"'"+user_name+"'");
            get_id.next();
            int user_id=get_id.getInt(1);
            System.out.println(x);
            int quiz_id=create_quiz(Quiz_title,user_id);
            ResultSet sql_Setquiz=statement1.executeQuery("SELECT Answer, Question FROM quiz WHERE Quiz_id="+x);
            while(sql_Setquiz.next()){
                Share.put(sql_Setquiz.getString(1), sql_Setquiz.getString(2));
            }

            for(Map.Entry<String,String> data:Share.entrySet()){
            String insert=String.format("INSERT INTO quiz (Quiz_id, Answer, Question) VALUES ('%s','%s','%s')",quiz_id,data.getKey(),data.getValue());
            statement2.executeUpdate(insert);
            }
            connect.close();
            System.out.println("display success");
            System.out.println(Share);
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("display failed");
            return false;
        }
        
    }

    public HashMap<String,String> sql_display(int x){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connect=DriverManager.getConnection(url_sql, user, password);
            Statement statement=connect.createStatement();
            ResultSet sql_Setquiz=statement.executeQuery("SELECT Answer, Question FROM quiz WHERE Quiz_id="+x);
            while(sql_Setquiz.next()){
                quiz_game.put(sql_Setquiz.getString(1), sql_Setquiz.getString(2));
            }
            connect.close();
            System.out.println("display success");
            return quiz_game;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("display failed");
            return null;
        }
    
}

public HashMap<Integer, String[]> sql_Edit(int x){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection connect=DriverManager.getConnection(url_sql, user, password);
        Statement statement=connect.createStatement();
        ResultSet sql_Setquiz=statement.executeQuery("SELECT quiz_num,Answer, Question FROM quiz WHERE Quiz_id="+x);
        while(sql_Setquiz.next()){
            String key[]=new String[2];
            key[0]=sql_Setquiz.getString(3);
            key[1]=sql_Setquiz.getString(2);
            multi.put(sql_Setquiz.getInt(1),key);
        }
        connect.close();
        System.out.println("display success");
        return multi;

    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
        System.out.println("display failed");
        return null;
    }

}




    public static String getMd5(String input){
    try {

        // Static getInstance method is called with hashing MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // digest() method is called to calculate message digest
        // of an input digest() return array of byte
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    // For specifying wrong message digest algorithms
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}

public static String sql_createUser(String username,String pass){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection connect=DriverManager.getConnection(url_sql, user, password);
      Statement statement=connect.createStatement();
      Statement statement1=connect.createStatement();
      Statement insert=connect.createStatement();
      String check_user=String.format("SELECT User_name FROM account_db WHERE User_name='%s'",username);
      ResultSet sql_user=statement.executeQuery(check_user);
      String check_pass=String.format("SELECT `Password` FROM account_db WHERE `Password`='%s'",pass);
      ResultSet sql_pass=statement1.executeQuery(check_pass);

      if(!sql_user.next()){
        if (!sql_pass.next()){
            String encryptpass=getMd5(pass);
            String CreateUser=String.format("INSERT INTO account_db(User_name, Password) VALUES ('%s','%s')",username,encryptpass);
            insert.executeUpdate(CreateUser);
            System.out.println(CreateUser);
            return "successfully registered";
        }else{
            return "The password is Already Exists";
        }

      }else{
        System.out.println("no");
        return "The username is Already Exists";
      }

  } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
      System.out.println("insert failed");
      return null;
  }
}

public static String sql_login(String username,String pass){
    try {
      String encrypt=getMd5(pass);
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection connect=DriverManager.getConnection(url_sql, user, password);
      Statement statement=connect.createStatement();
      Statement statement2=connect.createStatement();
      String login=String.format("SELECT id,User_name FROM account_db WHERE Password = '%s' and User_name='%s'",encrypt,username);
      String check_user=String.format("SELECT User_name FROM account_db WHERE User_name='%s'",username);
      ResultSet sql_user=statement2.executeQuery(check_user);
      ResultSet sql_login=statement.executeQuery(login);
    if (sql_user.next()){
        if (sql_login.next()){
            setUser_id(sql_login.getInt(1),sql_login.getString(2));
            return "login success";
        }else{
            return "The password you’ve entered is incorrect";
        }
    }else{
        return "The username or password you entered is incorrect";
    }



      
  } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
      System.out.println("insert failed");
      return null;
  }
}

public static void main(String[] args) {
    System.out.println(sql_login("herolmel","12345"));
    
}
}
