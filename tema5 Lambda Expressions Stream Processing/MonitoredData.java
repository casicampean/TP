package tema5;

public class MonitoredData {
	private String start_time;
	private String end_time;
	private String activity;
	
	public MonitoredData(String start, String end, String activity) {
		this.start_time=start;
		this.end_time=end;
		this.activity=activity;
	}
	public String getActivity() {
		return activity;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	
	

}
