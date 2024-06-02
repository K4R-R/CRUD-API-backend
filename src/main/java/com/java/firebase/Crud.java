package com.java.firebase;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Crud {
    private String documentId;
    private String name;
    private Map<String,Float> Marks;
}
