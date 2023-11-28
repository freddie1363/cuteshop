package egovframework.kjhpayment.service.impl;

import java.util.List;

import egovframework.kjhpayment.service.KjhpaymentVO;
import egovframework.kjhpayment.service.KjhpaymentDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : KjhpaymentMapper.java
 * @Description : Kjhpayment Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("kjhpaymentMapper")
public interface KjhpaymentMapper {

	/**
	 * kjhpayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertKjhpayment(KjhpaymentVO vo) throws Exception;

    /**
	 * kjhpayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhpayment(KjhpaymentVO vo) throws Exception;

    /**
	 * kjhpayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhpayment(KjhpaymentVO vo) throws Exception;

    /**
	 * kjhpayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhpaymentVO
	 * @return 조회한 kjhpayment
	 * @exception Exception
	 */
    public KjhpaymentVO selectKjhpayment(KjhpaymentVO vo) throws Exception;

    /**
	 * kjhpayment 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhpayment 목록
	 * @exception Exception
	 */
    public List<?> selectKjhpaymentList(KjhpaymentDefaultVO searchVO) throws Exception;

    /**
	 * kjhpayment 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhpayment 총 갯수
	 * @exception
	 */
    public int selectKjhpaymentListTotCnt(KjhpaymentDefaultVO searchVO);

}
