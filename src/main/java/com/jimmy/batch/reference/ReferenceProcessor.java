package com.jimmy.batch.reference;

import com.jimmy.batch.dto.ReferenceXmlItem;
import com.jimmy.batch.commons.entity.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class ReferenceProcessor implements ItemProcessor<ReferenceXmlItem, Reference> {

    private static final Logger log = LoggerFactory.getLogger(ReferenceProcessor.class);

    @Override
    public Reference process(final ReferenceXmlItem ref) throws Exception {
        System.out.println("processor start");
        final String shortDesc = ref.getActivityShDesc() == null ? (ref.getDivisionShDesc() == null ? ( ref.getPositionShDesc() == null ? null : ref.getPositionShDesc() ) : ref.getDivisionShDesc() ) : ref.getActivityShDesc();
        final String longDesc = ref.getActivityLgDesc() == null ? (ref.getDivisionLgDesc() == null ? ( ref.getPositionLgDesc() == null ? null : ref.getPositionLgDesc() ) : ref.getDivisionLgDesc() ) : ref.getActivityLgDesc();

        final Reference transformedRef = new Reference(null, "1", shortDesc, longDesc);

        log.info("Converting (" + ref + ") into (" + transformedRef + ")");

        return transformedRef;
    }

}
