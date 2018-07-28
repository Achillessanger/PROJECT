package dao_impl;

import entity.Statistics;
import entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StatisticsDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        StatisticsDAO statisticsDAO = DAOFactory.getStatisticsDAOInstance();
        List<Map<String, String>> ret = statisticsDAO.infoList(new Statistics());
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        StatisticsDAO statisticsDAO = DAOFactory.getStatisticsDAOInstance();
        List<Map<String, String>> ret = statisticsDAO.infoList(new Statistics("4","",""));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        StatisticsDAO statisticsDAO = DAOFactory.getStatisticsDAOInstance();
        int ret = statisticsDAO.append(new Statistics("4","2","2"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        StatisticsDAO statisticsDAO = DAOFactory.getStatisticsDAOInstance();
        int ret = statisticsDAO.delete(new Statistics("4","",""));
        assertEquals(1, ret);
    }


}
