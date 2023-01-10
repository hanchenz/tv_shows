package movies.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import movies.model.*;

public class MediaDao{
	
	protected ConnectionManager connectionManager;
	
	private static MediaDao instance = null;
	
	protected MediaDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static MediaDao getInstance() {
		if(instance == null) {
			instance = new MediaDao();
		}
		return instance;
	}
	
	// Create
	
	public Media create(Media movie) throws SQLException {
		String insertMovie = 
				"INSERT INTO Media(TitleId, TitleType, Title, IsAdult, StartYear, RuntimeMinutes, Genres) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertMovie);
			insertStmt.setString(1, movie.getMovieId());
			insertStmt.setString(2, movie.getMovieType());
			insertStmt.setString(3, movie.getTitle());;
			insertStmt.setBoolean(4, movie.getIsAdult());
			insertStmt.setInt(5, movie.getStartYear());
			insertStmt.setInt(6, movie.getRuntime());
			insertStmt.setString(7, movie.getGenres());
			insertStmt.executeUpdate();
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	public List<Media> getMediaByTitle(String title) throws SQLException{
		List<Media> medias = new ArrayList<Media>();
		String selectMovie = "SELECT TitleId, TitleType, Title, IsAdult, StartYear, RuntimeMinutes, Genres " + 
        "FROM Media WHERE Title=? ORDER BY StartYear;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMovie);
			selectStmt.setString(1, title);
			results = selectStmt.executeQuery();
			while (results.next()) {
				String resultMovieId = results.getString("TitleId");
				String resultMovieType = results.getString("TitleType");
				String resultTitle = results.getString("Title");
				Boolean resultIsAdult = results.getBoolean("IsAdult");
				int resultStartYear = results.getInt("StartYear");
				int resultRunTimes = results.getInt("RuntimeMinutes");
				String resultGenres = results.getString("Genres");
				
				Media movie = new Media(resultMovieId, resultMovieType, resultTitle,
                    resultIsAdult, resultStartYear, resultRunTimes, resultGenres);
				medias.add(movie);
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
		return medias;
	}
	
	public Media getMediaById(String titleId) throws SQLException{
		
		String selectMovie = "SELECT TitleId, TitleType, Title, IsAdult, StartYear, RuntimeMinutes, Genres " + 
        "FROM Media WHERE TitleId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectMovie);
			selectStmt.setString(1, titleId);
			results = selectStmt.executeQuery();
			if (results.next()) {
				String resultMovieId = results.getString("TitleId");
				String resultMovieType = results.getString("TitleType");
				String resultTitle = results.getString("Title");
				Boolean resultIsAdult = results.getBoolean("IsAdult");
				int resultStartYear = results.getInt("StartYear");
				int resultRunTimes = results.getInt("RuntimeMinutes");
				String resultGenres = results.getString("Genres");
				
				Media movie = new Media(resultMovieId, resultMovieType, resultTitle,
                    resultIsAdult, resultStartYear, resultRunTimes, resultGenres);
				return movie;
                
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

	
	// Update Genre 
	public Media updateGenre(Media media, String genre) throws SQLException {
		String updateMedia = "UPDATE Media SET Genres=? WHERE TitleId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateMedia);
			updateStmt.setString(1, genre);
			updateStmt.setString(2, media.getMovieId());
			updateStmt.executeUpdate();
			
			// Update the media param before returning to the caller.
			media.setGenres(genre);
			return media;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	
	// Delete
	
	public Media delete(Media media) throws SQLException {
		String deleteMedia = "DELETE FROM Media WHERE TitleId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteMedia);
			deleteStmt.setString(1, media.getMovieId());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Persons instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
	
}
	

