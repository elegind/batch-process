package com.jimmy.batch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "activityData")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceXmlItem {

    @XmlAttribute(name = "position")
    private String positionId;

    @XmlAttribute(name = "activity")
    private String activityId;

    @XmlAttribute(name = "division")
    private String divisionId;

    @XmlAttribute(name = "divisionShDesc")
    private String divisionShDesc;

    @XmlAttribute(name = "divisionLgDesc")
    private String divisionLgDesc;

    @XmlAttribute(name = "positionLgDesc")
    private String positionLgDesc;

    @XmlAttribute(name = "positionShDesc")
    private String positionShDesc;

    @XmlAttribute(name = "activityLgDesc")
    private String activityLgDesc;

    @XmlAttribute(name = "activityShDesc")
    private String activityShDesc;
}
