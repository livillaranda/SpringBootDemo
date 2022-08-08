package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.repos.CandyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CandyServiceImpl implements CandyService {

    @Autowired
    private CandyRepo cRepo;

    @Autowired
    public CandyServiceImpl(CandyRepo cRepo) {
        this.cRepo = cRepo;
    }

    @Override
    public boolean createCandy(Candy candy) {
        int pk = cRepo.save(candy).getId();
        return (pk > 0) ? true: false;
    }

    @Override
    public Candy getCandyByID(int id) {
        return cRepo.findByID(id);
    }

    @Override
    public List<Candy> getAllCandies() {
        return cRepo.findAll();
    }

    @Override
    public boolean updateCandy(Candy candy) {
      return cRepo.update(candy.getName(), candy.getPrice(), candy.getId());
    }

    @Override
    public boolean deleteCandy(Candy candy) {
        cRepo.delete(candy);
        return true;
    }

    public void doCors (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin","http://127.0.0.1:5500");
        resp.addHeader("Vary","Origin");
        resp.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers","*");
        //resp.addHeader("Access-Control-Allow-Headers","X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Allow-Credentials","true");
        resp.addHeader("Access-Control-Max-Age","1728000");
        resp.addHeader("Produces","application/json");

    }

}