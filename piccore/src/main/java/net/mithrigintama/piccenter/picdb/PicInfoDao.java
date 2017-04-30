package net.mithrigintama.piccenter.picdb;

import net.mithrigintama.piccenter.picpojo.PicInfo;

public interface PicInfoDao {

	PicInfo findPicUrlById(String picId);

	boolean addPicUrl(PicInfo picInfo);

	boolean rmPicUrlById(String picId);

}
