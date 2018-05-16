package com.kartik;

import com.kartik.configuration.ApplicationContextBean;
import com.kartik.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppLauncher {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext (ApplicationContextBean.class);
        Controller controller = (Controller) applicationContext.getBean("AppController");//returns Obj
        controller.initializeApp ();
    }
}
