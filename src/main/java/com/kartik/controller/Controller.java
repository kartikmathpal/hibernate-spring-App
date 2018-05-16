package com.kartik.controller;

import com.kartik.entity.Train;
import com.kartik.entity.User;
import com.kartik.services.TrainService;
import com.kartik.services.UserService;
import com.kartik.services.interfaces.ITrainService;
import com.kartik.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("AppController")
public  class Controller {

    @Autowired
    UserService userService ;//= new UserService();

    @Autowired
    TrainService trainService ;//= new TrainService();

    private ArrayList<Train> trainReturned;

    public void initializeApp() {
        try {
            User user = userService.getUserDetails();
            System.out.println(user);

            if (user.getAdmin()) {
                trainReturned = trainService.getAdminUserInputs();
                System.out.println (trainReturned);
            } else {
                trainReturned = trainService.getUserInputs();
                System.out.println (trainReturned);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
