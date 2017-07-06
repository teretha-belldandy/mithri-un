package com.picenter.picdb.dao;

import com.picenter.picdb.model.PicInfo;

public interface PicInfoMapper {

	int addPicInfo(PicInfo picinfo);

	int delPicInfo(int id);

	int updatePicInfo(PicInfo picinfo);

	PicInfo queryPicInfoById(int id);

}
