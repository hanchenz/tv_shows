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


@WebServlet("/getStreamingSites")
public class FindStreamingSites extends HttpServlet {
	
	protected StreamingSitesDao streamingSitesDao;
	
	@Override
	public void init() throws ServletException {
		streamingSitesDao = streamingSitesDao.getInstance();
	}
	
	//get all
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        // Retrieve BlogUsers, and store in the request.
        List<StreamingSites> streamingSites = new ArrayList<StreamingSites>();
        try {
        	streamingSites = streamingSitesDao.getAll();
        	System.out.println(streamingSites);
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        req.setAttribute("streamingSites", streamingSites);
        req.getRequestDispatcher("/FindStreamingSites.jsp").forward(req, resp);
	}
}
