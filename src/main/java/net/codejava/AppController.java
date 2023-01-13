package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService service;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}

	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}

	@GetMapping("/add")
	public String showAdd(Model model) {
		model.addAttribute("user", new User());

		return "add_form";
	}

	@PostMapping("/process_add")
	public String processAdd(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return "redirect:/admin";
	}


	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_form");

		User user = service.get(id);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}



	@RequestMapping("/admin")
	public String viewAdminPage() {
		return "admin";
	}

	@RequestMapping("/timetracking")
	public String viewTimeTrackingPage(Model model) {

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("User", new User());

		return "timetracking";
	}

	@GetMapping("/admin")
	public String listUser(Model model){
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("User", new User());

		return "admin";
	}




	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User User) {
		userRepo.save(User);

		return "redirect:/admin";
	}





}
