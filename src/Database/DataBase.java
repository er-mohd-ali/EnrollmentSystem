/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Core.Course;
import Core.Trainer;
import Core.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mohammad_Ali
 */
public class DataBase {

    private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
    private String user = "en_admin";
    private String passsword = "en_admin";
    private Connection conn;
    private Statement stm;

    public DataBase() throws SQLException {
        conn = DriverManager.getConnection(url, user, passsword);
        stm = conn.createStatement();
    }

    public ResultSet LoggedIn() {
        ResultSet rs;
        try {

            String queString = "select * from login_info";
            rs = stm.executeQuery(queString);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return null;
    }

    public int insertStudent(student s) throws SQLException {
        String queString = "insert into student values(seq_sid.nextval,'" + s.getFirstname() + "',"
                + "'" + s.getLastname() + "','" + s.getPrimarycon() + "','" + s.getSecondarycon() + "',"
                + "'" + s.getAddress() + "','" + s.getEmail() + "')";
        int res = stm.executeUpdate(queString);
        String queString1 = "insert into login_info values(seq_sid.nextval,'" + s.getEmail() + "','" + s.getUsername() + "',"
                + "'" + s.getPassword() + "',1)";
        res += stm.executeUpdate(queString1);

        return res;
    }

    public ResultSet getAllStudent() throws SQLException {
        ResultSet rs;

        String queString = "select * from student order by id desc";
        rs = stm.executeQuery(queString);
        return rs;
    }

    public int updateStudent(student s, int sid) throws SQLException {

        String queString = "update student set first_name='" + s.getFirstname() + "',last_name='" + s.getLastname() + "',"
                + "primary_contact='" + s.getPrimarycon() + "',secondary_contact='" + s.getSecondarycon() + "',"
                + "address='" + s.getAddress() + "',email='" + s.getEmail() + "' where id=" + sid + "";
        int res = stm.executeUpdate(queString);
        return res;
    }

    public ResultSet searchStudent(String search) throws SQLException
    {
        String queString="select id,first_name,last_name,primary_contact,secondary_contact,address,email from student where first_name like '"+search+"%' or last_name like '"+search+"%' or primary_contact like '"+search+"%' or secondary_contact like '"+search+"%' or address like '"+search+"%' or email like '"+search+"%'";
    ResultSet rs=stm.executeQuery(queString);
    return rs;
    }

    public int insertTrainer(Trainer t) throws SQLException {
    
        String queString="insert into Trainer values"
                + "(seq_tid.nextval,'"+t.getTrainerName()+"','"+t.getTrainerEmail()+"',"
                + "'"+t.getTrainerContact()+"','"+t.getTrainerAddress()+"')";
        int res=stm.executeUpdate(queString);
        return res;
        
    }
    public ResultSet getAllTrainer() throws SQLException
    {
        String queString="select * from trainer order by id desc";
        ResultSet rs=stm.executeQuery(queString);
        
        return rs;
    }

    public int updateTrainer(Trainer t, int tid) throws SQLException {
     String queString="update trainer set trainer_name='"+t.getTrainerName()+"',trainer_email='"+t.getTrainerEmail()+"',"
             + "trainer_contact='"+t.getTrainerContact()+"',trainer_address='"+t.getTrainerAddress()+"' where id="+tid+"";
    int res=stm.executeUpdate(queString);
    return res;
    }
    
    public ResultSet searchTrainer(String search) throws SQLException
    {
        String queString="select id,trainer_name,trainer_email,trainer_contact,trainer_address from trainer where id like '"+search+"%' or trainer_name like '"+search+"%'  or trainer_contact like '"+search+"%' or trainer_address like '"+search+"%' or trainer_email like '"+search+"%'";
    ResultSet rs=stm.executeQuery(queString);
    return rs;
    }

    public int insertCourse(Course c) throws SQLException {
    
        String queString="insert into course values(seq_cid.nextval,'"+c.getCourseName()+"',"+c.getCourseDuration()+")";
        int res=stm.executeUpdate(queString);
        return res;
        
    }
    
    public ResultSet getAllCourse() throws SQLException
    {
        String queString="select * from course order by id desc";
        ResultSet rs=stm.executeQuery(queString);
        
        return rs;
    }

    public int updateCourse(Course c, int id) throws SQLException {
     String queString="update course set course_name='"+c.getCourseName()+"',course_duration="+c.getCourseDuration()+" where id="+id+"";
     int res=stm.executeUpdate(queString);
     
     return res;
    }

    public ResultSet searchCourse(String search) throws SQLException {
    String queString="select id,course_name,course_duration from course where course_name like '"+search+"%' ";
    ResultSet rs=stm.executeQuery(queString);
    return rs;    
    }

    
}
