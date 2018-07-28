package dao_impl;

import entity.Talk;
import entity.User;

import java.util.List;
import java.util.Map;

public interface TalkDAO {
    int append(Talk talk);

    int delete(int id);

    int modify(Talk talk);

    List<Map<String, String>> infoList(Talk talk);
}
