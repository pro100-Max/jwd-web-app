package com.epam.jwd.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Faculty extends Entity {

    private EnumFaculty type;
    private int countPlaces;

    public Faculty(final EnumFaculty type, final int countPlaces) {
        this.type = type;
        this.countPlaces = countPlaces;
    }
}