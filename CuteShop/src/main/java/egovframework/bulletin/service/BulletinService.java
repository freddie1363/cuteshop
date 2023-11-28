package egovframework.bulletin.service;

import java.util.List;
import egovframework.bulletin.service.BulletinDefaultVO;
import egovframework.bulletin.service.BulletinVO;

/**
 * @Class Name : BulletinService.java
 * @Description : Bulletin Business class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface BulletinService {
	
	/**
	 * bulletin을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BulletinVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertBulletin(BulletinVO vo) throws Exception;
    
    /**
	 * bulletin을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BulletinVO
	 * @return void형
	 * @exception Exception
	 */
    void updateBulletin(BulletinVO vo) throws Exception;
    
    /**
	 * bulletin을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BulletinVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBulletin(BulletinVO vo) throws Exception;
    
    /**
	 * bulletin을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BulletinVO
	 * @return 조회한 bulletin
	 * @exception Exception
	 */
    BulletinVO selectBulletin(BulletinVO vo) throws Exception;
    
    /**
	 * bulletin 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return bulletin 목록
	 * @exception Exception
	 */
    List selectBulletinList(BulletinDefaultVO searchVO) throws Exception;
    
    /**
	 * bulletin 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return bulletin 총 갯수
	 * @exception
	 */
    int selectBulletinListTotCnt(BulletinDefaultVO searchVO);
    
}
