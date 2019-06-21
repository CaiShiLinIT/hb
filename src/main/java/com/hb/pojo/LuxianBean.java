/**
  * Copyright 2019 bejson.com 
  */
package com.hb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class LuxianBean {
    private Datas data;
    private int errcode;
    private String errdetail;
    private String errmsg;
    private String ext;
}