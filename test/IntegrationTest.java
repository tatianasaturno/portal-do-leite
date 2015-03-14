import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void testaLogin() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333/login");
                assertThat(browser.pageSource()).contains("Portal do Leite");
            }
        });
    }
    
    @Test
    public void testaHome() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333/home");
                assertThat(browser.pageSource()).contains("Portal do Leite");
                assertThat(browser.pageSource()).contains("Análise e Design");
                assertThat(browser.pageSource()).contains("Javascript");
                assertThat(browser.pageSource()).contains("Projeto");
            }
        });
    }

}
