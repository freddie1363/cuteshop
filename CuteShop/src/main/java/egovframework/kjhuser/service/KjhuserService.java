package egovframework.kjhuser.service;

import java.util.List;
import egovframework.kjhuser.service.KjhuserDefaultVO;
import egovframework.kjhuser.service.KjhuserVO;

/**
 * @Class Name : KjhuserService.java
 * @Description : Kjhuser Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface KjhuserService {
	
	/**
	 * kjhuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertKjhuser(KjhuserVO vo) throws Exception;
    
    /**
	 * kjhuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhuserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateKjhuser(KjhuserVO vo) throws Exception;
    
    /**
	 * kjhuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhuserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteKjhuser(KjhuserVO vo) throws Exception;
    
    /**
	 * kjhuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhuserVO
	 * @return 조회한 kjhuser
	 * @exception Exception
	 */
    KjhuserVO selectKjhuser(KjhuserVO vo) throws Exception;
    
    /**
	 * kjhuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhuser 목록
	 * @exception Exception
	 */
    List selectKjhuserList(KjhuserDefaultVO searchVO) throws Exception;
    
    /**
	 * kjhuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhuser 총 갯수
	 * @exception
	 */
    int selectKjhuserListTotCnt(KjhuserDefaultVO searchVO);
    
    KjhuserVO checkUserLogin(KjhuserVO userVO);
    
    KjhuserVO userJoin(KjhuserVO userVO) throws Exception;
    
    KjhuserVO findId(KjhuserVO vo) throws Exception;
    
    KjhuserVO findPw(KjhuserVO vo) throws Exception;
}
