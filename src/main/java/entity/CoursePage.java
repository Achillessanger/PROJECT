package entity;

import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;

@DBTable("course_pages")
public class CoursePage {
    @SQLInteger(constraint = @Constraints(primaryKey = true, unique = true))
    private String id;
    @SQLInteger
    private String c_id;
    @SQLString
    private String number;
    @SQLString
    private String title;

    public CoursePage(String... id_c_number_title) {
        switch (id_c_number_title.length) {
            case 4:
                title=id_c_number_title[3];
            case 3:
                number=id_c_number_title[2];
            case 2:
                c_id=id_c_number_title[1];
            case 1:
                id=id_c_number_title[0];
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_id() {
        return c_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}