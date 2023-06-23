
import db.model.ExtraServices;
import db.mybatis.*;

public class MyBatisMain {
    public static void main(String[] main) {

        System.out.println(new AddressDAO().getByID(1));
        System.out.println(new AddressDAO().getAll());
        System.out.println(new CityDAO().getAll());
        System.out.println(new PersonDAO().getAll());
        System.out.println(new ManufacturerDAO().getAll());
        System.out.println(new EmployeeDAO().getAll());
        System.out.println(new ExtraServicesDAO().getAll());
        System.out.println(new InsuranceDAO().getAll());
        System.out.println(new ColorDAO().getAll());
        System.out.println(new ConditionDAO().getAll());
        System.out.println(new CustomerDAO().getAll());
        System.out.println(new InventoryDAO().getAll());
        System.out.println(new PaymentMethodDAO().getAll());
        System.out.println(new SaleDAO().getAll());
    }
}
