package egovframework.kjhgallerylikes.service;

import java.util.List;
import egovframework.kjhgallerylikes.service.KjhgallerylikesDefaultVO;
import egovframework.kjhgallerylikes.service.KjhgallerylikesVO;

/**
 * @Class Name : KjhgallerylikesService.java
 * @Description : Kjhgallerylikes Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface KjhgallerylikesService {
	
	/**
	 * kjhgallerylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgallerylikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;
    
    /**
	 * kjhgallerylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgallerylikesVO
	 * @return void형
	 * @exception Exception
	 */
    void updateKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;
    
    /**
	 * kjhgallerylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgallerylikesVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;
    
    /**
	 * kjhgallerylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgallerylikesVO
	 * @return 조회한 kjhgallerylikes
	 * @exception Exception
	 */
    KjhgallerylikesVO selectKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;
    
    /**
	 * kjhgallerylikes 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallerylikes 목록
	 * @exception Exception
	 */
    List selectKjhgallerylikesList(KjhgallerylikesDefaultVO searchVO) throws Exception;
    
    /**
	 * kjhgallerylikes 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallerylikes 총 갯수
	 * @exception
	 */
    int selectKjhgallerylikesListTotCnt(KjhgallerylikesDefaultVO searchVO);
    
}
