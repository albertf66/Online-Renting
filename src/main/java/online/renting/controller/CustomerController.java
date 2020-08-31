package online.renting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import online.renting.dao.CustomerMapper;
import online.renting.entity.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerMapper mapper;

	@ModelAttribute("customer")
	public Customer getCustomerObject() {
		return new Customer();
	}

	@Bean
	public MessageSource messageSource() {
	     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	     messageSource.setBasename("/WEB-INF/messages");
	     return messageSource;
	}
	
	@RequestMapping("/")
	public String index() {
		return "register";
	}

	@RequestMapping("/addProcess")
	public String addProcess(@ModelAttribute("customer") Customer customer) {
		if (customer.getCust_id() == null) {
			mapper.addCustomer(customer);
		} else {
			mapper.updateCustomer(customer);
		}
		return "redirect:/";
	}

	@RequestMapping("/deleteCustomer")
	public String deleteProcess(@RequestParam("customer") int customerId) {
		mapper.deleteCustomer(customerId);
		return "redirect:/";
	}

	@RequestMapping("/editCustomer")
	public ModelAndView editCustomer(@RequestParam("customer") int customerId) {
		ModelAndView mav = new ModelAndView("edit");
		Customer customer = mapper.findById(customerId);
		mav.addObject("customer", customer);
		return mav;
	}

	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute("customer") Customer customer) {
		System.out.println("cust : " + customer);
		ModelAndView mav = new ModelAndView("login");
		mapper.addCustomer(customer);
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("customer") Customer customer, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		try {
			if (customer.getCust_pw().equals(null)) {
				result.rejectValue("cust_pw", "error.empty.pw");
				return mav = new ModelAndView("login");
			}
			else if (customer.getCust_email().equals(null)) {
				result.rejectValue("cust_email", "error.empty.email");
				return mav = new ModelAndView("login");
			}
			else if (mapper.findByEmail(customer.getCust_email()) == null) {
				result.rejectValue("cust_email", "error.mismatch.email");
				return mav = new ModelAndView("login");
			}
			else if (!customer.getCust_pw().equals(mapper.checkPw(customer.getCust_email()))) {
				System.out.println("pw 1 " + customer.getCust_pw() +  "pw 2 " + mapper.checkPw(customer.getCust_email()));
				result.rejectValue("cust_pw", "error.mismatch.pw");
				return mav = new ModelAndView("login");
			}
			else {
				System.out.println(mapper.getAllCustomer());
				mav.addObject("listofcustomers", mapper.getAllCustomer());
				return mav = new ModelAndView("index");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
