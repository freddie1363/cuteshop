package egovframework.bulletin.web;

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

import egovframework.bulletin.service.BulletinService;
import egovframework.bulletin.service.BulletinDefaultVO;
import egovframework.bulletin.service.BulletinVO;

/**
 * @Class Name : BulletinController.java
 * @Description : Bulletin Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=BulletinVO.class)
public class BulletinController {

    @Resource(name = "bulletinService")
    private BulletinService bulletinService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * bulletin 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 BulletinDefaultVO
	 * @return "/bulletin/BulletinList"
	 * @exception Exception
	 */
    @RequestMapping(value="/bulletin/BulletinList.do")
    public String selectBulletinList(@ModelAttribute("searchVO") BulletinDefaultVO searchVO, 
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
		
        List<?> bulletinList = bulletinService.selectBulletinList(searchVO);
        model.addAttribute("resultList", bulletinList);
        
        int totCnt = bulletinService.selectBulletinListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/bulletin/BulletinList";
    } 
    
    @RequestMapping("/bulletin/addBulletinView.do")
    public String addBulletinView(
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("bulletinVO", new BulletinVO());
        return "/bulletin/BulletinRegister";
    }
    
    @RequestMapping("/bulletin/addBulletin.do")
    public String addBulletin(
            BulletinVO bulletinVO,
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO, SessionStatus status)
            throws Exception {
        bulletinService.insertBulletin(bulletinVO);
        status.setComplete();
        return "forward:/bulletin/BulletinList.do";
    }
    
    @RequestMapping("/bulletin/updateBulletinView.do")
    public String updateBulletinView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO, Model model)
            throws Exception {
        BulletinVO bulletinVO = new BulletinVO();
        bulletinVO.setId(id);        
        // 변수명은 CoC 에 따라 bulletinVO
        model.addAttribute(selectBulletin(bulletinVO, searchVO));
        return "/bulletin/BulletinRegister";
    }

    @RequestMapping("/bulletin/selectBulletin.do")
    public @ModelAttribute("bulletinVO")
    BulletinVO selectBulletin(
            BulletinVO bulletinVO,
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO) throws Exception {
        return bulletinService.selectBulletin(bulletinVO);
    }

    @RequestMapping("/bulletin/updateBulletin.do")
    public String updateBulletin(
            BulletinVO bulletinVO,
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO, SessionStatus status)
            throws Exception {
        bulletinService.updateBulletin(bulletinVO);
        status.setComplete();
        return "forward:/bulletin/BulletinList.do";
    }
    
    @RequestMapping("/bulletin/deleteBulletin.do")
    public String deleteBulletin(
            BulletinVO bulletinVO,
            @ModelAttribute("searchVO") BulletinDefaultVO searchVO, SessionStatus status)
            throws Exception {
        bulletinService.deleteBulletin(bulletinVO);
        status.setComplete();
        return "forward:/bulletin/BulletinList.do";
    }

}
