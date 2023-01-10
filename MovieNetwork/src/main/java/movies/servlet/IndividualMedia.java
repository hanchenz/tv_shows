package movies.servlet;

import movies.dal.*;
import movies.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/individualmedia")
public class IndividualMedia extends HttpServlet {
	
	protected MediaInfoDao mediaInfoDao;
	
	@Override
	public void init() throws ServletException {
		mediaInfoDao = MediaInfoDao.getInstance();
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
        	MediaInfo media = mediaInfoDao.getMediaInfoById(titleId);
        	System.out.print(media);
        	if(media == null) {
        		messages.put("success", "Media does not exist.");
        	}
        	req.setAttribute("media", media);
        	req.setAttribute("titleId", titleId);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        
        req.getRequestDispatcher("/IndividualMedia.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        String titleId = req.getParameter("titleId");
        try {
        	MediaInfo media = mediaInfoDao.getMediaInfoById(titleId);
        	if(media == null) {
        		messages.put("success", "Media does not exist.");
        	}
        	req.setAttribute("media", media);
        	req.setAttribute("titleId", titleId);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        
        
        req.getRequestDispatcher("/IndividualMedia.jsp").forward(req, resp);
    }
}
