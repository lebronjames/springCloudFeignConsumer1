服务消费者，使用Feign实现
1) pom.xml增加Feign(spring-cloud-starter-feign)、eureka(spring-cloud-starter-eureka)配置
2) 在应用主类Application增加@EnableDiscoveryClient注解来添加发现服务能力,通过@EnableFeignClients注解开启Feign功能
3) 定义compute-service服务的接口，具体如下：
@FeignClient("compute-service")
public interface ComputeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
4) 通过Spring MVC的注解来配置compute-service服务下的具体实现。
在web层中调用上面定义的ComputeClient，具体如下：
@RestController
public class ConsumerController {
    @Autowired
    ComputeClient computeClient;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}

5) application.properties中不用变，指定eureka服务注册中心即可
spring.application.name=feign-consumer
server.port=3333
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/