package com.iris.study.springboot.controller.business;

import com.alibaba.fastjson.JSON;
import com.iris.study.springboot.vo.boss.CustomInfo;
import com.iris.study.springboot.vo.boss.ResponseMessage;
import com.iris.study.springboot.vo.boss.VehicleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/driverService")
public class DriverServiceController {

    private static final Logger logger = LoggerFactory.getLogger(DriverServiceController.class);

    @RequestMapping(value="/receiveCustomInfo", method = RequestMethod.POST)
    public ResponseMessage receiveCustomInfo(@RequestBody CustomInfo customInfo) {
        logger.debug("into BossController receiveCustomInfo ...");
        logger.info("receiveCustomInfo接收到的参数为:"+ JSON.toJSONString(customInfo));
        return new ResponseMessage("1", "接收成功!");
    }

    @RequestMapping(value="/receiveVehicleInfo", method = RequestMethod.POST)
    public ResponseMessage receiveVehicleInfo(@RequestBody VehicleInfo vehicleInfo) {
        logger.debug("into BossController receiveVehicleInfo ...");
        logger.info("receiveVehicleInfo接收到的参数为:"+ JSON.toJSONString(vehicleInfo));
        return new ResponseMessage("1", "接收成功!");
    }

}
