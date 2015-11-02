public class Presentation {
	string title;
	int time;
	int duration;
	Presenter[] presenter;

	public void printDetails(){
		System.out.print("Title: " + title + " will be at: " + time
							+ " presented by: ");
		presenter.printName();
	}
}
