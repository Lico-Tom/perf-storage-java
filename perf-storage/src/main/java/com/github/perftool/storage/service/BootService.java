/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.github.perftool.storage.service;


import com.github.perftool.storage.config.StorageConfig;
import com.github.perftool.storage.mysql.service.MysqlBootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
@Slf4j
public class BootService {


    @Autowired
    private StorageConfig storageConfig;

    @Autowired
    private MysqlBootService mysqlBootService;

    @PostConstruct
    public void init() {
        log.info("storage type : {}", storageConfig.storageType);
        switch (storageConfig.storageType.toUpperCase(Locale.ROOT)) {
            case "DUMMY" -> log.info("dummy storage");
            case "MYSQL" -> mysqlBootService.boot();
            default -> {
            }
        }
    }
}
