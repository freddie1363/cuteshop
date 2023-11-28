package egovframework.notice.web;

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

import egovframework.notice.service.NoticeService;
import egovframework.notice.service.NoticeDefaultVO;
import egovframework.notice.service.NoticeVO;

/**
 * @Class Name : NoticeController.java
 * @Description : Notice Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=NoticeVO.class)
public class NoticeController {

    @Resource(name = "noticeService")
    private NoticeService noticeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * notice 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 NoticeDefaultVO
	 * @return "/notice/NoticeList"
	 * @exception Exception
	 */
    
    @RequestMapping(value="/notice/NoticeMgr.do")
    public String NoticeMgr(NoticeVO vo, ModelMap model
    		, HttpServletRequest request) throws Exception {
    	String param = (String)request.getParameter("param");
    	if(param.equals("list")) {
    		//NoticeDefaultVO searchVO = new NoticeDefaultVO();
    		List<?> noticeList = noticeService.selectNoticeList(vo);
            model.addAttribute("resultList", noticeList);
    	} else if(param.equals("search")) {
    		//String id = (String)request.getParameter("id");
    		//NoticeVO vo = new NoticeVO();
    		//vo.setId(Integer.parseInt(id));
    		System.out.println("id : " + vo.getId());
    		System.out.println("subject : " + vo.getSubject());
    		vo = noticeService.selectNotice(vo);
    		System.out.println("id : " + vo.getId());
    		System.out.println("subject : " + vo.getSubject());
    		model.addAttribute("searchedVO", vo);
    		param = "regist";
    	} else if(param.equals("regist")) {
    		if(vo.getId()>0)
    			noticeService.updateNotice(vo);
    		else
    			noticeService.insertNotice(vo);
    		return "forward:/notice/NoticeMgr.do?param=list";
    			
    	}  	    	
    	System.out.println("\n\n\n /notice/NoticeMgr.do?param=" + param);
    	return "forward:/NoticeMgr.jsp?param=" + param;
    }
    
    @RequestMapping(value="/notice/NoticeList.do")
    public String selectNoticeList(@ModelAttribute("searchVO") NoticeDefaultVO searchVO, 
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
		
        List<?> noticeList = noticeService.selectNoticeList(searchVO);
        model.addAttribute("resultList", noticeList);
        
        int totCnt = noticeService.selectNoticeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/notice/NoticeList";
    } 
    
    @RequestMapping("/notice/addNoticeView.do")
    public String addNoticeView(
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("noticeVO", new NoticeVO());
        return "/notice/NoticeRegister";
    }
    
    @RequestMapping("/notice/addNotice.do")
    public String addNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.insertNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }
    
    @RequestMapping("/notice/updateNoticeView.do")
    public String updateNoticeView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, Model model)
            throws Exception {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setId(id);        
        // 변수명은 CoC 에 따라 noticeVO
        model.addAttribute(selectNotice(noticeVO, searchVO));
        return "/notice/NoticeRegister";
    }

    @RequestMapping("/notice/selectNotice.do")
    public @ModelAttribute("noticeVO")
    NoticeVO selectNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO) throws Exception {
        return noticeService.selectNotice(noticeVO);
    }

    @RequestMapping("/notice/updateNotice.do")
    public String updateNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.updateNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }
    
    @RequestMapping("/notice/deleteNotice.do")
    public String deleteNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.deleteNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }

}
