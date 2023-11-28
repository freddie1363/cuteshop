package egovframework.kjhpayment.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.kjhpayment.service.KjhpaymentService;
import egovframework.kjhpayment.service.KjhpaymentDefaultVO;
import egovframework.kjhpayment.service.KjhpaymentVO;

/**
 * @Class Name : KjhpaymentController.java
 * @Description : Kjhpayment Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=KjhpaymentVO.class)
public class KjhpaymentController {

    @Resource(name = "kjhpaymentService")
    private KjhpaymentService kjhpaymentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * kjhpayment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 KjhpaymentDefaultVO
	 * @return "/kjhpayment/KjhpaymentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/kjhpayment/KjhpaymentList.do")
    public String selectKjhpaymentList(@ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, 
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
		
        List<?> kjhpaymentList = kjhpaymentService.selectKjhpaymentList(searchVO);
        model.addAttribute("resultList", kjhpaymentList);
        
        int totCnt = kjhpaymentService.selectKjhpaymentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/kjhpayment/KjhpaymentList";
    } 
    
    @RequestMapping("/kjhpayment/addKjhpaymentView.do")
    public String addKjhpaymentView(
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("kjhpaymentVO", new KjhpaymentVO());
        return "/kjhpayment/KjhpaymentRegister";
    }
    
    @RequestMapping("/kjhpayment/addKjhpayment.do")
    public String addKjhpayment(
            KjhpaymentVO kjhpaymentVO,
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhpaymentService.insertKjhpayment(kjhpaymentVO);
        status.setComplete();
        return "forward:/kjhpayment/KjhpaymentList.do";
    }
    
    @RequestMapping("/kjhpayment/updateKjhpaymentView.do")
    public String updateKjhpaymentView(
            @RequestParam("pno") int pno ,
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, Model model)
            throws Exception {
        KjhpaymentVO kjhpaymentVO = new KjhpaymentVO();
        kjhpaymentVO.setPno(pno);        
        // 변수명은 CoC 에 따라 kjhpaymentVO
        model.addAttribute(selectKjhpayment(kjhpaymentVO, searchVO));
        return "/kjhpayment/KjhpaymentRegister";
    }

    @RequestMapping("/kjhpayment/selectKjhpayment.do")
    public @ModelAttribute("kjhpaymentVO")
    KjhpaymentVO selectKjhpayment(
            KjhpaymentVO kjhpaymentVO,
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO) throws Exception {
        return kjhpaymentService.selectKjhpayment(kjhpaymentVO);
    }

    @RequestMapping("/kjhpayment/updateKjhpayment.do")
    public String updateKjhpayment(
            KjhpaymentVO kjhpaymentVO,
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhpaymentService.updateKjhpayment(kjhpaymentVO);
        status.setComplete();
        return "forward:/kjhpayment/KjhpaymentList.do";
    }
    
    @RequestMapping("/kjhpayment/deleteKjhpayment.do")
    public String deleteKjhpayment(
            KjhpaymentVO kjhpaymentVO,
            @ModelAttribute("searchVO") KjhpaymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhpaymentService.deleteKjhpayment(kjhpaymentVO);
        status.setComplete();
        return "forward:/kjhpayment/KjhpaymentList.do";
    }

}
