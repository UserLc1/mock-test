package com.example.request;

/**
 * @Author: Lc
 * @Date: 2022-02-28
 * @apiNote
 */
public interface QueueRequest {

    boolean execute();

    void taskOver();
}
