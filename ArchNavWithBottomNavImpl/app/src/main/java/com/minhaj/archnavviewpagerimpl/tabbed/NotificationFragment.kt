package com.minhaj.archnavviewpagerimpl.tabbed

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.samples.apps.sunflower.tabbed.dummy.DummyContent
import com.google.samples.apps.sunflower.tabbed.dummy.DummyContent.DummyItem
import com.minhaj.archnavviewpagerimpl.R
import com.minhaj.archnavviewpagerimpl.constants.Constants.NOTIFICATION_ID_DEFAULT
import com.minhaj.archnavviewpagerimpl.data.notification.Notification
import com.minhaj.archnavviewpagerimpl.tabbed.viewmodels.NotificationViewModel
import com.minhaj.archnavviewpagerimpl.utilities.InjectorUtils
import com.minhaj.archnavviewpagerimpl.utilities.NotificationUtils
import kotlinx.android.synthetic.main.fragment_notification_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NotificationFragment.OnListFragmentInteractionListener] interface.
 */
class NotificationFragment : Fragment(), View.OnClickListener, CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    private val viewModel : NotificationViewModel by viewModels{
        InjectorUtils.provideNotificationViewModel(requireContext())
    }

    private val args : NotificationFragmentArgs by navArgs()




    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification_list, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Set the adapter
        with(list) {

            println()
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(requireContext())
                else -> GridLayoutManager(requireContext(), columnCount)
            }
            adapter = MyNotificationRecyclerViewAdapter(DummyContent.ITEMS, listener)
        }

        btnAddNotification.setOnClickListener(this)


        viewModel.notifications.observe(this, Observer<List<Notification>> {

            print("Notifications::::::::::"+it)

        })


        args.notificationId.let {

            if (it != NOTIFICATION_ID_DEFAULT){

                val notification  = Notification(notificationId = args.notificationId, title = args.notificationTitle.toString(), message = args.notificationMessage.toString(), image = args.notificationImage.toString())
                viewModel.addNotification(notification)
            }



            viewLifecycleOwner.lifecycleScope.launch {



            }


        }

        lifecycle;

        lifecycleScope.launch {

            list.visibility = View.GONE
            list.visibility = View.VISIBLE
        }


        viewLifecycleOwnerLiveData


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    override fun onClick(v: View?) {

        when(v?.id) {

            R.id.btnAddNotification -> {


//                launch {
//
//                    viewModel.callAsyncWithAwait()
//                }


                NotificationUtils.triggerNotification(requireContext())

//                val notificationDetail = NotificationFragmentDirections.actionNotificationFragmentToNavTabNotification()
////
//                findNavController().navigate(notificationDetail)
            }

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            NotificationFragment().apply ( block = {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_notification,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){

            R.id.updateNotify ->{

                viewModel.updateImage("fdfhjdhf df jfhjd fjdhjd fjdfh")
            }

        }

        return false
    }
}
