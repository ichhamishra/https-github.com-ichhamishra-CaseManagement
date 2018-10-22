package com.iig.gcp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iig.gcp.casem.dto.Alertsinfo;
import com.iig.gcp.casem.dto.OpsDetail;
import com.iig.gcp.casem.service.casemService;

@Controller
@SessionAttributes(value = { "Alert_id", "arrJobId" })
public class CaseController {
	
	private static final Model model = null;
	@Autowired
	private casemService casemService;
	private Object grouplist;
	
	/*@RequestMapping(value = { "/login"})
    public ModelAndView submitUser(ModelMap modelMap) {
		
		return new ModelAndView("casem/case");
	}*/
	
	@RequestMapping(value = "/casem/viewAlerts", method = RequestMethod.GET)
	public ModelAndView test(@Valid Model modelMap) {
		ArrayList<String> viewSSID= casemService.getMDSysList();
		modelMap.addAttribute("viewSSID", viewSSID);
		return new ModelAndView("/casem/viewAlerts");
		}
	
	@RequestMapping(value = "/casem/Level-1Investigation", method = RequestMethod.GET)
	public ModelAndView test1(@Valid Model modelMap) {
		ArrayList<String> viewSSID1= casemService.getMDSysList1();
		modelMap.addAttribute("viewSSID1", viewSSID1);
		System.out.println(viewSSID1);
		return new ModelAndView("/casem/Level-1Investigation");
		}
	@RequestMapping(value = "/casem/OperationsView", method = RequestMethod.GET)
	public ModelAndView Opslist(@Valid Model modelMap) {
		ArrayList<String> viewOPSID= casemService.getopsList();
		modelMap.addAttribute("viewOPSID", viewOPSID);
		return new ModelAndView("/casem/OperationsView");
		}
	
	
	
	
	@RequestMapping(value="/casem/viewCtryList",method=RequestMethod.POST)
	public ModelAndView viewCtryList(@Valid @ModelAttribute("sys_id")String sys_id, ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		//System.out.println("inside cntrller"+sys_id);
		ArrayList<String> countryList;
		countryList=casemService.getCtryList(sys_id); 
		model.addAttribute("countryList", countryList);
		model.addAttribute("sys_id",sys_id);
		return new ModelAndView("/casem/viewAlerts0");
	}
	
	@RequestMapping(value="/casem/viewCtryList1",method=RequestMethod.POST)
	public ModelAndView viewCtryList1(@Valid @ModelAttribute("sys_id")String sys_id, ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		//System.out.println("inside cntrller"+sys_id);
		ArrayList<String> countryList;
		countryList=casemService.getCtryList(sys_id); 
		model.addAttribute("countryList", countryList);
		model.addAttribute("sys_id",sys_id);
		return new ModelAndView("/casem/Level-1Investigation0");
	}
	
	@RequestMapping(value="/casem/viewAlertTable1",method=RequestMethod.POST)
	public ModelAndView viewAlertTable1(@Valid @ModelAttribute("sys_id")String sys_id, @ModelAttribute("ctry_id")String ctry_id,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		//System.out.println("inside cntrller"+sys_id);
		
		ArrayList<OpsDetail> tableList = new ArrayList<>();
		tableList= casemService.getAlertTable1(sys_id,ctry_id);
		model.addAttribute("tableList",tableList);
		ArrayList<String> getuserList ;
		getuserList= casemService.getuserList();
		System.out.println(getuserList.toString());
		model.addAttribute("getuserList",getuserList);
		return new ModelAndView("/casem/Level-1Investigation1");
	}
	
	
	@RequestMapping(value="/casem/viewAlertTable",method=RequestMethod.POST)
	public ModelAndView viewAlertTable(@Valid @ModelAttribute("sys_id")String sys_id, @ModelAttribute("ctry_id")String ctry_id,@ModelAttribute("alert_id")String alert_id,@ModelAttribute("group_name")String group_name,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		//System.out.println("inside cntrller"+sys_id);
		ArrayList<Alertsinfo> tableList;
		tableList=casemService.getAlertTable(sys_id,ctry_id);
		
		model.addAttribute("tableList",tableList);
		ArrayList<String> getopsList;
		ArrayList<String> grouplist = casemService.getopsList();
		System.out.println(grouplist.toString());
		model.addAttribute("grouplist", grouplist);
		casemService.updategroupname(alert_id,group_name);
		return new ModelAndView("/casem/viewAlerts1");
	}

	@RequestMapping(value="/casem/viewsubmit",method=RequestMethod.POST)
	public ModelAndView viewAlertTable(@Valid @ModelAttribute("alert_id")String alert_id,@ModelAttribute("group_name")String group_name,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		casemService.updategroupname(alert_id,group_name);
		ArrayList<String> viewSSID= casemService.getMDSysList();
		model.addAttribute("viewSSID", viewSSID);
		return new ModelAndView("/casem/viewAlerts");
	}
	
	@RequestMapping(value="/casem/viewsubmit1",method=RequestMethod.POST)
	public ModelAndView viewAlertTable11(@Valid @ModelAttribute("alert_id")String alert_id,@ModelAttribute("user_name")String user_name,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		casemService.updateassigneename(alert_id,user_name);
		System.out.println(user_name);
		ArrayList<String> viewSSID= casemService.getMDSysList();
		model.addAttribute("viewSSID", viewSSID);
		return new ModelAndView("/casem/Level-1Investigation");
	}
	
	
	@RequestMapping(value="/casem/viewsubmit2",method=RequestMethod.POST)
	public ModelAndView viewAlertTable11(@Valid @ModelAttribute("alert_id")String alert_id,@ModelAttribute("Comment")String Comment,@ModelAttribute("user_name")String user_name,@ModelAttribute("comment")String comment,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		casemService.updatecomment(alert_id,Comment,user_name);
		System.out.println(user_name);
		ArrayList<String> viewSSID= casemService.getMDSysList();
		model.addAttribute("viewSSID", viewSSID);
		return new ModelAndView("/casem/Level-1Investigation");
	}
	
	@RequestMapping(value="/casem/viewopsList",method=RequestMethod.POST)
	public ModelAndView viewOpTable(@Valid @ModelAttribute("ops_group")String ops_group,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
		ArrayList<Alertsinfo> tableList;
		tableList=casemService.getOPTable(ops_group );
		model.addAttribute("tableList",tableList);
		return new ModelAndView("/casem/OperationsView0");
	}
	
	@RequestMapping(value = { "/CaseManagement/Assigneedetail" }, method = RequestMethod.GET)
	public  ModelAndView Updateassignee(@Valid ModelMap modelMap) {
		/*ArrayList<String> grouplist = casemService.getopsList();
		System.out.println(grouplist.toString());
		model.addAttribute("grouplist", grouplist);*/
		return new ModelAndView("casem/Alertinfo1");

	}
	@RequestMapping(value = "/Case/save", method = RequestMethod.GET)
		public ModelAndView viewAlertTable2(@Valid @ModelAttribute("alert_id")String alert_id,@ModelAttribute("group_name")String group_name,ModelMap model) throws IOException, ClassNotFoundException, SQLException {
			casemService.updategroupname(alert_id,group_name);
			ArrayList<String> viewSSID= casemService.getMDSysList();
			model.addAttribute("viewSSID", viewSSID);
			return new ModelAndView("/casem/Alertinfo1");
		}

	
@RequestMapping(value = "Case/updateassignee", method = RequestMethod.GET)
public ModelAndView updateassignee(@Valid ModelMap modelMap) {
	
	return new ModelAndView("casem/viewAlerts");

}}
