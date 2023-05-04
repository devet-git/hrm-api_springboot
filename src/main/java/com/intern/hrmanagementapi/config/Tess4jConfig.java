package com.intern.hrmanagementapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Tess4jConfig {

  static {
    String tessDataPath = "src/main/resources/tessdata";
    System.setProperty("TESSDATA_PREFIX", tessDataPath);
  }

}
