package dao_impl;

import entity.HomeworkSubmit;
import entity.User;

import java.util.List;
import java.util.Map;

public interface HomeworkSubmitDAO {
    int append(HomeworkSubmit homeworkSubmit);

    int delete(HomeworkSubmit homeworkSubmit);

    int modify(HomeworkSubmit homeworkSubmit);

    List<Map<String, String>> infoList(HomeworkSubmit homeworkSubmit);
}
