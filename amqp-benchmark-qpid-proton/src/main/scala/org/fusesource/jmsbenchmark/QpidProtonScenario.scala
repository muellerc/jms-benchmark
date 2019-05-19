/**
 * Copyright (C) 2009-2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.jmsbenchmark

import java.net.URI

object QpidProtonScenario {
  def main(args:Array[String]):Unit = {
    val scenario = new QpidProtonScenario
    scenario.url = "tcp://localhost:61613"
    scenario.user_name = "admin"
    scenario.password = "password"
    scenario.display_errors = true
    scenario.message_size = 20
    scenario.destination_type = "queue"
    scenario.consumers = 1
    scenario.queue_prefix = "queue://"
    scenario.topic_prefix = "topic://"
    scenario.run()
  }
}

/**
 * <p>
 * Qpid Proton implementation of the AMQP Scenario class.
 * </p>
 *
 * @author Christian Mueller
 */
class QpidProtonScenario extends AMQPClientScenario {

  def createProducer(i:Int) = {
    new ProducerClient(i)
  }

  def createConsumer(i:Int, drain:Boolean) = {
    new ConsumerClient(i, drain)
  }

  class ProducerClient(override val id: Int) extends Client {

    def start = {
    }

    def shutdown = {
    }

    def wait_for_shutdown = {
    }
  }

  class ConsumerClient(override val id: Int, val drain:Boolean) extends Client {

    def start = {
    }

    def shutdown = {
    }

    def wait_for_shutdown = {
    }
  }
}