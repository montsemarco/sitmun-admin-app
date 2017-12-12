package org.sitmun.app.admin.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CorePluginIntegrationTest {
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void configjsIsPresent() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/app/config.js", String.class))
                .contains("requirejs.config");
    }
    
    @Test
    public void jsIsPresent() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/app/config.js", String.class))
                .contains("sitmun-plugin-core");
    }
}