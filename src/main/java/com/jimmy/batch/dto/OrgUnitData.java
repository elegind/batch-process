package com.jimmy.batch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="orgUnitData")
public class OrgUnitData {

    @XmlElement
    private String name;

    @XmlAttribute(name = "division")
    private String item_id;

    @XmlAttribute(name = "divisionShDesc")
    private String divisionShDesc;

    @XmlAttribute(name = "divisionLgDesc")
    private String divisionLgDesc;

}
