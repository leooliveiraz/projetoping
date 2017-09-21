package jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import regras.RegraStatus;

public class PingEmpregosMogi implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
    	RegraStatus.recebePing("http://www.empregosmogi.com/ping");	
	}

}
