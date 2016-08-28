package com.mobilize.web.controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.service.UserDetailsService;

/**
 * Handles requests for the application user details page.
 */
@Controller
//@RequestMapping("/userDetails")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;	


	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value="/userDetails/getUser", method=RequestMethod.GET)
	public String userDetails(ModelMap model,HttpSession session) {
		UserVO loginForm = (UserVO)session.getAttribute("loginForm");
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO = userDetailsService.getUserDetailsById(loginForm.getUid().trim(), loginForm.getUserType());		
		model.addAttribute("userDetails", userDetailsVO);
		return "userProfile";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@RequestMapping(method = RequestMethod.POST)
	@RequestMapping(value="/userDetails/saveUser", method=RequestMethod.POST)
	public String saveUserDetails(@ModelAttribute("userDetails") UserDetailsVO userDetailsVO,Model modelresult,HttpServletRequest request) {
		UserVO loginForm = (UserVO)request.getSession().getAttribute("loginForm");
		userDetailsVO.setUid(loginForm.getUid().trim());
		userDetailsVO.setUserType(loginForm.getUserType());
		int result = userDetailsService.updateUserDetailsById(userDetailsVO);
		if(result == 0){
			userDetailsVO.setResMessage("Error while saving User details.");
		}else{
			userDetailsVO.setResMessage("User details saved.");
		}
		return "userProfile";
	}	
	@RequestMapping(value="/userDetails/addUser", method=RequestMethod.POST)
	public String addUserDetails(@ModelAttribute("userDetails") UserDetailsVO userDetailsVO,Model modelresult,HttpServletRequest request) {
		UserVO loginForm = (UserVO)request.getSession().getAttribute("loginForm");
		userDetailsVO.setUid(loginForm.getUid().trim());
		int result = userDetailsService.insertUserDetails(userDetailsVO);
		if(result == 0){
			userDetailsVO.setResMessage("Error while adding User details.");
		}else{
			userDetailsVO.setResMessage("User added.");
		}
		return "userProfile";
	}
	@RequestMapping(value="/userDetails/deleteUser", method=RequestMethod.POST)
	public String deleteUserDetails(@ModelAttribute("userDetails") UserDetailsVO userDetailsVO,Model modelresult,HttpServletRequest request) {
		UserVO loginForm = (UserVO)request.getSession().getAttribute("loginForm");
		int result = userDetailsService.deleteUserDetailsById(loginForm.getUid().trim(), loginForm.getUserType());
		if(result == 0){
			userDetailsVO.setResMessage("Error while deleting User details.");
		}else{
			userDetailsVO.setResMessage("User deleted.");
		}
		return "userProfile";
	}		

}
