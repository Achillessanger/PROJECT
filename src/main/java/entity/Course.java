package entity;

import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;

@DBTable("courses")
public class Course {
    @SQLInteger(constraint = @Constraints(primaryKey = true, unique = true))
    private String id;
    @SQLString
    private String title;
    @SQLInteger
    private String t_uid;
    @SQLString
    private String img;
    @SQLString
    private String content;

    public Course(String... id_title_t_img_content){
        switch (id_title_t_img_content.length) {
            case 5:
                content=id_title_t_img_content[4];
            case 4:
                img=id_title_t_img_content[3];
            case 3:
                t_uid=id_title_t_img_content[2];
            case 2:
                title=id_title_t_img_content[1];
            case 1:
                id=id_title_t_img_content[0];
            default:
                break;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getT_uid() {
        return t_uid;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setT_uid(String t_uid) {
        this.t_uid = t_uid;
    }
}
