package egovframework.faq.service;

import java.util.List;
import egovframework.faq.service.FaqDefaultVO;
import egovframework.faq.service.FaqVO;

/**
 * @Class Name : FaqService.java
 * @Description : Faq Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FaqService {
	
	/**
	 * faq을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FaqVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFaq(FaqVO vo) throws Exception;
    
    /**
	 * faq을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FaqVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFaq(FaqVO vo) throws Exception;
    
    /**
	 * faq을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FaqVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFaq(FaqVO vo) throws Exception;
    
    /**
	 * faq을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FaqVO
	 * @return 조회한 faq
	 * @exception Exception
	 */
    FaqVO selectFaq(FaqVO vo) throws Exception;
    
    /**
	 * faq 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return faq 목록
	 * @exception Exception
	 */
    List selectFaqList(FaqDefaultVO searchVO) throws Exception;
    
    /**
	 * faq 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return faq 총 갯수
	 * @exception
	 */
    int selectFaqListTotCnt(FaqDefaultVO searchVO);
    
}
