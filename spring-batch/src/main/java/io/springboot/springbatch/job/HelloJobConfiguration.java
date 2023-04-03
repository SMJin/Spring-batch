package io.springboot.springbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
//lombok에서 제공하는 의존성 자동 주입 annotation
@RequiredArgsConstructor
public class HelloJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	public HelloJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		
	}

	@Bean
	public Job helloJob() {
		return this.jobBuilderFactory.get("helloJob")
				.start(helloStep1())
				.next(helloStep2())
				.build();
	}

	@Bean
	public Step helloStep1() {
		return stepBuilderFactory.get("helloStep1")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
							throws Exception {

						System.out.println("========================");
						System.out.println(" >> Hello Spring Batch!!");
						System.out.println("========================");
						
						// 기능이 한번 실행되고 종료됨.
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	
	@Bean
	public Step helloStep2() {
		return stepBuilderFactory.get("helloStep2")
				.tasklet(new Tasklet() {
					
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
							throws Exception {
						
						System.out.println("========================");
						System.out.println(" >> step2 was executed!!");
						System.out.println("========================");
						
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
}
