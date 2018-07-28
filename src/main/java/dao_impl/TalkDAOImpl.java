package dao_impl;

import entity.Talk;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalkDAOImpl implements TalkDAO {
    @Override
    public int append(Talk talk) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`talk` ( `uid`, `content`, `time`) VALUES (?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, talk.getUid());
            ppst.setString(2, talk.getContent());
            ppst.setString(3, talk.getTime());

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
            String sql = "DELETE FROM talk WHERE id=?";
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
    public int modify(Talk talk) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE talk SET uid=?, content=?, time=? WHERE id=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, talk.getUid());
            ppst.setString(2, talk.getContent());
            ppst.setString(3, talk.getTime());
            ppst.setString(4, talk.getId());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Map<String, String>> infoList(Talk talk) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM talk");
            if (StringUtil.isNotEmpty(String.valueOf(talk.getUid()))) {
                stringBuilder.append(" AND uid=\"");
                stringBuilder.append(talk.getUid());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(talk.getId())) {
                stringBuilder.append(" AND id=\"");
                stringBuilder.append(talk.getId());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(talk.getContent())) {
                stringBuilder.append(" AND content=\"");
                stringBuilder.append(talk.getContent());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(talk.getTime())) {
                stringBuilder.append(" AND time=\"");
                stringBuilder.append(talk.getTime());
                stringBuilder.append("\"");
            }

            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("uid", rs.getString("uid"));
                map.put("id", rs.getString("id"));
                map.put("content", rs.getString("content"));
                map.put("time", rs.getString("time"));
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

