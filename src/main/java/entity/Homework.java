package entity;
import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;
@DBTable("homework")
public class Homework {
    @SQLInteger(constraint = @Constraints(primaryKey = true, unique = true))
    private String id;
    @SQLInteger
    private String c_id;
    @SQLString
    private String beg_time;
    @SQLString
    private String end_time;
    @SQLString
    private String title;
    @SQLString
    private String content;

    public Homework(String... id_c_beg_end_title_content){
        switch (id_c_beg_end_title_content.length) {
            case 6:
                content =id_c_beg_end_title_content[5];
            case 5:
                title=id_c_beg_end_title_content[4];
            case 4:
                end_time=id_c_beg_end_title_content[3];
            case 3:
                beg_time=id_c_beg_end_title_content[2];
            case 2:
                c_id=id_c_beg_end_title_content[1];
            case 1:
                id=id_c_beg_end_title_content[0];
            default:
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getC_id() {
        return c_id;
    }

    public String getBeg_time() {
        return beg_time;
    }

    public String getContent() {
        return content;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBeg_time(String beg_time) {
        this.beg_time = beg_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
