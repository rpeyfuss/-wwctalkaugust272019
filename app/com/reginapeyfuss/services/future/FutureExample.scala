package com.reginapeyfuss.services.future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

case class LongRunningProcess(msg: String)

object FutureExample {


    def longrunningProcess: Future[LongRunningProcess] = {
        //this could be an async call to another service thru rest  or to reactive mongoDb
        Future(LongRunningProcess("done with the long running process"))
    }

    def checkLongRunningProcess: Future[LongRunningProcess] = {
        val result = longrunningProcess

        result.map (res => {
            //do something else when process is done
        })

        result.onComplete{
            case Success(_) => // do nothing
            case Failure(err) => //add observability and logging, or/and recover
        }
        result
    }
}
