package egovframework.kjhuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.kjhuser.service.KjhuserService;
import egovframework.kjhuser.service.KjhuserDefaultVO;
import egovframework.kjhuser.service.KjhuserVO;
import egovframework.kjhuser.service.impl.KjhuserMapper;
/**
 * @Class Name : KjhuserServiceImpl.java
 * @Description : Kjhuser Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("kjhuserService")
public class KjhuserServiceImpl extends EgovAbstractServiceImpl implements
        KjhuserService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(KjhuserServiceImpl.class);

    @Resource(name="kjhuserMapper")
    private KjhuserMapper kjhuserDAO;
    
    //@Resource(name="kjhuserDAO")
    //private KjhuserDAO kjhuserDAO;
    
    /** ID Generation */
    //@Resource(name="{egovKjhuserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * kjhuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertKjhuser(KjhuserVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	kjhuserDAO.insertKjhuser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * kjhuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhuser(KjhuserVO vo) throws Exception {
        kjhuserDAO.updateKjhuser(vo);
    }

    /**
	 * kjhuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhuser(KjhuserVO vo) throws Exception {
        kjhuserDAO.deleteKjhuser(vo);
    }

    /**
	 * kjhuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhuserVO
	 * @return 조회한 kjhuser
	 * @exception Exception
	 */
    public KjhuserVO selectKjhuser(KjhuserVO vo) throws Exception {
        KjhuserVO resultVO = kjhuserDAO.selectKjhuser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * kjhuser 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhuser 목록
	 * @exception Exception
	 */
    public List<?> selectKjhuserList(KjhuserDefaultVO searchVO) throws Exception {
        return kjhuserDAO.selectKjhuserList(searchVO);
    }

    /**
	 * kjhuser 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhuser 총 갯수
	 * @exception
	 */
    public int selectKjhuserListTotCnt(KjhuserDefaultVO searchVO) {
		return kjhuserDAO.selectKjhuserListTotCnt(searchVO);
	}

	@Override
	public KjhuserVO checkUserLogin(KjhuserVO userVO) {
		return kjhuserDAO.checkUserLogin(userVO);
	}

	@Override
	public KjhuserVO userJoin(KjhuserVO userVO) throws Exception {
		kjhuserDAO.userJoin(userVO);
		return selectKjhuser(userVO);
	}

	@Override
	public KjhuserVO findId(KjhuserVO vo) throws Exception {
		KjhuserVO resultVO = kjhuserDAO.findId(vo);
		 if (resultVO == null)
			 throw processException("info.nodata.msg");
		return resultVO;
	}
	
	@Override
	public KjhuserVO findPw(KjhuserVO vo) throws Exception {
		KjhuserVO resultVO = kjhuserDAO.findPw(vo);
		 if (resultVO == null)
			 throw processException("info.nodata.msg");
		return resultVO;
	}
    
}
