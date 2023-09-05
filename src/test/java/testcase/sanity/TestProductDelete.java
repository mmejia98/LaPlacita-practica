package testcase.sanity;

import org.laplacita.pages.CartPage;
import org.laplacita.pages.ProductDetailPage;
import org.laplacita.pages.home.HeaderPage;
import org.laplacita.pages.home.ProductosDestacadosPage;
import org.laplacita.testCaseImplements.TestCase;
import org.laplacita.testCaseImplements.TestCaseLoginCustomer;
import org.testng.annotations.Test;

public class TestProductDelete extends TestCaseLoginCustomer {

    @Test
    public void Test1(){
        ProductosDestacadosPage productoDestacados = new ProductosDestacadosPage(browser);
        ProductDetailPage productDetailPage = new ProductDetailPage(browser);
        CartPage cart = new CartPage(browser);
        HeaderPage headerPage = new HeaderPage(browser);

        productoDestacados.getProductByName("Nintendo Switch Lite - Azul");
        productDetailPage.agregarAlCarritoClick();
        headerPage.carritoClick();
        cart.ordenarAhoraClick();
    }

}
