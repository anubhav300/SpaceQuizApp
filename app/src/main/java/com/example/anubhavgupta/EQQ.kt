package com.example.anubhavgupta



object EQQ{
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(1,"What is the true shape of the Earth?",
            "Flat","Sphere","Oval","Oblate spheroid",4)
        questionsList.add(que1)
        val que2=Question(2,"What is the speed of Earth's orbit around the Sun","50,000mph","67,000mph","80,000mph","95,000mph",2)
        questionsList.add(que2)
        val que3=Question(3,"What is the longest mountain chain on the planet?","The Bermuda Triangle","The Mariana Trench","Himalayas","Atlantic Mountains",2)
        questionsList.add(que3)
        val que4=Question(4,"How often does lightning strikes the Earth?","100 times a day","100 times an hour","100 times a second","100 times a day",3)
        questionsList.add(que4)
        val que5=Question(5,"Where was the hottest temperature measured on Earth?","El Azizia, Libya","Death Valley, USA","Ohio, USA","Phnom Penh, Cambodia",2)
        questionsList.add(que5)

        return questionsList
    }

}