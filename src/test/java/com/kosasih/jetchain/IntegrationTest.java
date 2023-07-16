package com.kosasih.jetchain;

import com.kosasih.jetchain.JetchainApp;
import com.kosasih.jetchain.config.AsyncSyncConfiguration;
import com.kosasih.jetchain.config.EmbeddedElasticsearch;
import com.kosasih.jetchain.config.EmbeddedKafka;
import com.kosasih.jetchain.config.EmbeddedSQL;
import com.kosasih.jetchain.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JetchainApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
