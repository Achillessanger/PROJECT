package dao_impl;

import entity.Course;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAOImpl implements CourseDAO{
    @Override
    public int append(Course course){
        Connection con = SqlUtil.createCon();
        if (con != null)
            try {
            String sql = "INSERT INTO `mooc`.`courses` (`title`, `t_uid`, `img`, `content`) VALUES (?, ?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, course.getTitle());
            ppst.setString(2, course.getT_uid());
            ppst.setString(3, course.getImg());
            ppst.setString(4, course.getContent());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    @Override
    public int delete(int id){
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "DELETE FROM courses WHERE id=?";
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
    public int modify(Course course){
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE courses SET title=?, t_uid=?, img=?, content=? WHERE id=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, course.getTitle());
            ppst.setString(2, course.getT_uid());
            ppst.setString(3, course.getImg());
            ppst.setString(4, course.getContent());
            ppst.setString(5,course.getId());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public List<Map<String, String>> infoList(Course course){
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM courses");
            if (StringUtil.isNotEmpty(String.valueOf(course.getId()))) {
                stringBuilder.append(" AND id=\"");
                stringBuilder.append(course.getId());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(course.getTitle())) {
                stringBuilder.append(" AND title=\"");
                stringBuilder.append(course.getTitle());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(course.getT_uid())) {
                stringBuilder.append(" AND t_uid=\"");
                stringBuilder.append(course.getT_uid());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(course.getImg())) {
                stringBuilder.append(" AND img=\"");
                stringBuilder.append(course.getImg());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(course.getContent())) {
                stringBuilder.append(" AND content=\"");
                stringBuilder.append(course.getContent());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("title", rs.getString("title"));
                map.put("t_uid", rs.getString("t_uid"));
                map.put("img", rs.getString("img"));
                map.put("content", rs.getString("content"));
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
