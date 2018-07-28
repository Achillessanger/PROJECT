package dao_impl;

import entity.ChooseCourse;

import java.util.List;
import java.util.Map;

public interface ChooseCourseDAO {
    int append(ChooseCourse chooseCourse);

    int delete(ChooseCourse chooseCourse);

    List<Map<String, String>> infoList(ChooseCourse chooseCourse);
}
