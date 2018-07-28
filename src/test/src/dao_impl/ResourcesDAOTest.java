package dao_impl;

import entity.Resources;
import entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ResourcesDAOTest {

    @Test
    public void testInfoQueryZeroSet() {
        ResourcesDAO resourcesDAO = DAOFactory.getResourcesDAOInstance();
        List<Map<String, String>> ret = resourcesDAO.infoList(new Resources());
        assertEquals(0, ret.size());
    }

    @Test
    public void testInfoQuerySomethingSet() {
        ResourcesDAO resourcesDAO = DAOFactory.getResourcesDAOInstance();
        List<Map<String, String>> ret = resourcesDAO.infoList(new Resources("2","nu",""));
        assertEquals(1, ret.size());
    }

    @Test
    public void testAppend() {
        ResourcesDAO resourcesDAO = DAOFactory.getResourcesDAOInstance();
        int ret = resourcesDAO.append(new Resources("2","nu","er"));
        assertEquals(1, ret);
    }

    @Test
    public void testDelete() {
        ResourcesDAO resourcesDAO = DAOFactory.getResourcesDAOInstance();
        int ret = resourcesDAO.delete(new Resources("2","nu",""));
        assertEquals(1, ret);
    }

    @Test
    public void testModify() {
        ResourcesDAO resourcesDAO = DAOFactory.getResourcesDAOInstance();
        int ret = resourcesDAO.modify(new Resources("2","nu","ers"));
        assertEquals(2, ret);
    }
}
