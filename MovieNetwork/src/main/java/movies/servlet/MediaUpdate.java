package movies.servlet;

import movies.dal.*;
import movies.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mediaupdate")
public class MediaUpdate extends HttpServlet {
	
	protected MediaDao mediaDao;
	
	@Override
	public void init() throws ServletException {
		mediaDao = MediaDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String titleId = req.getParameter("titleId");
       
        try {
        	Media media = mediaDao.getMediaById(titleId);
        	if(media == null) {
        		messages.put("success", "Media does not exist.");
        	}
        	req.setAttribute("media", media);
        	req.setAttribute("titleId", titleId);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        
        req.getRequestDispatcher("/MediaUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String titleId = req.getParameter("titleId");
        try {
        	Media media = mediaDao.getMediaById(titleId);
        	if(media == null) {
        		messages.put("success", "Media does not exist.");
        	} else {
        		String newGenre = req.getParameter("genre");
        		if (newGenre == null) {
        			messages.put("success", "Please enter a valid genre.");
        	    } else {
        	        media = mediaDao.updateGenre(media, newGenre);
        	        messages.put("success", "Successfully updated " + media.getTitle());
        	    	}
        		}
        		req.setAttribute("media", media);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        req.getRequestDispatcher("/MediaUpdate.jsp").forward(req, resp);
    }
}
