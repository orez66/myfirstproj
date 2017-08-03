package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutil {
private static Connection connection;
private static final String URL="jdbc:postgresql://pellefant.db.elephantsql.com:5432/fksljizp";
private static final String USERNAME="fksljizp";
private static final String PASSWORD="SCPWBqwXbbsB1n5gtgurKyTd0x-I2S66"; 

public static Connection getConnection (){
	if(connection!=null){
		return connection;
		}
		try
		{
			Class.forName("org.postgresql.Driver");
			connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}
			catch (ClassNotFoundException | java.sql.SQLException e){
				System.out.println(e.getMessage());
			}
			
		return connection;
	}

	//method for closing a specific Connection object
	public static void closeConnection(Connection toBeClosed){
		if (toBeClosed==null)
			return;
		
		try{
			toBeClosed.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	

	
}

