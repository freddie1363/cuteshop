package egovframework.kjhgallery.web;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.kjhgallery.service.KjhgalleryService;
import egovframework.kjhcomment.service.KjhcommentService;
import egovframework.kjhcomment.service.KjhcommentVO;
import egovframework.kjhgallery.service.KjhgalleryDefaultVO;
import egovframework.kjhgallery.service.KjhgalleryVO;

/**
 * @Class Name : KjhgalleryController.java
 * @Description : Kjhgallery Controller class
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
@SessionAttributes(types=KjhgalleryVO.class)
public class KjhgalleryController {

	@Resource(name = "kjhcommentService")
    private KjhcommentService kjhcommentService;
	
    @Resource(name = "kjhgalleryService")
    private KjhgalleryService kjhgalleryService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * kjhgallery 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 KjhgalleryDefaultVO
	 * @return "/kjhgallery/KjhgalleryList"
	 * @exception Exception
	 */
    
    
    @RequestMapping(value="/kjhgallery/selectSearchList.do")
    public String selectSearchList(@ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());//현재 페이지 번호
		paginationInfo.setRecordCountPerPage(4);//한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(8);//페이징 리스트의 사이즈
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> kjhgalleryList = kjhgalleryService.selectSearchList(searchVO);
        model.addAttribute("resultList2", kjhgalleryList);
        
        int totCnt = kjhgalleryService.selectKjhgalleryListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("keyword", searchVO);
        model.addAttribute("searchpaginationInfo", paginationInfo);
        //return "/kjhgallery/KjhgalleryList";
        return "gallerysearch";
        
        
    }
    
    
    
    @RequestMapping(value="/index.do")
    public String indexGalleryList(@ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());//현재 페이지 번호
		paginationInfo.setRecordCountPerPage(4);//한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(8);//페이징 리스트의 사이즈
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> kjhgalleryList = kjhgalleryService.selectKjhgalleryList(searchVO);
        model.addAttribute("resultList", kjhgalleryList);
        
        int totCnt = kjhgalleryService.selectKjhgalleryListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        //return "/kjhgallery/KjhgalleryList";
        return "main";
    }
     
    @RequestMapping(value="/kjhgallery/KjhgalleryList.do")
    public String selectKjhgalleryList(@ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());//현재 페이지 번호
		paginationInfo.setRecordCountPerPage(4);//한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(8);//페이징 리스트의 사이즈
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> kjhgalleryList = kjhgalleryService.selectKjhgalleryList(searchVO);
        model.addAttribute("resultList", kjhgalleryList);
        
        int totCnt = kjhgalleryService.selectKjhgalleryListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("keyword", searchVO);
        //return "/kjhgallery/KjhgalleryList";
        return "gallery";
    } 
    
    @RequestMapping("/kjhgallery/addKjhgalleryView.do")
    public String addKjhgalleryView(
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("kjhgalleryVO", new KjhgalleryVO());
        return "/kjhgallery/KjhgalleryRegister";
    }
    
    @RequestMapping("/kjhgallery/addKjhgallery.do")
    public String addKjhgallery(
            KjhgalleryVO kjhgalleryVO,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgalleryService.insertKjhgallery(kjhgalleryVO);
        status.setComplete();
        return "forward:/kjhgallery/KjhgalleryList.do";
    }
    
    @RequestMapping("/kjhgallery/updateKjhgalleryView.do")
    public String updateKjhgalleryView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, Model model)
            throws Exception {
        KjhgalleryVO kjhgalleryVO = new KjhgalleryVO();
        kjhgalleryVO.setId(id);        
        // 변수명은 CoC 에 따라 kjhgalleryVO
        model.addAttribute(selectKjhgallery(kjhgalleryVO, searchVO));
        return "/kjhgallery/KjhgalleryRegister";
    }
    
    
    
    @RequestMapping("/kjhgallery/selectGallery.do")
    public String selectGallery(KjhgalleryVO kjhgalleryvo, HttpServletRequest request, Model model) throws Exception {
    	kjhgalleryService.updateViews(kjhgalleryvo);
    	KjhgalleryVO vo = kjhgalleryService.selectKjhgallery(kjhgalleryvo);
    	request.getSession().setAttribute("selectedVO", vo);
    	
    	List<?> kjhcommentList = kjhcommentService.selectKjhcommentList(kjhgalleryvo);
        model.addAttribute("commentList", kjhcommentList);
        
    	
    	
    	return "gallerypost";
    }

    @RequestMapping("/kjhgallery/selectKjhgallery.do")
    public @ModelAttribute("kjhgalleryVO")
    KjhgalleryVO selectKjhgallery(
            KjhgalleryVO kjhgalleryVO,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO) throws Exception {
        return kjhgalleryService.selectKjhgallery(kjhgalleryVO);
    }

    @RequestMapping("/kjhgallery/updateKjhgallery.do")
    public String updateKjhgallery(
            KjhgalleryVO kjhgalleryVO,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgalleryService.updateKjhgallery(kjhgalleryVO);
        status.setComplete();
        return "forward:/kjhgallery/KjhgalleryList.do";
    }
    
    
    @RequestMapping("/kjhgallery/modifyKjhgalleryVO.do")
    public String modifyKjhgalleryVO(final MultipartHttpServletRequest multiRequest,
            KjhgalleryVO kjhgalleryVO,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	final Map<String, MultipartFile> files = multiRequest.getFileMap();
    	if(!files.isEmpty()) {
    		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    		MultipartFile file;
    		String filePath = "";
    		
    		while (itr.hasNext()) {
    			Entry<String, MultipartFile> entry = itr.next();
    			file = entry.getValue();
    			String originFileName = file.getOriginalFilename();
    			System.out.println("\n\nn" + originFileName + "\n");
    			filePath = "C:\\eGovFrame-3.10.0\\workspace.edu\\CuteShop\\src\\main\\webapp\\uploads\\" + originFileName;
    			file.transferTo(new File(filePath));
    			kjhgalleryVO.setAppendix("uploads\\" + originFileName); 	
    			kjhgalleryService.updateKjhgallery(kjhgalleryVO);
    	        status.setComplete();
    		}
    	} 

    	return "forward:/kjhgallery/KjhgalleryList.do";
    }
    
    @RequestMapping("/kjhgallery/deleteKjhgallery.do")
    public String deleteKjhgallery(
            KjhgalleryVO kjhgalleryVO,
            @ModelAttribute("searchVO") KjhgalleryDefaultVO searchVO, SessionStatus status)
            throws Exception {
        kjhgalleryService.deleteKjhgallery(kjhgalleryVO);
        status.setComplete();
        return "forward:/kjhgallery/KjhgalleryList.do";
    }
    
    @RequestMapping(value="/kjhgallery/insertKjhgalleryVO.do")
    public String insertKjhgalleryVO(final MultipartHttpServletRequest multiRequest,KjhgalleryVO vo, ModelMap model) throws Exception {
    	final Map<String, MultipartFile> files = multiRequest.getFileMap();    		
    	if(!files.isEmpty()) {
    		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    		MultipartFile file;
    		String filePath = "";
    		
    		while (itr.hasNext()) {
    			Entry<String, MultipartFile> entry = itr.next();
    			file = entry.getValue();
    			String originFileName = file.getOriginalFilename();
    			System.out.println("\n\nn" + originFileName + "\n");
    			filePath = "C:\\eGovFrame-3.10.0\\workspace.edu\\CuteShop\\src\\main\\webapp\\uploads\\" + originFileName;
    			file.transferTo(new File(filePath));
    			vo.setAppendix("uploads\\" + originFileName);
    			kjhgalleryService.insertKjhgallery(vo);
    		}
    	}
    	return "forward:/kjhgallery/KjhgalleryList.do";
    }
       
}
