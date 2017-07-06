package com.picenter.picdb.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import com.picenter.picdb.model.PicInfo;



public class PicInfoMapperTest {
	
	static SqlSessionFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String resource = "E:\\workspace\\learnspace\\mithri-mn\\picenter\\picdb\\src\\main\\resources\\mybatis-config.xml";
		File resfile = new File(resource); // Resources.getResourceAsFile(resource);
		System.out.println(resfile.exists());
		InputStream inputStream = new FileInputStream(resfile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(inputStream);

		Configuration config = factory.getConfiguration();
		Environment env = config.getEnvironment();
		System.out.println(env.getId());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPicInfo() {
		SqlSession session = factory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			PicInfo picinfo = createPicInfo();
			int res = picinfoMapper.addPicInfo(picinfo);
			Assert.assertTrue(1 == res);
			session.commit(true);
		} finally {
			session.close();
		}
	}
	
	private PicInfo createPicInfo() {
		PicInfo picinfo = new PicInfo();
		Random rand = new Random();
		picinfo.setPid(rand.nextInt(20000));
		picinfo.setPname("may");
		picinfo.setPdesc("ons");
		picinfo.setPsize(9.99);
		picinfo.setPpath("path way");
		
		return picinfo;
	}

	@Test
	public void testDelPicInfo() {
		SqlSession session = factory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			int res = picinfoMapper.delPicInfo(2);
			Assert.assertTrue(1 == res);
			session.commit(true);
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdatePicInfo() {
		SqlSession session = factory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			PicInfo picinfo = new PicInfo();
			picinfo.setPid(13177);
			picinfo.setPname("amanda");
			picinfo.setPdesc("ons");
			picinfo.setPsize(9.99);
			picinfo.setPpath("path way");
			int res = picinfoMapper.updatePicInfo(picinfo);
			Assert.assertTrue(1 == res);
			session.commit(true);
		} finally {
			session.close();
		}
	}

	@Test
	public void testQueryPicInfoById() {
		SqlSession session = factory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			PicInfo res = picinfoMapper.queryPicInfoById(13177);
			Assert.assertTrue(null != res);
			System.out.println(res);
			// session.commit(true);
		} finally {
			session.close();
		}
	}

}
