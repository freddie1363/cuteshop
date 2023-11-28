package egovframework.kjhgallery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.kjhgallery.service.KjhgalleryService;
import egovframework.kjhgallery.service.KjhgalleryDefaultVO;
import egovframework.kjhgallery.service.KjhgalleryVO;
import egovframework.kjhgallery.service.impl.KjhgalleryMapper;
/**
 * @Class Name : KjhgalleryServiceImpl.java
 * @Description : Kjhgallery Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("kjhgalleryService")
public class KjhgalleryServiceImpl extends EgovAbstractServiceImpl implements
        KjhgalleryService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(KjhgalleryServiceImpl.class);

    @Resource(name="kjhgalleryMapper")
    private KjhgalleryMapper kjhgalleryDAO;
    
    //@Resource(name="kjhgalleryDAO")
    //private KjhgalleryDAO kjhgalleryDAO;
    
    /** ID Generation */
    //@Resource(name="{egovKjhgalleryIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * kjhgallery을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgalleryVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertKjhgallery(KjhgalleryVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	kjhgalleryDAO.insertKjhgallery(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * kjhgallery을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgalleryVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhgallery(KjhgalleryVO vo) throws Exception {
        kjhgalleryDAO.updateKjhgallery(vo);
    }

    /**
	 * kjhgallery을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgalleryVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhgallery(KjhgalleryVO vo) throws Exception {
        kjhgalleryDAO.deleteKjhgallery(vo);
    }

    /**
	 * kjhgallery을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgalleryVO
	 * @return 조회한 kjhgallery
	 * @exception Exception
	 */
    public KjhgalleryVO selectKjhgallery(KjhgalleryVO vo) throws Exception {
        KjhgalleryVO resultVO = kjhgalleryDAO.selectKjhgallery(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * kjhgallery 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallery 목록
	 * @exception Exception
	 */
    public List<?> selectKjhgalleryList(KjhgalleryDefaultVO searchVO) throws Exception {
        return kjhgalleryDAO.selectKjhgalleryList(searchVO);
    }

    /**
	 * kjhgallery 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallery 총 갯수
	 * @exception
	 */
    public int selectKjhgalleryListTotCnt(KjhgalleryDefaultVO searchVO) {
		return kjhgalleryDAO.selectKjhgalleryListTotCnt(searchVO);
	}

	@Override
	public KjhgalleryVO selectGallery(KjhgalleryVO vo) throws Exception {
		KjhgalleryVO resultVO = kjhgalleryDAO.selectKjhgallery(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
	}

	@Override
	public List<?> selectSearchList(KjhgalleryDefaultVO searchVO) throws Exception {
        return kjhgalleryDAO.selectSearchList(searchVO);
    }

	@Override
	public void increaseBoardLikes(KjhgalleryVO vo) throws Exception {
		kjhgalleryDAO.increaseBoardLikes(vo);
		
	}

	@Override
	public void decreaseBoardLikes(KjhgalleryVO vo) throws Exception {
		kjhgalleryDAO.decreaseBoardLikes(vo);
		
	}
    
	public void updateViews(KjhgalleryVO vo) throws Exception {
        kjhgalleryDAO.updateViews(vo);
    }
}
