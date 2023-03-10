package com.jimmy.batch.reference;

import com.jimmy.batch.commons.entity.Reference;
import com.jimmy.batch.commons.repository.ReferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  @Autowired
  private ReferenceRepository referenceRepository;

  @Autowired
  public JobCompletionNotificationListener(ReferenceRepository referenceRepository) {
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      System.out.println("job finished");
      log.info("!!! JOB FINISHED! Time to verify the results");
      List<Reference> refList = referenceRepository.findAll();
      log.info("Found : " + refList.size() + " records stored in DB");
    }
  }
}