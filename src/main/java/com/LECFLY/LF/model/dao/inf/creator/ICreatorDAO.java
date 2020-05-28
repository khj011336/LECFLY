package com.LECFLY.LF.model.dao.inf.creator;

import com.LECFLY.LF.model.vo.creator.CreatorVO;

public interface ICreatorDAO {
	CreatorVO selectOneCreator(int fid);
	 boolean insertNewCreator(int fid , String imgPath, String name , String nickname, String cellphone, String sns, String info ,int status);
	 boolean updateCreator(CreatorVO crVo ,int fid); 
		
	 
}
