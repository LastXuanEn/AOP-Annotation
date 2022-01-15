package com.lte.mysynctask.firtask;

import com.lte.mysynctask.firtask.service.MsgService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirtaskApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FirtaskApplication.class, args);
        // SyncTask bean = context.getBean(SyncTask.class);
        // bean.init();

        MsgService bean = context.getBean(MsgService.class);
        bean.sendMsg("21");
        bean.getMsg();
    }
}
