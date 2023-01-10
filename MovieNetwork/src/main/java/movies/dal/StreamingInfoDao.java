package movies.dal;

import movies.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreamingInfoDao {
	protected ConnectionManager connectionManager;

	private static StreamingInfoDao instance = null;
	protected StreamingInfoDao() {
		connectionManager = new ConnectionManager();
	}
	public static StreamingInfoDao getInstance() {
		if(instance == null) {
			instance = new StreamingInfoDao();
		}
		return instance;
	}	
	
	public List<StreamingInfo> getStreamingInfoByMovieName(String movieName) throws SQLException {
		List<StreamingInfo> streamingInfo = new ArrayList<>();
		String select = "SELECT StreamingInfoId, StreamingInfo.StreamingSiteId as StreamingSiteId,Type, Title, Director, \n"
				+ "				Cast, Country, Date_Added, Release_Year, Rating, Duration , Listed_In, Description\n"
				+ "				 ,StreamingPlatform, Url\n"
				+ "				FROM StreamingInfo \n"
				+ "                inner join StreamingSite on  StreamingSite.StreamingSiteId = StreamingInfo.StreamingSiteId\n"
				+ "                WHERE Title=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(select);
			selectStmt.setString(1, movieName);

			results = selectStmt.executeQuery();
			
			while(results.next()) {
				int streamingInfoId = results.getInt("StreamingInfoId");
				int streamingSiteId = results.getInt("StreamingSiteId");
				String type = results.getString("Type");
				String title = results.getString("Title");
				String director = results.getString("Director");
				String cast = results.getString("Cast");
				String country = results.getString("Country");
				String dateAdded = results.getString("Date_Added");
				int releaseYear = results.getInt("Release_Year");
				String rating = results.getString("Rating");
				String duration = results.getString("Duration");
				String listedIn = results.getString("Listed_In");
				String description = results.getString("Description");
				
				// streaming site
				String streamingPlatform = results.getString("StreamingPlatform");
				String url = results.getString("Url");
				
				StreamingSites site = new StreamingSites(streamingSiteId,streamingPlatform,url);
				StreamingInfo info = new StreamingInfo(streamingInfoId,site, type, title, director, cast, country, 
						dateAdded, releaseYear, rating, duration, listedIn, description);
				streamingInfo.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return streamingInfo;
	}
	
}
