package dao_impl;

import entity.Statistics;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsDAOImpl implements StatisticsDAO {
    @Override
    public int append(Statistics statistics) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`statistics` (`s_id`, `c_id`, `cp_id`) VALUES (?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1,statistics.getS_id());
            ppst.setString(2, statistics.getC_id());
            ppst.setString(3, statistics.getCp_id());
            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(Statistics statistics) {
        Connection con=SqlUtil.createCon();
        if (con!=null){
            try {
                StringBuilder stringBuilder = new StringBuilder("DELETE FROM `mooc`.`statistics` ");
                if (StringUtil.isNotEmpty(String.valueOf(statistics.getS_id()))) {
                    stringBuilder.append(" AND s_id=\"");
                    stringBuilder.append(statistics.getS_id());
                    stringBuilder.append("\"");
                }
                if (StringUtil.isNotEmpty(String.valueOf(statistics.getC_id()))) {
                    stringBuilder.append(" AND c_id=\"");
                    stringBuilder.append(statistics.getC_id());
                    stringBuilder.append("\"");
                }
                if (StringUtil.isNotEmpty(String.valueOf(statistics.getCp_id()))) {
                    stringBuilder.append(" AND cp_id=\"");
                    stringBuilder.append(statistics.getCp_id());
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
    public List<Map<String, String>> infoList(Statistics statistics) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM statistics");
            if (StringUtil.isNotEmpty(String.valueOf(statistics.getS_id()))) {
                stringBuilder.append(" AND s_id=\"");
                stringBuilder.append(statistics.getS_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(statistics.getC_id())) {
                stringBuilder.append(" AND c_id=\"");
                stringBuilder.append(statistics.getC_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(statistics.getCp_id())) {
                stringBuilder.append(" AND cp_id=\"");
                stringBuilder.append(statistics.getCp_id());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("s_id", rs.getString("s_id"));
                map.put("c_id", rs.getString("c_id"));
                map.put("cp_id", rs.getString("cp_id"));
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

