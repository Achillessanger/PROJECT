package entity;
import util.annotation.Constraints;
import util.annotation.DBTable;
import util.annotation.SQLInteger;
@DBTable("statistics")
public class Statistics {
    @SQLInteger
    private String s_id;
    @SQLInteger
    private String c_id;
    @SQLInteger
    private String cp_id;

    public Statistics(String... s_c_cp){
        switch (s_c_cp.length) {
            case 3:
               cp_id =s_c_cp[2];
            case 2:
                c_id = s_c_cp[1];
            case 1:
                s_id = s_c_cp[0];
            default:
                break;
        }
    }

    public String getC_id() {
        return c_id;
    }

    public String getCp_id() {
        return cp_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public void setCp_id(String cp_id) {
        this.cp_id = cp_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
}
