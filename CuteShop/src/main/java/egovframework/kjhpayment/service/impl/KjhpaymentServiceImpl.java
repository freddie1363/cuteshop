package egovframework.kjhpayment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.kjhpayment.service.KjhpaymentService;
import egovframework.kjhpayment.service.KjhpaymentDefaultVO;
import egovframework.kjhpayment.service.KjhpaymentVO;
import egovframework.kjhpayment.service.impl.KjhpaymentMapper;
/**
 * @Class Name : KjhpaymentServiceImpl.java
 * @Description : Kjhpayment Business Implement class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-05-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("kjhpaymentService")
public class KjhpaymentServiceImpl extends EgovAbstractServiceImpl implements
        KjhpaymentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(KjhpaymentServiceImpl.class);

    @Resource(name="kjhpaymentMapper")
    private KjhpaymentMapper kjhpaymentDAO;
    
    //@Resource(name="kjhpaymentDAO")
    //private KjhpaymentDAO kjhpaymentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovKjhpaymentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * kjhpayment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhpaymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertKjhpayment(KjhpaymentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	kjhpaymentDAO.insertKjhpayment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * kjhpayment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhpaymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhpayment(KjhpaymentVO vo) throws Exception {
        kjhpaymentDAO.updateKjhpayment(vo);
    }

    /**
	 * kjhpayment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhpaymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhpayment(KjhpaymentVO vo) throws Exception {
        kjhpaymentDAO.deleteKjhpayment(vo);
    }

    /**
	 * kjhpayment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhpaymentVO
	 * @return 조회한 kjhpayment
	 * @exception Exception
	 */
    public KjhpaymentVO selectKjhpayment(KjhpaymentVO vo) throws Exception {
        KjhpaymentVO resultVO = kjhpaymentDAO.selectKjhpayment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * kjhpayment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhpayment 목록
	 * @exception Exception
	 */
    public List<?> selectKjhpaymentList(KjhpaymentDefaultVO searchVO) throws Exception {
        return kjhpaymentDAO.selectKjhpaymentList(searchVO);
    }

    /**
	 * kjhpayment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return kjhpayment 총 갯수
	 * @exception
	 */
    public int selectKjhpaymentListTotCnt(KjhpaymentDefaultVO searchVO) {
		return kjhpaymentDAO.selectKjhpaymentListTotCnt(searchVO);
	}
    
}
