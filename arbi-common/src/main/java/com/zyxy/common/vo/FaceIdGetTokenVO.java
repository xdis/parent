package com.zyxy.common.vo;

public class FaceIdGetTokenVO {

    private String request_id;

    private int time_used;

    private String token;

    private int expired_time;

    private String error_message;


    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(int expired_time) {
        this.expired_time = expired_time;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    @Override
    public String toString() {
        return "FaceIdGetTokenVO{" +
                "request_id='" + request_id + '\'' +
                ", time_used=" + time_used +
                ", token='" + token + '\'' +
                ", expired_time=" + expired_time +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}
