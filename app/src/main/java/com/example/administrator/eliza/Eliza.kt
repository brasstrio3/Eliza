package com.mcandroid.eliza

import java.util.*
import kotlin.collections.HashMap

class Eliza {
    val hedge = arrayOfNulls<String>(3)
    val qualifier = arrayOfNulls<String>(3)
    var replacement = HashMap<String,String>()
    var question: String = "Welcome! How can I help you?"

    init {
        loadData()
    }

    private fun loadData(){

        hedge[0]="Please tell me more."
        hedge[1] = "Many of my patients tell me the same thing."
        hedge[2] = "It is getting late, maybe we had better quit."

        qualifier[0] = "Why do you say that "
        qualifier[1] = "You seem to think that "
        qualifier[2] = "So, you are concerned that "

        replacement.put("me","you")
        replacement.put("i","you")
        replacement.put("my","your")
        replacement.put("am","are")

    }

    fun ask(text:String){
        question = text
    }

    fun generateResponse():String{
        var output = StringBuilder()

        val useHedge: Boolean = makeDecision()

        if (useHedge){
            //pick random hedge
            val selectedHedge = generateRandomNumber(0,2)
            output.append(hedge[selectedHedge])
        }else{
            //pick random qualifier
            val selectedQualifier = generateRandomNumber(0,2)
            output.append(qualifier[selectedQualifier])

            //apply replacements
            var words = question.split(" ")

            for (word in words)
            {
                if (replacement.containsKey(word))
                {
                    output.append(replacement.get(word))
                }else{
                    output.append(word)
                }
                output.append(" ")
            }
            output.trim()//remove trailing spaces
            output.append("?")
        }

        return output.toString()

    }


    fun generateRandomNumber(min:Int, max:Int): Int {
        var random = Random()
        val randomNum = random.nextInt(max + 1 - min) + min
        return randomNum
    }

    fun makeDecision():Boolean{
        if (generateRandomNumber(0,1)>0) return true else return false
    }

}