package com.kartik.services;

import com.kartik.dao.TrainDao;
import com.kartik.dao.interfaces.ITrainDao;
import com.kartik.entity.Train;
import com.kartik.services.interfaces.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;
@Service("TrainService")
public class TrainService implements ITrainService {
    private static Scanner scanner = new Scanner(System.in);
    private Integer userChoice;
    private String trainName;
    private String sourceStation;
    private String destinationStation;
    private ArrayList<Train> matchedRecords = new ArrayList<Train>(); //Empty List


    @Autowired
    //TrainDao trainDao = new TrainDao();
    ITrainDao trainDao;

    /* --------------------------------------------------------------------------------- */
    //@Override
    public ArrayList<Train> getTrainDetails(Integer userChoice) throws Exception {


        switch (userChoice) {
            case 1:
                ArrayList<Train> returnedTrainList = new ArrayList<Train>();
                System.out.println("Enter Train name: ");
                scanner.nextLine();                                     //<--------------
                trainName = scanner.nextLine();
                System.out.println(trainDao.searchTrain(trainName));
                //add train object in the array list
                try {
                    returnedTrainList.add(trainDao.searchTrain(trainName));
                    return returnedTrainList;
                } catch (Exception e) {
                    throw new Exception(e);
                }

            case 2:
                System.out.print("\nEnter Source Station Name :");
                scanner.nextLine();
                sourceStation = scanner.nextLine();
                System.out.print("\nEnter Destination Station Name : ");
                destinationStation = scanner.nextLine();
                try {

                    return trainDao.searchTrainByStation(sourceStation, destinationStation);
                } catch (Exception e) {
                    throw new Exception(e);
                }

            default:
                break;

        }
        return null;
    }

    public ArrayList<Train> getTrainDetailsAdmin(Integer userChoice) throws Exception {


        switch (userChoice) {
            case 1:
                ArrayList<Train> returnedTrainList = new ArrayList<Train>();
                System.out.println("Enter Train name: ");
                scanner.nextLine();                                     //<--------------
                trainName = scanner.nextLine();
                System.out.println(trainDao.searchTrain(trainName));
                //add train object in the array list
                try {
                    returnedTrainList.add(trainDao.searchTrain(trainName));
                    return returnedTrainList;
                } catch (Exception e) {
                    throw new Exception(e);
                }

            case 2:
                System.out.print("\nEnter Source Station Name :");
                scanner.nextLine();
                sourceStation = scanner.nextLine();
                System.out.print("\nEnter Destination Station Name : ");
                destinationStation = scanner.nextLine();
                try {

                    return trainDao.searchTrainByStation(sourceStation, destinationStation);
                } catch (Exception e) {
                    throw new Exception(e);
                }
            case 3:
                System.out.println ("Add a train ");
                System.out.println ("Enter train name");
                scanner.nextLine ();
                trainName = scanner.nextLine ();
                System.out.println ("Enter source station");
                sourceStation = scanner.nextLine ();
                System.out.println ("Enter destination station");
                destinationStation = scanner.nextLine ();
                trainDao.addTrain(new Train(trainName,sourceStation,destinationStation));
                break;
            case 4:
                System.out.println ("Delete train ");
                break;
            case 5:
                break;
            default:
                break;

        }
        return null;
    }
    /* ----------------------------------------------------------------------------------- */
    //@Override
    public ArrayList<Train> getUserInputs() throws Exception {
        System.out.println("1.Search Train By Name");
        System.out.println("2.Search By Station");
        System.out.println("*****Enter option*****");
        userChoice = scanner.nextInt();
        matchedRecords = getTrainDetails(userChoice);
        if (matchedRecords != null) {
            System.out.println(matchedRecords);
            return matchedRecords;
        } else {
            throw new Exception("No data present in DB!!");
        }

    }

    /* -------------------------------ADMIN-------------------------------------------------- */
    public ArrayList<Train> getAdminUserInputs() throws Exception {
        System.out.println("1.Search Train By Name");
        System.out.println("2.Search By Station");
        System.out.println("3.Add Train");
        System.out.println("4.Delete train");
        System.out.println("5.Show trains");
        System.out.println("*****Enter option*****");
        userChoice = scanner.nextInt();
        matchedRecords = getTrainDetailsAdmin(userChoice);
        //System.out.println (matchedRecords);
        if (matchedRecords != null) {
            //System.out.println(matchedRecords);
            return matchedRecords;
        } else {
            throw new Exception("No data present in DB!!");
        }
    }
}
