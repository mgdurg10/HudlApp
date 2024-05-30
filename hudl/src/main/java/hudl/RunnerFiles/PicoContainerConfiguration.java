package hudl.RunnerFiles;

import hudlutilities.WebDriverManager;
import io.cucumber.core.backend.ObjectFactory;

public class PicoContainerConfiguration implements ObjectFactory {
	    private final WebDriverManager webDriverManager = new WebDriverManager();

	    @Override
	    public void start() {}

	    @Override
	    public void stop() {
	        webDriverManager.quitDriver();
	    }

	    @Override
	    public boolean addClass(Class<?> type) {
	        return true;
	    }

	    @Override
	    public <T> T getInstance(Class<T> type) {
	        if (type.isAssignableFrom(WebDriverManager.class)) {
	            return type.cast(webDriverManager);
	        }
	        return null;
	    }
	}

