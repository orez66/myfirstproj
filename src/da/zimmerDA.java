package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.dbutil;
import model.zimmer;

public class zimmerDA implements zimmerDAi {

	
	private Connection connection;


public zimmerDA (){
	connection = dbutil.getConnection();
}


@Override
public void addZimmer(zimmer zimmer) {
	try{
		String query = "INSERT INTO public.zimmer (zimmer_id, zimmer_name) VALUES (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, zimmer.getZimmer_id());
		preparedStatement.setString(2, zimmer.getZimmer_name());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	catch (SQLException e){
		System.out.println(e.getMessage());
	}
}


@Override
public List<zimmer> getAllZimmer() {
	List <zimmer> zimmer = new ArrayList <zimmer>();
	
	try{
		String query = "SELECT * FROM public.zimmer";
		Statement Statement = connection.createStatement();
		
		ResultSet rs = Statement.executeQuery(query);
		
		while (rs.next())
		{
			zimmer z = new zimmer();
			z.setZimmer_id(rs.getInt("zimmer_id"));
			z.setZimmer_name(rs.getString("zimmer_name"));
			
			zimmer.add(z);
			
		}
		
		rs.close();
		Statement.close();
	}
	catch (SQLException e){
		System.out.println(e.getMessage());
	}

	return zimmer;
}


@Override
public zimmer getZimmerById(int zimmer_id) {
	zimmer z = new zimmer();
	try{
		String query = "SELECT * FROM public.zimmer WHERE zimmer_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, zimmer_id);
		
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()){
			z.setZimmer_id(rs.getInt("zimmer_id"));
			z.setZimmer_name(rs.getString("zimmer_name"));
		}
		rs.close();
		preparedStatement.close();
	}
	catch (SQLException e){
		System.out.println(e.getMessage());
	}
	return z ;
}


@Override
public void updateZimmer(zimmer zimmer) {
	try{
		String query = "UPDATE public.zimmer SET zimmer_name =? WHERE zimmer_id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,zimmer.getZimmer_name());
		preparedStatement.setInt(2,zimmer.getZimmer_id());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	catch (SQLException e){
		System.out.println(e.getMessage());
	}
	
}


@Override
public void delete(int zimmer_id) {
	try{
		String query = "DELETE FROM public.zimmer WHERE zimmer_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, zimmer_id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	catch (SQLException e){
		System.out.println(e.getMessage());
	}
}
	
}
