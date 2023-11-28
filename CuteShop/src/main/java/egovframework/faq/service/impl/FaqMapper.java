package egovframework.faq.service.impl;

import java.util.List;

import egovframework.faq.service.FaqVO;
import egovframework.faq.service.FaqDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : FaqMapper.java
 * @Description : Faq Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("faqMapper")
public interface FaqMapper {

	/**
	 * faq을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FaqVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertFaq(FaqVO vo) throws Exception;

    /**
	 * faq을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FaqVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFaq(FaqVO vo) throws Exception;

    /**
	 * faq을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FaqVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFaq(FaqVO vo) throws Exception;

    /**
	 * faq을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FaqVO
	 * @return 조회한 faq
	 * @exception Exception
	 */
    public FaqVO selectFaq(FaqVO vo) throws Exception;

    /**
	 * faq 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return faq 목록
	 * @exception Exception
	 */
    public List<?> selectFaqList(FaqDefaultVO searchVO) throws Exception;

    /**
	 * faq 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return faq 총 갯수
	 * @exception
	 */
    public int selectFaqListTotCnt(FaqDefaultVO searchVO);

}
