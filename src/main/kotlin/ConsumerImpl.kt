package org.petrovic.rabbit

import com.rabbitmq.client.AMQP.BasicProperties
import com.rabbitmq.client.Consumer
import com.rabbitmq.client.Envelope
import com.rabbitmq.client.ShutdownSignalException

class ConsumerImpl : Consumer {
    override fun handleConsumeOk(consumerTag : String?) {
    }
    override fun handleCancelOk(p0 : String?) {
        throw UnsupportedOperationException()
    }
    override fun handleRecoverOk(p0 : String?) {
        throw UnsupportedOperationException()
    }
    override fun handleCancel(p0 : String?) {
        throw UnsupportedOperationException()
    }
    override fun handleDelivery(consumerTag : String?, envelope : Envelope?, basicProperties : BasicProperties?, body : ByteArray?) {
        println("got message: " + body?.toString("UTF-8"))
    }
    override fun handleShutdownSignal(p0 : String?, p1 : ShutdownSignalException?) {
        println("got shutdown signal")
    }
}