package com.project.myprogress.modelclass;

import com.project.myprogress.R;

public enum  StateTask {


    State1( R.drawable.galochka_grey24),
    State2(R.drawable.galochka_green24),
    State3(R.drawable.white_on_red24);

    public int icon;

    StateTask( int icon) {
        this.icon = icon;
    }


    public int getIcon() {
        return icon;
    }
}




