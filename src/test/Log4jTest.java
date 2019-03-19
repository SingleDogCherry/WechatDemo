

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	static Logger logger = LogManager.getLogger(Log4jTest.class.getClass());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//logger.log(Level.ALL, "111111");
		//BasicContextSelector.configure();
		//Level
		//ConfigurationFactory  configurationFactory ;
		//configurationFactory.setConfigurationFactory(factory);
		
        //下面的消息将被输出
		/**
		logger.trace("Entering application  ");
		logg
		logger.debug("Entering application  22222");
        logger.info("this is an info");
        logger.warn("this is a warn");
        logger.error("this is an error");
        logger.fatal("this is a fatal");
*/   
		logger.trace("Entering application  ");
		/*Bar bar = new Bar();
		if (!bar.doIt()) {
			logger.error("忘记做了");
		}*/
		logger.trace("z做完啦");

	}

}
