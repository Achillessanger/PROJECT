package dao_impl;

import entity.Homework;
import entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HomeworkDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        List<Map<String, String>> ret =homeworkDAO.infoList(new Homework());
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        List<Map<String, String>> ret =homeworkDAO.infoList(new Homework("1"));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        int ret =homeworkDAO.append(new Homework("","2","2018-02-01","2018-07-01","h","hh"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        int ret =homeworkDAO.delete(1);
        assertEquals(1, ret);
    }

    @Test
    public void testModify() {
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        int ret =homeworkDAO.modify(new Homework("2","2","1007-08-09","8012-08-09","hh","hhh"));
        assertEquals(1, ret);
    }
}
