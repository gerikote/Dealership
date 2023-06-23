package db.interfaces;

import db.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAddressDAO extends IBaseDAO<Address> {
}
