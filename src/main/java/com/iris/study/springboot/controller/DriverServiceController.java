package com.iris.study.springboot.controller;

import com.iris.study.springboot.vo.boss.CustomInfo;
import com.iris.study.springboot.vo.boss.VehicleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/driverService")
public class DriverServiceController {

    private static final Logger logger = LoggerFactory.getLogger(DriverServiceController.class);

    @RequestMapping(value="/receiveCustomInfo", method = RequestMethod.POST)
    @ResponseBody
    public CustomInfo receiveCustomInfo(@RequestBody CustomInfo customInfo) {

        return customInfo;
    }

    @RequestMapping(value="/receiveVehicleInfo", method = RequestMethod.POST)
    @ResponseBody
    public VehicleInfo receiveVehicleInfo(@RequestBody VehicleInfo vehicleInfo) {
        logger.debug("into BossController sendVehicleInfo ...");

        return vehicleInfo;
    }

}
