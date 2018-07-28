package dao_impl;

import entity.HomeworkSubmit;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkSubmitDAOImpl implements HomeworkSubmitDAO {
    @Override
    public int append(HomeworkSubmit homeworkSubmit) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`homework_submit` (`hw_id`, `s_id`, `content`, `score`) VALUES (?, ?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, homeworkSubmit.getHw_id());
            ppst.setString(2, homeworkSubmit.getS_id());
            ppst.setString(3, homeworkSubmit.getContent());
            ppst.setString(4, homeworkSubmit.getScore());
            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(HomeworkSubmit homeworkSubmit) {
        Connection con=SqlUtil.createCon();
        if (con!=null){
            try {
                StringBuilder stringBuilder = new StringBuilder("DELETE FROM `mooc`.`homework_submit` ");
                if (StringUtil.isNotEmpty(String.valueOf(homeworkSubmit.getHw_id()))) {
                    stringBuilder.append(" AND hw_id=\"");
                    stringBuilder.append(homeworkSubmit.getHw_id());
                    stringBuilder.append("\"");
                }
                if (StringUtil.isNotEmpty(String.valueOf(homeworkSubmit.getS_id()))) {
                    stringBuilder.append(" AND s_id=\"");
                    stringBuilder.append(homeworkSubmit.getS_id());
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
    public int modify(HomeworkSubmit homeworkSubmit) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE homework_submit SET content=?,score=?  WHERE hw_id=? AND s_id=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, homeworkSubmit.getContent());
            ppst.setString(2, homeworkSubmit.getScore());
            ppst.setString(3, homeworkSubmit.getHw_id());
            ppst.setString(4, homeworkSubmit.getS_id());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Map<String, String>> infoList(HomeworkSubmit homeworkSubmit) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM homework_submit");
            if (StringUtil.isNotEmpty(String.valueOf(homeworkSubmit.getHw_id()))) {
                stringBuilder.append(" AND hw_id=\"");
                stringBuilder.append(homeworkSubmit.getHw_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homeworkSubmit.getS_id())) {
                stringBuilder.append(" AND s_id=\"");
                stringBuilder.append(homeworkSubmit.getS_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homeworkSubmit.getContent())) {
                stringBuilder.append(" AND content=\"");
                stringBuilder.append(homeworkSubmit.getContent());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(homeworkSubmit.getScore())) {
                stringBuilder.append(" AND score=\"");
                stringBuilder.append(homeworkSubmit.getScore());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("hw_id", rs.getString("hw_id"));
                map.put("s_id", rs.getString("s_id"));
                map.put("content", rs.getString("content"));
                map.put("score", rs.getString("score"));
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
