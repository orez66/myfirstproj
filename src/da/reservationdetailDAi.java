package da;

import java.util.List;

import model.reservationdetail;


public interface reservationdetailDAi {
	public void addReservationdetail (reservationdetail reservationdetail);
	public List <reservationdetail> getAllReservationdetail();
	public reservationdetail getReservationdetailById (int reservation_detail_id);
	public void updateReservationdetail (reservationdetail reservationdetail);
	public void delete (int reservation_detail_id);
}
