package movies.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import movies.model.*;

public class MediaInfoDao{
	
	protected ConnectionManager connectionManager;
	
	private static MediaInfoDao instance = null;
	
	protected MediaInfoDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static MediaInfoDao getInstance() {
		if(instance == null) {
			instance = new MediaInfoDao();
		}
		return instance;
	}
	
	public MediaInfo getMediaInfoById(String titleId) throws SQLException {
		System.out.print(titleId);
		String selectMedia = "SELECT Media.Title AS Title, Media.TitleId AS TitleId, Name AS Actor, "
				+ "	AverageRating AS ImdbAudience, NumVotes AS ImdbNumVotes, CriticRating AS RottenCritic, "
				+ "    AudienceRating AS RottenAudience, StreamingPlatform, Media.Genres AS Genres, Media.StartYear AS Year, Books.URL AS URL\n"
				+ " FROM Media \n"
				+ " LEFT OUTER JOIN MediaActorMatches ON Media.TitleId = MediaActorMatches.TitleId\n"
				+ " LEFT OUTER JOIN ActorInfo ON MediaActorMatches.ActorId = ActorInfo.ActorId\n"
				+ " LEFT OUTER JOIN ImdbRating ON Media.TitleId = ImdbRating.TitleId\n"
				+ " LEFT OUTER JOIN StreamingInfo ON Media.Title = StreamingInfo.Title\n"
				+ " LEFT OUTER JOIN StreamingSite ON StreamingInfo.StreamingSiteId = StreamingSite.StreamingSiteId\n"
				+ " LEFT OUTER JOIN RottenTomatoes ON Media.Title = RottenTomatoes.Title\n"
				+ " LEFT OUTER JOIN Books ON Media.Title = Books.BookTitle"
				+ " WHERE Media.TitleId = ? \n"
				+ " LIMIT 1;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMedia);
			selectStmt.setString(1, titleId);
			results = selectStmt.executeQuery();

			if(results.next()) {
				String resultTitle = results.getString("Title");
				System.out.print(resultTitle);
				String resultTitleId = results.getString("TitleId");
				String actor = results.getString("Actor");
				int imdbAudience = results.getInt("ImdbAudience");
				int imdbNumVotes = results.getInt("ImdbNumVotes");
				int rottenCritic = results.getInt("RottenCritic");
				int rottenAudience = results.getInt("RottenAudience");
				String streamingPlatform = results.getString("StreamingPlatform");
				String genres = results.getString("Genres");
				int year = results.getInt("Year");
				String URL = results.getString("URL");
				
				MediaInfo mediaInfo = new MediaInfo(resultTitle, resultTitleId, actor, imdbAudience
							, imdbNumVotes, rottenCritic, rottenAudience, streamingPlatform, genres, year, URL);
				return mediaInfo;
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
		return null;
	}
	
	
	/**
	public List<MediaInfo> getMediaInfoByTitle(String title) throws SQLException {
		List<MediaInfo> mediaInfos = new ArrayList<MediaInfo>();
		String selectMedia = "SELECT Media.Title AS Title, Media.TitleId AS TitleId, Name AS Actor,"
				+ " AverageRating AS ImdbAudience, NumVotes AS ImdbNumVotes, CriticRating AS RottenCritic,"
				+ " AudienceRating AS RottenAudience, StreamingPlatform, Media.Genres AS Genres, Media.StartYear AS Year\n"
				+ " FROM Media \n"
				+ " INNER JOIN MediaActorMatches ON Media.TitleId = MediaActorMatches.TitleId\n"
				+ " INNER JOIN ActorInfo ON MediaActorMatches.ActorId = ActorInfo.ActorId\n"
				+ " INNER JOIN ImdbRating ON Media.TitleId = ImdbRating.TitleId\n"
				+ " INNER JOIN StreamingInfo ON Media.Title = StreamingInfo.Title\n"
				+ " INNER JOIN StreamingSite ON StreamingInfo.StreamingSiteId = StreamingSite.StreamingSiteId\n"
				+ " LEFT OUTER JOIN RottenTomatoes ON Media.Title = RottenTomatoes.Title\n"
				+ " WHERE Media.Title = ? ;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMedia);
			selectStmt.setString(1, title);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String resultTitle = results.getString("Title");
				String titleId = results.getString("TitleId");
				String actor = results.getString("Actor");
				int imdbAudience = results.getInt("ImdbAudience");
				int imdbNumVotes = results.getInt("ImdbNumVotes");
				int rottenCritic = results.getInt("RottenCritic");
				int rottenAudience = results.getInt("RottenAudience");
				String streamingPlatform = results.getString("StreamingPlatform");
				String genres = results.getString("Genres");
				int year = results.getInt("Year");
				
				MediaInfo mediaInfo = new MediaInfo(resultTitle, titleId, actor, imdbAudience, imdbNumVotes, rottenCritic, rottenAudience, streamingPlatform, genres, year);

				//Adding to our array list above
				mediaInfos.add(mediaInfo);
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
		//return the cc array list
		return mediaInfos;
	}
	**/
}
	

