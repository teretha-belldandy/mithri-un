package com.picenter.picservice;

import java.util.List;

import com.picenter.picservice.model.PicInfo;

public interface PicSearchService {

	List<PicInfo> searchPicByUrl(String urlPath);

	List<PicInfo> searchPicByKey(String key);

}
