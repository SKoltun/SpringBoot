package pl.skoltun.SpringBoot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "pl.skoltun.SpringBoot.repository")
public class JPAConfig {
}
