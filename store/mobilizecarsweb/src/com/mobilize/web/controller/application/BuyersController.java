package com.mobilize.web.controller.application;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobilize.core.domain.value.CarDetailsVO;
import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserPref1VO;
import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.service.CarDetailsService;
import com.mobilize.core.service.UserDetailsService;

/**
 * Handles requests for the application user details page.
 */
@Controller
//@RequestMapping("/buyer")
public class BuyersController {
	
	@Autowired
	private CarDetailsService carDetailsService;	
	
	@Autowired
	private UserDetailsService userDetailsService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="buyer/getPref", method=RequestMethod.GET)
	public String buyerPref(Model model,HttpSession session,HttpServletRequest request) {
		
		UserVO loginForm = (UserVO)session.getAttribute("loginForm");
		UserPref1VO userPref2VO = new UserPref1VO();
		System.out.println("getting UID from loginpage:"+loginForm.getUid());
		//userPref2VO = userPref1Service.getUserPref1ById(loginForm.getUid().trim());	
		System.out.println("userPrefVO==========="+userPref2VO.getPrice());
		model.addAttribute("userPref2", userPref2VO);		
		
		/*String returnPage = "";
		System.out.println("page type:"+request.getParameter("pageType"));
		String toPage = request.getParameter("pageType");
		if(toPage.equalsIgnoreCase("preferences")){
			returnPage = "buyerPref";
		}else if(toPage.equalsIgnoreCase("searchCriteria")){
			returnPage = "buyerCriteria";
		}else if(toPage.equalsIgnoreCase("searchResults")){
			returnPage = "buyerSearch";
		}*/
		System.out.println("Hello");
		return "buyerPref";
	}	
	@RequestMapping(value="buyer/getResult", method=RequestMethod.GET)
	public String buyerResults(Model model,HttpSession session,HttpServletRequest request) {		
		UserVO loginForm = (UserVO)session.getAttribute("loginForm");
		System.out.println("getting UID from loginpage:"+loginForm.getUid());
		//ArrayList<CarDetailsVO> carsList = carDetailsService.getAllCarDetails();
		UserVO userVO = (UserVO)session.getAttribute("loginForm");
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO = userDetailsService.getUserDetailsById(userVO.getUid().trim(), userVO.getUserType());	
		ArrayList<CarDetailsVO> carsList = new ArrayList<CarDetailsVO> ();
		if(null != userDetailsVO.getZip() && !"".equals(userDetailsVO.getZip())){
			carsList = carDetailsService.getCarDetailsByZip(userDetailsVO.getZip());
		}
		for(CarDetailsVO carvo:carsList){
			System.out.println("carvo==========="+carvo.getId());		
			System.out.println("carvo==========="+carvo.getMake());		
			System.out.println("carvo==========="+carvo.getModel());		
			System.out.println("carvo==========="+carvo.getYear());					
		}
		model.addAttribute("carsList", carsList);		
		return "buyerSearch";
	}
	
	@RequestMapping(value="buyer/getCriteria", method=RequestMethod.GET)
	public String buyerCriteria(Model model,HttpSession session,HttpServletRequest request) {		
		UserVO loginForm = (UserVO)session.getAttribute("loginForm");
		System.out.println("getting UID from loginpage:"+loginForm.getUid());
		/*ArrayList<CarDetailsVO> carsList = carDetailsService.getAllCarDetails(); 
		for(CarDetailsVO carvo:carsList){
			System.out.println("carvo==========="+carvo.getCarId());		
		}
		model.addAttribute("carsList", carsList);	*/				
		return "buyerCriteria";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("userPref2") UserPref1VO userPref1VO,Model modelresult,HttpServletRequest request) {
			String toPage = request.getParameter("pageType");
		if(toPage.equalsIgnoreCase("save")){
			UserVO loginForm = (UserVO)request.getSession().getAttribute("loginForm");
			userPref1VO.setUid(loginForm.getUid());
			System.out.println("mobile:"+userPref1VO.getPrice());
			System.out.println("uid:"+userPref1VO.getUid());
			
			
			int result = userPref1Service.updateUserPref1ById(userPref1VO);
			System.out.println("result"+result);			
		}
		return "userProfile";
	}	*/	

}
