package blood_donation_system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdul-Rhman Osama
 */
public class DataBase {

    private Connection con = null;
    private Statement query = null;
    private ResultSet res = null;

    DataBase() {
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodDonation", "app", "Admin");
            System.out.println("Connectiong Created Done");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    /***********************************************************************************************************/
    /***********************************************************************************************************/
    
    
    
    /***********************************************************************************************************/
    /***********************************************************************************************************/
    boolean firsttime (double id)
    {
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Boolean Found=false;
       
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+""; 
          sql1 =  "select FIRSTLOGIN from USERS where ID='"+id+"'";
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
              System.out.println("a");
              if (rs.getBoolean("FIRSTLOGIN"))
              {
                  Found = true;
                  break;
              }
          }
          rs.close();
          stmt.close();
          conn.close();
          }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(Found);
    return Found;
    }
    /***********************************************************************************************************/
    /***********************************************************************************************************/
    boolean checkUserName (String UserName)
    {
        String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Boolean Found=false;
       
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+""; 
          sql1 =  "select USER_NAME from USERS";
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
              System.out.println("a");
              if (UserName.equals(rs.getString("USER_NAME")))
              {
                  Found = true;
                  break;
              }
          }
          rs.close();
          stmt.close();
          conn.close();
          }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(Found);
    return Found;
    }
    /*******************************************************************************************************************/
    /*******************************************************************************************************************/
    boolean checkHospital (String Hospital)
    {
        String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Boolean Found=false;
       
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+""; 
          sql1 =  "select HOSPITAL from USERS";
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
              System.out.println("a");
              if (Hospital.equals(rs.getString("HOSPITAL")))
              {
                  Found = true;
                  break;
              }
          }
          rs.close();
          stmt.close();
          conn.close();
          }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(Found);
    return Found;
    }
   /************************************************************************************************************/ 
   /************************************************************************************************************/ 
    void UpdateUser (String UserName, String Password, Double ID, String Email, String Phone,String Name)
    {
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
            System.out.println(Name);
            System.out.println(UserName);
            System.out.println(Password);
            System.out.println(ID);
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE USERS SET USER_NAME='"+ UserName +"' ,PASSWORD='"+ Password +"', FIRSTLOGIN=false , EMAIL='"+Email+"', PHONENUM='"+Phone+"' "
                  + "WHERE ID="+ ID.toString() +" " ; 
           UpdateUsername ( ID, Name);
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
 /************************************************************************************************************/ 
 void UpdateUsername (Double ID,String Name)
    {
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
            System.out.println(Name);
            System.out.println(ID);
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE USERS SET NAME='"+Name+"'"
                  + "WHERE ID="+ ID.toString() +" " ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    
    
  /************************************************************************************************************/ 
    Double CheckUser(String UserName, String Password, String City, String Hospital) 
    {
        String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Double ID1 = null;
        Connection conn = null;
        Statement stmt = null;
        Boolean firsttime=false;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("hos: " + Hospital);
            System.out.println("cit: " + City);
            System.out.println("pass: " + Password);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+""; 
          
            sql1 =  "select ID, FIRSTLOGIN from USERS where USER_NAME ='"+UserName+"' and PASSWORD='"+Password+"'"
                    + "and CITY='"+City+"' and HOSPITAL='"+Hospital+"'";
            ResultSet rs = stmt.executeQuery(sql1);
            
            //STEP 5: Extract data from result set
            while (rs.next()) {
                ID1 = rs.getDouble("ID");
                firsttime=rs.getBoolean("FIRSTLOGIN");
                System.out.println("User1: " + ID1); 
            }
            
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

            
                if (firsttime)
                {
                    Terms1 t=new Terms1();
                    t.setVisible(true);
                    t.jLabel2.setVisible(false);
                    t.jLabel2.setText(ID1.toString());
                    return ID1;
                }
                if (ID1 >= 2.0)
                {
                UserPanel u=new UserPanel();
                u.jLabel20.setText(City);
                u.jLabel21.setText(Hospital);  
                DataBase db=new DataBase();
                byte[] img = db.getimage(City,Hospital);
                 String name = Fetchname( City,  Hospital);
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(u.jLabel1.getWidth(), u.jLabel1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                u.jLabel1.setIcon(newImage);
                u.Name.setText(name);
//                u.add(....)
                u.pack();
                u.setVisible(true);
                }
               return ID1; 
          
              
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return 0.0;
      
}
    /***********************************************************************************************************/
    /***********************************************************************************************************/
   
    
    public static void applyQualityRenderingHints(Graphics2D g2d) {

    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

}
    
    String Fetchname(String city, String hospital) 
   {
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        String name=null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select NAME from USERS where CITY='"+city+"'and HOSPITAL='"+hospital+"'" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            name=rs.getString("NAME");
      
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
  return name;
   
   }
/*********************************************************************************************************************/    
  double MaxID ()
  {
  String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        Double max=0.0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ID from USERS" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            ID=rs.getDouble("ID");
            if (Double.compare(max,ID)<0)
                max=ID;
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(max);
  return max;
  }
    /*******************************************************************************************************************/
    /*******************************************************************************************************************/
  boolean InsertIntoUsers (double ID, String Username,String Password, String City, String Hospital)
  {
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double id=0.0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1,sql2;
            System.out.println(ID);
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "INSERT INTO USERS(ID, USER_NAME, PASSWORD, CITY, HOSPITAL, FIRSTLOGIN)"
                  + " VALUES ("+ ID +",'"+ Username +"','"+ Password +"','"+ City +"','"+ Hospital +"',true)" ;  
          stmt.executeUpdate(sql1);
     sql2 = ("Select ID from USERS where USER_NAME='"+Username+"' "
             + "and PASSWORD='"+Password+"' and CITY='"+City+"' and HOSPITAL='"+Hospital+"'");
          ResultSet res =stmt.executeQuery(sql2);;
          while(res.next())
          {
            id=res.getDouble("ID");
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }   
  if (Double.compare(id, ID)==0)
      return true;
  else 
      return false;
  }
/************************************************************************************************************************/
  /************************************************************************************************************************/
   double MaxPatientID ()
  {
  String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        Double max=0.0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ID from DONORNAME" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            ID=rs.getDouble("ID");
            if (Double.compare(max,ID)<0)
                max=ID;
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(max);
  return max;
  }
/************************************************************************************************************************/
/*************************************************************************************************************************/
boolean AddDonor(String uName,String BloodType,String gender,String phNo,String City,String Hospital,int age,int HeartRate,int Hemoglobin,int BloodPressure,int NoOfBags,int BloodPressure2,Double Temperature,Double ID, Double weight )
{
 String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        String BloodPressure3 =(String.valueOf(BloodPressure))+" / "+(String.valueOf(BloodPressure2));
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1,sql2,sql3;
            System.out.println(ID);
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "INSERT INTO DONORNAME(ID, NAME, BLOODTYPE, CITY, HOSPITAL, NOOFBAGS, PHONE)"
                  + " VALUES ("+ ID +",'"+ uName +"','"+ BloodType +"','"+ City +"','"+ Hospital +"',"+ NoOfBags +",'"+ phNo +"')" ;  
          stmt.executeUpdate(sql1);
     sql2 = "INSERT INTO DONORPERSONAL(ID, AGE, GENDER, HAEMOGLOBIN, HEARTRATE, BLOODPRESSURE, TEMPERATURE, WEIGHT)"
                  + " VALUES ("+ ID +","+ age +",'"+ gender +"',"+ Hemoglobin +","+ HeartRate +",'"+ BloodPressure3 +"',"+ Temperature +","+weight+")" ;
          stmt.executeUpdate(sql2);;
     sql3 = "INSERT INTO DONORINVESTGATION(ID)"
                  + " VALUES ("+ID +")" ;
          stmt.executeUpdate(sql3);;     
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }   
        return true;
}
/************************************************************************************************************************/
/*************************************************************************************************************************/
String DonorName (Double ID, String City, String Hospital)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        String name=null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1,sql2,sql3;
            System.out.println(ID);
              sql1 =  " SELECT NAME FROM DONORNAME where ID="+ID+" and CITY='"+City+"' and HOSPITAL='"+Hospital+"'" ;  
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next())
            {
              name=rs.getString("NAME");
            }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
           
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            
        }
        return name;
}
/********************************************************************************************************************/
/********************************************************************************************************************/
boolean UpdateMedicalState(boolean VirusB,boolean VirusC,boolean Aids,boolean Syphilis,boolean ACCEPTED,Double ID)
{
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        String name=null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1,sql2,sql3;
            System.out.println(ID);
              sql1 =  "UPDATE DONORINVESTGATION SET VIRUSB='"+ VirusB +"' ,VIRUSC='"+ VirusC +"' ,AIDS='"+Aids+"' ,SYPHILIS='"+Syphilis+"' ,ACCEPTED='"+ACCEPTED+"' "
                  + "WHERE ID="+ID+" " ; ;  
             stmt.executeUpdate(sql1);
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
           return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;
}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
String FetchEmail(String UserName)
{
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        String Email=null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select EMAIL from USERS where USER_NAME='"+UserName+"'" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            Email=rs.getString("EMAIL");
      
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
  return Email;
}
/**********************************************************************************************************************/
/**********************************************************************************************************************/
 double MaxRestore (String Email)
  {
  String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        Double max=0.0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select RESTORE from USERS" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            ID=rs.getDouble("RESTORE");
            if (Double.compare(max,ID)<0)
                max=ID;
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(max);
        Random random = new Random();
       String number = String.format("%04d", random.nextInt(10000));
        max+= Double.valueOf(number);
       if (Double.compare(999999,max)<0)
        {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Update USERS SET RESTORE=0.0" ;  
          stmt.executeUpdate(sql1);
 
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
            Double Max=MaxRestore(Email);
            return Max;
        }
       
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Update USERS SET RESTORE ="+max+" where EMAIL='"+Email+"'" ;  
         stmt.executeUpdate(sql1);
          
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
  return max;
  }
 /**********************************************************************************************************************/
