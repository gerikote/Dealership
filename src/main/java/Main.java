import db.dao.*;
import db.model.Address;
import db.model.City;
import db.model.Condition;
import db.model.Manufacturer;
import db.services.AddressService;
import db.services.SaleService;

public class Main {
    public static void main(String[] args) {
        //Update address
        AddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.getByID(1);
        address.setAddress("new address");
        address.setZipCode("00000");
        address.setCityID(2);
        addressDAO.update(address);
        System.out.println(addressDAO.getAll());
        //insert address
        Address newAddress = new Address("testadress", "0000", 1);
        addressDAO.save(newAddress);
        System.out.println(addressDAO.getAll());
        //delete address
        addressDAO.deleteByID(6);
        System.out.println(addressDAO.getAll());

        System.out.println();
        CityDAO cityDao = new CityDAO();
        System.out.println(cityDao.getAll());
        System.out.println(cityDao.getByID(1));
        //Insert address
        City newcity = new City("London");
        cityDao.save(newcity);
        System.out.println(cityDao.getAll());
        //Delete address
        cityDao.deleteByID(11);
        //update city
        City city1 = cityDao.getByID(1);
        city1.setCity("New York City");
        cityDao.update(city1);
        System.out.println(cityDao.getAll());

        System.out.println();
        ConditionDAO conditionDAO = new ConditionDAO();
        System.out.println(conditionDAO.getAll());
        Condition cond1 = conditionDAO.getByID(1);
        cond1.setCondition("new1");
        conditionDAO.update(cond1);
        System.out.println(conditionDAO.getAll());
        cond1.setCondition("new");
        conditionDAO.update(cond1);
        System.out.println(conditionDAO.getAll());

        AddressService addressService = new AddressService();
        //get all  - get by id
        System.out.println();
        System.out.println(addressService.getAllAddresses());
        System.out.println(addressService.getAddressByID(1));

        //update address
        Address address1 = addressService.getAddressByID(1);
        address1.setZipCode("1111");
        addressService.updateAddress(address1);
        System.out.println(addressService.getAddressByID(1));

        SaleService saleService = new SaleService();
        System.out.println(saleService.getAllSales());
    }
}
