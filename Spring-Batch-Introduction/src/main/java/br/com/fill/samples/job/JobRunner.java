package br.com.fill.samples.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobRunner {

	public static void main(String[] args) throws ParseException {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("job-tax-calculator.xml");
		Date dtTransaction = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2018");
		Long bank = 237L;
		JobParameters parameters = new JobParametersBuilder()
				.addDate("DT_TRANSACTION",dtTransaction)
				.addLong("BANK",bank)
				.toJobParameters();
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher"); // recover the bean of JobLauncher
		Job job = (Job) context.getBean("job-task-calculator");
		
		try {
			jobLauncher.run(job, parameters);
			System.out.println("Completed");
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
