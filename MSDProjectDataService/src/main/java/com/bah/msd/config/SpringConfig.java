package com.bah.msd.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import( {SpringRepositoryConfig.class, SpringServicesConfig.class})
public class SpringConfig {
}
