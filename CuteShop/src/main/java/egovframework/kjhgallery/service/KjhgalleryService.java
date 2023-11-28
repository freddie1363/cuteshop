package egovframework.kjhgallery.service;

import java.util.List;
import egovframework.kjhgallery.service.KjhgalleryDefaultVO;
import egovframework.kjhgallery.service.KjhgalleryVO;

/**
 * @Class Name : KjhgalleryService.java
 * @Description : Kjhgallery Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface KjhgalleryService {
	
	/**
	 * kjhgallery을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgalleryVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertKjhgallery(KjhgalleryVO vo) throws Exception;
    
    /**
	 * kjhgallery을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgalleryVO
	 * @return void형
	 * @exception Exception
	 */
    void updateKjhgallery(KjhgalleryVO vo) throws Exception;
    
    /**
	 * kjhgallery을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgalleryVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteKjhgallery(KjhgalleryVO vo) throws Exception;
    
    /**
	 * kjhgallery을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgalleryVO
	 * @return 조회한 kjhgallery
	 * @exception Exception
	 */
    KjhgalleryVO selectKjhgallery(KjhgalleryVO vo) throws Exception;
    
    /**
	 * kjhgallery 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallery 목록
	 * @exception Exception
	 */
    List selectKjhgalleryList(KjhgalleryDefaultVO searchVO) throws Exception;
    
    /**
	 * kjhgallery 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallery 총 갯수
	 * @exception
	 */
    int selectKjhgalleryListTotCnt(KjhgalleryDefaultVO searchVO);
    
    KjhgalleryVO selectGallery(KjhgalleryVO vo) throws Exception;
    
    List selectSearchList(KjhgalleryDefaultVO searchVO) throws Exception;
    
    void increaseBoardLikes(KjhgalleryVO vo) throws Exception;
    void decreaseBoardLikes(KjhgalleryVO vo) throws Exception;
    
    void updateViews(KjhgalleryVO vo) throws Exception;
}
