package com.jimmy.batch.configuration;

import com.jimmy.batch.dto.ReferenceXmlItem;
import com.jimmy.batch.reference.JobCompletionNotificationListener;
import com.jimmy.batch.reference.ReferenceProcessor;
import com.jimmy.batch.commons.entity.Reference;
import com.jimmy.batch.commons.repository.ReferenceRepository;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class BatchConfiguration {

    @Autowired
    ReferenceRepository referenceRepository;

    @Bean
    public StaxEventItemReader itemReader() {
        System.out.println("current dir : " + System.getProperty("user.dir"));
        return new StaxEventItemReaderBuilder<ReferenceXmlItem>()
                .name("itemReader")
                .resource(new FileSystemResource("./src/main/resources/com.jimmy.batch/sample.xml"))
                .addFragmentRootElements("orgUnitData", "positionData", "activityData")
                .unmarshaller(refMarshaller())
                .build();

    }

    @Bean
    public XStreamMarshaller refMarshaller() {
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("orgUnitData", ReferenceXmlItem.class);
        aliases.put("positionData", ReferenceXmlItem.class);
        aliases.put("activityData", ReferenceXmlItem.class);
        aliases.put("divisionShDesc", String.class);
        aliases.put("divisionLgDesc", String.class);
        aliases.put("positionLgDesc", String.class);
        aliases.put("positionShDesc", String.class);
        aliases.put("activityLgDesc", String.class);
        aliases.put("activityShDesc", String.class);

        XStreamMarshaller marshaller = new XStreamMarshaller();
        ExplicitTypePermission typePermission = new ExplicitTypePermission(new Class[] { ReferenceXmlItem.class });
        marshaller.setTypePermissions(typePermission);

        marshaller.setAliases(aliases);

        return marshaller;
    }

    @Bean
    public ReferenceProcessor processor() {
        return new ReferenceProcessor();
    }

    @Bean
    public ItemWriter<Reference> writer() {
        return references -> {
            System.out.println("save reference objects");
            referenceRepository.saveAll(references);
        };
    }

    @Bean
    public Job reference(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("reference", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, ItemWriter<Reference> writer) {
        return new StepBuilder("step1", jobRepository)
                .<ReferenceXmlItem, Reference> chunk(10, transactionManager)
                .reader(itemReader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
