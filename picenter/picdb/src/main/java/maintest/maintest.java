package maintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.picenter.picdb.dao.PicuserMapper;
import com.picenter.picdb.model.Picuser;

public class maintest {

	public static void main(String[] args) throws IOException {
		String resource = "E:\\workspace\\learnspace\\mithri-mn\\picenter\\picdb\\src\\main\\resources\\mybatis-config.xml";
		File resfile = new File(resource); //Resources.getResourceAsFile(resource);
		System.out.println(resfile.exists());
		InputStream inputStream = new FileInputStream(resfile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);
		Configuration config = factory.getConfiguration();
		// config.addMapper(PicuserMapper.class);
		Environment env = config.getEnvironment();
		System.out.println(env.getId());
		SqlSession session = factory.openSession();
		try {
			PicuserMapper picuserMapper = session.getMapper(PicuserMapper.class);
			Picuser user = picuserMapper.select(1);
			System.out.println(user.getUname());
		} finally {
			session.close();
		}
	}

}
