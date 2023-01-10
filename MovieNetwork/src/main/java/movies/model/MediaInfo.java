package movies.model;

public class MediaInfo {
	
	protected String title;
	protected String titleId;
	protected String actor;
	protected int imdbAudience;
	protected int imdbNumVotes;
	protected int rottenCritic;
	protected int rottenAudience;
	protected String streamingPlatform;
	protected String genres;
	protected int year;
	protected String URL;
	
	public MediaInfo(String title, String titleId, String actor, int imdbAudience, int imdbNumVotes, int rottenCritic,
			int rottenAudience, String streamingPlatform, String genres, int year, String URL) {
		this.title = title;
		this.titleId = titleId;
		this.actor = actor;
		this.imdbAudience = imdbAudience;
		this.imdbNumVotes = imdbNumVotes;
		this.rottenCritic = rottenCritic;
		this.rottenAudience = rottenAudience;
		this.streamingPlatform = streamingPlatform;
		this.genres = genres;
		this.year = year;
		this.URL = URL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getImdbAudience() {
		return imdbAudience;
	}

	public void setImdbAudience(int imdbAudience) {
		this.imdbAudience = imdbAudience;
	}

	public int getImdbNumVotes() {
		return imdbNumVotes;
	}

	public void setImdbNumVotes(int imdbNumVotes) {
		this.imdbNumVotes = imdbNumVotes;
	}

	public int getRottenCritic() {
		return rottenCritic;
	}

	public void setRottenCritic(int rottenCritic) {
		this.rottenCritic = rottenCritic;
	}

	public int getRottenAudience() {
		return rottenAudience;
	}

	public void setRottenAudience(int rottenAudience) {
		this.rottenAudience = rottenAudience;
	}

	public String getStreamingPlatform() {
		return streamingPlatform;
	}

	public void setStreamingPlatform(String streamingPlatform) {
		this.streamingPlatform = streamingPlatform;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	
}