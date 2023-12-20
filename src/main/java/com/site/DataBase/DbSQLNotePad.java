
package com.site.DataBase;
import com.site.NotePad.NotePad;
import com.site.User.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbSQLNotePad {
    private static Connection conexao_MySql = null;
    private static String localBD = "localhost";
    private static String LINK =
            "jdbc:mysql://" + localBD + ":3306/Site"; // MUDAR NOME DA DB SELECIONADA
    private static final String usuario = "root";
    private static final String senha = "";
    
    //CRIANDO CONEXÃO COM MYSQL
    public Connection connectionMySql(){
        try{
            conexao_MySql = DriverManager.getConnection(LINK, usuario, senha);
            System.out.println("Conexao OK!");
        }catch(SQLException e){
            throw new RuntimeException("Ocorreu um Erro");
                
        }
        return conexao_MySql;
    }
    // FECHANDO CONEXÃO COM MYSQL
    public void closeConnectionMySql(Connection con){
        try{
            if(con != null){
                con.close();
                System.out.println("DB Fechado");
            }
        }catch(SQLException e){
            throw new RuntimeException("Ocorreu um problema para encerrar"+"a conexâo com o BD.", e);
        }
    }
    
    //INSERINDO USUARIO NA TEBELA USUARIO
    public void sqlDbNoteInsert(NotePad notePad){
        Connection connection = connectionMySql();
        
        String StringSQL = "insert into NotePad(ID,UserID,NoteName,Content,created)values(null,?,?,?,? )";
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(StringSQL);
            preparedStmt.setInt(1, notePad.getUserID());
            preparedStmt.setString(2, notePad.getName());
            preparedStmt.setString(3, notePad.getContent());
            preparedStmt.setTimestamp(4, notePad.getCreatedAt());
            preparedStmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();}
        closeConnectionMySql(connection);
    }
    
    public List<NotePad> sqlDbNoteSelect( User user){
        List<NotePad> notePadList = new ArrayList<>();
        
        Connection connection = connectionMySql();
        String StringSQL = "select* from NotePad where UserID = ?";
        PreparedStatement preparedStmt;
        
        try{
            preparedStmt = connection.prepareStatement(StringSQL);
            preparedStmt.setInt(1,user.getID());
            ResultSet result = preparedStmt.executeQuery();
            
            while(result.next()){
                NotePad note = new NotePad();
                note.setID(result.getInt("ID"));
                note.setUserID(result.getInt("UserID"));
                note.setName(result.getString("NoteName"));
                note.setContent(result.getString("Content"));
                note.setCreatedAt(result.getTimestamp("created"));
                notePadList.add(note);
            }
        }catch  (SQLException e){
            e.printStackTrace();
        }
        closeConnectionMySql(connection);
        
        return notePadList;
        
    }
}
