package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class LoginPage {

    //Primeiro princípio page objects, tenha 1 atributo do tipo webdriver na classe
    private WebDriver navegador;

    // Segundo: Tenha um construtor que pegue o objeto e "jogue" em navegador
    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    //Sempre retornar a página em uso ou subsequente
    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;

    }

    public LoginPage informarSenha(String senha){
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        //Retorna navegador na próxima página
        return new ListaDeProdutosPage(navegador);
    }


}
