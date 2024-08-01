package DAO;

import java.sql.*;
import java.util.ArrayList;

public class BDD {
    private Connection con;
    private String url;
    private String bddMysql;
    private String bddApp;
    private String user;
    private String pwd;

    public BDD(){
        this.bddApp="exojee";
        this.bddMysql="mysql";
        this.url="jdbc:mysql://localhost:3306/";
        this.pwd="";
        this.user="root";
    }

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url+bddApp+"?characterEncoding=UTF-8",user,pwd);
            this.con = conn;
            return conn;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void crudRequete(String sql, ArrayList<Data> datas) throws SQLException{
        getConnection();
        PreparedStatement psmt2 = this.con.prepareStatement(sql);
        for (Data data : datas){
            if(data.type.equals("int")){
                psmt2.setInt(data.position, Integer.parseInt(data.valeur));
            }
            else{
                psmt2.setString(data.position, data.valeur);
            }
        }
        psmt2.execute();
        psmt2.close();
        this.con.close();
    }

    public ResultSet selectRequete(String sql) throws SQLException{
        getConnection();
        PreparedStatement pstm = this.con.prepareStatement(sql);
        ResultSet st = pstm.executeQuery();
        return st;
    }

//    public void createTables() throws SQLException {
//        try {
//            this.getConnection();
//            String requete = "CREATE TABLE if not exists categories(category_id INT PRIMARY KEY ,nom VARCHAR(20) not null, description VARCHAR(500)  ";
//            PreparedStatement st = con.prepareStatement(requete);
//            System.out.println("table crée");
//            con.close();
//            st.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
