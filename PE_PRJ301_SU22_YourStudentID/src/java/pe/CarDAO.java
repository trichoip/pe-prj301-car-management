/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author hd
 */
public class CarDAO {

//   your code here
    // nhớ đổi tên table và colunm name sau WHERE 
    private static final String SEARCH = "SELECT * FROM tblCars WHERE name like ?";
    private static final String DELETE = "UPDATE tblCars SET status = ? WHERE id = ?";
    private static final String UPDATE = "UPDATE tblCars SET name = ?, description = ?, price = ?, speed = ? WHERE id = ?";
    private static final String CHECK_DUPLICATE = "SELECT id FROM tblCars WHERE id = ?";
    private static final String INSERT = "INSERT INTO tblCars(id, name, description, price, speed, status) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String REMOVE = "DELETE tblCars WHERE id=?";

    public List<CarDTO> getListCar(String search) throws SQLException {
        List<CarDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    // nhớ lấy tên đúng theo colunm trong database
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int speed = rs.getInt("speed");
                    boolean status = rs.getBoolean("status");
                    list.add(new CarDTO(id, name, description, price, speed, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String carID) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                // set gia tri theo thứ tư dấu ?
                ptm.setBoolean(1, false);
                ptm.setString(2, carID);

                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean update(CarDTO car) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                // set gia tri theo thứ tư dấu ?
                ptm.setString(1, car.getName());
                ptm.setString(2, car.getDescription());
                ptm.setDouble(3, car.getPrice());
                ptm.setInt(4, car.getSpeed());
                ptm.setString(5, car.getId());

                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }

    public boolean checkDuplicate(String carID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, carID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean insert(CarDTO car) throws SQLException {
        boolean checkInsert = false;
        Connection con = null;
        PreparedStatement ptm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(INSERT);
                // set gia tri theo thứ tư dấu ?
                ptm.setString(1, car.getId());
                ptm.setString(2, car.getName());
                ptm.setString(3, car.getDescription());
                ptm.setDouble(4, car.getPrice());
                ptm.setInt(5, car.getSpeed());
                ptm.setBoolean(6, true);
                checkInsert = ptm.executeUpdate() > 0 ? true : false;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return checkInsert;
    }

    public boolean remove(String carID) throws SQLException {
        boolean checkRemove = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(REMOVE);
                ptm.setString(1, carID);
                checkRemove = ptm.executeUpdate() > 0 ? true : false;
            } else {
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return checkRemove;
    }
}
