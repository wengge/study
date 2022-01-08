package com.wengge.study.po;

import java.io.Serializable;
import lombok.Data;

/**
 * t_student
 * @author 
 */
@Data
public class Student implements Serializable {
    /**
     * 主键自增
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 班级
     */
    private String classes;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String idNumber;

    private static final long serialVersionUID = 1L;
}