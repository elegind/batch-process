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
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityData {

    @XmlAttribute(name = "activity")
    private String item_id;

    @XmlAttribute(name = "activityLgDesc")
    private String activityLgDesc;

    @XmlAttribute(name = "activityShDesc")
    private String activityShDesc;

}
