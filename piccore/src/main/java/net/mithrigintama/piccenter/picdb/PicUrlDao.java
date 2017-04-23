package net.mithrigintama.piccenter.picdb;

import net.mithrigintama.piccenter.piccore.PicUrl;

public interface PicUrlDao {

	PicUrl findPicUrlById(String id);

	boolean addPicUrl(PicUrl picUrl);

	boolean rmPicUrlById(String id);

}
