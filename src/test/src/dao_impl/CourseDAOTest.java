package dao_impl;

import entity.Course;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CourseDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        List<Map<String, String>> ret = courseDAO.infoList(new Course("3"));
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        List<Map<String, String>> ret = courseDAO.infoList(new Course("2","web","5","",""));
        assertEquals(0, ret.size());
    }

    @Test
    public void testAppend() {
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        int ret = courseDAO.append(new Course("","web","4","hhhh","hhhhhh"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        int ret = courseDAO.delete(1);
        assertEquals(1, ret);
    }

    @Test
    public void testModify() {
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        int ret = courseDAO.modify(new Course("2","web","4","x","xi"));
        assertEquals(1, ret);
    }
}