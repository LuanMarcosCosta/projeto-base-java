package support;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getdriver;

public class PrintScreen {
    public static void addScreenshotOnScenario(Scenario scenario){

        System.out.println("========================");
        System.out.println("Teste executado: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("Tag: " + scenario.getSourceTagNames());
        System.out.println("========================");

        if (scenario.isFailed()){

            //A foto está em tipo array Byte, pego os dados e coloco na minha variável
            byte[] screenshot = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.BYTES);

            // Aqui eu pego esse Byte e o converto em imagem passando os parâmetros
            scenario.embed(screenshot, "image/png");
        }
    }
}
