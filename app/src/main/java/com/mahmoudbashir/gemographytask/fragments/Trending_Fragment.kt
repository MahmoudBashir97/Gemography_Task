package com.mahmoudbashir.gemographytask.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.gemographytask.R
import com.mahmoudbashir.gemographytask.adapters.Tadapter
import com.mahmoudbashir.gemographytask.databinding.FragmentTrendingBinding
import com.mahmoudbashir.gemographytask.pojo.Item
import com.mahmoudbashir.gemographytask.ui.MainActivity
import com.mahmoudbashir.gemographytask.viewModel.TrendingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Trending_Fragment : Fragment() {

    lateinit var trendBinding:FragmentTrendingBinding
    lateinit var viewModel:TrendingViewModel
    lateinit var Tadapt :Tadapter
    private lateinit var mlist:ArrayList<Item>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        trendBinding=DataBindingUtil.inflate(inflater, R.layout.fragment_trending, container, false)
       // initializing TrendingViewModel
        viewModel = (activity as MainActivity).viewModel


        //use Coroutines as MainThread with Global Scope
        GlobalScope.launch(Dispatchers.Main){
            // get Most Starred Repositories with its list trending items
            getTrendingListData()
        }


        return trendBinding.root
    }

    // use suspend function
    private suspend fun getTrendingListData(){
        //initialize list of Items( trending list )
        mlist=ArrayList()
        // as we using dataBinding , i set it (isLoading = true) for let progress bar visible and recyclerview gone
        trendBinding.isLoading = true
        // use ViewModel for getting data from api
        viewModel.getTrendingList().body().let {
            // check if data is received successfully or not
            if (it?.total_count != null){
                Log.d("responseT: ","${it.total_count}")
                mlist.addAll(it.items)
                trendBinding.isLoading = false
            }
        }
        delay(10)
        // as its name its for setUp Views as(RecyclerView and initializing Trending adapter)
        setUpViews()
    }
    private fun setUpViews(){
        Tadapt = Tadapter(mlist)
        trendBinding.recTrending.apply {
            setHasFixedSize(true)
            adapter = Tadapt
        }
    }
}