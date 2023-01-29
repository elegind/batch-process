package com.jimmy.batch.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PositionData {

    @XmlAttribute(name = "position")
    private String item_id;

    @XmlAttribute(name = "positionLgDesc")
    private String positionLgDesc;

    @XmlAttribute(name = "positionShDesc")
    private String positionShDesc;

}