import db.dao.*;
import db.model.Manufacturer;

public class Main {
    public static void main(String[] args){
     /*   PersonDAO personDAO = new PersonDAO();
        System.out.println(personDAO.getPerson(1));
        System.out.println();
        System.out.println(personDAO.getPeople());

        AddressDao addressDao = new AddressDao();
        System.out.println(addressDao.getAddress(1));
*/
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        System.out.println(manufacturerDAO.getAll());
        System.out.println(manufacturerDAO.getByID(1));

        Manufacturer mn = new Manufacturer(20,"Accura","111111","acura@gmail.com");
        manufacturerDAO.save(mn);
        System.out.println(manufacturerDAO.getByID(20));

        CityDAO cityDao = new CityDAO();
        System.out.println(cityDao.getAll());
        System.out.println(cityDao.getByID(1));

        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println(employeeDAO.getAll());
        System.out.println(employeeDAO.getByID(1));

    }
}
