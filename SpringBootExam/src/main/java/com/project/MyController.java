package com.project;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Model.BeanFile;
import com.project.Model.CommentsModel;
import com.project.Model.IdFlowModel;
import com.project.RegisterRepository.CommentsRepository;
import com.project.RegisterRepository.RegisterRepository;
import com.project.Service.Register;

@Controller
public class MyController {

	@Autowired
	Register register;
	@Autowired
	RegisterRepository repository;
	@Autowired
	HttpSession session;
	@Autowired
	CommentsRepository commentsRepository;
	ModelAndView mav = new ModelAndView();
	IdFlowModel idFlowModel = new IdFlowModel();
	

	@RequestMapping("/")
	public ModelAndView index() {
		mav.setViewName("index");
		return mav;
	}

	
	  @RequestMapping("/login1") public ModelAndView
	  login(@ModelAttribute("register") BeanFile data) { mav.setViewName("login");
	  
	  return mav; }
	 
	@RequestMapping("/NewUser")
	public String NewUser() {
		return "NewUser";
	}

	@JsonIgnore
	@RequestMapping("/login")
	public String getNewUser(@RequestBody(required = false) @ModelAttribute("register") BeanFile data) {
		register.registerNewUser(data);
		return "login";
	}

	@RequestMapping("/receive")
	public String login(@RequestParam("name") String name, @RequestParam("pass") String pass) {
		Iterable li = register.forLogin(name, pass);
		System.out.println(li);
		int id = 0;
		for (Object c : li) {
			String s = c.toString();
			id = Integer.parseInt(s);
		}
		System.out.println(id);
		idFlowModel.setId(id);
		if (id == 0) {
			return "login";
		} else {

			return "success";
		}
	}

	// Changing Password
	@RequestMapping("/getnewpassword")
	public String getnewpassword(@ModelAttribute("register") BeanFile data) {
		register.registerNewUser(data);
		return "updatepassword";
	}

	@RequestMapping("/updatepassword")
	public String getgetnewpassword(@RequestParam("mail1") String mail, @RequestParam("pass") String name) {
		register.updateAdress(mail, name);
		return "success";
	}

	@RequestMapping("/receiver")
	public String getforgotpassword(@RequestParam("name") String name, @RequestParam("mail") String mail) {
		Iterable li = register.forForgotPassword(name, mail);
		System.out.println(li);
		int id = 0;
		for (Object c : li) {
			String s = c.toString();
			id = Integer.parseInt(s);
		}
		idFlowModel.setId(id);
		if (id == 0) {
			return "forgotpassword";
		} else {

			return "getnewpassword";
		}
	}

	@RequestMapping("/forgotpassword")
	public String getforgotpassword() {
		return "forgotpassword";
	}

	@RequestMapping("/post")
	public String post() {
		int id = idFlowModel.getId();
		Iterable i = register.idFlow(id);
		String name = "";
		for (Object obj : i) {
			name = String.valueOf(obj);
		}

		session.setAttribute("name", name);
		System.out.println(session.getAttribute("name"));
		return "post";
	}

	@RequestMapping("/PostComment")
	public String postComments(@ModelAttribute("postcomment") CommentsModel commentsModel) {
		register.insertComments(commentsModel);
		return "post";
	}
    //already existed
	/*@GetMapping("/ViewComments")
	@ResponseBody
	public Iterable<CommentsModel> viewComments() {
	return commentsRepository.findAll();
	}*/
	
	/*
	 * @GetMapping("/ViewComments")
	 * 
	 * @ResponseBody public Iterable<CommentsModel> viewComments(){ int
	 * id=idFlowModel.getId(); Iterable<CommentsModel>
	 * name=commentsRepository.alwaysLogin(id); System.out.println("Name  " +name);
	 * //register.invidualUser(name); //ArrayList
	 * comments=register.individualUser(name); return name; }
	 */

	/*
	 * @GetMapping("/ViewComments")
	 * 
	 * @ResponseBody public ArrayList<CommentsModel> viewComments(){ int
	 * id=idFlowModel.getId(); ArrayList<CommentsModel>
	 * name=(ArrayList<CommentsModel>) commentsRepository.alwaysLogin(id);
	 * System.out.println("Name  " +name); //register.invidualUser(name); ArrayList
	 * comments=register.individualUser(name); return comments ; }
	 */
	
	//for working with REST
	@GetMapping("/ViewComments")
	@ResponseBody
	public ModelAndView viewComments(){
		int id=idFlowModel.getId();
		ArrayList<CommentsModel> name=(ArrayList<CommentsModel>) commentsRepository.alwaysLogin(id);
		System.out.println("Name  "  +name);
		 //register.invidualUser(name);
	    ArrayList comments=register.individualUser(name);
	    mav.setViewName("display");
	    mav.addObject("d", comments);
		return mav ;
	}
	
}
