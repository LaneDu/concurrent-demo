package com.concurrent.demo21enum;

/**
 * @author lane
 * @date 2021年05月30日 上午10:44
 */
public enum Result {

     SUCCESS(200,"成功"),
     ERROR(404,"失败");

    private int code;
    private String message;

 private  Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code(){
     return this.code;
    }
    public String message(){
        return this.message;
    }
/*
    @Override
    public String toString() {
        return "enumDemo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }*/
}
