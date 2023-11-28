package egovframework.kjhuser.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.kjhuser.service.KjhuserService;
import egovframework.kjhuser.service.KjhuserDefaultVO;
import egovframework.kjhuser.service.KjhuserVO;

/**
 * @Class Name : KjhuserController.java
 * @Description : Kjhuser Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=KjhuserVO.class)
public class KjhuserController {

    @Resource(name = "kjhuserService")
    private KjhuserService kjhuserService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * kjhuser 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 KjhuserDefaultVO
	 * @return "/kjhuser/KjhuserList"
	 * @exception Exception
	 */
    
    @RequestMapping(value="/kjhuser/idDoubleCheck.do")
    public @ResponseBody ModelAndView idDoubleCheck(KjhuserVO vo) throws Exception {
    	vo = kjhuserService.selectKjhuser(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("searchedVO",vo);
    	return jsonView;
    }
    
    @RequestMapping(value="/kjhuser/findId.do")
    public @ResponseBody ModelAndView findId(KjhuserVO vo) throws Exception {
    	vo = kjhuserService.findId(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("findVO",vo);
    	return jsonView;
    }
    
    @RequestMapping(value="/kjhuser/findPw.do")
    public @ResponseBody ModelAndView findPw(KjhuserVO vo) throws Exception {
    	vo = kjhuserService.findPw(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("findVO",vo);
    	return jsonView;
    }
    
    @RequestMapping(value="/kjhuser/KjhuserList.do")
    public String selectKjhuserList(@ModelAttribute("searchVO") KjhuserDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> kjhuserList = kjhuserService.selectKjhuserList(searchVO);
        model.addAttribute("resultList", kjhuserList);
        
        int totCnt = kjhuserService.selectKjhuserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/kjhuser/KjhuserList";
    } 
    
    @RequestMapping("/kjhuser/addKjhuserView.do")
    public String addKjhuserView(
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("kjhuserVO", new KjhuserVO());
        return "/kjhuser/KjhuserRegister";
    }
    
    @RequestMapping("/kjhuser/addKjhuser.do")
    public String addKjhuser(
            KjhuserVO kjhuserVO,
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhuserService.insertKjhuser(kjhuserVO);
        status.setComplete();
        return "forward:/kjhuser/KjhuserList.do";
    }
    
    @RequestMapping("/kjhuser/updateKjhuserView.do")
    public String updateKjhuserView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO, Model model)
            throws Exception {
        KjhuserVO kjhuserVO = new KjhuserVO();
        kjhuserVO.setId(id);        
        // 변수명은 CoC 에 따라 kjhuserVO
        model.addAttribute(selectKjhuser(kjhuserVO, searchVO));
        return "/kjhuser/KjhuserRegister";
    }

    @RequestMapping("/kjhuser/selectKjhuser.do")
    public @ModelAttribute("kjhuserVO")
    KjhuserVO selectKjhuser(
            KjhuserVO kjhuserVO,
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO) throws Exception {
        return kjhuserService.selectKjhuser(kjhuserVO);
    }

    @RequestMapping("/kjhuser/updateKjhuser.do")
    public String updateKjhuser(
            KjhuserVO kjhuserVO,
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO, SessionStatus status, Model model, HttpServletRequest request)
            throws Exception {
        kjhuserService.updateKjhuser(kjhuserVO);
        status.setComplete();
        
        model.addAttribute("result", kjhuserVO);
    	
        request.getSession().setAttribute("loginedUserVO", kjhuserVO);
        
        return "forward:/index.do";
    }
    
    @RequestMapping("/kjhuser/deleteKjhuser.do")
    public String deleteKjhuser(
            KjhuserVO kjhuserVO,
            @ModelAttribute("searchVO") KjhuserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhuserService.deleteKjhuser(kjhuserVO);
        status.setComplete();
        return "forward:/kjhuser/KjhuserList.do";
    }
    
    @RequestMapping("/kjhuser/checkUserLogin.do")
    public String checkUserLogin(
            KjhuserVO userVO, Model model, HttpServletRequest request) throws Exception {
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpw: " + userVO.getUserpw());
    	userVO = kjhuserService.checkUserLogin(userVO);
    	System.out.println("id : " + userVO.getId());
    	System.out.println("userid : " + userVO.getUserid());
    	System.out.println("userpw : " + userVO.getUserpw());
    	model.addAttribute("result", userVO);
    	
    	request.getSession().setAttribute("loginedUserVO", userVO);
    	return "forward:/index.do";
    }
    
    @RequestMapping("/kjhuser/userLogout.do")
    public String userLogout(HttpServletRequest request) throws Exception {
    	request.getSession().removeAttribute("loginedUserVO");
    	return "forward:/index.do";
    }
    
    @RequestMapping("/kjhuser/userJoin.do")
    public String kjhuserJoin(
            KjhuserVO userVO, HttpServletRequest request) {
        try {
			userVO = kjhuserService.userJoin(userVO);
		} catch (Exception e) {
			userVO = null;
		}
        request.getSession().removeAttribute("loginedUserVO");
        //request.getSession().setAttribute("insertedLogin", userVO);
        return "signin";
    }	

}
