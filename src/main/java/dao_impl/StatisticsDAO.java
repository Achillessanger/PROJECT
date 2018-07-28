package dao_impl;

import entity.Statistics;
import entity.User;

import java.util.List;
import java.util.Map;

public interface StatisticsDAO {
    int append(Statistics statistics);

    int delete(Statistics statistics);


    List<Map<String, String>> infoList(Statistics statistics);
}
