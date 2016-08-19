package com.goeuro.controller;

import com.goeuro.model.Response;
import com.goeuro.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HarryZ on 8/19/16.
 */
@RestController
@RequestMapping("/rest/provider/goeurobus/direct/")
public class MainController {

    @Autowired
    private MainService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{dep_sid}/{arr_sid}")
    public Response getRoute(@PathVariable int dep_sid, @PathVariable int arr_sid) {
        boolean isDirectRoute = service.findRoute(dep_sid, arr_sid);
        return new Response(dep_sid, arr_sid, isDirectRoute);
    }
}
