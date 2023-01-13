package com.example.springboot3.configuration;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class DeclarativeObservationConfig {

  // To have the @Observed support we need to register this aspect
  @Bean
  ObservedAspect observedAspect(final ObservationRegistry observationRegistry) {
    return new ObservedAspect(observationRegistry);
  }

  // WARNING!!! WILL PRODUCE HUGE AMOUNT OF LOGS!!!
//  @Bean
  ObservationHandler<Context> customObservationLoggingHandler() {
    final var log = LoggerFactory.getLogger("CustomObservationLoggingHandler");
    return new ObservationHandler<>() {

      @Override
      public void onStart(Observation.Context context) {
        log.info("Before running the observation for context [{}]", context.getName());
      }

      @Override
      public void onStop(Observation.Context context) {
        log.info("After running the observation for context [{}]", context.getName());
      }

      @Override
      public boolean supportsContext(Observation.Context context) {
        return true;
      }
    };
  }
}
