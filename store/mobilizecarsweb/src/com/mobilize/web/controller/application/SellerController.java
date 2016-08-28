package com.mobilize.web.controller.application;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobilize.core.domain.value.CarDetailsVO;
import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.service.CarDetailsService;

/**
 * Handles requests for the application user details page.
 */
@Controller
//@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private CarDetailsService carDetailsService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="seller/addCar", method=RequestMethod.GET)
	public String addCars(Model model,HttpSession session,HttpServletRequest request) {
		CarDetailsVO carDetails = new CarDetailsVO();
		model.addAttribute("carDetailsForm",carDetails);
		return "sellerAddACar";
	}	

	@RequestMapping(value="seller/addCarSave", method=RequestMethod.POST)
	public String saveCarDetails(@ModelAttribute("carDetailsForm") CarDetailsVO carDetailsVO,HttpServletRequest request) {
		String retPage = "sellerAddACar";
		UserVO loginForm = (UserVO)request.getSession().getAttribute("loginForm");
		UserDetailsVO userDetailsVO = (UserDetailsVO)request.getSession().getAttribute("userDetailsVO");
		carDetailsVO.setUid(loginForm.getUid().trim());
		carDetailsVO.setZipCode(userDetailsVO.getZip());
		String careId = Math.random()+"";
		carDetailsVO.setId(careId.substring((careId.length()-10), careId.length()));
		System.out.println("get  year==================="+carDetailsVO.getYear());
		request.getSession().setAttribute("carId", carDetailsVO.getId());
		int result = carDetailsService.insertCarDetails(carDetailsVO);
		if(result == 0){
			carDetailsVO.setResMessage("Error while saving Car details.");			
		}else{
			carDetailsVO.setResMessage("Car details saved.");
			retPage = "sellerAddACarImg";
		}

		return retPage;
	}	
	@RequestMapping(value="seller/addCarSaveImg", method=RequestMethod.POST)
	public String saveCarImgs(@ModelAttribute("carDetailsForm") CarDetailsVO carDetailsVO,HttpServletRequest request) {
			// upload file start
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (!isMultipart) {
			} else {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				Iterator<FileItem> itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
					} else {
						try {
							String itemName = item.getName();
							File savedFile = new File("C:\\Temp\\"+request.getSession().getAttribute("carId")+itemName);
							item.write(savedFile);  

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}						
			}
		// upload file ends
			carDetailsVO.setResMessage("Car images uploaded.");
		return "sellerAddACarImg";
	}
	@RequestMapping(value="seller/makePay", method=RequestMethod.GET)
	public String makePay(Model model,HttpSession session,HttpServletRequest request) {
		return "sellerMakePay";
	}	

	@RequestMapping(value="seller/carsList", method=RequestMethod.GET)
	public String carsList(Model model,HttpSession session,HttpServletRequest request) {
		UserVO loginForm = (UserVO)session.getAttribute("loginForm");
		System.out.println("getting UID from loginpage:"+loginForm.getUid());
		ArrayList<CarDetailsVO> carsList = carDetailsService.getCarDetailsByUid(loginForm.getUid().trim());
		for(CarDetailsVO carvo:carsList){
			System.out.println("carvo==========="+carvo.getId());		
			System.out.println("carvo==========="+carvo.getMake());		
			System.out.println("carvo==========="+carvo.getModel());		
			System.out.println("carvo==========="+carvo.getYear());					
		}
		model.addAttribute("carsList", carsList);			

		return "sellerCarListings";
	}	

}
