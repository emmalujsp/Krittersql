import java.sql.*;
import java.util.Scanner;

public class bank {
    Scanner sc = new Scanner(System.in);
    String bankid = "";
    String bname = "";
    String hoffice = "";
    int totalemp;
    String MySQLURL = "jdbc:mysql://localhost:3306/bank?useSSL=false";
    String databseUserName = "root";
    String databasePassword = "emmalujsp";
    Connection con = null;

    void addBank() {
        System.out.print("Enter Bank id :");
        bankid = sc.nextLine();
        System.out.print("Enter Bank Name :");
        bname = sc.nextLine();
        System.out.print("Enter Bank head office :");
        hoffice = sc.nextLine();
        System.out.print("Enter Total number of employees :");
        totalemp = sc.nextInt();
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                String query = " insert into bankdetails (bankid, bname, hoffice, totalemp)" + " values (?, ?, ?, ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, bankid);
                preparedStmt.setString(2, bname);
                preparedStmt.setString(3, hoffice);
                preparedStmt.setInt(4, totalemp);
                preparedStmt.execute();


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    void printBank() {
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from bankdetails");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void editdetails() {
        printBank();
        System.out.print("Enter the Bank id to edit :");
        bankid = sc.nextLine();
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement stmt = con.createStatement();
                PreparedStatement statement = con.prepareStatement("select * from bankdetails where bankid=?");
                statement.setString(1, bankid);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
                    totalemp = rs.getInt(4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.print("Enter Total number of new employees :");
        int newmeb = sc.nextInt();
        totalemp = totalemp + newmeb;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                String sql = "UPDATE  bankdetails set totalemp=? where bankid=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, totalemp);
                statement.setString(2, bankid);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void bankbranch() {
        printBank();
        System.out.print("Enter the Bank for branch :");
        bankid = sc.nextLine();
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                Statement stmt = con.createStatement();
                PreparedStatement statement = con.prepareStatement("select count(*) as cnt from branchdetails where bid=?  group by bid");
                statement.setString(1, bankid);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    System.out.print("Number of Branches for this bank :");
                    System.out.println(rs.getInt("cnt"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                Statement stmt = con.createStatement();
                PreparedStatement statement = con.prepareStatement("select * from branchdetails where bid=?");
                statement.setString(1, bankid);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
