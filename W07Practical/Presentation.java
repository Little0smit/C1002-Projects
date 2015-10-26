public class Presentation {
	string title;
	int time;
	int duration;
	Presentor[] presentor;

	public void printDetails(){
		System.out.print("Title: " + title + " will be at: " + time
							+ " presented by: ");
		presentor.printName();
	}
}
