package dao_impl;

import entity.Talk;
import entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TalkDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        TalkDAO talkDAO = DAOFactory.getTalkDAOInstance();
        List<Map<String, String>> ret = talkDAO.infoList(new Talk());
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        TalkDAO talkDAO = DAOFactory.getTalkDAOInstance();
        List<Map<String, String>> ret = talkDAO.infoList(new Talk("","4","",""));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        TalkDAO talkDAO = DAOFactory.getTalkDAOInstance();
        int ret = talkDAO.append(new Talk("","4","hi","2017-02-17"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        TalkDAO talkDAO = DAOFactory.getTalkDAOInstance();
        int ret = talkDAO.delete(1);
        assertEquals(1, ret);
    }

    @Test
    public void testModify() {
        TalkDAO talkDAO = DAOFactory.getTalkDAOInstance();
        int ret = talkDAO.modify(new Talk("2","4","hi","2017-03-17"));
         assertEquals(1, ret);
    }
}
