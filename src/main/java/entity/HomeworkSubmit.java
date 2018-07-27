package entity;

import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;

@DBTable("homework_submit")
public class HomeworkSubmit {
    @SQLInteger
    private String hw_id;
    @SQLInteger
    private String s_id;
    @SQLString
    private String content;
    @SQLString
    private String score;
    public HomeworkSubmit(String... hw_s_content_score){
        switch (hw_s_content_score.length) {
            case 4:
                score=hw_s_content_score[3];
            case 3:
                content=hw_s_content_score[2];
            case 2:
                s_id=hw_s_content_score[1];
            case 1:
                hw_id=hw_s_content_score[0];
                default:
                    break;
        }
        }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_id() {
        return s_id;
    }

    public String getHw_id() {
        return hw_id;
    }

    public String getScore() {
        return score;
    }

    public void setHw_id(String hw_id) {
        this.hw_id = hw_id;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
