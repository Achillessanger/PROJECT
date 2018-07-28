package dao_impl;

import entity.Homework;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkDAOImpl implements HomeworkDAO {
    @Override
    public int append(Homework homework) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`homework` (`c_id`, `beg_time`, `end_time`, `title`, `content`) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, homework.getC_id());
            ppst.setString(2, homework.getBeg_time());
            ppst.setString(3, homework.getEnd_time());
            ppst.setString(4, homework.getTitle());
            ppst.setString(5, homework.getContent());
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
            String sql = "DELETE FROM homework WHERE id=?";
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
    public int modify(Homework homework) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE homework SET c_id=?, beg_time=?, end_time=?,title=?,content=?  WHERE id=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, homework.getC_id());
            ppst.setString(2, homework.getBeg_time());
            ppst.setString(3, homework.getEnd_time());
            ppst.setString(4, homework.getTitle());
            ppst.setString(5, homework.getContent());
            ppst.setString(6,homework.getId());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Map<String, String>> infoList(Homework homework) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM homework");
            if (StringUtil.isNotEmpty(String.valueOf(homework.getId()))) {
                stringBuilder.append(" AND id=\"");
                stringBuilder.append(homework.getId());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homework.getC_id())) {
                stringBuilder.append(" AND c_id=\"");
                stringBuilder.append(homework.getC_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homework.getBeg_time())) {
                stringBuilder.append(" AND beg_time=\"");
                stringBuilder.append(homework.getBeg_time());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homework.getEnd_time())) {
                stringBuilder.append(" AND end_time=\"");
                stringBuilder.append(homework.getEnd_time());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homework.getTitle())) {
                stringBuilder.append(" AND title=\"");
                stringBuilder.append(homework.getTitle());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homework.getContent())) {
                stringBuilder.append(" AND content=\"");
                stringBuilder.append(homework.getContent());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("c_id", rs.getString("c_id"));
                map.put("beg_time", rs.getString("beg_time"));
                map.put("end_time", rs.getString("end_time"));
                map.put("title", rs.getString("title"));
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
