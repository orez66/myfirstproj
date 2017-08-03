package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.reservationdetail;


public class reservationdetailDA implements reservationdetailDAi {

	private Connection connection;
	@Override
	public void addReservationdetail(reservationdetail reservationdetail) {
		// TODO Auto-generated method stub
		try{
			String query = "INSERT INTO public.reservation_detail (reservation_detail_id, zimmer_id, num_of_guests, baby, notes, start_date, end_date) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reservationdetail.getReservation_detail_id());
			preparedStatement.setInt(2,reservationdetail.getZimmer_id());
			preparedStatement.setInt(3,reservationdetail.getNum_of_guests());
			preparedStatement.setInt(4,reservationdetail.getBaby());
			preparedStatement.setString(5,reservationdetail.getNotes());
			preparedStatement.setString(6,reservationdetail.getStart_date());
			preparedStatement.setString(7,reservationdetail.getEnd_date());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List <reservationdetail> getAllReservationdetail() {
		List <reservationdetail> reservationdetail = new ArrayList <reservationdetail>();
		
		try{
			String query = "SELECT * FROM public.reservation_detail";
			Statement Statement = connection.createStatement();
			
			ResultSet rs = Statement.executeQuery(query);
			
			while (rs.next())
			{
				reservationdetail rd = new reservationdetail();
				rd.setReservation_detail_id(rs.getInt("reservation_detail_id"));
				rd.setZimmer_id(rs.getInt("zimmer_id"));
				rd.setNum_of_guests(rs.getInt("num_of_guests"));
				rd.setBaby(rs.getInt("baby"));
				rd.setNotes(rs.getString("notes"));
				rd.setStart_date(rs.getString("start_date"));
				rd.setEnd_date(rs.getString("end_date"));
				
				reservationdetail.add(rd);
			}
			
			rs.close();
			Statement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}

		return reservationdetail;
	}

	@Override
	public reservationdetail getReservationdetailById(int reservation_detail_id) {
		reservationdetail rd = new reservationdetail();
		try{
			String query = "SELECT * FROM public.reservation_detail WHERE reservation_detail_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reservation_detail_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				rd.setReservation_detail_id(rs.getInt("reservation_detail_id"));
				rd.setZimmer_id(rs.getInt("zimmer_id"));
				rd.setNum_of_guests(rs.getInt("num_of_guests"));
				rd.setBaby(rs.getInt("baby"));
				rd.setNotes(rs.getString("notes"));
				rd.setStart_date(rs.getString("start_date"));
				rd.setEnd_date(rs.getString("end_date"));
				
			}
			rs.close();
			preparedStatement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return rd ;
	}
	

	@Override
	public void updateReservationdetail(reservationdetail reservationdetail) {
		try{
			String query = "UPDATE public.reservation_detail SET zimmer_id=?, num_of_guests=?, baby=?, notes=?, start_date=?, end_date=? WHERE reservation_detail_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1,reservationdetail.getZimmer_id());
			preparedStatement.setInt(2,reservationdetail.getNum_of_guests());
			preparedStatement.setInt(3,reservationdetail.getBaby());
			preparedStatement.setString(4,reservationdetail.getNotes());
			preparedStatement.setString(5,reservationdetail.getStart_date());
			preparedStatement.setString(6,reservationdetail.getEnd_date());
			preparedStatement.setInt(7, reservationdetail.getReservation_detail_id());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int reservation_detail_id) {
		try{
			String query = "DELETE FROM public.reservation_detail WHERE reservation_detail_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reservation_detail_id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
