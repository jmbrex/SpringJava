package com.site.DataBase;

import com.site.User.User;
import java.sql.*;
public class DbSQLUser {
    private static Connection conexao_MySql = null;
    private static String localBD = "localhost"; // nome do servidor com banco de dados
    private static String LINK =
            "jdbc:mysql://" + localBD + ":3306/Site"; // Caminho para conectar com o banco de dados (colocar no final a porta de conexão e o nome da DB)
    private static final String usuario = "root"; // usuario de autenticação no banco de dados
    private static final String senha = ""; // Senha para login do user (caso não tenha senha deixar em branco)
    
    //CRIANDO CONEXÃO COM MYSQL
    public Connection connectionMySql(){
        try{
            conexao_MySql = DriverManager.getConnection(LINK, usuario, senha); // cria uma conexão com o banco de dados e retorna uma instancia da conexão
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
                con.close(); // recebe uma instancia de conexão  e fecha ela
                System.out.println("DB Fechado");
            }
        }catch(SQLException e){
            throw new RuntimeException("Ocorreu um problema para encerrar"+"a conexâo com o BD.", e);
        }
    }
    
    //INSERINDO USUARIO NA TEBELA USUARIO
    public void sqlDbUserInsert(User user){
        Connection connection = connectionMySql();
        
        String StringSQL = "insert into usuario(ID,Nome,NickName,email, Senha)values(null,?,?,?,? )"; 
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(StringSQL);
            preparedStmt.setString(1, user.getName());
            preparedStmt.setString(2, user.getNick());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getSenha());
            preparedStmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();}
        closeConnectionMySql(connection);
    }
    //SELECIONANDO USUARIO PELO NICKNAME
    public User sqlUserSelectNickName(String Nome){
        User p1 = new User();
        
        Connection connection = connectionMySql();
        String StringSQL = "Select * from usuario where NickName  = ?";
        PreparedStatement preparedStmt;
        
        try{
            preparedStmt = connection.prepareStatement(StringSQL);
            preparedStmt.setString(1,Nome);
            ResultSet result = preparedStmt.executeQuery();
            while(result.next()){
                p1.setID(result.getInt("ID"));
                p1.setName(result.getString("Nome"));
                p1.setNick(result.getString("NickName"));
                p1.setEmail(result.getString("email"));
               p1.setSenha(result.getString("Senha"));
            }
        }catch  (SQLException e){
            e.printStackTrace();
        }
        closeConnectionMySql(connection);
        
        return p1;
    }
    
   
}
