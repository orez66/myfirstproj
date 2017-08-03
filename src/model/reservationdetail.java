package model;

public class reservationdetail {
	private int reservation_detail_id;
	private int zimmer_id;
	private int num_of_guests;
	private int baby;
	private String notes;
	private String start_date;
	private String end_date;
	public int getReservation_detail_id() {
		return reservation_detail_id;
	}
	public void setReservation_detail_id(int reservation_detail_id) {
		this.reservation_detail_id = reservation_detail_id;
	}
	public int getZimmer_id() {
		return zimmer_id;
	}
	public void setZimmer_id(int zimmer_id) {
		this.zimmer_id = zimmer_id;
	}
	public int getNum_of_guests() {
		return num_of_guests;
	}
	public void setNum_of_guests(int num_of_guests) {
		this.num_of_guests = num_of_guests;
	}
	public int getBaby() {
		return baby;
	}
	public void setBaby(int baby) {
		this.baby = baby;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
}
