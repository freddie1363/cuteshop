package egovframework.kjhcomment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.kjhcomment.service.KjhcommentService;
import egovframework.kjhcomment.service.KjhcommentDefaultVO;
import egovframework.kjhcomment.service.KjhcommentVO;
import egovframework.kjhcomment.service.impl.KjhcommentMapper;
import egovframework.kjhgallery.service.KjhgalleryVO;
/**
 * @Class Name : KjhcommentServiceImpl.java
 * @Description : Kjhcomment Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("kjhcommentService")
public class KjhcommentServiceImpl extends EgovAbstractServiceImpl implements
        KjhcommentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(KjhcommentServiceImpl.class);

    @Resource(name="kjhcommentMapper")
    private KjhcommentMapper kjhcommentDAO;
    
    //@Resource(name="kjhcommentDAO")
    //private KjhcommentDAO kjhcommentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovKjhcommentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * kjhcomment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhcommentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertKjhcomment(KjhcommentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	kjhcommentDAO.insertKjhcomment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * kjhcomment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhcommentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhcomment(KjhcommentVO vo) throws Exception {
        kjhcommentDAO.updateKjhcomment(vo);
    }

    /**
	 * kjhcomment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhcommentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhcomment(KjhcommentVO vo) throws Exception {
        kjhcommentDAO.deleteKjhcomment(vo);
    }

    /**
	 * kjhcomment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhcommentVO
	 * @return 조회한 kjhcomment
	 * @exception Exception
	 */
    public KjhcommentVO selectKjhcomment(KjhcommentVO vo) throws Exception {
        KjhcommentVO resultVO = kjhcommentDAO.selectKjhcomment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * kjhcomment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhcomment 목록
	 * @exception Exception
	 */
//    public List<?> selectKjhcommentList(KjhcommentDefaultVO searchVO) throws Exception {
//        return kjhcommentDAO.selectKjhcommentList(searchVO);
//    }

    public List<?> selectKjhcommentList(KjhgalleryVO vo) throws Exception {
        return kjhcommentDAO.selectKjhcommentList(vo);
    }
    
    /**
	 * kjhcomment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhcomment 총 갯수
	 * @exception
	 */
    public int selectKjhcommentListTotCnt(KjhcommentDefaultVO searchVO) {
		return kjhcommentDAO.selectKjhcommentListTotCnt(searchVO);
	}
    
}
