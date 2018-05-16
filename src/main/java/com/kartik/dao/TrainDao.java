package com.kartik.dao;

import com.kartik.dao.interfaces.ITrainDao;
import com.kartik.entity.Train;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static java.sql.JDBCType.NULL;


@Transactional
@Repository("TrainDao") //@annotation("id")
public class TrainDao implements ITrainDao {

    @Autowired
    private SessionFactory sessionFactory;

    private ArrayList <Train> matchedList = new ArrayList <Train> (); //Empty List

    private static ArrayList <Train> trains;

    static {
        trains = new ArrayList <Train> ();
    }


    public Train searchTrain(String trainName) throws Exception {


        Train foundTrain = (Train) sessionFactory
                .getCurrentSession ()
                .createQuery ("from Train where trainName=:trainName")
                .setParameter ("trainName", trainName)
                .uniqueResult ();

        if (foundTrain == null) {
            throw new Exception ("No such train exists in DB!!!");
        } else {
            return foundTrain;
        }

    }


    public ArrayList <Train> searchTrainByStation(String sourceStation, String destinationStation) throws Exception {
        matchedList = (ArrayList <Train>) sessionFactory
                .getCurrentSession ()
                .createQuery ("from Train where sourceStation=:source and destinationStation=:destination")
                .setParameter ("source", sourceStation)
                .setParameter ("destination", destinationStation)
                .list ();

        if (matchedList == null) {
            throw new Exception ("No entries found in DB\n");
        } else {
            return matchedList;
        }

    }

    //Add return list of trains
    public void addTrain(Train train){
      /* int x =  sessionFactory
                .getCurrentSession ()
                .createSQLQuery ("INSERT INTO train(train_name,source_station,destination_station)" +
                        "VALUES(:name,:src,:dest)")
//                .setParameter ("id", NULL)
                .setParameter ("name", train.getTrainName ())
                .setParameter ("src", train.getSourceStation ())
                .setParameter ("dest", train.getDestinationStation ())
                .executeUpdate();*/
      train = (Train)sessionFactory.getCurrentSession().merge (train);
        System.out.println (train + " added");
//       System.out.println (x + "Row added");

    }
    /*Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +
            "select stock_code, stock_name from backup_stock");
    int result = query.executeUpdate();*/

    //delete return list of trains
/*
Query query = session.createQuery("delete Stock where stockCode = :stockCode");
query.setParameter("stockCode", "7277");
int result = query.executeUpdate();
 */

}
