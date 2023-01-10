package movies.servlet;

import movies.dal.MediaDao;
import movies.model.Media;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mediacreate")
public class MediaCreate extends HttpServlet{
	
	protected MediaDao mediaDao;
	
	@Override
	public void init() throws ServletException{
		mediaDao = MediaDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/MediaCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String titleId = req.getParameter("titleId");
        if (titleId == null || titleId.trim().isEmpty()) {
            messages.put("Success!", "Invalid titleId");
        } else {
        	// Create the Media.
        	String mediaType = req.getParameter("movieType");
        	String mediaTitle = req.getParameter("title");
        	String isAdult = req.getParameter("isAdult");
        	String yearOfCreation = req.getParameter("year");
        	String runtimeMinutes = req.getParameter("runtime");
        	String genre = req.getParameter("genres");
        	boolean boIsAdult = Boolean.valueOf(isAdult);
        	int yOCreation = Integer.valueOf(yearOfCreation);
        	int rtMinutes = Integer.valueOf(runtimeMinutes);
        	
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Media media = new Media(titleId, mediaType, mediaTitle, boIsAdult, yOCreation, rtMinutes, genre);
	        	media = mediaDao.create(media);
	        	messages.put("success", "Successfully created " + mediaTitle);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
      
        req.getRequestDispatcher("/MediaCreate.jsp").forward(req, resp);
    }
}
