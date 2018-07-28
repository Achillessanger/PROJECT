package dao_impl;

import entity.ChooseCourse;
import entity.Course;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChooseCourseDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        ChooseCourseDAO chooseCourseDAO = DAOFactory.getChooseCourseDAOInstance();
        List<Map<String, String>> ret = chooseCourseDAO.infoList(new ChooseCourse("3"));
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        ChooseCourseDAO chooseCourseDAO = DAOFactory.getChooseCourseDAOInstance();
        List<Map<String, String>> ret = chooseCourseDAO.infoList(new ChooseCourse("2","3"));
        assertEquals(0, ret.size());
    }

    @Test
    public void testAppend() {
        ChooseCourseDAO chooseCourseDAO = DAOFactory.getChooseCourseDAOInstance();
        int ret = chooseCourseDAO.append(new ChooseCourse("2","4"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        ChooseCourseDAO chooseCourseDAO = DAOFactory.getChooseCourseDAOInstance();
        int ret = chooseCourseDAO.delete(new ChooseCourse("2","4"));
        assertEquals(1, ret);
    }


}