package dao_impl;

import entity.HomeworkSubmit;
import entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HomeworkSubmitDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        HomeworkSubmitDAO homeworkSubmitDAO = DAOFactory.getHomeworkSubmitDAOInstance();
        List<Map<String, String>> ret = homeworkSubmitDAO.infoList(new HomeworkSubmit());
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        HomeworkSubmitDAO homeworkSubmitDAO = DAOFactory.getHomeworkSubmitDAOInstance();
        List<Map<String, String>> ret = homeworkSubmitDAO.infoList(new HomeworkSubmit("2",""));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        HomeworkSubmitDAO homeworkSubmitDAO = DAOFactory.getHomeworkSubmitDAOInstance();
        int ret = homeworkSubmitDAO.append(new HomeworkSubmit("2","4","hi","80"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        HomeworkSubmitDAO homeworkSubmitDAO = DAOFactory.getHomeworkSubmitDAOInstance();
       int ret = homeworkSubmitDAO.delete(new HomeworkSubmit("",""));
        assertEquals(2, ret);
    }

    @Test
    public void testModify() {
        HomeworkSubmitDAO homeworkSubmitDAO = DAOFactory.getHomeworkSubmitDAOInstance();
        int ret = homeworkSubmitDAO.modify(new HomeworkSubmit("2","4","hi","23"));
        assertEquals(1, ret);
    }
}