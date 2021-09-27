package com.example.anubhavgupta



object BHQ{
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1=Question(1,"The first image of a black hole was released on",
            "April 10, 2019","April 20, 2019","April 25, 2019","April 20, 2020",1)
        questionsList.add(que1)
        val que2=Question(2,"Cygnus X-1 is _____ light-years away from Earth","5000","6000","7000","8000",2)
        questionsList.add(que2)
        val que3=Question(3,"Black hole at the Galactic Center of the Milky Way is called","Sagittarius A*","Fornax A","Cygnus X-3","Centrox MW",1)
        questionsList.add(que3)
        val que4=Question(4,"When was the Chandra X-ray Observatory launched?","June 23, 1999","July 23, 2000","August 23, 2000","July 23, 1999",4)
        questionsList.add(que4)
        val que5=Question(5,"The supermassive black hole in the center of Messier 87 galaxy is _____ times the mass of the Sun","8.5 billion","6.5 million","6.5 billion","8.5 billion",3)
        questionsList.add(que5)

        return questionsList
    }

}