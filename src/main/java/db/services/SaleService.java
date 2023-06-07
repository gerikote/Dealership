package db.services;

import db.dao.SaleDAO;
import db.model.Sale;

import java.util.List;

public class SaleService {
    private SaleDAO saleDAO;

    public SaleService() {
        saleDAO = new SaleDAO();
    }

    public List<Sale> getAllSales() {
        return saleDAO.getAll();
    }

    public Sale getSaleByID(int id) {
        return saleDAO.getByID(id);
    }

    public void saveSale(Sale sale) {
        saleDAO.save(sale);
    }

    public void updateSale(Sale sale) {
        saleDAO.update(sale);
    }

    public void deleteSaleByID(int id) {
        saleDAO.deleteByID(id);
    }
}
