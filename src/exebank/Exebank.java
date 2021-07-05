package exebank;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Exebank {

    public static void main(String[] args) {
        String BD = "jdbc:postgresql://ec2-3-231-69-204.compute-1.amazonaws.com:5432/da7h3qajcvr1c8";
        String user = "sfywxdrkesegee";
        String pw = "6b8334dc491a6a65d449e58855d7926bb0bbef6a087acc8b85f7a65824ccc6ac";
        gui xd = new gui();
        xd.setVisible(true);
        
        try {
            Connection conect = DriverManager.getConnection(BD, user, pw);
            //JOptionPane.showMessageDialog(null, "Conection Success");
            java.sql.Statement st = conect.createStatement();
            String query1 = "SELECT * FROM users;";
            ResultSet result = st.executeQuery(query1);
            String data[] = new String[3];
            String users = "";
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("username");
            modelo.addColumn("ssn");
            modelo.addColumn("nationality");
            while(result.next()){

                data[0] = result.getString("username");
                data[1] = result.getString("ssn");
                data[2] = result.getString("nationality");
                modelo.addRow(data);
            }
            String query2 = "SELECT * FROM departments;";
            ResultSet result2 = st.executeQuery(query2);
            while(result2.next()){
                System.out.println(result2.getString("department_chief"));
            }

            result.close();
            st.close();
            conect.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
