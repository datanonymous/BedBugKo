package ko.alex.bedbugko;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Bot3Frag extends Fragment {

    public Bot3Frag(){
        // Required empty public constructor
        //Working with RecyclerView
        //https://www.androidhive.info/2016/01/android-working-with-recycler-view/

        //Custom alert dialog
        //https://www.youtube.com/watch?v=plnLs6aST1M

        //Working with Firebase and Recyclerview
        //https://www.youtube.com/watch?v=kyGVgrLG3KU&list=LLj1xIyoM3IcZs9XdwFDaJWA&index=3&t=0s
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bot3frag, container, false);
        return view;
    } //END ONCREATEVIEW

} //END BOT1FRAG
