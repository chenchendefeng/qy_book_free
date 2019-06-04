package ooh.chaos.configuration;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.springframework.amqp.core.Message;

public class RabbitAckService {
    public RabbitAckService() {
    }

    public void process(Channel channel, Message message, boolean isDiscard) {
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("receiver success");
        } catch (IOException var7) {
            var7.printStackTrace();
            if (isDiscard) {
                try {
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                } catch (IOException var6) {
                    System.out.println("discard fail");
                }
            }

            System.out.println("receiver fail");
        }

    }
}
