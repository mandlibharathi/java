import java.sql.*;
class DatabaseConnection{
public static void main(String[] args){
try{
Class.forName("com.mysql.jdbc.Driver");
String str="jdbc:mysql://localhost:3306/sqlexamples?characterEncoding=latin1";
Connection con=DriverManager.getConnection(str,"root","Jaanu.@22");
//Statement stmt=con.createStatement();
// ResultSet rs=stmt.executeQuery("select * from student");
//while(rs.next()) 
//System.out.println(rs.getInt(1) +"   " + rs.getString(2) + "    " +rs.getString(3));
//con.close();
String sql="insert into student(sno,sname,age,place,qualification,salary) values(?,?,?,?,?,?)";
PreparedStatement  statement=con.prepareStatement(sql);
statement.setString(1,"9");
statement.setString(2,"asb");
statement.setString(3,"25");
statement.setString(4,"atp");
statement.setString(5,"bcom");
statement.setString(6,"100000");
int rowsInserted=statement.executeUpdate();
if(rowsInserted >0){
System.out.println("inserted Sucessfully");

con.close();

}
}
catch(Exception e){
System.out.println(e);
}
try{
String str="jdbc:mysql://localhost:3306/sqlexamples?characterEncoding=latin1";
Connection con=DriverManager.getConnection(str,"root","Jaanu.@22");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from student");
while(rs.next()) 
System.out.println(rs.getInt(1) +"   " + rs.getString(2) + "    " +rs.getString(3));
}
catch (Exception e){System.out.println(e);}
}
}