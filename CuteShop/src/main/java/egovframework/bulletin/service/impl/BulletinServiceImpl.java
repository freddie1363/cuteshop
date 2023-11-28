package egovframework.bulletin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.bulletin.service.BulletinService;
import egovframework.bulletin.service.BulletinDefaultVO;
import egovframework.bulletin.service.BulletinVO;
import egovframework.bulletin.service.impl.BulletinMapper;
/**
 * @Class Name : BulletinServiceImpl.java
 * @Description : Bulletin Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-03-23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("bulletinService")
public class BulletinServiceImpl extends EgovAbstractServiceImpl implements
        BulletinService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(BulletinServiceImpl.class);

    @Resource(name="bulletinMapper")
    private BulletinMapper bulletinDAO;
    
    //@Resource(name="bulletinDAO")
    //private BulletinDAO bulletinDAO;
    
    /** ID Generation */
    //@Resource(name="{egovBulletinIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * bulletin을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BulletinVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBulletin(BulletinVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	bulletinDAO.insertBulletin(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * bulletin을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BulletinVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBulletin(BulletinVO vo) throws Exception {
        bulletinDAO.updateBulletin(vo);
    }

    /**
	 * bulletin을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BulletinVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBulletin(BulletinVO vo) throws Exception {
        bulletinDAO.deleteBulletin(vo);
    }

    /**
	 * bulletin을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BulletinVO
	 * @return 조회한 bulletin
	 * @exception Exception
	 */
    public BulletinVO selectBulletin(BulletinVO vo) throws Exception {
        BulletinVO resultVO = bulletinDAO.selectBulletin(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * bulletin 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return bulletin 목록
	 * @exception Exception
	 */
    public List<?> selectBulletinList(BulletinDefaultVO searchVO) throws Exception {
        return bulletinDAO.selectBulletinList(searchVO);
    }

    /**
	 * bulletin 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return bulletin 총 갯수
	 * @exception
	 */
    public int selectBulletinListTotCnt(BulletinDefaultVO searchVO) {
		return bulletinDAO.selectBulletinListTotCnt(searchVO);
	}
    
}
