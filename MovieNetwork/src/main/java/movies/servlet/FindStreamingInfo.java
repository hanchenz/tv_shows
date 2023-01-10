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


@WebServlet("/getStreamingInfo")
public class FindStreamingInfo extends HttpServlet {
	
	protected StreamingInfoDao streamingInfoDao;
	
	@Override
	public void init() throws ServletException {
		streamingInfoDao = streamingInfoDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        // Retrieve BlogUsers, and store in the request.
        List<StreamingInfo> streamingInfo = new ArrayList<StreamingInfo>();
        
        String mediaName = req.getParameter("mediaName");
        if (mediaName == null || mediaName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
            System.out.println(messages);
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
        		streamingInfo = streamingInfoDao.getStreamingInfoByMovieName(mediaName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + mediaName);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousMediaName", mediaName);
        }
        req.setAttribute("streamingInfoByMediaName", streamingInfo);
        
        req.getRequestDispatcher("/FindStreamingInfo.jsp").forward(req, resp);
	}
//	
//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// Map for storing messages.
//        Map<String, String> messages = new HashMap<String, String>();
//        req.setAttribute("messages", messages);
//        
//        // Retrieve BlogUsers, and store in the request.
//        List<StreamingInfo> streamingInfo = new ArrayList<StreamingInfo>();
//        
//        String mediaName = req.getParameter("mediaName");
//        if (mediaName == null || mediaName.trim().isEmpty()) {
//            messages.put("success", "Please enter a valid name.");
//        } else {
//        	// Retrieve BlogUsers, and store as a message.
//        	try {
//        		streamingInfo = streamingInfoDao.getStreamingInfoByMovieName(mediaName);
//            } catch (SQLException e) {
//    			e.printStackTrace();
//    			throw new IOException(e);
//            }
//        	messages.put("success", "Displaying results for " + mediaName);
//        	// Save the previous search term, so it can be used as the default
//        	// in the input box when rendering FindUsers.jsp.
////        	messages.put("previousMediaName", mediaName);
//        }
//        req.setAttribute("streamingInfoByMediaName", streamingInfo);
//        
//        req.getRequestDispatcher("/FindStreamingInfo.jsp").forward(req, resp);
//	}
}
