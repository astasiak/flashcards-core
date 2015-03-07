package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import model.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import db.SetsDao;

@RestController
@RequestMapping(value="/sets")
public class SetsController {
	
	@Autowired
	private SetsDao setsDao;

    @ResponseBody
    @RequestMapping(method=GET)
    public List<Set> listSets() {
        return setsDao.listSets();
    }

    @ResponseBody
    @RequestMapping(method=POST)
    public Set postSet(@RequestBody Set set) {
    	return setsDao.createSet(set);
    }

    @ResponseBody
    @RequestMapping(value="/{id}",method=DELETE)
    public void deleteSet(@PathVariable("id") String id) {
    	// TODO: return 204
    	setsDao.deleteSet(id);
    }
}
