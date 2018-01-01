package com.picenter.picutils.comm;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.InitializingBean;

public class CuratorClient implements InitializingBean {

	public String getZkServer() {
		return zkServer;
	}

	public void setZkServer(String zkServer) {
		this.zkServer = zkServer;
	}

	public String getZkPort() {
		return zkPort;
	}

	public void setZkPort(String zkPort) {
		this.zkPort = zkPort;
	}

	private String zkServer;
	private String zkPort;
	private int sessionTimeoutMs = 30000;
	private int connectionTimeoutMs = 30000;

	private CuratorFramework client;

	public void afterPropertiesSet() throws Exception {
		CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
		client = builder.connectString(zkServer + ":" + zkPort).sessionTimeoutMs(sessionTimeoutMs)
				.connectionTimeoutMs(connectionTimeoutMs).retryPolicy(new ExponentialBackoffRetry(1000, 3))
				.defaultData(null).build();
	}

}
