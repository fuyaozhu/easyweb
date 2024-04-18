package com.wf.ew.common;

/**
 * 通用的结果类，用于封装操作的结果，包括状态码、消息和数据。
 * @param <T> 结果包含的数据类型
 */
public class Result<T> {
    private Integer code;  // 操作结果的状态码
    private String msg;    // 操作结果的消息
    private T data;        // 操作结果的数据

    /**
     * 无参数构造函数，创建一个空的 Result 对象。
     */
    public Result() {
        super();
    }

    /**
     * 带参数的构造函数，创建一个包含状态码、消息和数据的 Result 对象。
     *
     * @param code 操作结果的状态码
     * @param msg  操作结果的消息
     * @param data 操作结果的数据
     */
    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 带参数的构造函数，创建一个包含状态码和消息的 Result 对象。
     *
     * @param code 操作结果的状态码
     * @param msg  操作结果的消息
     */
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取操作结果的状态码。
     *
     * @return 操作结果的状态码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置操作结果的状态码。
     *
     * @param code 操作结果的状态码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取操作结果的消息。
     *
     * @return 操作结果的消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置操作结果的消息。
     *
     * @param msg 操作结果的消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取操作结果的数据。
     *
     * @return 操作结果的数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置操作结果的数据。
     *
     * @param data 操作结果的数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 将 Result 对象的属性以字符串形式返回。
     *
     * @return 包含状态码、消息和数据的字符串表示形式
     */
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}