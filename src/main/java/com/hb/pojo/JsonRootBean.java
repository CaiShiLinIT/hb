/**
  * Copyright 2019 bejson.com 
  */
package com.hb.pojo;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class JsonRootBean {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<Geocodes> geocodes;

}