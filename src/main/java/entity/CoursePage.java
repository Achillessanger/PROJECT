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
    @SQLString
    private String link;

    public CoursePage(String... id_c_number_title_link) {
        switch (id_c_number_title_link.length) {
            case 5:
                link=id_c_number_title_link[4];
            case 4:
                title=id_c_number_title_link[3];
            case 3:
                number=id_c_number_title_link[2];
            case 2:
                c_id=id_c_number_title_link[1];
            case 1:
                id=id_c_number_title_link[0];
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}