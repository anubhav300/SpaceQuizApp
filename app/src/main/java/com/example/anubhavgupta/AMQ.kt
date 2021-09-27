package com.example.anubhavgupta


object AMQ{
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(1,"Who joined Neil Armstrong and Buzz Aldrin on the Apollo 11 Mission?",
            "James Lowell","Michael Collins","Garg Aldrin","Michael Vanderwaal",2)
        questionsList.add(que1)
        val que2=Question(2,"Apollo 11 launched on a 363 foot tall rocket called","Saturn V","Jupiter C","Sputnik V","Falcon",1)
        questionsList.add(que2)
        val que3=Question(3,"The Apollo 11 lunar modules were named:","Snoopy","Falcon","Eagle","Suzera",3)
        questionsList.add(que3)
        val que4=Question(4,"What was the first phrase spoken on the moon?","That's one step for a man","Contact Light","Houston, Tranquility base here","The moon is clear",2)
        questionsList.add(que4)
        val que5=Question(5,"A plaque left by Apollo 11 on the moon stated that \"We came in *what* for all mankind\"?","Peace","Unity","Apollo","Happiness",1)
        questionsList.add(que5)

        return questionsList
    }

}