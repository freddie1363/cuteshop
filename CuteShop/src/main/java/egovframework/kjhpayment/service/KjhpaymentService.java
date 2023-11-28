package egovframework.kjhpayment.service;

import java.util.List;
import egovframework.kjhpayment.service.KjhpaymentDefaultVO;
import egovframework.kjhpayment.service.KjhpaymentVO;

/**
 * @Class Name : KjhpaymentService.java
 * @Description : Kjhpayment Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface KjhpaymentService {
	
	/**
	 * kjhpayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertKjhpayment(KjhpaymentVO vo) throws Exception;
    
    /**
	 * kjhpayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateKjhpayment(KjhpaymentVO vo) throws Exception;
    
    /**
	 * kjhpayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteKjhpayment(KjhpaymentVO vo) throws Exception;
    
    /**
	 * kjhpayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhpaymentVO
	 * @return 조회한 kjhpayment
	 * @exception Exception
	 */
    KjhpaymentVO selectKjhpayment(KjhpaymentVO vo) throws Exception;
    
    /**
	 * kjhpayment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhpayment 목록
	 * @exception Exception
	 */
    List selectKjhpaymentList(KjhpaymentDefaultVO searchVO) throws Exception;
    
    /**
	 * kjhpayment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhpayment 총 갯수
	 * @exception
	 */
    int selectKjhpaymentListTotCnt(KjhpaymentDefaultVO searchVO);
    
}
