package dk.ubaya.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.ubaya.advweek4.model.Student

class ListViewModel:ViewModel() {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh() {
        val student1 = Student("34-7637846","Gilberte","2002/04/09","9505044384","http://dummyimage.com/100x75.png/cc0000/ffffff")
        val student2 = Student("01-9234987","Wynnie","1995/01/27","5495093961","http://dummyimage.com/100x75.png/cc0000/ffffff")
        val student3 = Student("17-1563651","Cathee","1998/11/02","3257640965","http://dummyimage.com/100x75.png/5fa2dd/ffffff")

        studentsLD.value = arrayListOf<Student>(student1, student2, student3)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }

}