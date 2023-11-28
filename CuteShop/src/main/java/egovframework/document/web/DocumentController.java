package egovframework.document.web;

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

import egovframework.document.service.DocumentService;
import egovframework.document.service.DocumentDefaultVO;
import egovframework.document.service.DocumentVO;

/**
 * @Class Name : DocumentController.java
 * @Description : Document Controller class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=DocumentVO.class)
public class DocumentController {

    @Resource(name = "documentService")
    private DocumentService documentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * document 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DocumentDefaultVO
	 * @return "/document/DocumentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/document/DocumentList.do")
    public String selectDocumentList(@ModelAttribute("searchVO") DocumentDefaultVO searchVO, 
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
		
        List<?> documentList = documentService.selectDocumentList(searchVO);
        model.addAttribute("resultList", documentList);
        
        int totCnt = documentService.selectDocumentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "documentMgr";//"/document/DocumentList";
    } 
    
    @RequestMapping("/document/addDocumentView.do")
    public String addDocumentView(
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("documentVO", new DocumentVO());
        return "/document/DocumentRegister";
    }
    
    @RequestMapping("/document/addDocument.do")
    public String addDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.insertDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }
    
    @RequestMapping("/document/updateDocumentView.do")
    public String updateDocumentView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, Model model)
            throws Exception {
        DocumentVO documentVO = new DocumentVO();
        documentVO.setId(id);        
        // 변수명은 CoC 에 따라 documentVO
        //model.addAttribute(selectDocument(documentVO, searchVO));
        return "/document/DocumentRegister";
    }

    @RequestMapping("/document/selectDocument.do")
    public String selectDocument(
            DocumentVO documentVO,
            HttpServletRequest request) throws Exception {
    	DocumentVO vo = documentService.selectDocument(documentVO);
    	request.getSession().setAttribute("selectedVO", vo);
        return "forward:/documentMgr.jsp?param=regist";
    }

    @RequestMapping("/document/updateDocument.do")
    public String updateDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.updateDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }
    
    @RequestMapping("/document/deleteDocument.do")
    public String deleteDocument(
            DocumentVO documentVO,
            @ModelAttribute("searchVO") DocumentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        documentService.deleteDocument(documentVO);
        status.setComplete();
        return "forward:/document/DocumentList.do";
    }

}
