package movies.dal;

import movies.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreamingSitesDao {
	protected ConnectionManager connectionManager;

	private static StreamingSitesDao instance = null;
	protected StreamingSitesDao() {
		connectionManager = new ConnectionManager();
	}
	public static StreamingSitesDao getInstance() {
		if(instance == null) {
			instance = new StreamingSitesDao();
		}
		return instance;
	}

	public List<StreamingSites> getAll() throws SQLException {
	List<StreamingSites> streamingSites = new ArrayList<>();
	String select = "SELECT StreamingSiteId, StreamingPlatform, Url FROM StreamingSite;";
	Connection connection = null;
	PreparedStatement selectStmt = null;
	ResultSet results = null;
	try {
		connection = connectionManager.getConnection();
		selectStmt = connection.prepareStatement(select);
		results = selectStmt.executeQuery();
		while(results.next()) {
			int streamingSiteId = results.getInt("StreamingSiteId");
			String streamingPlatform = results.getString("StreamingPlatform");
			String url = results.getString("Url");
			StreamingSites streamingSite = new StreamingSites(streamingSiteId,streamingPlatform, url);
			streamingSites.add(streamingSite);
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
	return streamingSites;
}

}
