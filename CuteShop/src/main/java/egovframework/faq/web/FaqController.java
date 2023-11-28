package egovframework.faq.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.faq.service.FaqService;
import egovframework.faq.service.FaqDefaultVO;
import egovframework.faq.service.FaqVO;

/**
 * @Class Name : FaqController.java
 * @Description : Faq Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=FaqVO.class)
public class FaqController {

    @Resource(name = "faqService")
    private FaqService faqService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * faq 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 FaqDefaultVO
	 * @return "/faq/FaqList"
	 * @exception Exception
	 */
    @RequestMapping(value="/faq/searchFaqVO.do")
    public @ResponseBody ModelAndView searchFaqVO(FaqVO vo) throws Exception {
    	vo = faqService.selectFaq(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("searchedVO",vo);
    	return jsonView;
    }
    
    @RequestMapping(value="/faq/getFaqVOListJson.do")
    public @ResponseBody ModelAndView getFaqVOListJson(FaqVO vo) throws Exception {
    	List<?> faqList = faqService.selectFaqList(vo);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("faqVOList",faqList);
    	return jsonView;
    }
    
    @RequestMapping(value="/faq/FaqMgr.do")
    public String FaqMgr(FaqVO vo, ModelMap model
    		, HttpServletRequest request) throws Exception {
    	String param = (String)request.getParameter("param");
    	if(param.equals("list")) {
    		//FaqDefaultVO searchVO = new FaqDefaultVO();
    		List<?> faqList = faqService.selectFaqList(vo);
            model.addAttribute("resultList", faqList);
    	} else if(param.equals("search")) {
    		//String id = (String)request.getParameter("id");
    		//FaqVO vo = new FaqVO();
    		//vo.setId(Integer.parseInt(id));
    		System.out.println("id : " + vo.getId());
    		System.out.println("subject : " + vo.getSubject());
    		vo = faqService.selectFaq(vo);
    		System.out.println("id : " + vo.getId());
    		System.out.println("subject : " + vo.getSubject());
    		model.addAttribute("searchedVO", vo);
    		param = "regist";
    	} else if(param.equals("regist")) {
    		if(vo.getId()>0)
    			faqService.updateFaq(vo);
    		else
    			faqService.insertFaq(vo);
    		return "forward:/faq/FaqMgr.do?param=list";
    			
    	}  	    	
    	System.out.println("\n\n\n /faq/FaqMgr.do?param=" + param);
    	return "forward:/FaqMgr.jsp?param=" + param;
    }
    
    @RequestMapping(value="/faq/insertFaqVO.do")
    public String insertFaqVO(final MultipartHttpServletRequest multiRequest,FaqVO vo, ModelMap model) throws Exception {
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
    			faqService.insertFaq(vo);
    		}
    	}
    	return "forward:/FaqMgr.jsp?param=list";
    }
    
    
    
    
    
    
    @RequestMapping(value="/faq/FaqList.do")
    public String selectFaqList(@ModelAttribute("searchVO") FaqDefaultVO searchVO, 
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
		
        List<?> faqList = faqService.selectFaqList(searchVO);
        model.addAttribute("resultList", faqList);
        
        int totCnt = faqService.selectFaqListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/faq/FaqList";
    } 
    
    @RequestMapping("/faq/addFaqView.do")
    public String addFaqView(
            @ModelAttribute("searchVO") FaqDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("faqVO", new FaqVO());
        return "/faq/FaqRegister";
    }
    
    @RequestMapping("/faq/addFaq.do")
    public String addFaq(
            FaqVO faqVO,
            @ModelAttribute("searchVO") FaqDefaultVO searchVO, SessionStatus status)
            throws Exception {
        faqService.insertFaq(faqVO);
        status.setComplete();
        return "forward:/faq/FaqList.do";
    }
    
    @RequestMapping("/faq/updateFaqView.do")
    public String updateFaqView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") FaqDefaultVO searchVO, Model model)
            throws Exception {
        FaqVO faqVO = new FaqVO();
        faqVO.setId(id);        
        // 변수명은 CoC 에 따라 faqVO
        model.addAttribute(selectFaq(faqVO, searchVO));
        return "/faq/FaqRegister";
    }

    @RequestMapping("/faq/selectFaq.do")
    public @ModelAttribute("faqVO")
    FaqVO selectFaq(
            FaqVO faqVO,
            @ModelAttribute("searchVO") FaqDefaultVO searchVO) throws Exception {
        return faqService.selectFaq(faqVO);
    }

    @RequestMapping("/faq/updateFaq.do")
    public String updateFaq(
            FaqVO faqVO,
            @ModelAttribute("searchVO") FaqDefaultVO searchVO, SessionStatus status)
            throws Exception {
        faqService.updateFaq(faqVO);
        status.setComplete();
        return "forward:/faq/FaqList.do";
    }
    
    @RequestMapping("/faq/deleteFaq.do")
    public String deleteFaq(
            FaqVO faqVO,
            @ModelAttribute("searchVO") FaqDefaultVO searchVO, SessionStatus status)
            throws Exception {
        faqService.deleteFaq(faqVO);
        status.setComplete();
        return "forward:/faq/FaqList.do";
    }

}
