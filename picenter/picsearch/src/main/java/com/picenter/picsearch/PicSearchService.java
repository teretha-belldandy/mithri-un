package com.picenter.picsearch;

import com.picenter.picsearch.model.PicInfo;

public interface PicSearchService {

	PicInfo searchPicByUrl(String urlPath);

	PicInfo searchPicByKey(String key);

}
