package com.goeuro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by HarryZ on 8/19/16.
 */
@Service
public class MainService {

    private static final Logger LOG = LoggerFactory.getLogger(MainService.class);

    @Resource(name = "routeMap")
    private Map<Integer,Map<Integer, Integer>> routeMap;

    public boolean findRoute(int start, int end) {

        for (Map.Entry<Integer, Map<Integer, Integer>> routeSet : routeMap.entrySet()) {
            Map<Integer, Integer> route = routeSet.getValue();
            if (!route.containsKey(start) || !route.containsKey(end)) {
                continue;
            }

            if (route.get(start) <= route.get(end)) {
                return true;
            }
        }

        return false;

    }
}
