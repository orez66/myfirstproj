package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.reservationdetailDA;
import model.reservationdetail;
import model.zimmer;


/**
 * Servlet implementation class reservationdetailControllerAj
 */
@WebServlet("/reservationdetailControllerAj")
public class reservationdetailControllerAj extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String List_reservationdetail="/reservationdetail.jsp";
	public static final String form_reservationdetail="/formreservationdetail.jsp"; 
	
	reservationdetailDA myReservatindetailDA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationdetailControllerAj() {
        super();
        myReservatindetailDA= new reservationdetailDA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String forward = "";

		if (action.equalsIgnoreCase("reservationdetaillist")){//zimmerlist-zimmerajax.JS
		request.setCharacterEncoding("UTF-8"); 
		forward =List_reservationdetail;
		List <reservationdetail> list = myReservatindetailDA.getAllReservationdetail();
		request.setAttribute("reservationdetaill", list);//zimmerl-zimmer.JSP
		response.setContentType("text/html");
		}

		else if (action.equalsIgnoreCase("delete")){
		forward = List_reservationdetail;
		int reservation_detail_id = Integer.valueOf(request.getParameter("id"));
		myReservatindetailDA.delete(reservation_detail_id);
		List <reservationdetail> list = myReservatindetailDA.getAllReservationdetail();
		request.setAttribute("reservationdetaill", list);
		}

		else if (action.equalsIgnoreCase("update")){
		request.setCharacterEncoding("UTF-8");
		forward = form_reservationdetail;
		int reservation_detail_id = Integer.valueOf(request.getParameter("id"));
		reservationdetail reservationdetail = myReservatindetailDA.getReservationdetailById(reservation_detail_id);
		request.setAttribute("reservationdetailf", reservationdetail);
		}

		else if(action.equalsIgnoreCase("add")){
		forward = form_reservationdetail;	
		request.setAttribute("action","toAdd" );
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action_type = request.getParameter("action_type");
		reservationdetail reservationdetail = new reservationdetail();
		String forward = "";
		request.setCharacterEncoding("UTF-8"); 
		
		int idZimmer = Integer.valueOf(request.getParameter("idzimmer"));
		int numberguests = Integer.valueOf(request.getParameter("numguests"));
		int babies = Integer.valueOf(request.getParameter("baby"));
		String note = request.getParameter("notes");
		String start = request.getParameter("startdate");
		String end = request.getParameter("enddate");	
		
		reservationdetail.setZimmer_id(idZimmer);
		reservationdetail.setNum_of_guests(numberguests);
		reservationdetail.setBaby(babies);
		reservationdetail.setNotes(note);
		reservationdetail.setStart_date(start);
		reservationdetail.setEnd_date(end);
		
		String idresdet = request.getParameter("id");
		
		if(idresdet == null||idresdet.isEmpty()){
			}

		else{
			reservationdetail.setReservation_detail_id(Integer.valueOf(idresdet));

		if(action_type.equals("update")){
			myReservatindetailDA.updateReservationdetail(reservationdetail);
		}

		else{
			myReservatindetailDA.addReservationdetail(reservationdetail);
						}
						
					}

					List <reservationdetail> list = myReservatindetailDA.getAllReservationdetail();
					request.setAttribute("reservatindetail", list);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(List_reservationdetail);
					response.setCharacterEncoding("UTF-8");
					dispatcher.forward(request, response);

					

			}

		}
