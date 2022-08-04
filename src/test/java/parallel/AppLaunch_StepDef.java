package parallel;

import com.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import pom.wsi.PermissionPage;
import pom.wsi.RegistryPage;

public class AppLaunch_StepDef {

    @Given("user launches the apps")
    public void userLaunchesTheApp() {
        Hooks hooks = new Hooks();
        hooks.launchBrowser();
    }
}
