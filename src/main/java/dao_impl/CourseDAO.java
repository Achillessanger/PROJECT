package dao_impl;

import entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseDAO {
    int append(Course course);

    int delete(int id);

    int modify(Course course);

    List<Map<String, String>> infoList(Course course);
}
