package com.example.iluriadashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.util.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        createGraph()
    }

    fun createGraph() {

        // generate Dates
        // generate Dates
        val calendar: Calendar = Calendar.getInstance()
        val d1: Date = calendar.getTime()
        calendar.add(Calendar.DATE, 1)
        val d2: Date = calendar.getTime()
        calendar.add(Calendar.DATE, 1)
        val d3: Date = calendar.getTime()



        val graph = getView()?.findViewById<View>(R.id.graph) as GraphView
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(
            arrayOf(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0)
            )
        )
        series.setDrawDataPoints(true)
        series.setDataPointsRadius(10.0F);
        graph.addSeries(series)

        // set manual x bounds to have nice steps
        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(24.0);
        graph.getViewport().setXAxisBoundsManual(true);

        graph.getViewport().setMinY(0.0);
        graph.getViewport().setMaxY(20.0);
        graph.getViewport().setYAxisBoundsManual(true);
        // set date label formatter
        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        staticLabelsFormatter.setHorizontalLabels(arrayOf("12 AM", "6", "12 PM", "6", ""))
        //staticLabelsFormatter.setVerticalLabels(arrayOf("low", "middle", "high"))
        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter

    }
}