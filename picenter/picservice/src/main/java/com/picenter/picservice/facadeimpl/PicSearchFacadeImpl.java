package com.picenter.picservice.facadeimpl;

import java.util.List;

import com.beust.jcommander.internal.Lists;

import net.picenter.picfacade.PicSearchFacade;

public class PicSearchFacadeImpl implements PicSearchFacade {

	public List<String> searchPicForUrl(String url) {
		List<String> picList = Lists.newArrayList();
		// TODO
		picList.add("test url");
		return picList;
	}

	public List<String> searchPicForKey(String key) {
		List<String> picList = Lists.newArrayList();
		// TODO
		picList.add("test key");
		return picList;
	}

}