/**********************************************************************************************************************/
 boolean CheckCode (String user, double Code)
    {
        String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Boolean Found=false;
       
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+""; 
          sql1 =  "select RESTORE from USERS where USER_NAME='"+user+"'";
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
              if (Double.compare(Code, rs.getDouble("RESTORE"))==0)
              {
                  Found = true;
                  break;
              }
          }
          rs.close();
          stmt.close();
          conn.close();
          }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(Found);
    return Found;
    }
/**********************************************************************************************************************/ 
/**********************************************************************************************************************/
boolean updatePassword(String Password, String Username)
{
 String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE USERS SET PASSWORD='"+ Password +"' WHERE USER_NAME='"+ Username +"'" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;
}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
boolean checkAcceptance(double id)
{
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       boolean acc=false;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ACCEPTED from DONORINVESTGATION where ID="+id ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while (rs.next())
          {
          acc=rs.getBoolean("ACCEPTED");
          }
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return acc;

}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
int NoOfBags (String Type,String Hospital)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       int total=0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ID, NOOFBAGS from DONORNAME where HOSPITAL='"+Hospital+"' and BLOODTYPE='"+Type+"'" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while (rs.next())
          {
              boolean x=checkAcceptance(rs.getDouble("ID"));
              int v= rs.getInt("NOOFBAGS");
              if (x)
              {
                total+=v;
              }
          }
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return total;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return total;
        }
