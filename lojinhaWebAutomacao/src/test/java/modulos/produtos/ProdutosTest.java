package modulos.produtos;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.*;


import java.time.Duration;

@DisplayName("Testes Web do módulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver117\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Maximizar a tela
        this.navegador.manage().window().maximize();

        //Definir tempo de espera padrão de 5s
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Navegar para página da lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

        //Login

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("MackbookPro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        // Vou para a tela de registro do produto
        //Vou preencher dados do produto e o valor será igual a zero
        //Vou submeter o formulário
        //navegador.findElement(By.cssSelector("button[type='submit']")).click();
        // Validar mensagem de erro apresentada
        //String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    /*Exercício
    @Test
    @DisplayName("Não é permitido registrar um produto acima de R$ 7.000,00")
    
     */


    @AfterEach
    public void afterEach(){
        //fechar o navegador
        navegador.quit();
    }
}
