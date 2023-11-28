package egovframework.kjhgallery.service.impl;

import java.util.List;

import egovframework.kjhgallery.service.KjhgalleryVO;
import egovframework.kjhgallery.service.KjhgalleryDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : KjhgalleryMapper.java
 * @Description : Kjhgallery Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("kjhgalleryMapper")
public interface KjhgalleryMapper {

	/**
	 * kjhgallery을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgalleryVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertKjhgallery(KjhgalleryVO vo) throws Exception;

    /**
	 * kjhgallery을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgalleryVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhgallery(KjhgalleryVO vo) throws Exception;

    /**
	 * kjhgallery을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgalleryVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhgallery(KjhgalleryVO vo) throws Exception;

    /**
	 * kjhgallery을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgalleryVO
	 * @return 조회한 kjhgallery
	 * @exception Exception
	 */
    public KjhgalleryVO selectKjhgallery(KjhgalleryVO vo) throws Exception;

    /**
	 * kjhgallery 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhgallery 목록
	 * @exception Exception
	 */
    public List<?> selectKjhgalleryList(KjhgalleryDefaultVO searchVO) throws Exception;

    /**
	 * kjhgallery 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhgallery 총 갯수
	 * @exception
	 */
    public int selectKjhgalleryListTotCnt(KjhgalleryDefaultVO searchVO);
    
    public List<?> selectSearchList(KjhgalleryDefaultVO searchVO) throws Exception;

	public void decreaseBoardLikes(KjhgalleryVO vo) throws Exception;
	public void increaseBoardLikes(KjhgalleryVO vo) throws Exception;

	public void updateViews(KjhgalleryVO vo) throws Exception;
}
