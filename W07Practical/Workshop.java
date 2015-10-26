public class Workshop{
	string venue;
	int registrationFee;
	Attendees[] attendee;
	Presentation[] presentations;

	public void printSchedule(){
	if (presentations != null){
			for (Presentation presentation: presentations){
				if (presentation != null){
					presentation.printDetails();
				}
			}
		}
	}

	public static void main(string args[]){
	}
}
