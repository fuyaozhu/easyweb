package com.wf.ew.common.utils;


import com.wf.ew.common.Result;

/**
 * 通用的结果工具类，用于创建成功或失败的结果对象，并提供多个重载的方法。
 */
public class ResultUtil {

    /**
     * 创建一个成功的结果对象，没有消息和数据。
     * @return 成功的结果对象
     */
    public static Result success() {
        return success("成功");
    }

    /**
     * 创建一个成功的结果对象，包含指定消息。
     * @param msg 成功消息
     * @return 成功的结果对象
     */
    public static Result success(String msg) {
        Result result = new Result(200, msg);
        return result;
    }

    /**
     * 创建一个成功的结果对象，包含指定数据。
     * @param object 成功的数据
     * @return 成功的结果对象
     */
    public static Result success(Object object) {
        Result result = new Result(200, "成功", object);
        return result;
    }

    /**
     * 创建一个成功的结果对象，包含指定消息和数据。
     * @param msg 成功消息
     * @param object 成功的数据
     * @return 成功的结果对象
     */
    public static Result success(String msg, Object object) {
        Result result = new Result(200, msg, object);
        return result;
    }

    /**
     * 创建一个失败的结果对象，没有消息和数据。
     * @return 失败的结果对象
     */
    public static Result error() {
        return error("失败");
    }

    /**
     * 创建一个失败的结果对象，包含指定消息。
     * @param msg 失败消息
     * @return 失败的结果对象
     */
    public static Result error(String msg) {
        Result result = new Result(500, msg);
        return result;
    }

    /**
     * 创建一个失败的结果对象，包含指定数据。
     * @param object 失败的数据
     * @return 失败的结果对象
     */
    public static Result error(Object object) {
        Result result = new Result(500, "失败", object);
        return result;
    }

    /**
     * 创建一个失败的结果对象，包含指定消息和数据。
     * @param msg 失败消息
     * @param object 失败的数据
     * @return 失败的结果对象
     */
    public static Result error(String msg, Object object) {
        Result result = new Result(500, msg, object);
        return result;
    }
}


