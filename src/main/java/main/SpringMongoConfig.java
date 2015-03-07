package main;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.util.StringUtils;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
	
	private static final Logger LOG = Logger.getLogger(SpringMongoConfig.class);
	
	private final String DEFAULT_MONGO_URI = "mongodb://localhost/yourdb";
	
	private MongoClientURI mongoUri;
	
	@Override
	public String getDatabaseName() {
		return getMongoUri().getDatabase();
	}
 
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(getMongoUri());
	}
	
	private MongoClientURI getMongoUri() {
		if(mongoUri==null) {
			String uriString = System.getenv("MONGOLAB_URI");
			if(StringUtils.isEmpty(uriString)) {
				uriString = DEFAULT_MONGO_URI;
			}
			LOG.info("Connecting to mongo instance: ["+uriString+"]");
			mongoUri = new MongoClientURI(uriString);
		}
		return mongoUri;
	}
}