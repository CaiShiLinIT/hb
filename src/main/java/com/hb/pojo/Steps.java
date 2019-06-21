package com.hb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class Steps {

    private String action;
    private String assistant_action;
    private int distance;
    private int duration;
    private String instruction;
    private String orientation;
    private String polyline;
    private String road;

}