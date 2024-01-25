package test.src.java.com.amigotech.functional;

import org.junit.jupiter.api.*;
import test.src.java.com.amigotech.macros.FrontPageMacro;
import test.src.java.com.amigotech.macros.Selenium;
import test.src.java.com.amigotech.macros.WebDriverGetter;
import test.src.java.com.amigotech.paths.FrontPagePath;

public class FrontPageTests {
    /*
    * As ferramentas escolhidas foram Selenium WebDriver, JUnit 5 e Maven
    * O motivo principal da escolha do Selenium é por ser muito completo para testes web,
    * compatibilidade com a maioria das linguagens, com Python, Java, Rust, C#, etc.
    * JUnit 5 foi escolhido por ser muito utilizado para testes unitários, de integração e
    * aqui funciona muito bem para testes funcionais com o Selenium.
    */

    //Antes do inicio de todos os testes é nessesário iniciar o webdriver
    //Foi criado funções para ficar mais legível todas as interações com o Selenium
    @BeforeAll
    static void beforeAll() {
        Selenium.setBrowserType("Chrome");
    }

    //Após todos os testes o webdriver deve ser encerrado
    @AfterAll
    static void afterAll() {
        WebDriverGetter.closeWebDriver();
    }

    //Como detalhado no plano de testes, antes que o teste fosse iniciado
    //propriamente o usuário deveria ir a página a ser testada e ter feito
    //um login.
    @BeforeEach
    void setUp() {
        Selenium.goToPage("https://www.saucedemo.com/");
        FrontPageMacro.loginIntoPage("standard_user", "secret_sauce");
    }

    //Ao final de cada teste é necessário limpar todos os itens selecionados
    //para que a informação deixada pelo teste anterior não interfira no resultado
    //do próximo teste.
    @AfterEach
    void tearDown() {
        FrontPageMacro.tearDownItens();
    }

    //Nesse primeiro teste é coberto para o caso mais simpres
    //em que, o usuário adiciona um item ao carrinho e o número
    //exibido no carrinho juntamente com o item dentro dele
    //correspondem ao item selecinado.
    @Test
    void addOneItemToChart() {
        Selenium.clickAt(FrontPagePath.ITEM1_ADD_TO_CHART_BUTTON.toString());
        Selenium.assertTextEqual(FrontPagePath.SHOP_CHART_BADGE.toString(), "1");
        Selenium.clickAt(FrontPagePath.SHOP_CHART_BADGE.toString());
        Selenium.assertTextEqual(FrontPagePath.INVENTORY_ITEM_NAME.toString(), "Sauce Labs Backpack");
    }

    //Nesse teste é feito para garantir que tanto o número exibido no carrinho quanto
    //os itens presentes nele estão de acordo.
    @Test
    void addMultipleItemToChart() {
        Selenium.clickAt(FrontPagePath.ITEM1_ADD_TO_CHART_BUTTON.toString());
        Selenium.clickAt(FrontPagePath.ITEM2_ADD_TO_CHART_BUTTON.toString());
        Selenium.assertTextEqual(FrontPagePath.SHOP_CHART_BADGE.toString(), "2");
        Selenium.clickAt(FrontPagePath.SHOP_CHART_BADGE.toString());
        Selenium.assertTextEqual(FrontPagePath.INVENTORY_ITEM_NAME.toString(), "Sauce Labs Backpack");
        Selenium.assertTextEqual(FrontPagePath.INVENTORY_ITEM2_NAME.toString(), "Sauce Labs Bike Light");
    }

    //E por fim, esse teste garante que ao selecionar mais um item e remover
    //um desses itens, a remoção so afetará o item removido, garantindo a funcionalidade correta
    //do botão de remover sem afetar outros itens presentes.
    @Test
    void assertCorrectItemIsRemovedFromChart() {
        Selenium.clickAt(FrontPagePath.ITEM1_ADD_TO_CHART_BUTTON.toString());
        Selenium.clickAt(FrontPagePath.ITEM2_ADD_TO_CHART_BUTTON.toString());
        Selenium.clickAt(FrontPagePath.ITEM1_REMOVE_TO_CHART_BUTTON.toString());
        Selenium.assertTextEqual(FrontPagePath.SHOP_CHART_BADGE.toString(), "1");
        Selenium.clickAt(FrontPagePath.SHOP_CHART_BADGE.toString());
        Selenium.assertTextEqual(FrontPagePath.INVENTORY_ITEM_NAME.toString(), "Sauce Labs Bike Light");
        Selenium.assertElementNotPresent(FrontPagePath.INVENTORY_ITEM2_NAME.toString());
    }
}
