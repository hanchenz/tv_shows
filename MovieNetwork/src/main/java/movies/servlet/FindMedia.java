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

@WebServlet("/findmedia")
public class FindMedia extends HttpServlet {
	
	protected MediaDao mediaDao;
	
	@Override
	public void init() throws ServletException {
		mediaDao = MediaDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Media> mediaList = new ArrayList<Media>();

        String mediaName = req.getParameter("medianame");
        if (mediaName == null || mediaName.trim().isEmpty()) {
        	// if name is empty or null, print this message 
            messages.put("success", "Please enter a valid movie or tv show title.");
        } else {
        	try {
            	mediaList = mediaDao.getMediaByTitle(mediaName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + mediaName);
        	messages.put("previousMediaName", mediaName);
        }
        req.setAttribute("mediaList", mediaList);
        
        req.getRequestDispatcher("/FindMedia.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Media> mediaList = new ArrayList<Media>();
        
        String mediaName = req.getParameter("medianame");
        if (mediaName == null || mediaName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid movie or tv show title.");
        } else {
        	try {
        		mediaList = mediaDao.getMediaByTitle(mediaName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + mediaName);
        }
        req.setAttribute("mediaList", mediaList);
        
        req.getRequestDispatcher("/FindMedia.jsp").forward(req, resp);
    }
}
