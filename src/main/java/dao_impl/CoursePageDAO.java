package dao_impl;

import entity.CoursePage;
import entity.User;

import java.util.List;
import java.util.Map;

public interface CoursePageDAO {
    int append(CoursePage coursePage);

    int delete(int id);

    int modify(CoursePage coursePage);

    List<Map<String, String>> infoList(CoursePage coursePage);
}
