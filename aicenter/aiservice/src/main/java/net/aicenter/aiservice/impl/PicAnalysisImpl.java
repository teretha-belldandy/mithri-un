package net.aicenter.aiservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.aicenter.aiservice.PicAnalysis;
import net.picenter.picfacade.PicSearchFacade;

@Service
public class PicAnalysisImpl implements PicAnalysis {

	@Autowired
	private PicSearchFacade picSearchFacade;

	public String analysisPic(String picId) {
		String res = picSearchFacade.searchPicForKey(picId).get(0);
		System.out.println(res);
		// TODO Auto-generated method stub
		return res;
	}

}
