package org.petrovic.rabbit

import com.rabbitmq.client.ConnectionFactory

fun main(args : Array<String>) : Unit {
    val exchange = "rabbit.kotlin"
    val exchangeType = "topic"
    val routingKey = "a.b"
    val emptyQueueName = ""
    val durable = false
    val exclusive = true
    val autodelete = true
    val autoAck = true
    val basicProperties = null
    val arguments = null

    val conx = ConnectionFactory()
    val connection = conx.newConnection()
    val channel = connection?.createChannel()
    val declareOk = channel?.exchangeDeclare(exchange, exchangeType, false)

    if( args[0].equals("--producer")) {
        channel?.basicPublish(exchange, routingKey, basicProperties, "hello".getBytes())
        println("published")
        connection?.close()
    } else {
        val queueDeclare = channel?.queueDeclare(emptyQueueName, durable, exclusive, autodelete, arguments)
        val assignedQueueName = queueDeclare?.getQueue()
        channel?.queueBind(assignedQueueName, exchange, routingKey)
        channel?.basicConsume(assignedQueueName, autoAck, ConsumerImpl())
        println("consumer listening")
    }
}