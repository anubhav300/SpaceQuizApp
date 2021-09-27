package com.example.anubhavgupta

object CQ{
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(1,"Which of these constellations is not in the zodiac?",
            "Alpha Centauri","Leo","Aries","Capricornus",1)
        questionsList.add(que1)
        val que2=Question(2,"In what constellation is Sirius found?","Andromeda","Ursa Minor","Ursa Major","Canis Major",4)
        questionsList.add(que2)
        val que3=Question(3,"What is the name of a bright star in Orion?","Behemoth","Beetle","Betelgeuse","Belinda",3)
        questionsList.add(que3)
        val que4=Question(4,"What is the zodiacal symbol for the constellation Leo?","elephant","lion","turkey","tiger",2)
        questionsList.add(que4)
        val que5=Question(5,"Which constellation contains two of the largest star clusters visible from Earth: the Hyades and the Pleiades.","Leo","Capricornus ","Taurus ","Hercules",3)
        questionsList.add(que5)

        return questionsList
    }

}