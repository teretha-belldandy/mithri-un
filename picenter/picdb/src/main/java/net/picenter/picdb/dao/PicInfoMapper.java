package net.picenter.picdb.dao;

import java.util.List;

import net.picenter.picdb.model.PicInfo;

public interface PicInfoMapper {

	int addPicInfo(PicInfo picinfo);

	int delPicInfo(int id);

	int updatePicInfo(PicInfo picinfo);

	PicInfo queryPicInfoById(int id);
	
	List<PicInfo> queryAllPicInfo();

}
