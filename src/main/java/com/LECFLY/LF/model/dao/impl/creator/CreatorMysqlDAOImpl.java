package com.LECFLY.LF.model.dao.impl.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.creator.CreatorVO;

@Repository
public class CreatorMysqlDAOImpl {
	 final String INSERT_NEW_CREATOR = "insert into creator values(null,?,?,?,?,?,?,?,1,now())" ;
	 @Autowired
	 JdbcTemplate jtem;
	 
	 public boolean insertNewCreator(CreatorVO crvo) {
		  int r = jtem.update(INSERT_NEW_CREATOR,crvo.getFid(),crvo.getImgPath(),crvo.getName(),crvo.getNickname(),crvo.getCellPhone()
				 ,crvo.getSNS(),crvo.getInfo());
		  return r==1;
	 }
	 public boolean insertNewCreator(int fid , String imgPath, String name , String nickname, String cellphone, String sns, String info ) {
		 int r = jtem.update(INSERT_NEW_CREATOR,fid, imgPath,name,nickname,cellphone,sns,info );
		 return r== 1;
	 }
}
	
