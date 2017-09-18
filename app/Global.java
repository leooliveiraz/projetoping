import jobs.Agendamento;
import play.GlobalSettings;;

public class Global extends GlobalSettings {
	public void onStart(play.Application application) {
		System.out.println("hey");
		Agendamento.callMultipleScheduler();		
	}
}