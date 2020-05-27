package com.LECFLY.LF.model.dao.inf.creator;

import com.LECFLY.LF.model.vo.creator.KitVO;

public interface IKitDAO {
	boolean updateKit(KitVO kitVo , int CFId);
	KitVO selectOneKit(int CFid);
	boolean insertKit(int fid , int cfid , int cate , String attr, String title , int price , int remain , String imgPath,
			String deliver , int deliverPrice , String fromTO , String info , String detail);
}
