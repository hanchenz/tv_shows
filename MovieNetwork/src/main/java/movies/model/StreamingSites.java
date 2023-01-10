package movies.model;

public class StreamingSites {
	protected int StreamingSiteId;
	protected String StreamingPlatform;
	protected String Url;
	
	public StreamingSites(int streamingSiteId, String streamingPlatform, String url) {
		StreamingSiteId = streamingSiteId;
		StreamingPlatform = streamingPlatform;
		Url = url;
	}
	
	public StreamingSites(String streamingPlatform, String url) {
		StreamingPlatform = streamingPlatform;
		Url = url;
	}

	public int getStreamingSiteId() {
		return StreamingSiteId;
	}

	public void setStreamingSiteId(int streamingSiteId) {
		StreamingSiteId = streamingSiteId;
	}

	public String getStreamingPlatform() {
		return StreamingPlatform;
	}

	public void setStreamingPlatform(String streamingPlatform) {
		StreamingPlatform = streamingPlatform;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
}