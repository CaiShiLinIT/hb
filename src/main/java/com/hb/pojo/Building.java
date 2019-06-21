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
public class Building {

    private List<String> name;
    private List<String> type;

}