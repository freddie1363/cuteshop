package egovframework.kjhcomment.service;

import java.util.List;
import egovframework.kjhcomment.service.KjhcommentDefaultVO;
import egovframework.kjhcomment.service.KjhcommentVO;
import egovframework.kjhgallery.service.KjhgalleryVO;

/**
 * @Class Name : KjhcommentService.java
 * @Description : Kjhcomment Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface KjhcommentService {
	
	/**
	 * kjhcomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertKjhcomment(KjhcommentVO vo) throws Exception;
    
    /**
	 * kjhcomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhcommentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateKjhcomment(KjhcommentVO vo) throws Exception;
    
    /**
	 * kjhcomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteKjhcomment(KjhcommentVO vo) throws Exception;
    
    /**
	 * kjhcomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhcommentVO
	 * @return 조회한 kjhcomment
	 * @exception Exception
	 */
    KjhcommentVO selectKjhcomment(KjhcommentVO vo) throws Exception;
    
    /**
	 * kjhcomment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhcomment 목록
	 * @exception Exception
	 */
    //List selectKjhcommentList(KjhcommentDefaultVO searchVO) throws Exception;
    List selectKjhcommentList(KjhgalleryVO vo) throws Exception;
    /**
	 * kjhcomment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhcomment 총 갯수
	 * @exception
	 */
    int selectKjhcommentListTotCnt(KjhcommentDefaultVO searchVO);
    
}
