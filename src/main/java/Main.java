import db.dao.*;
import db.model.*;
import db.services.AddressService;
import db.services.SaleService;
import jakarta.xml.bind.JAXBException;
import utils.DOMParser;
import utils.XMLValidator;
import utils.jackson.JSONUtils;
import utils.jaxb.JAXBUtils;

import java.io.File;
import java.sql.Date;

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

        //validate xml
        File xmlFile = new File("./src/main/resources/inventory.xml");
        File xsdSchema = new File("./src/main/resources/inventorySchema.xsd");
        System.out.println("Is xml file valid? " + XMLValidator.isXMLValid(xmlFile, xsdSchema));

        //DOMParser
        DOMParser.parseXMLFile("./src/main/resources/inventory.xml");

        File xmlFilePerson = new File("./src/main/resources/Person.xml");
        Person johny = DOMParser.parseXMLToObject(xmlFilePerson, Person.class);

        //JAXB
        //Marshall
        Person person = new Person("Johny", "Doe", Date.valueOf("2011-01-01"), "1234567890", "john.doe@example.com", 1);
        Sale sale = new Sale(1000, Date.valueOf("2022-01-01"), 1, 2, 1, 1, 1);
        Inventory inventory = new Inventory("cx30", 2022, 10000, "gas", 35000, "P1231A232CV", true, 1, 2, 3);

        try {
            JAXBUtils.marshal(person);
            JAXBUtils.marshal(sale);
            JAXBUtils.marshal(inventory);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //Unmarshall
        Inventory invetory2 = JAXBUtils.unmarshal(xmlFile, Inventory.class);
        System.out.println(invetory2);

        Person person2 = JAXBUtils.unmarshal(xmlFilePerson, Person.class);
        System.out.println(person2.toString());

        //JSON write
        JSONUtils.writeJSON(person, "./src/main/resources/Person.json");

        //JSON read
        Person person3 = JSONUtils.readJSON("./src/main/resources/Person.json", Person.class);
    }
}
