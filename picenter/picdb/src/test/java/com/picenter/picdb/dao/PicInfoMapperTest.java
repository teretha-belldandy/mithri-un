package com.picenter.picdb.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.picenter.picdb.model.PicInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/application*.xml" })
public class PicInfoMapperTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	static int picid = 0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@SuppressWarnings("unused")
	private static SqlSessionFactory genSqlSessionFactory() throws FileNotFoundException {
		String resource = "E:\\workspace\\learnspace\\mithri-mn\\picenter\\picdb\\src\\main\\resources\\mybatis-config.xml";
		File resfile = new File(resource); // Resources.getResourceAsFile(resource);
		System.out.println(resfile.exists());
		InputStream inputStream = new FileInputStream(resfile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);

		Configuration config = factory.getConfiguration();
		Environment env = config.getEnvironment();
		System.out.println(env.getId());

		return factory;
	}

	@Test
	public void testAddPicInfo() {
		SqlSession session = sqlSessionFactory.openSession();
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

	@Test
	public void testDelPicInfo() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			if (picid != 0) {
				int res = picinfoMapper.delPicInfo(picid);
				Assert.assertTrue(1 == res);
				session.commit(true);
			}
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdatePicInfo() {
		SqlSession session = sqlSessionFactory.openSession();
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
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			long t = System.currentTimeMillis();
			PicInfo res = picinfoMapper.queryPicInfoById(1);
			System.out.println("time : " + (System.currentTimeMillis() - t));

			PicInfoMapper picinfoMapper1 = session.getMapper(PicInfoMapper.class);
			long t1 = System.currentTimeMillis();
			PicInfo res1 = picinfoMapper1.queryPicInfoById(1);
			System.out.println("time : " + (System.currentTimeMillis() - t1));

			Assert.assertTrue(null != res);
			Assert.assertTrue(null != res1);
			System.out.println(res);
			// session.commit(true);
		} finally {
			session.close();
		}
	}

	@Test
	public void testQueryAllPicInfo() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			PicInfoMapper picinfoMapper = session.getMapper(PicInfoMapper.class);
			long t1 = System.currentTimeMillis();
			List<PicInfo> resList = picinfoMapper.queryAllPicInfo();
			System.out.println("time : " + (System.currentTimeMillis() - t1));
			Assert.assertTrue(null != resList);
			Assert.assertTrue(resList.size() > 0);
			System.out.println(resList);
			// session.commit(true);
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
		picid = picinfo.getPid();
		return picinfo;
	}

}
