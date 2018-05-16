package com.kartik.services.interfaces;

import com.kartik.entity.Train;

import java.util.ArrayList;

public interface ITrainService {
    ArrayList<Train> getUserInputs() throws Exception;
    ArrayList<Train> getTrainDetails(Integer userChoice) throws Exception;
    ArrayList<Train> getAdminUserInputs() throws Exception;
}
