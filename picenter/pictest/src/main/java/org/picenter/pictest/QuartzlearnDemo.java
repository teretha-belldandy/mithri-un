package org.picenter.pictest;

import java.util.Date;

import org.picenter.pictest.testclass.MyJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzlearnDemo {

	public static void main(String[] args) {
		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.startAt(new Date(System.currentTimeMillis() + 10000))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			scheduler.scheduleJob(job, trigger);
			System.out.println(scheduler.checkExists(new JobKey("job1", "group1")));
			System.out.println(scheduler.checkExists(new TriggerKey("trigger1", "group1")));

			scheduler.start();
			// Thread.sleep(1000);
			// scheduler.shutdown();
			System.out.println(scheduler.checkExists(new JobKey("job1", "group1")));
			System.out.println(scheduler.checkExists(new TriggerKey("trigger1", "group1")));
		} catch (Exception e) {

		} finally {

		}
	}
}