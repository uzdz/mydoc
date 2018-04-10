package com.eliteams.mydoc.common.generic;

/**
 * 所有自定义枚举类型实现该接口
 *
 * @author uzdz
 * @since 2017年6月9日 下午6:14:06
 **/
public interface GenericEnum {

    /**
     * value: 为保存在数据库中的值
     */
    String getValue();

    /**
     * text : 为前端显示值
     */
    String getText();

}
