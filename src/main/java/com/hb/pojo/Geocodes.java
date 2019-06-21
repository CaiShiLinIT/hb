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
public class Geocodes {
    private String formatted_address;
    private String country;
    private String province;
    private String citycode;
    private String city;
    private String district;
    private List<String> township;
    private Neighborhood neighborhood;
    private Building building;
    private String adcode;
    private List<String> street;
    private List<String> number;
    private String location;
    private String level;

}