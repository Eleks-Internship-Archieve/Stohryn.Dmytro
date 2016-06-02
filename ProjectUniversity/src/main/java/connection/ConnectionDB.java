package connection;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class ConnectionDB{
       
    public Connection getConnection(){
    	Connection con = null;
    	try{
    		InitialContext initContext = new InitialContext();
		   	DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
    		con = ds.getConnection();
    		}catch (SQLException e) {
    		System.out.print("SQLException");
		} catch (NamingException e) {
    		System.out.print("NamingException");
		}
    	return con;
	}
 }
