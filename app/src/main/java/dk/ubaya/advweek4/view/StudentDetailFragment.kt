package dk.ubaya.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dk.ubaya.advweek4.R
import dk.ubaya.advweek4.util.loadImage
import dk.ubaya.advweek4.viewmodel.DetailViewModel
import dk.ubaya.advweek4.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable.timer
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*
import kotlinx.android.synthetic.main.student_list_item.txtId
import kotlinx.android.synthetic.main.student_list_item.txtName
import java.util.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).id.toString())

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtId.setText(it.id)
            txtName.setText(it.name)
            imageView2.loadImage(it.photoUrl.toString(), progressBar)
            txtBod.setText(it.bod)
            txtPhone.setText(it.phone)

            var student=it
            btnNotif.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        MainActivity.showNotification(student.name.toString(),"A new notification created", R.drawable.ic_baseline_person_24)
                    }

            }
        })


    }
}