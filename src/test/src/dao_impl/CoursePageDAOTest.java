package dao_impl;

import entity.CoursePage;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoursePageDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        CoursePageDAO coursePageDAO = DAOFactory.getCoursePageDAOInstance();
        List<Map<String, String>> ret = coursePageDAO.infoList(new CoursePage("1"));
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        CoursePageDAO coursePageDAO = DAOFactory.getCoursePageDAOInstance();
        List<Map<String, String>> ret = coursePageDAO.infoList(new CoursePage("1"));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        CoursePageDAO coursePageDAO = DAOFactory.getCoursePageDAOInstance();
        int ret = coursePageDAO.append(new CoursePage("","2","3-0","h","hh"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        CoursePageDAO coursePageDAO = DAOFactory.getCoursePageDAOInstance();
        int ret = coursePageDAO.delete(1);
        assertEquals(1, ret);
    }

    @Test
    public void testModify() {
        CoursePageDAO coursePageDAO = DAOFactory.getCoursePageDAOInstance();
        int ret = coursePageDAO.modify(new CoursePage("2","2","nu","nu","nu"));
        assertEquals(1, ret);
    }
}
