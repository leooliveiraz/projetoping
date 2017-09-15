import jobs.Agendamento;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;

import static play.mvc.Results.notFound;

import java.util.Date;

import static play.mvc.Results.internalServerError;
import static play.mvc.Results.badRequest;;

public class Global extends GlobalSettings {
	public void onStart(play.Application application) {
		System.out.println("hey");
		Agendamento.callMultipleScheduler();		
	}
}