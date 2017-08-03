package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.zimmerDA;
import model.zimmer;

/**
 * Servlet implementation class zimmerControllerAj
 */
@WebServlet("/zimmerControllerAj")
public class zimmerControllerAj extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String List_zimmer="/zimmer.jsp";
	public static final String form_zimmer="/formZimmerAjax.jsp";
	
	zimmerDA myZimmerDA;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zimmerControllerAj() {
        super();
        myZimmerDA = new zimmerDA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";

		if (action.equalsIgnoreCase("zimmerlist")){
		request.setCharacterEncoding("UTF-8"); 
		forward =List_zimmer;
		List <zimmer> list = myZimmerDA.getAllZimmer();
		request.setAttribute("zimmerl", list);
		response.setContentType("text/html");
		}

		else if (action.equalsIgnoreCase("delete")){
		forward = List_zimmer;
		int zimmer_id = Integer.valueOf(request.getParameter("id"));
		myZimmerDA.delete(zimmer_id);
		List <zimmer> list = myZimmerDA.getAllZimmer();
		request.setAttribute("zimmerl", list);
		}

		else if (action.equalsIgnoreCase("update")){
		request.setCharacterEncoding("UTF-8");
		forward = form_zimmer;
		int zimmer_id = Integer.valueOf(request.getParameter("id"));
		zimmer zimmer = myZimmerDA.getZimmerById(zimmer_id);
		request.setAttribute("zimmerf", zimmer);
		}

		else if(action.equalsIgnoreCase("add")){
		forward = form_zimmer;	
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
		zimmer zimmer = new zimmer();
		String forward = "";
		request.setCharacterEncoding("UTF-8"); 

		String zimmername = request.getParameter("name");
		zimmer.setZimmer_name(zimmername);

		String id = request.getParameter("id");

		if(id == null||id.isEmpty()){
			}

		else{
		zimmer.setZimmer_id(Integer.valueOf(id));

		if(action_type.equals("Update")){
			myZimmerDA.updateZimmer(zimmer);
		}

		else{
			myZimmerDA.addZimmer(zimmer);
						}
						
					}

					List <zimmer> list = myZimmerDA.getAllZimmer();
					request.setAttribute("zimmer", list);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(List_zimmer);
					response.setCharacterEncoding("UTF-8");
					dispatcher.forward(request, response);

					

			}

		}
