package org.smart4j.charter.bean;

import lombok.Data;

@Data
public final class ResponseBo<T> {
    private String code;
    private String msg;
    private T data;

    public static ResponseBo ok() {
        return ok(null);
    }

    public static <T> ResponseBo ok(T obj) {
        ResponseBo bo = new ResponseBo();
        bo.setCode("0");
        bo.setMsg("success");
        bo.setData(obj);
        return bo;
    }

    public static ResponseBo error() {
        return error(null);
    }

    public static ResponseBo error(String msg) {
        return error(msg, null);
    }

    public static <T> ResponseBo error(String msg, T obj) {
        ResponseBo bo = new ResponseBo();
        bo.setCode("-1");
        bo.setMsg(msg);
        bo.setData(obj);
        return bo;
    }

}
