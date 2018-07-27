package entity;

import util.annotation.DBTable;
import util.annotation.SQLInteger;
import util.annotation.SQLString;
@DBTable("resources")
public class Resources {
    @SQLInteger
    private String c_id;
    @SQLString
    private String number;
    @SQLString
    private String content;
    public Resources(String... c_number_content) {
        switch (c_number_content.length) {
            case 3:
                content=c_number_content[2];
            case 2:
                number=c_number_content[1];
            case 1:
                number=c_number_content[0];
                default:
                    break;
        }
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
