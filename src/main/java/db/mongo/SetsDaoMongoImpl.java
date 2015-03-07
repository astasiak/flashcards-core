package db.mongo;

import java.util.List;

import model.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import db.SetsDao;

@Repository
public class SetsDaoMongoImpl implements SetsDao {

	@Autowired
	MongoOperations mongo;
	
	@Override
	public List<Set> listSets() {
		Query query = new Query();
		query.fields().exclude("flashcards");
		return mongo.find(query, Set.class);
	}

	@Override
	public Set createSet(Set set) {
		mongo.insert(set);
		return set;
	}

	@Override
	public void deleteSet(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongo.remove(query, Set.class);
	}

}
