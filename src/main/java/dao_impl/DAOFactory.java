package dao_impl;

import entity.Homework;
import entity.HomeworkSubmit;
import entity.Resources;
import entity.Talk;

public class DAOFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImpl();
    }
    public static CourseDAO getCourseDAOInstance(){return new CourseDAOImpl() ;}
    public static ChooseCourseDAO getChooseCourseDAOInstance(){return new ChooseCourseDAOImpl();}
    public static CoursePageDAO getCoursePageDAOInstance(){return new CoursePageDAOImpl();}
    public static HomeworkDAO getHomeworkDAOInstance(){return new HomeworkDAOImpl();}
    public static HomeworkSubmitDAO getHomeworkSubmitDAOInstance(){return new HomeworkSubmitDAOImpl();}
    public static ResourcesDAO getResourcesDAOInstance(){return new ResourcesDAOImpl();}
    public static StatisticsDAO getStatisticsDAOInstance(){return new StatisticsDAOImpl();}
    public static TalkDAO getTalkDAOInstance(){return new TalkDAOImpl();}
}

