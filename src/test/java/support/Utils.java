package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.util.Random;

public class Utils extends RunCucumberTest {
    static Random random = new Random();

    // --- Comandos variados para espera --- //
    public static void esperarElementoEstarPresente(By element, int tempo){
        WebDriverWait wait = new WebDriverWait(getdriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static String geraEmailrandom(){
        String emaiInit = "luanTeste_";
        String emailFinal = "@qa.com.br";

        Random ramdom = new Random();
        int minimo = 1;
        int maximo = 999;

        int resultado = ramdom.nextInt(maximo-minimo) + minimo;

        return emaiInit + resultado + emailFinal;
    }

    public static String geraSenhaRamdom(){
        String senhaInit = "S3";
        String senhaFinal = "Nh@";

        Random random = new Random();
        int minimo = 1980;
        int maximo = 2022;

        int resultado = random.nextInt(maximo-minimo);

        return senhaInit + resultado + senhaFinal;
    }

    public static String geraNomeRandom(){

        String[] names = {"Eduardo Lucas da Silva", "Sandra Maria de Jesus", "José Henrrique de Anchieta", "Luciana Marques de Paula", "Fernando Nunes da Rocha",
                          "Lucas Silva Rodrigues", "Maria Antonierta Santos", "Matheus Crause Barcelos", "Lenadro Barreto Martins", "Fernanda Cowskine de Paula"};

        int minimo = 0;
        int maximo = (names.length) - 1;

        int posicao = random.nextInt(maximo-minimo) + minimo;

        return names[posicao];
    }


    public static String geraNumeroCelular(boolean comPontos){
        String numerosConcatenados;
        //numeros gerados
        String DDD = "27";
        String operadora = "99";
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        int n3 = random.nextInt(10);
        int n4 = random.nextInt(10);
        int n5 = random.nextInt(10);
        int n6 = random.nextInt(10);
        int n7 = random.nextInt(10);

        if (comPontos){
            numerosConcatenados = "(" + DDD + ")" + operadora + n1 + n2 + n3 + "-" + n4 + n5 + n6 + n7;
        }else{
            numerosConcatenados = DDD + operadora + n1 + n2 + n3 + n4 + n5 + n6 + n7;
        }

        return numerosConcatenados;
    }

    public static void clickElement(By element) {
        System.out.println("##################################");
        try {
            System.out.println("Vai clicar no elemento: " + element);
            esperarElementoEstarPresente(element, 10);
            getdriver().findElement(element).click();
            System.out.println("Clicou no elemento: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }

    public static void fillField(By element, String value) {
        System.out.println("##################################");
        try {
            System.out.println("Vai preencher o campo: " + element);
            esperarElementoEstarPresente(element, 10);
            getdriver().findElement(element).sendKeys(value);
            System.out.println("Preencheu o campo: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }

    public static void checkMessage(By element, String expectedMessage) {
        String actualMessage = "";

        System.out.println("##################################");
        System.out.println("");

        System.out.println("Vai validar mensagem: " + expectedMessage);
        esperarElementoEstarPresente(element, 10);
        actualMessage = getdriver().findElement(element).getText();

        // Quando não der certo, vai quebrar o teste!!!
        Assert.assertEquals("Erro ao validar mensagens!", expectedMessage, actualMessage);
        // Quando não der certo, vai quebrar o teste!!!

        System.out.println("Validou mensagem: " + expectedMessage);

        System.out.println("");
        System.out.println("##################################");
    }
}
