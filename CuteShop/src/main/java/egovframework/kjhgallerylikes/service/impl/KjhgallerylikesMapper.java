package egovframework.kjhgallerylikes.service.impl;

import java.util.List;

import egovframework.kjhgallerylikes.service.KjhgallerylikesVO;
import egovframework.kjhgallerylikes.service.KjhgallerylikesDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : KjhgallerylikesMapper.java
 * @Description : Kjhgallerylikes Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("kjhgallerylikesMapper")
public interface KjhgallerylikesMapper {

	/**
	 * kjhgallerylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgallerylikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;

    /**
	 * kjhgallerylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgallerylikesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;

    /**
	 * kjhgallerylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgallerylikesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;

    /**
	 * kjhgallerylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgallerylikesVO
	 * @return 조회한 kjhgallerylikes
	 * @exception Exception
	 */
    public KjhgallerylikesVO selectKjhgallerylikes(KjhgallerylikesVO vo) throws Exception;

    /**
	 * kjhgallerylikes 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhgallerylikes 목록
	 * @exception Exception
	 */
    public List<?> selectKjhgallerylikesList(KjhgallerylikesDefaultVO searchVO) throws Exception;

    /**
	 * kjhgallerylikes 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhgallerylikes 총 갯수
	 * @exception
	 */
    public int selectKjhgallerylikesListTotCnt(KjhgallerylikesDefaultVO searchVO);

}
