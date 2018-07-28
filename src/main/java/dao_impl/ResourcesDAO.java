package dao_impl;

import entity.Resources;
import entity.User;

import java.util.List;
import java.util.Map;

public interface ResourcesDAO {
    int append(Resources resources);

    int delete(Resources resources);

    int modify(Resources resources);

    List<Map<String, String>> infoList(Resources resources);
}
