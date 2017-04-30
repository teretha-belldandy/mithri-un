package net.mithrigintama.piccenter.picdb;

import net.mithrigintama.piccenter.picpojo.PicInfo;

public interface PicInfoDao {

	PicInfo findPicInfoById(String picId);

	boolean addPicInfo(PicInfo picInfo);

	boolean rmPicInfoById(String picId);

}
