package movies.model;

public class Media{
	
	protected String movieId;
	protected String movieType;
	protected String title;
	protected Boolean isAdult;
	protected int startYear;
	protected int runtime;
	protected String genres;
	
	public Media(String movieId, String movieType, String title, Boolean isAdult, int startYear, int runtime,
			String genres) {
		this.movieId = movieId;
		this.movieType = movieType;
		this.title = title;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.runtime = runtime;
		this.genres = genres;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(Boolean isAdult) {
		this.isAdult = isAdult;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	

}