package net.picenter.picfacade;

import java.util.List;

public interface PicSearchFacade {

	public List<String> searchPicForUrl(String url);

	public List<String> searchPicForKey(String key);

}