return total;
}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
boolean SendRequest (int NoOfBags, String HospitalRequest, String OwnerHospital, String BloodType, Double ID)
{
    String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "INSERT INTO RESERVATIONREQUESTS (NOOFBAGS,HOSPITALREQUEST, OWNERHOSPITAL, BLOODTYPE, ID) VALUES("+ NoOfBags +",'"+HospitalRequest+"' , '"+OwnerHospital+"' ,'"+BloodType+"',"+ID+")" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;
}
/******************************************************************************************************************/
/******************************************************************************************************************/
double MaxRequestID ()
  {
  String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double ID=1.0;
        Double max=0.0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ID from RESERVATIONREQUESTS" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            ID=rs.getDouble("ID");
            if (Double.compare(max,ID)<0)
                max=ID;
          }
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println(max);
  return max;
  }
/*****************************************************************************************************************/
/*****************************************************************************************************************/
boolean AccRequest(Double ID, String Hospital, String BloodType,int NoOfbags)
{
   
   boolean state=updateBloodDatabase(NoOfbags, Hospital, BloodType);
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       
if(state)
{ 
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE RESERVATIONREQUESTS Set ACCEPT='Accepted' where ID="+ID+"" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
 return true;       
}
return false;
}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
boolean updateBloodDatabase (int NoOfBags,String Hospital, String BloodType)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select ID, NOOFBAGS from DONORNAME where HOSPITAL='"+Hospital+"' and BLOODTYPE='"+BloodType+"'" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while (rs.next())
          {
              int numberoriginal=rs.getInt("NOOFBAGS");
              double ID = rs.getDouble("ID");
              System.out.println("No of bages = "+numberoriginal);
              System.out.println("ID = "+ID);
              if (NoOfBags>0)
              {
                if (NoOfBags > numberoriginal)
                {
                  NoOfBags-=numberoriginal;
                  UpdateNoOfBags(ID, 0);
                }
                else if(NoOfBags < numberoriginal)
                {     
                    UpdateNoOfBags(ID, numberoriginal-NoOfBags);
                    NoOfBags=0;
                }
                else if (NoOfBags == numberoriginal)
                {
                    UpdateNoOfBags(ID,0);
                    NoOfBags=0;
                }
              }
              if (NoOfBags==0)
                  return true;
              
          }
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;
}
/***************************************************************************************************************/
/***************************************************************************************************************/
void UpdateNoOfBags(Double ID,int Noupdated)
 {
  String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE DONORNAME Set NOOFBAGS="+Noupdated+" where ID="+ID+"";  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
 }
