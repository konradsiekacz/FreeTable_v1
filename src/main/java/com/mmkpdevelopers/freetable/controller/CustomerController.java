package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.model.Customer;
import com.mmkpdevelopers.freetable.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer")
	public String viewHomePage(Model model) {
		List<Customer> listCustomers = customerService.listAll();
		model.addAttribute("listCustomers", listCustomers);

		return "customer";
	}

	@RequestMapping("/customer/new")
	public String showNewCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "new_customer";
	}

	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);

		return "redirect:/customer";
	}

	@RequestMapping("/customer/edit/{id}")
	public ModelAndView showEditCustomerPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = customerService.get(id);
		mav.addObject("customer", customer);

		return mav;
	}

	@RequestMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") int id) {
		customerService.delete(id);
		return "redirect:/customer";
	}
}
