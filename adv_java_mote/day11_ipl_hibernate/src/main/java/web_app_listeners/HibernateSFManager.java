package web_app_listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

@WebListener // whatever follows is web listner
public class HibernateSFManager implements ServletContextListener {

	public HibernateSFManager() {

	}
	//undeploy redploy and server shut down.. conn pool will be closed
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed");
		HibernateUtils.getFactory().close();// SF : close , DBCP cleaned up !
	}

	// web container will call below once while deploying
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
		HibernateUtils.getFactory();// static init block : hib up n running //
	}

}
