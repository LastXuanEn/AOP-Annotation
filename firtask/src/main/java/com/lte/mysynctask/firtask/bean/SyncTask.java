package com.lte.mysynctask.firtask.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: laite
 * @Date: 2021/12/7 - 12 - 07 - 21:44
 * @Description: com.lte.mysynctask.firtask.bean
 * @version: 1.0
 */
@Component
@Lazy
@Scope
public class SyncTask {
    public void init(){
        System.out.println("nih");
    }
    public SyncTask(){
        System.out.println("Ni");
    }
}
