package com.hb.pojo;
import java.sql.Timestamp;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors
public class FileEntity {
    private String type;
    private String size;
    private String path;
    private String titleOrig;
    private String titleAlter;
    private Timestamp uploadTime;
}