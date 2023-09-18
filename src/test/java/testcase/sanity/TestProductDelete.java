package testcase.sanity;

import org.laplacita.pages.CartPage;
import org.laplacita.pages.OrderPage;
import org.laplacita.pages.ProductDetailPage;
import org.laplacita.pages.home.HeaderPage;
import org.laplacita.pages.home.ProductosDestacadosPage;
import org.laplacita.testCaseImplements.DataProviderProducto;
import org.laplacita.testCaseImplements.TestCaseLoginCustomer;
import org.testng.annotations.Test;

public class TestProductDelete extends TestCaseLoginCustomer {

    @Test
    public void Test1(){
        ProductosDestacadosPage productoDestacados = new ProductosDestacadosPage(browser);
        ProductDetailPage productDetailPage = new ProductDetailPage(browser);
        CartPage cart = new CartPage(browser);
        HeaderPage headerPage = new HeaderPage(browser);
        OrderPage order = new OrderPage(browser);

        productoDestacados.getProductByName("Razer Controller Wolverine Utimate for Xbox One");
        productDetailPage.agregarAlCarritoClick();
        headerPage.carritoClick();
        cart.ordenarAhoraClick();
        order.setDireccion();
        order.setMetodoPago(OrderPage.MetodoPago.EFECTIVO);
        //order.finalizarCompraClick();
    }

    @Test(dataProvider = "producto", dataProviderClass = DataProviderProducto.class)
    public void test2(String producto){
        HeaderPage header = new HeaderPage(browser);
        header.searchItems(producto);
    }
    
    @Test(groups = {"smoke"})
    public void test3(){
        System.out.println("Smoke test 1");
    }

    @Test(groups = {"smoke"})
    public void test4(){
        System.out.println("Smoke test 2");
    }

}
