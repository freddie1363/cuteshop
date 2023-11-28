package egovframework.bulletin.service.impl;

import java.util.List;

import egovframework.bulletin.service.BulletinVO;
import egovframework.bulletin.service.BulletinDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : BulletinMapper.java
 * @Description : Bulletin Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("bulletinMapper")
public interface BulletinMapper {

	/**
	 * bulletin을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BulletinVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertBulletin(BulletinVO vo) throws Exception;

    /**
	 * bulletin을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BulletinVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBulletin(BulletinVO vo) throws Exception;

    /**
	 * bulletin을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BulletinVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBulletin(BulletinVO vo) throws Exception;

    /**
	 * bulletin을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BulletinVO
	 * @return 조회한 bulletin
	 * @exception Exception
	 */
    public BulletinVO selectBulletin(BulletinVO vo) throws Exception;

    /**
	 * bulletin 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return bulletin 목록
	 * @exception Exception
	 */
    public List<?> selectBulletinList(BulletinDefaultVO searchVO) throws Exception;

    /**
	 * bulletin 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return bulletin 총 갯수
	 * @exception
	 */
    public int selectBulletinListTotCnt(BulletinDefaultVO searchVO);

}
