package ml.software.microservices.order_service.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "INVENTORY-SERVICE")
//@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
