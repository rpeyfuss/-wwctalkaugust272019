package com.reginapeyfuss.services.higherOrderFunction

import javax.inject.{Inject, Singleton}

@Singleton
class WorldCountManager @Inject()(){}

object WordCountManager
{
    def splitWords(text: String): List[String] = {
        text.split("\\s+").map(_.trim).filterNot(_ == "").toList
    }

    def addWorldToEachWord(word: String, strList: List[String]): List[String] = {
        strList.map(_ + word)
    }

    def filterWords(strList: List[String], excludedWord: String): List[String] = {
        strList.filter(p => p != excludedWord)
    }

    def tallyWordsFromLeft(strList: List[String]): Int = {
        strList.foldLeft(0)((accum, elem) =>  accum + 1)
    }
    def tallyWordsFromRight(strList: List[String]): Int = {
        strList.foldRight(0)((elem, accum) => accum + 1)
    }

    def tallyCharactersFromLeft(strList: List[String]): Int = {
        strList.foldLeft(0)((accum, elem) => accum + elem.length)
    }

    def tallyCharactersFromRight(strList: List[String]): Int = {
        strList.foldRight(0)((elem, accum) => accum + elem.length)
    }

    def findLongest(strList: List[String]): String = {
        strList.fold("")((strA, strB) => {
            if (strA.length > strB.length) strA
            else strB
        })
    }

    def findShortest(strList: List[String]): String = {
        strList.reduce((strA, strB) => {
            if (strA.length <= strB.length) strA
            else strB
        })
    }

    def findShortestLeft(strList: List[String]): String = {
        strList.reduceLeft((strB, strA) => {
            if (strA.length <= strB.length) strA
            else strB
        })
    }
    def findShortestRight(strList: List[String]): String = {
        strList.reduceRight((strA, strB) => {
            if (strA.length <= strB.length) strA
            else strB
        })
    }

    def findWord(key: String, strList: List[String]): String = {
        strList.find(_ == key).getOrElse("")
    }

    def uniqueWords(strList: List[String]): List[String] = {
        strList.distinct
    }

    val divide: (Double, Double) => Double = (x: Double, y: Double) => x / y

    def divideReduceLeft(numbers: List[Double] = List(1.0, 2.0, 3.0)): Double = {
        numbers.reduceLeft(divide)
    }

    def divideReduceRight(numbers: List[Double] = List(1.0, 2.0, 3.0)): Double = {
        numbers.reduceRight(divide)
    }
}
