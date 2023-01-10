package movies.model;

public class StreamingInfo {
	protected int StreamingInfoId;
	protected StreamingSites StreamingSite;
	protected String Type;
	protected String Title;
	protected String Director;
	protected String Cast;
	protected String Country;
	protected String Date_Added;
	protected int Release_Year;
	protected String Rating;
	protected String Duration;
	protected String Listed_In;
	protected String Description;
	
	public StreamingInfo(int streamingInfoId, StreamingSites streamingSite, String type, String title, String director,
			String cast, String country, String date_Added, int release_Year, String rating, String duration,
			String listed_In, String description) {
		StreamingInfoId = streamingInfoId;
		StreamingSite = streamingSite;
		Type = type;
		Title = title;
		Director = director;
		Cast = cast;
		Country = country;
		Date_Added = date_Added;
		Release_Year = release_Year;
		Rating = rating;
		Duration = duration;
		Listed_In = listed_In;
		Description = description;
	}
	
	public StreamingInfo(StreamingSites streamingSite, String type, String title, String director,
			String cast, String country, String date_Added, int release_Year, String rating, String duration,
			String listed_In, String description) {
		StreamingSite = streamingSite;
		Type = type;
		Title = title;
		Director = director;
		Cast = cast;
		Country = country;
		Date_Added = date_Added;
		Release_Year = release_Year;
		Rating = rating;
		Duration = duration;
		Listed_In = listed_In;
		Description = description;
	}

	public int getStreamingInfoId() {
		return StreamingInfoId;
	}

	public void setStreamingInfoId(int streamingInfoId) {
		StreamingInfoId = streamingInfoId;
	}

	public StreamingSites getStreamingSite() {
		return StreamingSite;
	}

	public void setStreamingSite(StreamingSites streamingSite) {
		StreamingSite = streamingSite;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getCast() {
		return Cast;
	}

	public void setCast(String cast) {
		Cast = cast;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getDate_Added() {
		return Date_Added;
	}

	public void setDate_Added(String date_Added) {
		Date_Added = date_Added;
	}

	public int getRelease_Year() {
		return Release_Year;
	}

	public void setRelease_Year(int release_Year) {
		Release_Year = release_Year;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getListed_In() {
		return Listed_In;
	}

	public void setListed_In(String listed_In) {
		Listed_In = listed_In;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}