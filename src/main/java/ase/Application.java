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
            /*TESTCASE 1*/
            for(int i = 1; i <= 10; i ++){
                Number number = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/1/testcase/"+i, Number.class);
                log.info(number.toString());
                NumberClient numberClient = new NumberClient();
                ResponseEntity<Solution> responseEntity= numberClient.invert(number);
                ResponseEntity<Result> response = restTemplate.postForEntity(
                        getBaseUrl()+"/assignment/stage/1/testcase/"+i,
                        responseEntity,
                        Result.class);
            }

            /*TESTCASE 2*/
            for(int i = 1; i <= 20; i++){
                Variables var = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/2/testcase/"+i, Variables.class);
                VariablesClient variablesClient = new VariablesClient();
                ResponseEntity<Solution> responseEntityVar= variablesClient.sum(var);
                ResponseEntity<Result> response = restTemplate.postForEntity(
                        getBaseUrl()+"/assignment/stage/2/testcase/"+i,
                        responseEntityVar,
                        Result.class);
            }

            /*TESTCASE 3*/
            for(int i = 1; i <= 30; i++){
                NumberArray numberArray = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/3/testcase/"+i, NumberArray.class);
                NumberArrayClient variablesClient = new NumberArrayClient();
                ResponseEntity<Solution> responseEntityNumArr= variablesClient.sum(numberArray);
                ResponseEntity<Result> response = restTemplate.postForEntity(
                        getBaseUrl()+"/assignment/stage/3/testcase/"+i,
                        responseEntityNumArr,
                        Result.class);
            }

            /*TESTCASE 4*/
            for(int i = 1; i <= 40; i++){
                Operations op = restTemplate.getForObject(this.getBaseUrl()+"/assignment/stage/4/testcase/"+i, Operations.class);
                OperationsClient operationsClient = new OperationsClient();
                ResponseEntity<SolutionBigInteger> responseEntityOp= operationsClient.calc(op);
                ResponseEntity<Result> response = restTemplate.postForEntity(
                        getBaseUrl()+"/assignment/stage/4/testcase/"+i,
                        responseEntityOp,
                        Result.class);
            }
        };
    }
}
