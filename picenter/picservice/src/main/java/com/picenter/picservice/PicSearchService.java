package com.picenter.picservice;

import com.picenter.picservice.model.PicInfo;

public interface PicSearchService {

	PicInfo searchPicByUrl(String urlPath);

	PicInfo searchPicByKey(String key);

}
