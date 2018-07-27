package entity;

import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;

public class ChooseCourse {
    @SQLInteger
    private String c_id;
    @SQLInteger
    private String s_id;

    public ChooseCourse(String... c_s){
        switch (c_s.length){
            case 2:
                s_id=c_s[1];
            case 1:
                c_id=c_s[0];

                default:
                    break;
        }
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
}
