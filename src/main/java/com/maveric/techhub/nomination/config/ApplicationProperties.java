package com.maveric.techhub.nomination.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Application.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
