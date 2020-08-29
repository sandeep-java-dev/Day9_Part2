package beans;

public class Courses {
	private String courseName;
	private String category;
	private int duration;
	private int numberOfTests;
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(String courseName, String category, int duration, int numberOfTests) {
		super();
		this.courseName = courseName;
		this.category = category;
		this.duration = duration;
		this.numberOfTests = numberOfTests;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumberOfTests() {
		return numberOfTests;
	}
	public void setNumberOfTests(int numberOfTests) {
		this.numberOfTests = numberOfTests;
	}
	@Override
	public String toString() {
		return "Courses [courseName=" + courseName + ", category=" + category + ", duration=" + duration
				+ ", numberOfTests=" + numberOfTests + "]";
	}
	
	
}
