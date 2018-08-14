package br.com.fill.samples.job;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobRunner {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("job-tax-calculator.xml");
	}
}
