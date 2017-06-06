package org.junjun.util.java.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.hibernate.tool.ant.Hbm2JavaExporterTask;
import org.hibernate.tool.ant.HibernateToolTask;
import org.hibernate.tool.ant.JDBCConfigurationTask;
import org.springframework.stereotype.Service;

@Service
public class ReverseEngineServiceImpl implements ReverseEngineService {

	private static final Logger log = Logger.getLogger(ReverseEngineServiceImpl.class);

	public Boolean databaseToJava() {
		Boolean done = Boolean.TRUE;
		try {
			final File destDir = new File("src/main/java");
			final File hibernateConfig = new File("src/main/resources/hibernate.cfg.xml");

			final HibernateToolTask persistenceGenerator = new HibernateToolTask();
			persistenceGenerator.setDestDir(destDir);

			final JDBCConfigurationTask jdbcConfiguration = persistenceGenerator.createJDBCConfiguration();
			jdbcConfiguration.setConfigurationFile(hibernateConfig);

			jdbcConfiguration.setDetectManyToMany(true);
			jdbcConfiguration.setDetectOneToOne(true);
			jdbcConfiguration.setPackageName("org.junjun.util.java.persistence");

			jdbcConfiguration.execute();

			final Hbm2JavaExporterTask hbm2Java = (Hbm2JavaExporterTask) persistenceGenerator.createHbm2Java();
			hbm2Java.setJdk5(Boolean.TRUE);
			hbm2Java.setEjb3(Boolean.TRUE);
			hbm2Java.setDestdir(destDir);
			hbm2Java.validateParameters();
			hbm2Java.execute();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			done = Boolean.FALSE;
		}
		return done;
	}

}
