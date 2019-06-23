package com.hb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 菜品PoJo
 */
@Data
@Accessors(chain = true)
@TableName("caidanbiao")
public class CaiDan implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer caiDanID;
    private String caiMing;         //菜名
    private Double yuanJiaGe;       //原价格
    private Double youHuiJiaGe;     //优惠价格
    private String caiPinMiaoShu;   //菜品描述
    private Integer caiPinLeiXing;  //菜品类型
    private Integer yueXiaoLiang;   //月销量
    private Double pingFen;         //评分
    private String caiPinTuPian;    //用","分割
    private Integer tuiJian;        //是否为推荐
    private Integer zheKou;         //是否为折扣
    private Integer xinPin;         //是否为新品
}
