package fa.training.dao.impl;

import fa.training.dao.ProductDAO;
import fa.training.entities.Product;
import fa.training.utils.ConnectionUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDAOImpl extends ConnectionUtil implements ProductDAO {
    private static final String CHECK_PRODUCT_ID = "SELECT product_id FROM Product WHERE product_id = ?";
    private static final String SELECT_LIST_PRICE_BY_PRODUCT_ID = "SELECT list_price FROM Product WHERE product_id = ?";


    @Override
    public List<Product> getAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<Product> getALlByID(int id) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean checkExits(int id) throws SQLException {
        int checkId;
        rs = executeQuery(CHECK_PRODUCT_ID, id);
        while (rs.next()) {
            checkId = rs.getInt(1);
            if (checkId == id) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean add(Product product) throws SQLException {
        return false;
    }

    @Override
    public double getListPriceById(int id) throws SQLException {
        double price = 0;
        rs = executeQuery(SELECT_LIST_PRICE_BY_PRODUCT_ID, id);
        while(rs.next()){
            price = rs.getDouble("list_price");
        }
        return price;
    }
}
