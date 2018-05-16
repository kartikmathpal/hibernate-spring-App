package com.kartik.dao.interfaces;

import com.kartik.entity.Train;

import java.util.ArrayList;

public interface ITrainDao {
    Train searchTrain(String trainName) throws Exception;
    ArrayList<Train> searchTrainByStation(String sourceStation, String destinationStation)throws Exception;
    void addTrain(Train train) throws Exception;
}
