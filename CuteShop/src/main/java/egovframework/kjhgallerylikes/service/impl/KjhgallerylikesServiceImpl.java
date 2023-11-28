package egovframework.kjhgallerylikes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.kjhgallerylikes.service.KjhgallerylikesService;
import egovframework.kjhgallerylikes.service.KjhgallerylikesDefaultVO;
import egovframework.kjhgallerylikes.service.KjhgallerylikesVO;
import egovframework.kjhgallerylikes.service.impl.KjhgallerylikesMapper;
/**
 * @Class Name : KjhgallerylikesServiceImpl.java
 * @Description : Kjhgallerylikes Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("kjhgallerylikesService")
public class KjhgallerylikesServiceImpl extends EgovAbstractServiceImpl implements
        KjhgallerylikesService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(KjhgallerylikesServiceImpl.class);

    @Resource(name="kjhgallerylikesMapper")
    private KjhgallerylikesMapper kjhgallerylikesDAO;
    
    //@Resource(name="kjhgallerylikesDAO")
    //private KjhgallerylikesDAO kjhgallerylikesDAO;
    
    /** ID Generation */
    //@Resource(name="{egovKjhgallerylikesIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * kjhgallerylikes을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhgallerylikesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertKjhgallerylikes(KjhgallerylikesVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	kjhgallerylikesDAO.insertKjhgallerylikes(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * kjhgallerylikes을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhgallerylikesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhgallerylikes(KjhgallerylikesVO vo) throws Exception {
        kjhgallerylikesDAO.updateKjhgallerylikes(vo);
    }

    /**
	 * kjhgallerylikes을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhgallerylikesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhgallerylikes(KjhgallerylikesVO vo) throws Exception {
        kjhgallerylikesDAO.deleteKjhgallerylikes(vo);
    }

    /**
	 * kjhgallerylikes을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhgallerylikesVO
	 * @return 조회한 kjhgallerylikes
	 * @exception Exception
	 */
    public KjhgallerylikesVO selectKjhgallerylikes(KjhgallerylikesVO vo) throws Exception {
        KjhgallerylikesVO resultVO = kjhgallerylikesDAO.selectKjhgallerylikes(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * kjhgallerylikes 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallerylikes 목록
	 * @exception Exception
	 */
    public List<?> selectKjhgallerylikesList(KjhgallerylikesDefaultVO searchVO) throws Exception {
        return kjhgallerylikesDAO.selectKjhgallerylikesList(searchVO);
    }

    /**
	 * kjhgallerylikes 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhgallerylikes 총 갯수
	 * @exception
	 */
    public int selectKjhgallerylikesListTotCnt(KjhgallerylikesDefaultVO searchVO) {
		return kjhgallerylikesDAO.selectKjhgallerylikesListTotCnt(searchVO);
	}
    
}
