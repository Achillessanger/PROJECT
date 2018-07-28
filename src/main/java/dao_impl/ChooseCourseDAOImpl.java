package dao_impl;

import entity.ChooseCourse;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseCourseDAOImpl implements ChooseCourseDAO{
    @Override
    public int append(ChooseCourse chooseCourse){
        Connection con = SqlUtil.createCon();
        if (con != null)
            try {
                String sql = "INSERT INTO `mooc`.`choose_course` (`c_id`, `s_id`) VALUES (?, ?)";
                PreparedStatement ppst = con.prepareStatement(sql);
                ppst.setString(1, chooseCourse.getC_id());
                ppst.setString(2, chooseCourse.getS_id());

                int ret = ppst.executeUpdate();
                SqlUtil.closeCon(con);

                return ret;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return -1;
    }
    @Override
    public int delete(ChooseCourse chooseCourse){
        Connection con=SqlUtil.createCon();
        if (con!=null){
            try {
                StringBuilder stringBuilder = new StringBuilder("DELETE FROM `mooc`.`choose_course` ");
                if (StringUtil.isNotEmpty(String.valueOf(chooseCourse.getC_id()))) {
                    stringBuilder.append(" AND c_id=\"");
                    stringBuilder.append(chooseCourse.getC_id());
                    stringBuilder.append("\"");
                }
                if (StringUtil.isNotEmpty(String.valueOf(chooseCourse.getS_id()))) {
                    stringBuilder.append(" AND s_id=\"");
                    stringBuilder.append(chooseCourse.getS_id());
                    stringBuilder.append("\"");
                }
                PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));
                int ret = pstm.executeUpdate();
                SqlUtil.closeCon(con);

                return ret;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            }
            return -1;
    }

    @Override
    public List<Map<String, String>> infoList(ChooseCourse chooseCourse) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM choose_course");
            if (StringUtil.isNotEmpty(String.valueOf(chooseCourse.getC_id()))) {
                stringBuilder.append(" AND c_id=\"");
                stringBuilder.append(chooseCourse.getC_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(String.valueOf(chooseCourse.getS_id()))) {
                stringBuilder.append(" AND s_id=\"");
                stringBuilder.append(chooseCourse.getS_id());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("c_id", rs.getString("c_id"));
                map.put("s_id", rs.getString("s_id"));
                ret.add(map);
            }
            SqlUtil.closeCon(con);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }

