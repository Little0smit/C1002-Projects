public class W07Practical {
	
	public static void main(string args[]){
	// create a workshop object for Grand Challenges in CS
		Workshop gcWorkshop = new Workshop();
		
		// create a few attendee objects and initialise them
		//1
		Attendee attendee1 = new Attendee();
		attendee1.name = "Yusef Peter";
		attendee1.email = "yusefpeter@gmail.com";
		attendee1.isStudent = false;
		//2
		Attendee attendee2 = new Attendee();
		attendee2.name = "Fyodor Bonnay";
		attendee2.email = "fyodorbonnay@gmail.com";
		attendee2.isStudent = false;
		//3
		Attendee attendee3 = new Attendee();
		attendee3.name = "Wade Shelby";
		attendee3.email = "ws123@gmail.com";
		attendee3.isStudent = true;

		
		// register attendees to workshop
		gcWorkshop.registerAsAttendee(attendee1);
		gcWorkshop.registerAsAttendee(attendee2);
		gcWorkshop.registerAsAttendee(attendee3);
		
		// create a few presenter objects and initialise them
		Presenter presenter1 = new Presenter();
		presenter1.name = "Prof Mary Shaw";
		presenter1.affiliation = "University of St Andrews";
		presenter1.presentationFee = 10;

		Presenter presenter2 = new Presenter();
		presenter2.name = "Prof Ettie Benson";
		presenter2.affiliation = "University of St Andrews";
		presenter2.presentationFee = 7;

		Presenter presenter3 = new Presenter();
		presenter3.name = "Barclay Cokes";
		presenter3.affiliation = "University of Edinburgh";
		presenter3.presentationFee = 15;
			
		// create a few presentations and initialise them
		Presentation pres1 = new Presentation();
		pres1.title = "Ubiquitous Computing";
		pres1.time = 1200;
		pres1.duration = 45;
		pres1.presenter = presenter1;

		Presentation pres2 = new Presentation();
		pres2.title = "Memories for Life";
		pres2.time = 1300;
		pres2.duration = 35;
		pres2.presenter = presenter2;

		Presentation pres3 = new Presentation();
		pres3.title = "Learning for Life";
		pres3.time = 1400;
		pres3.duration = 60;
		pres3.presenter = presenter3;


		// add presentations to workshop
		gcWorkshop.addPresentation(pres1);
		gcWorkshop.addPresentation(pres2);
		gcWorkshop.addPresentation(pres3);

		// print workshop schedule
		gcWorkshop.printSchedule();

	}
}
