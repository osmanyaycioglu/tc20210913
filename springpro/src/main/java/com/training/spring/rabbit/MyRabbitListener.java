package com.training.spring.rabbit;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.training.spring.employeep.Employee;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "root_message_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "root_exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "root_message"))
    public void handleRootMessage(final String str) {
        System.out.println("Received root messages : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "secondary_message_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "root_exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "secondary_message"))
    public void handleSecondaryMessage(final String str) {
        System.out.println("Received secondary messages : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "employee_tr_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "employee_exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "emp.tr.*"))
    public void handleTrEmployee(final Employee emp) {
        System.out.println("*** TR Employee : " + emp);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "employee_all_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "employee_exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "emp.#"))
    @SendTo("employee_response/employee_response_message")
    public String handleAllEmployee(final Employee emp) {
        System.out.println("++++ All Employee  : " + emp);
        return "Hello " + emp.getName();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "employee_eu_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "employee_exchange",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "emp.eu.*"))
    public void handleEuEmployee(final Employee emp) {
        System.out.println("*** EU Employee : " + emp);
    }

}
