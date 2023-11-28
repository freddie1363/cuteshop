package egovframework.kjhcomment.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import egovframework.kjhcomment.service.KjhcommentService;
import egovframework.kjhcomment.service.KjhcommentDefaultVO;
import egovframework.kjhcomment.service.KjhcommentVO;
import egovframework.kjhgallery.service.KjhgalleryService;
import egovframework.kjhgallery.service.KjhgalleryVO;

/**
 * @Class Name : KjhcommentController.java
 * @Description : Kjhcomment Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=KjhcommentVO.class)
public class KjhcommentController {

    @Resource(name = "kjhgalleryService")
    private KjhgalleryService kjhgalleryService;
	
    @Resource(name = "kjhcommentService")
    private KjhcommentService kjhcommentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * kjhcomment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 KjhcommentDefaultVO
	 * @return "/kjhcomment/KjhcommentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/kjhcomment/KjhcommentList.do")
    public String selectKjhcommentList(@ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, 
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
		
        //List<?> kjhcommentList = kjhcommentService.selectKjhcommentList(searchVO);
        //model.addAttribute("resultList", kjhcommentList);
        
        int totCnt = kjhcommentService.selectKjhcommentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/kjhcomment/KjhcommentList";
    } 
    
    @RequestMapping("/kjhcomment/addKjhcommentView.do")
    public String addKjhcommentView(
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("kjhcommentVO", new KjhcommentVO());
        return "/kjhcomment/KjhcommentRegister";
    }
    
    @RequestMapping("/kjhcomment/addKjhcomment.do")
    public String addKjhcomment(
            KjhcommentVO kjhcommentVO,
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, SessionStatus status, HttpServletRequest request, Model model)
            throws Exception {
        kjhcommentService.insertKjhcomment(kjhcommentVO);
        status.setComplete();
        
        KjhgalleryVO kjhgalleryvo = new KjhgalleryVO();
        kjhgalleryvo.setId(kjhcommentVO.getId());
        
        KjhgalleryVO vo = kjhgalleryService.selectKjhgallery(kjhgalleryvo);
    	request.getSession().setAttribute("selectedVO", vo);
    	
    	List<?> kjhcommentList = kjhcommentService.selectKjhcommentList(kjhgalleryvo);
        model.addAttribute("commentList", kjhcommentList);
  	
    	return "gallerypost";
   
        //return "forward:/kjhcomment/KjhcommentList.do";
    }
    
    @RequestMapping("/kjhcomment/updateKjhcommentView.do")
    public String updateKjhcommentView(
            @RequestParam("cno") int cno ,
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, Model model)
            throws Exception {
        KjhcommentVO kjhcommentVO = new KjhcommentVO();
        kjhcommentVO.setCno(cno);        
        // 변수명은 CoC 에 따라 kjhcommentVO
        model.addAttribute(selectKjhcomment(kjhcommentVO, searchVO));
        return "/kjhcomment/KjhcommentRegister";
    }

    @RequestMapping("/kjhcomment/selectKjhcomment.do")
    public @ModelAttribute("kjhcommentVO")
    KjhcommentVO selectKjhcomment(
            KjhcommentVO kjhcommentVO,
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO) throws Exception {
        return kjhcommentService.selectKjhcomment(kjhcommentVO);
    }

    @RequestMapping("/kjhcomment/updateKjhcomment.do")
    public String updateKjhcomment(
            KjhcommentVO kjhcommentVO,
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhcommentService.updateKjhcomment(kjhcommentVO);
        status.setComplete();
        return "forward:/kjhcomment/KjhcommentList.do";
    }
    
    @RequestMapping("/kjhcomment/deleteKjhcomment.do")
    public String deleteKjhcomment(
            KjhcommentVO kjhcommentVO,
            @ModelAttribute("searchVO") KjhcommentDefaultVO searchVO, SessionStatus status, HttpServletRequest request, Model model)
            throws Exception {
        kjhcommentService.deleteKjhcomment(kjhcommentVO);
        status.setComplete();
        
        KjhgalleryVO vo = new KjhgalleryVO();
        vo = (KjhgalleryVO) request.getSession().getAttribute("selectedVO");
        

    	request.getSession().setAttribute("selectedVO", vo);
    	
    	List<?> kjhcommentList = kjhcommentService.selectKjhcommentList(vo);
        model.addAttribute("commentList", kjhcommentList);
  	
    	return "gallerypost";
        
        
        //return "forward:/kjhcomment/KjhcommentList.do";
    }

}
