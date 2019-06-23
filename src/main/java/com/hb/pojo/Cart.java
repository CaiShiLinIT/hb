package com.hb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 购物车PoJo
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private String yhm;     //用户id
    private Integer caiPinId;   //菜品id
    private String title;       //菜品名
    private String img;         //菜品图片
    private Double price;       //价格
    private Integer shuLiang;   //数量
}
