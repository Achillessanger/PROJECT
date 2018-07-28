package dao_impl;

import entity.CoursePage;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursePageDAOImpl implements CoursePageDAO{
    @Override
    public int append(CoursePage coursePage) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`course_pages` (`c_id`, `number`, `title`,`link`) VALUES (?, ?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, coursePage.getC_id());
            ppst.setString(2, coursePage.getNumber());
            ppst.setString(3, coursePage.getTitle());
            ppst.setString(4,coursePage.getLink());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "DELETE FROM course_pages WHERE id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, String.valueOf(id));

            int ret = pstm.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int modify(CoursePage coursePage) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE course_pages SET c_id=?, number=?, title=? ,link=?  WHERE id=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, coursePage.getC_id());
            ppst.setString(2, coursePage.getNumber());
            ppst.setString(3, coursePage.getTitle());
            ppst.setString(4, coursePage.getLink());
            ppst.setString(5, coursePage.getId());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Map<String, String>> infoList(CoursePage coursePage) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM course_pages");
            if (StringUtil.isNotEmpty(String.valueOf(coursePage.getId()))) {
                stringBuilder.append(" AND id=\"");
                stringBuilder.append(coursePage.getId());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(coursePage.getC_id())) {
                stringBuilder.append(" AND c_id=\"");
                stringBuilder.append(coursePage.getC_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(coursePage.getNumber())) {
                stringBuilder.append(" AND number=\"");
                stringBuilder.append(coursePage.getNumber());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(coursePage.getTitle())) {
                stringBuilder.append(" AND email=\"");
                stringBuilder.append(coursePage.getTitle());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(coursePage.getLink())) {
                stringBuilder.append(" AND link=\"");
                stringBuilder.append(coursePage.getLink());
                stringBuilder.append("\"");
            }

            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("c_id", rs.getString("c_id"));
                map.put("number", rs.getString("number"));
                map.put("title", rs.getString("title"));
                map.put("link",rs.getString("link"));
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
