package entity;

import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;

@DBTable("talk")
public class Talk {
    @SQLInteger(constraint = @Constraints(primaryKey = true, unique = true))
    private String id;
    @SQLInteger
    private String uid;
    @SQLString
    private String content;
    @SQLString
    private String time;
    public Talk(String... id_uid_content_time) {
        switch (id_uid_content_time.length) {
            case 4:
                time=id_uid_content_time[3];
            case 3:
                content=id_uid_content_time[2];
            case 2:
                uid=id_uid_content_time[1];
            case 1:
                id=id_uid_content_time[0];
            default:
                break;
        }
    }
    public String getId(){
        return id;
    }
    public String getUid(){
        return uid;
    }
    public String getContent(){
        return content;
    }
    public String getTime(){
        return time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
