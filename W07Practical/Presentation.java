public class Presentation {
	string title;
	int time;
	int duration;
	Presenter[] presenter;

	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy"); 

	Date t; 

    t = ft.parse(input); 
    System.out.println(t);

    public void setTime(){

	public void printDetails(){
		System.out.print("Title: " + title + " will be at: " + time
							+ " presented by: ");
		presenter.printName();
	}
}
