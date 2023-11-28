package egovframework.faq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.faq.service.FaqService;
import egovframework.faq.service.FaqDefaultVO;
import egovframework.faq.service.FaqVO;
import egovframework.faq.service.impl.FaqMapper;
/**
 * @Class Name : FaqServiceImpl.java
 * @Description : Faq Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("faqService")
public class FaqServiceImpl extends EgovAbstractServiceImpl implements
        FaqService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(FaqServiceImpl.class);

    @Resource(name="faqMapper")
    private FaqMapper faqDAO;
    
    //@Resource(name="faqDAO")
    //private FaqDAO faqDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFaqIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * faq을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FaqVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFaq(FaqVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	faqDAO.insertFaq(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * faq을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FaqVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFaq(FaqVO vo) throws Exception {
        faqDAO.updateFaq(vo);
    }

    /**
	 * faq을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FaqVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFaq(FaqVO vo) throws Exception {
        faqDAO.deleteFaq(vo);
    }

    /**
	 * faq을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FaqVO
	 * @return 조회한 faq
	 * @exception Exception
	 */
    public FaqVO selectFaq(FaqVO vo) throws Exception {
        FaqVO resultVO = faqDAO.selectFaq(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * faq 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return faq 목록
	 * @exception Exception
	 */
    public List<?> selectFaqList(FaqDefaultVO searchVO) throws Exception {
        return faqDAO.selectFaqList(searchVO);
    }

    /**
	 * faq 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return faq 총 갯수
	 * @exception
	 */
    public int selectFaqListTotCnt(FaqDefaultVO searchVO) {
		return faqDAO.selectFaqListTotCnt(searchVO);
	}
    
}
