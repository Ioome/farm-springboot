package com.farm.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @name: ResponseStatus
 * @author: sutton
 * @date: 2023-04-02 16:10
 * @description: ResponseStatus
 */

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    /**
     * success.
     */
    SUCCESS("200", "success"),

    /**
     * 服务器内部错误.
     */
    FAIL("500", "failed"),

    /**
     * 成功
     */
    HTTP_STATUS_200("200", "ok"),

    /**
     * 400 请求错误
     */
    HTTP_STATUS_400("400", "request error"),

    /**
     * 401 未认证
     */
    HTTP_STATUS_401("401", "no authentication"),

    /**
     * 403 无权限
     */
    HTTP_STATUS_403("403", "no authorities"),

    /**
     * 500 服务器错误
     */
    HTTP_STATUS_500("500", "server error");

    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500
            ));

    /**
     * response code
     */
    private final String responseCode;

    /**
     * description.
     */
    private final String description;

}
