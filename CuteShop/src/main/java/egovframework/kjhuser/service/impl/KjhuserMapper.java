package egovframework.kjhuser.service.impl;

import java.util.List;

import egovframework.kjhuser.service.KjhuserVO;
import egovframework.kjhuser.service.KjhuserDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
/**
 * @Class Name : KjhuserMapper.java
 * @Description : Kjhuser Mapper Class
 * @Modification Information
 *
 * @author kjh
 * @since 2023-04-08
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("kjhuserMapper")
public interface KjhuserMapper {

	/**
	 * kjhuser을 등록한다.
	 * @param vo - 등록할 정보가 담긴 KjhuserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertKjhuser(KjhuserVO vo) throws Exception;

    /**
	 * kjhuser을 수정한다.
	 * @param vo - 수정할 정보가 담긴 KjhuserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateKjhuser(KjhuserVO vo) throws Exception;

    /**
	 * kjhuser을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 KjhuserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteKjhuser(KjhuserVO vo) throws Exception;

    /**
	 * kjhuser을 조회한다.
	 * @param vo - 조회할 정보가 담긴 KjhuserVO
	 * @return 조회한 kjhuser
	 * @exception Exception
	 */
    public KjhuserVO selectKjhuser(KjhuserVO vo) throws Exception;

    /**
	 * kjhuser 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhuser 목록
	 * @exception Exception
	 */
    public List<?> selectKjhuserList(KjhuserDefaultVO searchVO) throws Exception;

    /**
	 * kjhuser 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return kjhuser 총 갯수
	 * @exception
	 */
    public int selectKjhuserListTotCnt(KjhuserDefaultVO searchVO);
    public KjhuserVO checkUserLogin(KjhuserVO userVO);
    public void userJoin(KjhuserVO userVO);

	public KjhuserVO findId(KjhuserVO vo) throws Exception;
	public KjhuserVO findPw(KjhuserVO vo) throws Exception;

}
