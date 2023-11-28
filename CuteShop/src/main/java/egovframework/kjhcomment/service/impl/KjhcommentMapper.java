package egovframework.kjhcomment.service.impl;

import java.util.List;

import egovframework.kjhcomment.service.KjhcommentVO;
import egovframework.kjhgallery.service.KjhgalleryVO;
import egovframework.kjhcomment.service.KjhcommentDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : KjhcommentMapper.java
 * @Description : Kjhcomment Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("kjhcommentMapper")
public interface KjhcommentMapper {

	/**
	 * kjhcomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertKjhcomment(KjhcommentVO vo) throws Exception;

    /**
	 * kjhcomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhcommentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhcomment(KjhcommentVO vo) throws Exception;

    /**
	 * kjhcomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhcomment(KjhcommentVO vo) throws Exception;

    /**
	 * kjhcomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhcommentVO
	 * @return 조회한 kjhcomment
	 * @exception Exception
	 */
    public KjhcommentVO selectKjhcomment(KjhcommentVO vo) throws Exception;

    /**
	 * kjhcomment 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhcomment 목록
	 * @exception Exception
	 */
//    public List<?> selectKjhcommentList(KjhcommentDefaultVO searchVO) throws Exception;
    public List<?> selectKjhcommentList(KjhgalleryVO vo) throws Exception;
    /**
	 * kjhcomment 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhcomment 총 갯수
	 * @exception
	 */
    public int selectKjhcommentListTotCnt(KjhcommentDefaultVO searchVO);

}
