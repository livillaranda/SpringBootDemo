package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface CandyService {

    // Creates a new Candy
    boolean createCandy(Candy candy);

    // Get a Candy
    Candy getCandyByID(int id);

    // Get ALL Candies
    List<Candy> getAllCandies();

    // Update a Candy
    boolean updateCandy(Candy candy);

    // Delete a Candy
    boolean deleteCandy(Candy candy);

    void doCors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
