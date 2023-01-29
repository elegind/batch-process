package com.jimmy.batch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceXmlItem {

    private String divisionShDesc;

    private String divisionLgDesc;

    private String positionLgDesc;

    private String positionShDesc;

    private String activityLgDesc;

    private String activityShDesc;
}
