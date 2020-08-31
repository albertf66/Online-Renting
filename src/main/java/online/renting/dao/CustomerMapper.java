package online.renting.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import online.renting.entity.Customer;
import online.renting.util.MyBatilUtil;

@Repository
public class CustomerMapper {
	public List<Customer> getAllCustomer() {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		List<Customer> customerList = session.selectList("getAllCustomer");
		session.commit();
		session.close();
		return customerList;
	}

	public void addCustomer(Customer customer) {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		session.insert("addCustomer", customer);
		session.commit();
		session.close();
	}

	public void deleteCustomer(int customerId) {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		session.delete("deleteCustomer", customerId);
		session.commit();
		session.close();
	}

	public Customer findById(int customerId) {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		Customer customer = (Customer) session.selectOne("findById", customerId);
		session.commit();
		session.close();
		return customer;
	}

	public Customer findByEmail(String customerEmail) {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		Customer customer = (Customer) session.selectOne("findByEmail", customerEmail);
		session.commit();
		session.close();
		return customer;
	}

	public String checkPw(String customerEmail) {	
		try {
			SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
			Customer customer = (Customer) session.selectOne("findByEmail", customerEmail);
			session.commit();
			session.close();
			return customer.getCust_pw();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateCustomer(Customer customer) {
		SqlSession session = MyBatilUtil.getSqlSessionFactory().openSession();
		session.update("updateCustomer", customer);
		session.commit();
		session.close();
	}
}
