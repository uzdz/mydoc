package com.eliteams.mydoc.common.entity;

import java.util.Map;

/**
 * 客户端往后台的请求参数对象.
 *
 * @author uzdz
 * @since 2017年6月9日 下午6:14:06
 */
public class RequestParams {
    //map参数上传
    private Map<String, Object> map;

    public RequestParams() {
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
