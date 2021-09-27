package com.example.anubhavgupta

object Constants{
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(1,"The day on which the Sun’s direct rays cross the celestial equator is called:",
        "the solstice","the equinox","the ecliptic","the aphelion",2)
        questionsList.add(que1)
        val que2=Question(2,"Who invented the telescope?","Galileo","Hypatia","Hans Lippershey","Johannes Kepler",3)
        questionsList.add(que2)
        val que3=Question(3,"What term describes the alignment of three celestial bodies?","symbology","syzygy","sizzle","suzerainty",2)
        questionsList.add(que3)
        val que4=Question(4,"Which is the name of a radio source that is very far from Earth?","quasar","tracer","phaser","taser",1)
        questionsList.add(que4)
        val que5=Question(5,"Which spacecraft was Laika, the first living creature sent into space?","Sputnik 2","Sputnik 3","Apollo 11","Vostok 1",1)
        questionsList.add(que5)

        return questionsList
    }

}