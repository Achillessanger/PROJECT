package dao_impl;

import entity.Resources;
import util.SqlUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesDAOImpl implements ResourcesDAO {
    @Override
    public int append(Resources resources) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "INSERT INTO `mooc`.`resources` (`c_id`, `number`, `content`) VALUES (?, ?, ?)";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, resources.getC_id());
            ppst.setString(2, resources.getNumber());
            ppst.setString(3, resources.getContent());
            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(Resources resources) {
        Connection con=SqlUtil.createCon();
        if (con!=null){
            try {
                StringBuilder stringBuilder = new StringBuilder("DELETE FROM `mooc`.`resources` ");
                if (StringUtil.isNotEmpty(String.valueOf(resources.getC_id()))) {
                    stringBuilder.append(" AND c_id=\"");
                    stringBuilder.append(resources.getC_id());
                    stringBuilder.append("\"");
                    if (StringUtil.isNotEmpty(String.valueOf(resources.getNumber()))) {
                        stringBuilder.append(" AND number=\"");
                        stringBuilder.append(resources.getNumber());
                        stringBuilder.append("\"");
                    }
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
    public int modify(Resources resources) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            String sql = "UPDATE resources SET content=?  WHERE c_id=? AND number=?";
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, resources.getContent());
            ppst.setString(2, resources.getC_id());
            ppst.setString(3, resources.getNumber());

            int ret = ppst.executeUpdate();
            SqlUtil.closeCon(con);

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Map<String, String>> infoList(Resources resources) {
        Connection con = SqlUtil.createCon();
        if (con != null) try {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM resources");
            if (StringUtil.isNotEmpty(String.valueOf(resources.getC_id()))) {
                stringBuilder.append(" AND c_id=\"");
                stringBuilder.append(resources.getC_id());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(resources.getNumber())) {
                stringBuilder.append(" AND number=\"");
                stringBuilder.append(resources.getNumber());
                stringBuilder.append("\"");
            }
            if (StringUtil.isNotEmpty(resources.getContent())) {
                stringBuilder.append(" AND content=\"");
                stringBuilder.append(resources.getContent());
                stringBuilder.append("\"");
            }
            PreparedStatement pstm = con.prepareStatement(stringBuilder.toString().replaceFirst("AND", "WHERE"));

            ResultSet rs = pstm.executeQuery();

            List<Map<String, String>> ret = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("c_id", rs.getString("c_id"));
                map.put("number", rs.getString("number"));
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
