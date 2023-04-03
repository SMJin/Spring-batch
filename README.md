# Spring-batch
Spring-Batch Basic Start


## 에러 해결 기록
### Spring batch 의 Job을 잘 작성하였는데도 Job이 계속 실행이 안되는 문제 발생 - Spring Batch 버전 문제 해결
###### 'org.springframework.batch.core.configuration.annotation.JobBuilderFactory' that could not be found.
##### 가장 먼저 확인해야 할 것은 @EnableBatchProcessing 이 어노테이션을 잘 붙였는지 확인해야 한다.
##### 하지만 내 경우에는 @EnableBatchProcessing 어노테이션을 잘 확인했음에도 불구하고 여전히 Job이 실행되지 않았다.
##### 엄청난 구글링의 결과 ...
##### Spring batch 가 5.0.x 버전이 되면서 JobBuilderFactory가 deprecated 되었다는 것을 알았다.
##### Spring boot 버전을 2.7.x 으로 낮춰주고 Batch도 버전을 4.3.x로 낮춰주니까 결과가 잘 나온다.

###### 참고문서
###### https://stackoverflow.com/questions/75882879/org-springframework-batch-core-configuration-support-defaultbatchconfiguration-c
###### https://mindasom.tistory.com/168
###### https://github.com/spring-projects/spring-batch/wiki/Spring-Batch-5.0-Migration-Guide
