package com.wengge.study.enums;
import lombok.Getter;

import java.util.Objects;

/**
 * @author zhouwen
 * @date 2022
 */
@Getter
public enum SexEnum {
    /**
     * 男性
     */
    MAN("0","男"),
    /**
     * 女性
     */
    WOMAN("1","女")
    ;

    private String code;
    private String value;

    SexEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Boolean checkCode(String code){
        for(SexEnum sexEnum : SexEnum.values()){
            if(Objects.equals(sexEnum.getCode(),code)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
