package com.jimmy.batch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="omObjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceObjectContainer {
    @XmlElement(name = "orgUnitData")
    private List<OrgUnitData> orgUnitData;
    @XmlElement(name = "positionData")
    private List<PositionData> positionData;
    @XmlElement(name = "activityData")
    private List<ActivityData> activityData;

}