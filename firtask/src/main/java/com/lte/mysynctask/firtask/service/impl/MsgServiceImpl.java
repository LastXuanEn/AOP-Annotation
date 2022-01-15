package com.lte.mysynctask.firtask.service.impl;

import com.lte.mysynctask.firtask.aop.ParamAuthAnnotation;
import com.lte.mysynctask.firtask.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: laite
 * @Date: 2022/1/15 - 01 - 15 - 21:46
 * @Description: com.lte.mysynctask.firtask.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
public class MsgServiceImpl implements MsgService {
    @ParamAuthAnnotation(value = "out")
    @Override
    public void sendMsg(String msg) {
        log.info("发送信息:{}",msg);
    }
    @ParamAuthAnnotation(value = "inner")
    @Override
    public void getMsg() {
        System.out.println("收到信息：你好");
    }
}
