package com.jimmy.batch.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="header")
public class ReferenceObjectRoot {

    @XmlElement(name = "omObjects")
    private ReferenceObjectContainer referenceObjectContainer;

}