/*****************************************************************************************************************/
/*****************************************************************************************************************/
boolean RejRequest(Double ID)
{
   
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE RESERVATIONREQUESTS Set ACCEPT='Rejected' where ID="+ID+"" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;
}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
String CheckDonorName(Double ID, String Hospital, String City)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        String Name=null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "Select Name  from DONORNAME where HOSPITAL='"+Hospital+"' and CITY='"+City+"' and ID="+ID+"" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while (rs.next())
          {
              Name=rs.getString("NAME");
          }      
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return null;
        }
        System.out.println(Name);
return Name;
}
/***************************************************************************************************************/
/***************************************************************************************************************/
boolean AccRequest2(Double ID)
{
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE RESERVATIONREQUESTS Set DELIVERD="+true+" where ID="+ID+"" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
 return true;       

}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
void insertintoHospital (String hospital , String city, double ID)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        Double id=0.0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1,sql2;
            System.out.println(ID);
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "INSERT INTO CITY_HOSPITAL (ID, CITY, HOSPITAL)"
                  + " VALUES ("+ ID +",'"+ city +"','"+ hospital +"')" ;  
          stmt.executeUpdate(sql1);
    
          
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }   

}
/*****************************************************************************************************************/
/*****************************************************************************************************************/
private Connection connect() {
        // SQLite connection string
        String USER = "app";
        String PASS = "app";
        String url = "jdbc:derby://localhost:1527/BloodDonation";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
/******************************************************************************************************************/
/******************************************************************************************************************/
void updatepic(byte[] pic,Double ID,String filename) throws SQLException
{
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodDonation","app","app");
    Statement st = con.createStatement();       
    String updateSQL = "UPDATE USERS "
                + "SET IMAGED = ? "
                + "WHERE ID=?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, pic);
            pstmt.setDouble(2, ID);

            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/******************************************************************************************************************/
/******************************************************************************************************************/
byte[]  getimage(String city , String hospital)
{
   byte[] img=null;
    try{
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodDonation","app","app");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select IMAGED from USERS where CITY ='"+city+"' and HOSPITAL ='"+hospital+"'");
                if(rs.next()){
                    img = rs.getBytes("IMAGED");
                    //Resize The ImageIcon
//                    ImageIcon image = new ImageIcon(img);
//                    Image im = image.getImage();
//                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
//                    ImageIcon newImage = new ImageIcon(myImg);
//                    label.setIcon(newImage);
                }
                
                else{
                    //JOptionPane.showMessageDialog(null, "No Data");
                    
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        return img;
        }
/*****************************************************************************************************************/
/*****************************************************************************************************************/
int noOfRequests ( String Hospital)
{
int requests=0;
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "SELECT NOOFBAGS FROM RESERVATIONREQUESTS where OWNERHOSPITAL='"+Hospital+"'" ;  
          ResultSet rs = stmt.executeQuery(sql1);
          while(rs.next())
          {
            requests++;
          }
          stmt.close();
          conn.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return requests;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return requests;
        }
 return requests;  
}
/***************************************************************************************************************/
/***************************************************************************************************************/
boolean updateProfile (String Hospital, String username,String email,byte[] pic,String PhoneNum,String name)
{
String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql1;
          //  sql = "SELECT ID FROM USERS WHERE USER_NAME="+ UserName + "and PASSWORD="+Password+"";  
          sql1 =  "UPDATE USERS Set USER_NAME='"+username+"',EMAIL='"+email+"',PHONENUM='"+PhoneNum+"',NAME='"+name+"' where HOSPITAL='"+Hospital+"'" ;  
          stmt.executeUpdate(sql1);
          stmt.close();
          conn.close();
          updatepic2(pic, Hospital);
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
return true;

}
void updatepic2(byte[] pic,String hospital) throws SQLException
{
        String updateSQL = "UPDATE USERS "
                + "SET IMAGED = ? "
                + "WHERE HOSPITAL=?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, pic);
            pstmt.setString(2, hospital);

            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/***************************************************************************************************************/
/***************************************************************************************************************/
boolean updateStock(String Hospital, String BloodType,int NoOfbags)
{
   
   boolean state=updateBloodDatabase(NoOfbags, Hospital, BloodType);
   String DB_URL = "jdbc:derby://localhost:1527/BloodDonation";
        String USER = "app";
        String PASS = "app";
        Connection conn = null;
        Statement stmt = null;
       
return state;
}
/***************************************************************************************************************/
/***************************************************************************************************************/
byte[]  getimage(int ID)
{
   byte[] img=null;
    try{
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodDonation","app","app");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select IMAGE from IMAGES where ID ="+ID+"");
                if(rs.next()){
                    img = rs.getBytes("IMAGE");
                    //Resize The ImageIcon
//                    ImageIcon image = new ImageIcon(img);
//                    Image im = image.getImage();
//                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
//                    ImageIcon newImage = new ImageIcon(myImg);
//                    label.setIcon(newImage);
                }
                
                else{
                    //JOptionPane.showMessageDialog(null, "No Data");
                    
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        return img;
        }

/***************************************************************************************************************/
/***************************************************************************************************************/
void updatepic(byte[] pic,int ID) throws SQLException
{      
    String updateSQL = "UPDATE IMAGES "
                + "SET IMAGE = ? "
                + "WHERE ID=?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, pic);
            pstmt.setDouble(2, ID);

            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

/***************************************************************************************************************/
/***************************************************************************************************************/


/***************************************************************************************************************/
/***************************************************************************************************************/

}

