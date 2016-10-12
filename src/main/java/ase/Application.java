package ase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    protected String getBaseUrl() {
        return "http://localhost:8080";
    }



    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Number number = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/1/testcase/1", Number.class);
            log.info(number.toString());

            NumberClient numberClient = new NumberClient();
            ResponseEntity<Solution> responseEntity= numberClient.invert(number);
            log.info(responseEntity.toString());
            System.out.println("response; "+responseEntity.toString());
            ResponseEntity<Result> response = restTemplate.postForEntity(
                    getBaseUrl()+"/assignment/stage/1/testcase/1",
                    responseEntity,
                    Result.class);
            log.info(response.toString());
            System.out.println(response.getBody());

            Variables var = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/2/testcase/1", Variables.class);
            log.info(var.toString());
            VariablesClient variablesClient = new VariablesClient();
            ResponseEntity<Variables> responseEntityVar= variablesClient.invert(var);
            log.info(responseEntityVar.toString());
            /*ResponseEntity<Result> responseVar = restTemplate.postForEntity(
                    getBaseUrl()+"/assignment/stage/2/testcase/1",
                    responseEntity,
                    Result.class);
            log.info(responseVar.toString());*/

            NumberArray numArr = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/3/testcase/1", NumberArray.class);
            log.info(numArr.toString());

            Operations op = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/4/testcase/1", Operations.class);
            log.info(op.toString());
        };
    }
}
