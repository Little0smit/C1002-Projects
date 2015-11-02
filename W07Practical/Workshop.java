public class Workshop{
	string venue;
	int registrationFee;
	Attendees[] attendee;
	static int attendeeCount = 1;
	Presentation[] presentations;
	static int presCount = 1;

	public void registerAsAttendee(Attendees[] attendee){
		this.attendee[attendeeCount] = attendee;
		attendeeCount++;
	}

	public void addPresentation(Presentation[] presentation){
		this.presentations[presCount] = presentation;
		presCount++;	
	}
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
