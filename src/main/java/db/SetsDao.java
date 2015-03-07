package db;

import java.util.List;

import model.Set;

public interface SetsDao {
	List<Set> listSets();
	Set createSet(Set user);
	void deleteSet(String id);
}
