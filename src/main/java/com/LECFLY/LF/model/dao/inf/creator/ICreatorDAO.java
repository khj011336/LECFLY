package com.LECFLY.LF.model.dao.inf.creator;

import com.LECFLY.LF.model.vo.creator.CreatorVO;

public interface ICreatorDAO {
	CreatorVO selectOneCreator(int id);
	CreatorVO selectCreators();
	
}
