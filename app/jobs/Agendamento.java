package jobs;

import java.util.Date;

import org.quartz.ObjectAlreadyExistsException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;


public class Agendamento {
	public static void callMultipleScheduler() {
		try{
			// Set the job defination
			JobDetailImpl pingEmpregosMogiTeste = new JobDetailImpl();
			pingEmpregosMogiTeste.setName("pingEmpregosMogiTeste");
			pingEmpregosMogiTeste.setJobClass(PingEmpregosMogiTeste.class);

			JobDetailImpl pingEmpregosMogi = new JobDetailImpl();
			pingEmpregosMogi.setName("pingEmpregosMogi");
			pingEmpregosMogi.setJobClass(PingEmpregosMogi.class);



			// Creating schedule time with trigger
			SimpleTriggerImpl triggerPingEmpregosMogiTeste = new SimpleTriggerImpl();
			triggerPingEmpregosMogiTeste.setStartTime(new Date(System.currentTimeMillis() + 1000));
			triggerPingEmpregosMogiTeste.setRepeatInterval(240000);
			triggerPingEmpregosMogiTeste.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			triggerPingEmpregosMogiTeste.setName("pingEmpregosMogiTeste");
			

			SimpleTriggerImpl triggerPingEmpregosMogi = new SimpleTriggerImpl();
			triggerPingEmpregosMogi.setStartTime(new Date(System.currentTimeMillis() + 1000));
			triggerPingEmpregosMogi.setRepeatInterval(240000);
			triggerPingEmpregosMogi.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			triggerPingEmpregosMogi.setName("pingEmpregosMogi");


			try {
				org.quartz.Scheduler schedulerMain = new StdSchedulerFactory().getScheduler();
				schedulerMain.start();
				schedulerMain.scheduleJob(pingEmpregosMogiTeste,triggerPingEmpregosMogiTeste);
				schedulerMain.scheduleJob(pingEmpregosMogi,triggerPingEmpregosMogi);
			} catch (ObjectAlreadyExistsException e) {
				System.out.println("Já existe o JOB: "+e.getMessage());
			}

		}catch (Exception e) {
			System.out.println("Já existe o JOB");
		}
	}
}
