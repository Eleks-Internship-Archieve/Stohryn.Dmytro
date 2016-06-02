package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Registration;
import connection.ConnectionDB;

public class RegistrationDAO{

	public Registration getLoginAndPassword(String login, String password) {
		Registration registration = null;
		Connection connection = null;
		PreparedStatement statement=null;
		ResultSet res = null;
		try{
			connection = new ConnectionDB().getConnection();
			statement = connection.prepareStatement("SELECT * FROM registration WHERE login=? AND password=?");
			statement.setString(1,login);
			statement.setString(2,password);
			res = statement.executeQuery();
			if(res.next()){
				registration = new Registration(res.getString(2), res.getString(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{		
			try {
				res.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registration;
	}
	public void setParameters(String login, String password) {
		Registration registration = null;
		Connection connection = null;
		PreparedStatement statement=null;
		try{
			connection = new ConnectionDB().getConnection();
			statement = connection.prepareStatement("INSERT INTO registration(login, password) VALUES (?,?)");
			statement.setString(1,login);
			statement.setString(2,password);
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{		
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}