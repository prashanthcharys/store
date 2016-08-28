package com.mobilize.web.controller.application;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.mobilize.core.domain.value.BuyerVO;
//import com.mobilize.core.domain.value.SellerVO;
import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserVO;
//import com.mobilize.core.service.BuyerService;
import com.mobilize.core.service.LoginService;
import com.mobilize.core.service.UserDetailsService;
//import java.util.Locale;

/**
 * Handles requests for the application login page.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	/*@Autowired
	private BuyerService buyerService;*/
	@Autowired
	private UserDetailsService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value="/login/user", method=RequestMethod.GET)
	public String login(ModelMap model) {
		UserVO login = new UserVO();
		model.addAttribute("loginForm",login);
		//seller service testing starts.
		/*ArrayList<UserDetailsVO> sellerVOList =  buyerService.getAllBuyers();
		for(UserDetailsVO svo:sellerVOList){
			System.out.println("Buyer userID========================:"+svo.getFirstName());
		}*/
		//seller service testing ends.
		return "login";
	}
	@RequestMapping(value="/login/register", method=RequestMethod.GET)
	public String registerUser(ModelMap model) {
		UserDetailsVO userDetails = new UserDetailsVO();
		model.addAttribute("userForm",userDetails);
		return "register";
	}
	@RequestMapping(value="/login/register", method=RequestMethod.POST)
	public String userDetails(ModelMap model) {
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		model.addAttribute("userDetails", userDetailsVO);
		return "register";
	}
	@RequestMapping(value="/login/registerUser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("userForm") UserDetailsVO userForm,Model modelresult,HttpSession session) {
		userService.insertUserDetails(userForm);
		UserVO loginForm = loginService.getUserById(userForm.getUserId().trim());
		session.setAttribute("loginForm",loginForm);
		return "mainPage_2";
	}
	@RequestMapping(value="/login/validate", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("loginForm") UserVO loginForm,Model modelresult,HttpSession session) {
		System.out.println("UserID:"+loginForm.getUserId()+":Password:"+loginForm.getPassword());
		boolean loginValid =loginService.validateUser(loginForm.getUserId().trim(), loginForm.getPassword().trim());
		loginForm = loginService.getUserById(loginForm.getUserId().trim());		
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO = userService.getUserDetailsById(loginForm.getUid().trim(), loginForm.getUserType());		
		if(null == loginForm){
			loginForm = new UserVO();
		}
		session.setAttribute("loginForm",loginForm);
		session.setAttribute("userDetailsVO",userDetailsVO);
		if(loginValid){
			return "mainPage_2";
		}else{
			loginForm.setErrorMessage("Not a valid user id or password.");
			modelresult.addAttribute("loginForm",loginForm );
			return "login";
		}
	}
}
