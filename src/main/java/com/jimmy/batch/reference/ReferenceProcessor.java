package com.jimmy.batch.reference;

import com.jimmy.batch.dto.OrgUnitData;
import com.jimmy.batch.dto.ReferenceObjectContainer;
import com.jimmy.batch.dto.ReferenceXmlItem;
import com.jimmy.batch.commons.entity.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class ReferenceProcessor implements ItemProcessor<OrgUnitData, Reference> {

    private static final Logger log = LoggerFactory.getLogger(ReferenceProcessor.class);

    @Override
    public Reference process(final OrgUnitData ref) throws Exception {
        System.out.println("processor start");

        log.info("Converting (" + ref + ") ");

        return new Reference(null, ref.getItem_id(), ref.getDivisionShDesc(), ref.getDivisionLgDesc());
    }

}
