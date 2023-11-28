package egovframework.kjhgallerylikes.web;

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
import egovframework.kjhgallerylikes.service.KjhgallerylikesService;
import egovframework.kjhgallery.service.KjhgalleryService;
import egovframework.kjhgallery.service.KjhgalleryVO;
import egovframework.kjhgallerylikes.service.KjhgallerylikesDefaultVO;
import egovframework.kjhgallerylikes.service.KjhgallerylikesVO;
import egovframework.kjhuser.service.KjhuserVO;

/**
 * @Class Name : KjhgallerylikesController.java
 * @Description : Kjhgallerylikes Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=KjhgallerylikesVO.class)
public class KjhgallerylikesController {

    @Resource(name = "kjhgallerylikesService")
    private KjhgallerylikesService kjhgallerylikesService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @Resource(name = "kjhgalleryService")
    private KjhgalleryService kjhgalleryService;
    /**
	 * kjhgallerylikes 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 KjhgallerylikesDefaultVO
	 * @return "/kjhgallerylikes/KjhgallerylikesList"
	 * @exception Exception
	 */
    @RequestMapping(value="/kjhgallerylikes/KjhgallerylikesList.do")
    public String selectKjhgallerylikesList(@ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, 
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
		
        List<?> kjhgallerylikesList = kjhgallerylikesService.selectKjhgallerylikesList(searchVO);
        model.addAttribute("resultList", kjhgallerylikesList);
        
        int totCnt = kjhgallerylikesService.selectKjhgallerylikesListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/kjhgallerylikes/KjhgallerylikesList";
    } 
    
    @RequestMapping("/kjhgallerylikes/addKjhgallerylikesView.do")
    public String addKjhgallerylikesView(
            @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("kjhgallerylikesVO", new KjhgallerylikesVO());
        return "/kjhgallerylikes/KjhgallerylikesRegister";
    }
    
    @RequestMapping("/kjhgallerylikes/addKjhgallerylikes.do")
    public String addKjhgallerylikes(
            KjhgallerylikesVO kjhgallerylikesVO,
            @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgallerylikesService.insertKjhgallerylikes(kjhgallerylikesVO);
        status.setComplete();
        return "forward:/kjhgallerylikes/KjhgallerylikesList.do";
    }
    
	/*
	 * @RequestMapping("/kjhgallerylikes/updateKjhgallerylikesView.do") public
	 * String updateKjhgallerylikesView(
	 * 
	 * @RequestParam("lno") int lno ,
	 * 
	 * @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, Model model)
	 * throws Exception { KjhgallerylikesVO kjhgallerylikesVO = new
	 * KjhgallerylikesVO(); kjhgallerylikesVO.setLno(lno); // 변수명은 CoC 에 따라
	 * kjhgallerylikesVO model.addAttribute(selectKjhgallerylikes(kjhgallerylikesVO,
	 * searchVO)); return "/kjhgallerylikes/KjhgallerylikesRegister"; }
	 */

	/*
	 * @RequestMapping("/kjhgallerylikes/selectKjhgallerylikes.do")
	 * public @ModelAttribute("kjhgallerylikesVO") KjhgallerylikesVO
	 * selectKjhgallerylikes( KjhgallerylikesVO kjhgallerylikesVO,
	 * 
	 * @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO) throws
	 * Exception { return
	 * kjhgallerylikesService.selectKjhgallerylikes(kjhgallerylikesVO); }
	 */
    
    @RequestMapping("/kjhgallerylikes/selectKjhgallerylikes.do")
    public @ResponseBody ModelAndView selectKjhgallerylikes(KjhgallerylikesVO kjhgallerylikesVO, HttpServletRequest request) throws Exception {
    	
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	
    	KjhuserVO kjhuserVO = (KjhuserVO) request.getSession().getAttribute("loginedUserVO");
    	
    	int asd = kjhgallerylikesVO.getGno();

    	kjhgallerylikesVO.setUserid(kjhuserVO.getUserid());
    	//kjhgallerylikesVO.setGno(asd);
    	

    	int qqq = kjhgallerylikesService.selectKjhgallerylikesListTotCnt(kjhgallerylikesVO);//중복 검증 위해서 셀렉트 해서 likes 테이블에서 일치하는 행  조회함(갯수 반환) 
    	
    	
   	if(qqq>0) {//해당 하는거 찾음. 즉 중복이므로 likes 테이블 데이터 삭제하고 추천은 -1 
   		kjhgalleryService.decreaseBoardLikes((KjhgalleryVO) request.getSession().getAttribute("selectedVO"));
   		kjhgallerylikesService.deleteKjhgallerylikes(kjhgallerylikesVO);
	} else {//해당 하는거 못 찾음 likes 테이블에 데이터 집어넣고 추천은 +1
    		kjhgalleryService.increaseBoardLikes((KjhgalleryVO) request.getSession().getAttribute("selectedVO"));
    		kjhgallerylikesService.insertKjhgallerylikes(kjhgallerylikesVO);
    }
    	
    		
    	
    	
//    	
//   
//    		KjhgalleryVO vo = new KjhgalleryVO();
//        	vo.setId(asd);
    	
    	
    	KjhgalleryVO vo2 = kjhgalleryService.selectKjhgallery((KjhgalleryVO) request.getSession().getAttribute("selectedVO"));
    	request.getSession().setAttribute("selectedVO", vo2);
    	jsonView.addObject("searchedVO", vo2);
		 return jsonView;
    }

    @RequestMapping("/kjhgallerylikes/updateKjhgallerylikes.do")
    public String updateKjhgallerylikes(
            KjhgallerylikesVO kjhgallerylikesVO,
            @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgallerylikesService.updateKjhgallerylikes(kjhgallerylikesVO);
        status.setComplete();
        return "forward:/kjhgallerylikes/KjhgallerylikesList.do";
    }
    
    @RequestMapping("/kjhgallerylikes/deleteKjhgallerylikes.do")
    public String deleteKjhgallerylikes(
            KjhgallerylikesVO kjhgallerylikesVO,
            @ModelAttribute("searchVO") KjhgallerylikesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgallerylikesService.deleteKjhgallerylikes(kjhgallerylikesVO);
        status.setComplete();
        return "forward:/kjhgallerylikes/KjhgallerylikesList.do";
    }

}
