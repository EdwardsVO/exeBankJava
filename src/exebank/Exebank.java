package exebank;
import java.sql.*;
import javax.swing.JOptionPane;

public class Exebank {

    public static void main(String[] args) {
        String BD = "jdbc:postgresql://ec2-3-231-69-204.compute-1.amazonaws.com:5432/da7h3qajcvr1c8";
        String user = "sfywxdrkesegee";
        String pw = "6b8334dc491a6a65d449e58855d7926bb0bbef6a087acc8b85f7a65824ccc6ac";
        
        try {
            Connection conect = DriverManager.getConnection(BD, user, pw);
            JOptionPane.showMessageDialog(null, "Conection Success");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
